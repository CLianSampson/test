package com.cl.test.thread;

/**
 * @author sampson chen
 * @date 2021年09月02日 9:39
 */
public class Join {


    public static void main(String[] args) throws InterruptedException {
        Thread thread1 = new Thread(() -> {
            System.out.println("first");
        });

        Thread thread2 = new Thread(() -> {
            System.out.println("second");
        });

        thread1.join();
        thread2.join();

        thread2.start();
        thread1.start();

    }

}
