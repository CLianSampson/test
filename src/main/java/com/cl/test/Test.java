package com.cl.test;

import cn.hutool.core.date.DateTime;
import cn.hutool.core.util.RandomUtil;
import com.cl.test.config.MyConfig;
import com.cl.test.model.Student;
import org.apache.catalina.startup.Tomcat;
import org.springframework.boot.web.servlet.context.AnnotationConfigServletWebApplicationContext;
import org.springframework.boot.web.servlet.context.ServletWebServerApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.util.CollectionUtils;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;
import org.springframework.web.servlet.DispatcherServlet;

import java.math.BigDecimal;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.stream.Collectors;

/**
 * @author chen lian
 * @date 2021年09月28日 21:31
 */
public class Test {

    public static void main(String[] args) throws ParseException {

        System.out.println(RandomUtil.randomInt(0, 1));

//        testDiffDistance();
//        testBigLoop();

        WebApplicationContext context = new AnnotationConfigServletWebApplicationContext(MyConfig.class);

        DispatcherServlet servlet = new DispatcherServlet(context);

        Tomcat tomcat = new Tomcat();
        tomcat.addServlet("app","servlet",DispatcherServlet.class.getName());

    }







    public static void testBigLoop(){

        Set<Integer> set = new HashSet<>();
        for (int i = 0; i < 100000; i++) {
            set.add(i);
        }

        long startTime1 = System.currentTimeMillis();
        List<Integer> one = new ArrayList<>();
        for (int i = 0; i < 100; i++) {
            one.add(i);
            set.contains(i);
        }
        long time1 = System.currentTimeMillis()-startTime1;
        System.out.println("循环总耗时:" + time1);

        List<Integer> two = new ArrayList<>();
        for (int i = 0; i < 1000; i++) {
            two.add(i);
        }

        long startTiem = System.currentTimeMillis();
        for (Integer a : one) {
            for (Integer b : two) {
                System.out.println(a+b);
            }
        }
        long time = System.currentTimeMillis()-startTiem;
        System.out.println("循环总耗时:" + time);

    }


    public static  void  testDiffDistance(){
        //BigDecimal estimateDistance = new BigDecimal("109.50");
        //BigDecimal normalDistance = new BigDecimal("0.0");
        //BigDecimal test = new BigDecimal(normalDistance.subtract(estimateDistance).doubleValue());

        //System.out.println(normalDistance.subtract(estimateDistance).doubleValue());
        //System.out.println(test);

        testFilter();
    }

    public static void testFilter(){
        List<String> list = new ArrayList<>();
//        list.add("aaaa");
//        list.add("bbbb");
        list.add(null);

        list = list.stream().filter(Objects::nonNull).collect(Collectors.toList());

        System.out.println(list);
        System.out.println(CollectionUtils.isEmpty(list));
    }

    public static void testQuickSort(){
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
