package com.piyush.practice.concurrency.Deadlock;

import java.util.concurrent.TimeUnit;

/**
 * @author Piyush Kumar.
 * @since 5/29/19.
 */
public class DeadlockUsingAnyObjectExample {

    private static final String str1 = "lock1";
    private static final String str2 = "lock2";

    private Thread thread1 = new Thread(() -> {

        synchronized (str1) {
            System.out.println("Lock 1 acquired in thread 1");
            System.out.println("Wating for lock 2 in thread 1");
            try {
                TimeUnit.SECONDS.sleep(1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            synchronized (str2) {
                System.out.println("Lock 2 acquired in thread 1");
            }
        }
    });

    private Thread thread2 = new Thread(() -> {

        synchronized (str2) {
            System.out.println("Lock 2 acquired in thread 2");
            System.out.println("Wating for lock 1 in thread 2");
            try {
                TimeUnit.SECONDS.sleep(1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            synchronized (str1) {
            }
            System.out.println("Lock 1 acquired in thread 2");
        }
    });

    public static void main(String[] args) {

        /* Note : I have put thread outside psvm just trying out different way. You can keep it here as well. It will work. */

        DeadlockUsingAnyObjectExample dObj = new DeadlockUsingAnyObjectExample();
        dObj.thread1.start();
        dObj.thread2.start();
    }
}
