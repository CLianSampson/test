package com.cl.test.algorithm;


import com.cl.test.algorithm.sort.BubbleSort;

/**
 * @author chen lian
 * @date 2021年09月24日 9:31
 */
public class Today {

    public static void main(String[] args) {
        int[] nums = {55,12,80,1,8,6,90,100,52};
        //quickSort(nums,0,nums.length-1);
        //bubbleSortttt(nums);
        //quickSort(nums,0,nums.length-1);
        //bubbleSort0620(nums);
        //quickSort0623(nums,0,nums.length-1);
        //quickSort0624(nums,0,nums.length-1);
        //quickSort0706(nums,0,nums.length-1);

        //标准
        //bubbleSort20230705(nums);
        //错误冒泡排序，虽然能实现
        //bubbleSortttt(nums);
        //bubbleSort0706(nums);

        //qucikSort0706(nums,0,nums.length-1);
        qucikSort0707(nums,0,nums.length-1);

        for (int i = 0; i < nums.length; i++) {
            System.out.println(nums[i]);
        }
    }



    public static void quickSort0706(int[] nums,int l,int r){
        if (l>=r) return;
        int i = l;
        int j = r;
        int curr = nums[i];
        while (i<j && nums[j] > curr) j--;
        nums[i] = nums[j];
        while (i<j && nums[i] < curr) i++;
        nums[j] = nums[i];

        nums[i] = curr;
        quickSort0706(nums,0,i);
        quickSort0706(nums,i+1,r);

    }




    public static void quickSort0629(int[] nums,int l, int r){
        if (l>=r) return;
        int i = l;
        int j = r;
        int curr = nums[i];
        while (i<j && nums[j] > curr) j--;
        nums[i] = nums[j];
        while (i<j && nums[i] < curr) i++;
        nums[j] = nums[i];

        nums[i] = curr;
        quickSort0629(nums,0,i);
        quickSort0629(nums,i+1,r);
    }


    public static void quickSort0624(int[] nums,int l,int r){
        if (l>=r) return;
        int i = l;
        int j = r;
        int curr = nums[i];
        while (i<j && curr < nums[j]) j--;
        nums[i] = nums[j];
        while (i<j && curr > nums[i]) i++;
        nums[j] = nums[i];

        nums[i] = curr;
        quickSort(nums,0,i);
        quickSort(nums,i+1,r);
    }










    public static void quickSort0623(int[] nums,int l,int r){
        if (l>=r)return;
        int i = l;
        int j = r;
        int curr = nums[i];
        while (i<j && nums[j]>=curr)j--;
        nums[i] = nums[j];
        while (i<j && nums[i]<curr)i++;
        nums[j] = nums[i];

        nums[i] = curr;
        quickSort0623(nums,0,i);
        quickSort0623(nums,i+1,r);
    }









    public static void quickSort0620(int[] nums,int l,int r){
        int i = l;
        int j = r;
        int curr = nums[i];
        while (i<j && nums[j] >= curr) j--;
        nums[j] = nums[i];
        while (i<j && nums[i] < curr) i++;
        nums[i] = nums[j];

        nums[i] = curr;
        quickSort(nums,0,i);
        quickSort(nums,i+1,r);
    }


    public static void  bubbleSort0620(int[] nums){
        int l = nums.length;
        for (int i = 0; i < l; i++) {
            for (int j = i+1; j < l; j++) {
                if (nums[i] > nums[j]){
                    int temp = nums[i];
                    nums[i] = nums[j];
                    nums[j] = temp;
                }
            }
        }
    }


    /**
     * 错误方法，虽然也能成功
     *
     */
    public static void bubbleSortttt(int[] nums){
        int l = nums.length;
        for (int i = 0; i < l; i++) {
            for (int j = 0; j < l; j++) {
                if (nums[i] < nums[j]){
                    int temp = nums[i];
                    nums[i] = nums[j];
                    nums[j] = temp;
                }
            }
        }
    }



    //2022-06-15
    public static void quickSort(int[] nums,int l,int r){
        if (l>=r) return;
        int i = l;
        int j = r;
        int curr = nums[i];
        while (i<j && nums[j] >= curr) j--;
        nums[i] = nums[j];
        while (i<j && nums[i] < curr)i++;
        nums[j] = nums[i];

        nums[i] = curr;
        quickSort(nums,0,i);
        quickSort(nums,i+1,r);
    }











    /**
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
    **/










    public static void bubbleSort20230705(int[] array){
        int length = array.length;
        for (int i = 0; i < length; i++) {
            for (int j = 1; j < length-i; j++) {
                if (array[j-1] > array[j]){
                    int temp = array[j-1];
                    array[j-1] = array[j];
                    array[j] = temp;
                }
            }
        }
    }





    public static void bubbleSort0706(int[] array){
        int l = array.length;
        for (int i = 0; i < l; i++) {
            for (int j = 0; j < l-i-1; j++) {
                if (array[j] > array[j+1]){
                    int temp = array[j];
                    array[j] = array[j+1];
                    array[j+1] = temp;
                }
            }
        }
    }

    /**
     * [10,21,8,15,9,20]
     * @param nums
     * @param l
     * @param r
     */
    public static void qucikSort0706(int[] nums,int l,int r){
        if (l >= r){
            return;
        }
        int i = l;
        int j = r;
        int temp = nums[i];

        while (i < j){
            while (i<j && nums[j] >= temp) {
                j--;
            }
            //把大的放右边
            nums[i] = nums[j];
            while (i<j && nums[i] <= temp) {
                i++;
            }
            //把小的放左边
            nums[j] = nums[i];
        }
        //此时 左边都比 temp小, 右边都比temp大
        nums[i] = temp;

        qucikSort0706(nums,0,i-1);
        qucikSort0706(nums,i+1,r);
    }





    public static void qucikSort0707(int[] array,int l,int r){
        if (l>=r){return;}

        int i = l;
        int j = r;
        int curr = array[i];

        while (i < j){
            while (i<j && array[j] > curr) j--;
            array[i] = array[j];
            while (i<j && array[i] < curr) i++;
            array[j] = array[i];
        }

        array[i] = curr;

        qucikSort0707(array,0,i-1);
        qucikSort0707(array,i+1,r);

    }


























































}
