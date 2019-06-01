package com.piyush.practice.concurrency.Deadlock.withoutlambdas;

import java.util.concurrent.TimeUnit;

/**
 * @author Piyush Kumar.
 * @since 6/1/19.
 */
public class MyRunnable implements Runnable {

    private final Object lock1;
    private final Object lock2;

    public MyRunnable(Object lock1, Object lock2) {
        this.lock1 = lock1;
        this.lock2 = lock2;
    }

    @Override
    public void run() {

        synchronized (lock1){
            System.out.println("Lock 1 acquired in thread " + Thread.currentThread().getName());
            System.out.println("Wating for lock 2 in thread " + Thread.currentThread().getName());
            try {
                TimeUnit.SECONDS.sleep(1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            synchronized (lock2){
                System.out.println("Lock 2 acquired in thread " + Thread.currentThread().getName());
            }
        }

    }
}
