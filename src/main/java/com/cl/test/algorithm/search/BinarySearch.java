
package com.cl.test.algorithm.search;

import lombok.extern.slf4j.Slf4j;

/**
 * 二分查找
 *
 * 难点  确定index = (left + right) / 2
 *
 * 在看极客时间上王争老师的数据结构和算法课，15节二分查找，看到这段感觉受到启发，位运算右移一位就是除以2，例：1000（8）  0100（4） 0010（2）
 *
 * 实际上，mid=(low+high)/2 这种写法是有问题的。因为如果 low 和 high 比较大的话，两者之和就有可能会溢出。改进的方法是将 mid 的计算方式写成 low+(hgh-low)/2。更进一步，如果要将性能优化到极致的话，我们可以将这里的除以 2 操作转化成位运算 low+((high-low)>>1)。因为相比除法运算来说，计算机处理位运算要快得多。
 *
 * 作者：Missmiss懵
 * 链接：https://www.jianshu.com/p/2b4fd53b12d4
 * 来源：简书
 * 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
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