package com.cl.test;

import cn.hutool.core.date.DateTime;
import com.cl.test.model.Student;

import java.math.BigDecimal;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

/**
 * @author chen lian
 * @date 2021年09月28日 21:31
 */
public class Test {

    public static void main(String[] args) throws ParseException {
        BigDecimal rate = new BigDecimal(30).divide(new BigDecimal(31),15,BigDecimal.ROUND_HALF_DOWN);
        System.out.println(rate.doubleValue());

        Date inductionDate = new Date(1635758884000L);
        Date departureDate = new Date(1636018084000L);

        Calendar inductionCalendar = Calendar.getInstance();
        inductionCalendar.setTime(inductionDate);

        Calendar departureCalendar = Calendar.getInstance();
        departureCalendar.setTime(departureDate);

        int actualDay = departureCalendar.get(Calendar.DATE) - inductionCalendar.get(Calendar.DATE);

        System.out.println(actualDay);

        System.out.println(30 - inductionCalendar.get(Calendar.DATE));

        System.out.println("boundary-------");

        int[] nums = {100,85,99,46,88,77,99};
        quickSort(nums,0,nums.length-1);
        for (int i = 0; i < nums.length; i++) {
            System.out.println(nums[i]);
        }

        List list = new ArrayList();
        list.add(null);
        System.out.println("dfafsafdsfdsfdsf");
    }


    public static void quickSort(int[] nums,int l,int r){

        //****************************
       if (l >= r) return;

       int i = l;
       int j = r;
       int curr = nums[i];

       while (i < j){
           while (i < j && curr <= nums[j]) j--;
           nums[i] = nums[j];
           while (i < j && curr >= nums[i]) i++;
           nums[j] = nums[i];
       }

       nums[i] = curr;

       quickSort(nums,l,i-1);
       quickSort(nums,i+1,r);
    }



}
