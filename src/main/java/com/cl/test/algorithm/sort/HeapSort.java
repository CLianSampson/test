package com.cl.test.algorithm.sort;

/**
 * @author sampson chen
 * @date 2023年07月22日 10:37
 */
public class HeapSort {


    public static void main(String[] args) {
        int[] nums = {7,8,2,9,3,1,90,88,33};
        heapSort(nums);
        for (int i = 0; i < nums.length; i++) {
            System.out.println(nums[i]);
        }
    }



    public static void heapSort(int[] nums){
        int length = nums.length;
        //从这里开始构造大顶堆
        int start = length/2-1;

        //构造大顶堆
        for (int i = start;i>=0;i--) {
            heapAdjust(nums,i,length);
        }
        //重新构造大顶堆
        for (int i = length; i >=3; i--) {
            swap(nums,0,i-1);
            heapAdjust(nums,0,i-1);
        }
        //最后剩第0个和第1个元素
        if (nums[0] > nums[1]){
            swap(nums,0,1);
        }
    }

    public static void heapAdjust(int[] nums,int start,int length){
        if (length == 2){
            return;
        }
        int k = 2 * start + 1;
        if (nums[k + 1] > nums[k]){
            k++;
        }
        if (nums[k] > nums[start]){
            //交换
            swap(nums,start,k);

            //交换之后需要重新构建
            for (int i = 2 * start + 1; i < length/2-1; i++) {
                heapAdjust(nums,i,length);
            }
        }
    }

    public static void swap(int[] nums,int i,int j){
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }


}
