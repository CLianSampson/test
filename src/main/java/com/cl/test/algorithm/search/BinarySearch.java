
package com.cl.test.algorithm.search;

import lombok.extern.slf4j.Slf4j;

/**
 * 二分查找
 *
 * 难点  确定index = (left + right) / 2
 *
 * @author chenlian
 * @version 1.0
 * @date 2023/7/10 20:42
 */
@Slf4j
public class BinarySearch {



    public static void main(String[] args) {
        int size = 90000000;

        int[] array = {2,3,4,5,6,7,8,9,10,11};
        //int index = binarySearchRecursion(array, 0, array.length - 1, 1);

        int[] nums = new  int[size];
        long startTime0 = System.currentTimeMillis();
        for (int i = 0; i < size; i++) {
            nums[i] = i;
        }
        log.info("循环耗时:{}",System.currentTimeMillis()-startTime0);


        log.info("分隔符**************************************");

        long startTime = System.currentTimeMillis();
        int index = binarySearch(nums,-100);
        log.info("第二次查找:{}",index);
        log.info("耗时:{}",System.currentTimeMillis()-startTime);

        log.info("分隔符**************************************");

        long startTime1 = System.currentTimeMillis();
        int index1 = binarySearchRecursion(array, 0, array.length - 1, 111);
        log.info("第一次查找:{}",index1);
        log.info("耗时:{}",System.currentTimeMillis()-startTime1);


    }


    /**
     * 递归二分查找
     */
    public static int binarySearchRecursion(int[] nums,int left,int right,int value){
        if (left > right){
            return -1;
        }

        int index = (left + right)/2;
        int middle = nums[index];
        if (value == middle){
            return index;
        }else if (value > middle){
            return binarySearchRecursion(nums,index+1,right,value);
        }else {
            return binarySearchRecursion(nums,0,index-1,value);
        }
    }


    /**
     * 非递归二分查找
     */
    public static int binarySearch(int[] array,int value){
        int left = 0;
        int right = array.length;
        while (left<=right){
            int middle = (left + right)/2;

            if (array[middle] > value){
                right = middle-1;
            }else if (array[middle] < value){
                left = middle+1;
            }else {
                return middle;
            }
        }

        return -1;
    }





















}