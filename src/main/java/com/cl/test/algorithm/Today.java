package com.cl.test.algorithm;



/**
 * @author chen lian
 * @date 2021年09月24日 9:31
 */
public class Today {

    public static void main(String[] args) {
        int[] nums = {55,12,52,1,8,6,100,100,52};
        //quickSort(nums,0,nums.length-1);
        //bubbleSortttt(nums);
        //quickSort(nums,0,nums.length-1);
        //bubbleSort0620(nums);
        //quickSort0623(nums,0,nums.length-1);
        //quickSort0624(nums,0,nums.length-1);
        quickSort0706(nums,0,nums.length-1);


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



}
