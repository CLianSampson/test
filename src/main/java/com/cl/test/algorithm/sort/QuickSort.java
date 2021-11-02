package com.cl.test.algorithm.sort;

/**
 * @author sampson chen
 * @date 2021年09月03日 9:35
 */
public class QuickSort {

    public static void main(String[] args) {
        int[] nums = {7,8,2,9,3,1,90,88,33};
        quickSort(nums,0,nums.length-1);
        for (int i = 0; i < nums.length; i++) {
            System.out.println(nums[i]);
        }
    }


//    public static void quickSort(int[] nums,int l ,int r){
//        if (l >= r) return;
//
//        int i = l;
//        int j = r;
//        int curr = nums[l];
//
//        while (i < j){
//            while (i<j && curr < nums[j]) j--;
//            nums[i] = nums[j];
//            while (i<j && curr > nums[j]) i++;
//            nums[j] = nums[i];
//        }
//
//        nums[i] = curr;
//
//        quickSort(nums,l,i-1);
//        quickSort(nums,i+1,r);
//    }

    //TODO 快排非递归
    public static void quickSortNoRecursion(int[] nums){

    }


    /**
     * 2021-09-13  9:41
     * @param nums
     * @param l
     * @param r
     */
    public static void quickSort(int[] nums,int l,int r){
        if (l >= r) return;

        int i = l;
        int j = r;
        int curr = nums[i];

        while (i<j){
            while (i<j && curr < nums[j]) j--;
            nums[i] = nums[j];
            while (i<j && curr > nums[i]) i++;
            nums[j] = nums[i];
        }

        nums[i] = curr;

        quickSort(nums,l,i-1);
        quickSort(nums,i+1,r);
    }




}
