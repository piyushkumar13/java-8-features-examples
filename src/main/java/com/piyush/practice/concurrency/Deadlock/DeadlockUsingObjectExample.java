package com.piyush.practice.concurrency.Deadlock;

import java.util.concurrent.TimeUnit;

/**
 * @author Piyush Kumar.
 * @since 5/29/19.
 */
public class DeadlockUsingObjectExample {
    private static final Object obj1 = new Object();
    private static final Object obj2 = new Object();

    public static void main(String[] args) {
        Thread thread1 = new Thread(() -> {

            synchronized (obj1) {
                System.out.println("Lock 1 acquired in thread 1");
                System.out.println("Wating for lock 2 in thread 1");
                try {
                    TimeUnit.SECONDS.sleep(1);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

                synchronized (obj2) {
                    System.out.println("Lock 2 acquired in thread 1");
                }
            }
        });

        Thread thread2 = new Thread(() -> {

            synchronized (obj2) {
                System.out.println("Lock 2 acquired in thread 2");
                System.out.println("Wating for lock 1 in thread 2");
                try {
                    TimeUnit.SECONDS.sleep(1);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                synchronized (obj1) {
                }
                System.out.println("Lock 1 acquired in thread 2");
            }
        });

        thread1.start();
        thread2.start();
    }
}
