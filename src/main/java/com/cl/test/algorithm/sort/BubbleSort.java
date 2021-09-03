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
        int l = nums.length;
        for (int i = 0; i < l-1; i++) {
            for (int j = i+1; j < l-1; j++) {
                if (nums[i] > nums[j]){
                    int temp = nums[i];
                    nums[i] = nums[j];
                    nums[j] = temp;
                }
            }
        }
    }

}
