
package com.cl.test.algorithm.sort;

import lombok.extern.slf4j.Slf4j;

import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * 堆排序  https://www.cnblogs.com/chengxiao/p/6129630.html
 *
 *  重点 ： 第一个选取点  length/2 - 1 。是在倒数第二层，最右边一个节点
 *
 *   [10,8,6,5,4,3,1,2,3,7]
 *
 * @author chenlian
 * @version 1.0
 * @date 2023/7/19 11:16
 */
@Slf4j
public class HeapSortTwo {


    public static void main(String[] args) {

        PriorityQueue<Integer> queue = new PriorityQueue<>(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o1 - o2;
            }
        });
        queue.add(12);
        queue.add(20);
        queue.add(5);
        queue.add(8);
        queue.add(9);

        log.info("第一个元素:{}",queue.poll());
    }



    public static void heapSort(int[] nums){

        for (int i = nums.length/2-1; i >0; i--) {
            heapAdjust(nums,i,nums.length);
        }

        for (int i = 0; i < nums.length; i++) {
            swap(nums,0,nums.length-1);
            heapAdjust(nums,0,nums.length-i);
        }

    }


    public static void heapAdjust(int[] nums,int i,int l){
        //先比较 2*i+1 和2*i+2
        int k = 2*i+1;
        if (nums[2*i+1] < nums[2*i+2]){
            // k指向最大的
            k = 2*i+2;
        }
        //将大的交换到顶端
        if (nums[k] > nums[i]){
            swap(nums,k,i);
        }

    }

    public static void swap(int[] nums,int a,int b){
        int temp = nums[a];
        nums[a] = nums[b];
        nums[b] = temp;

    }


}