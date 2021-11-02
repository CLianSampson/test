package com.cl.test.algorithm;


/**
 * @author chen lian
 * @date 2021年09月24日 9:31
 */
public class Today {

    public static void main(String[] args) {
        int[] nums = {55,12,52,1,8,6,100};
        quickSort(nums,0,nums.length-1);
        for (int i = 0; i < nums.length; i++) {
            System.out.println(nums[i]);
        }
    }

    public static void quickSort(int[] nums,int l,int r){
        if (l >= r) return;

        int i = l;
        int j = r;
        int curr = nums[i];
        while (i < j){
            while (i<j && curr <= nums[j]) j--;
            nums[i] = nums[j];
            while (i<j && curr >= nums[i]) i++;
            nums[j] = nums[i];
        }

        nums[i] = curr;

        quickSort(nums,l,i-1);
        quickSort(nums,i+1,r);
    }




}
