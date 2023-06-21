package com.cl.test.thread;

/**
 * @author sampson chen
 * @date 2021年09月02日 9:39
 */
public class Join {


    public static void main(String[] args) throws InterruptedException {
        Thread thread1 = new Thread(() -> {
            for (int i=0;i<2000;i++) {
                System.out.println("first");
            }
        });

        Thread thread2 = new Thread(() -> {
            for (int i=0;i<2000;i++) {
                System.out.println("second");
            }
        });

        thread2.join();
        thread1.join();

        thread1.start();
        thread2.start();

        System.out.printf("ggggggggggggggggggggg");





    }

}
