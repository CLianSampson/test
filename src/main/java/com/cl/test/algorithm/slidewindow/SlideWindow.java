package com.cl.test.algorithm.slidewindow;

import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * 滑动窗口
 *
 * @author chenlian
 * @version 1.0
 * @date 2023/7/18 16:18
 */
@Slf4j
public class SlideWindow {


    public static void main(String[] args) {
        int[] array = {1,2,3,4,1};
        int value = slideWindow(array, 2);
        log.info("最大值:{}",value);
    }

    /**
     * 求最大连续 K 个数之和
     */
    public static int slideWindow(int[] nums,int k){
        int sum = 0;
        for (int i = 0; i <= nums.length-k; i++) {
            int temp = 0;
            for (int j = 0; j < k; j++) {
                temp += nums[i+j];
            }

            sum = Math.max(temp,sum);
        }

        return sum;
    }


    /**
     * 通用模板
     */
    public static void commonSlideWindow(int[] nums,int k){
        int left = 0,right = 0;

        List<Integer> window = new ArrayList<>();

        while (right < nums.length){
            window.add(nums[right]);
            right++;

            while (window.size() > 100){
                left++;
            }

        }
    }


    // 注意：java 代码由 chatGPT🤖 根据我的 cpp 代码翻译，旨在帮助不同背景的读者理解算法逻辑。
// 本代码还未经过力扣测试，仅供参考，如有疑惑，可以参照我写的 cpp 代码对比查看。

    /* 滑动窗口算法框架 */
    void slidingWindow(String s) {
        // 用合适的数据结构记录窗口中的数据
        HashMap<Character, Integer> window = new HashMap<>();

        int left = 0, right = 0;
        while (right < s.length()) {
            // c 是将移入窗口的字符
            char c = s.charAt(right);
            window.put(c, window.getOrDefault(c, 0) + 1);
            // 增大窗口
            right++;
            // 进行窗口内数据的一系列更新
            //...

            /*** debug 输出的位置 ***/
            // 注意在最终的解法代码中不要 print
            // 因为 IO 操作很耗时，可能导致超时
            System.out.printf("window: [%d, %d)\n", left, right);
            /********************/

            // 判断左侧窗口是否要收缩
            //while (left < right && window needs shrink) {
            while (left < right ) {
                // d 是将移出窗口的字符
                char d = s.charAt(left);
                window.put(d, window.get(d) - 1);
                // 缩小窗口
                left++;
                // 进行窗口内数据的一系列更新
                //...
            }
        }
    }




}