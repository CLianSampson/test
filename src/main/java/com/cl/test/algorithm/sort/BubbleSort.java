package com.cl.test.algorithm.sort;

/**
 * @author sampson chen
 * @date 2021年09月02日 9:37
 */
public class BubbleSort {

    public static void main(String[] args) {
        int[] nums = {7,8,2,9,3,1,90,88,33};
        bubbleSort(nums);
        for (int i = 0; i < nums.length; i++) {
            System.out.println(nums[i]);
        }
    }

    public static void bubbleSort(int[] nums){
        int length = nums.length;
        for (int i = 0; i < length-1; i++) {
            for (int j = 1; j < length-i; j++) {
                if (nums[j-1] > nums[j]){
                    int temp = nums[j-1];
                    nums[j-1] = nums[j];
                    nums[j] = temp;
                }
            }
        }
    }

}
