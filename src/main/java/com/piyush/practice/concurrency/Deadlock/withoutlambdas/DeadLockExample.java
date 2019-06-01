package com.piyush.practice.concurrency.Deadlock.withoutlambdas;

/**
 * @author Piyush Kumar.
 * @since 6/1/19.
 */
public class DeadLockExample {

    public static void main(String[] args) {

        Object lock1 = new Object();
        Object lock2 = new Object();

        Thread thread1 = new Thread(new MyRunnable(lock1, lock2));
        Thread thread2 = new Thread(new MyRunnable(lock2, lock1));

        thread1.start();
        thread2.start();
    }
}
