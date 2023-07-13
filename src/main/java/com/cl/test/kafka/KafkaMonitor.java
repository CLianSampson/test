

package com.cl.test.kafka;

import org.apache.kafka.clients.admin.*;
import org.apache.kafka.clients.consumer.KafkaConsumer;
import org.apache.kafka.clients.consumer.OffsetAndMetadata;
import org.apache.kafka.common.TopicPartition;
import org.apache.kafka.common.serialization.StringDeserializer;

import java.util.Collections;
import java.util.Map;
import java.util.Properties;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.stream.Collectors;

import static org.apache.kafka.server.quota.ClientQuotaEntity.ConfigEntityType.CLIENT_ID;

/**
 * TODO 类功能描述
 *
 * @author chenlian
 * @version 1.0
 * @date 2023/5/23 19:05
 */
public class KafkaMonitor {

    /**
     * ThreadPoolTaskExecutorConfig配置的公共线程池
     */
    public static final ThreadPoolExecutor asyncTaskExecutor = new ThreadPoolExecutor(100, 100, 60L, TimeUnit.SECONDS,
            new LinkedBlockingQueue<>(2000), new NamedThreadFactory("area-external-", false),
            new ThreadPoolExecutor.AbortPolicy());


    public static void main(String[] args) {
        list();
    }

    public static void list(){
        // 设置Kafka AdminClient配置信息
        Properties props = new Properties();
        props.put("bootstrap.servers", "10.201.88.51:9092");
        props.put("key.deserializer", StringDeserializer.class.getName());
        props.put("value.deserializer", StringDeserializer.class.getName());
        props.put("client_id_config", "Kafka-OPS");

        // 创建Kafka AdminClient实例
        AdminClient adminClient = AdminClient.create(props);
        try {
            // 设置消费组选项
            ListConsumerGroupsOptions options = new ListConsumerGroupsOptions();
            options.timeoutMs(5000);

            // 获取消费组列表
            ListConsumerGroupsResult result = adminClient.listConsumerGroups(options);

            // 迭代迭代消费组
            for (ConsumerGroupListing groupListing : result.all().get()) {
                asyncTaskExecutor.execute(()->{
                    try {
                        process(props, adminClient, groupListing);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    } catch (ExecutionException e) {
                        e.printStackTrace();
                    }
                });
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    private static void process(Properties props, AdminClient adminClient, ConsumerGroupListing groupListing) throws InterruptedException, ExecutionException {
        // 获取消费组信息，包括消费组状态
        String groupId = groupListing.groupId();
        DescribeConsumerGroupsResult describeResult = adminClient.describeConsumerGroups(Collections.singletonList(groupId));
        ConsumerGroupDescription groupDescription = describeResult.all().get().get(groupId);
        System.out.printf("Group: %s, state: %s\n", groupId, groupDescription.state());
        System.out.println(groupDescription.members().stream().flatMap(member -> member.assignment().topicPartitions().stream()).collect(Collectors.toList()));

        // 实例化ListConsumerGroupOffsetsOptions
        ListConsumerGroupOffsetsOptions offsetOptions = new ListConsumerGroupOffsetsOptions();

        // 参数为topic分区
        offsetOptions.topicPartitions(groupDescription.members().stream().flatMap(member -> member.assignment().topicPartitions().stream()).collect(Collectors.toList()));

        // 获取topic分区和对应的offset等元数据
        Map<TopicPartition, OffsetAndMetadata> offsets = adminClient.listConsumerGroupOffsets(groupId, offsetOptions).partitionsToOffsetAndMetadata().get();


        // 使用消费组成员迭代其offset
        for (MemberDescription member : groupDescription.members()) {
            System.out.printf("Member: %s, host: %s, client: %s\n", member.consumerId(), member.host(), member.clientId());

            for (TopicPartition partition : member.assignment().topicPartitions()) {
                OffsetAndMetadata offsetAndMetadata = offsets.get(partition);
                String currentOffset;
                try {
                    currentOffset = String.valueOf(offsetAndMetadata.offset());
                } catch (NullPointerException e){
                    currentOffset = "-";
                }

                long logEndOffset;
                long lag;
                try (KafkaConsumer<String, String> consumer = new KafkaConsumer<>(props)) {
                    consumer.assign(Collections.singleton(partition));
                    consumer.seekToEnd(Collections.singleton(partition));
                    logEndOffset = consumer.position(partition);
                    if (currentOffset.equals("-")) {
                        lag = 0;
                    } else {
                        lag = logEndOffset - Long.parseLong(currentOffset);
                    }
                }

                System.out.printf("Group: %s, state: %s, Member: %s, host: %s, client: %s, Topic: %s, partition: %d, offset: %s, log end offset: %d, lag: %d\n", groupId, groupDescription.state(), member.consumerId(), member.host(), member.clientId(), partition.topic(), partition.partition(), currentOffset, logEndOffset, lag);

            }
        }
        System.out.println("---------------------------------------------------");
    }

}