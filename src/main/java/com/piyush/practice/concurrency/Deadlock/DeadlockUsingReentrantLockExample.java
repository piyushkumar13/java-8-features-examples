package com.piyush.practice.concurrency.Deadlock;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author Piyush Kumar.
 * @since 5/29/19.
 */
public class DeadlockUsingReentrantLockExample {

    private static final ReentrantLock lock1 = new ReentrantLock();
    private static final ReentrantLock lock2 = new ReentrantLock();

    public static void main(String[] args) {

        Thread thread1 = new Thread(() -> {
            lock1.lock();
            System.out.println("Lock 1 acquired in thread 1");
            System.out.println("Wating for lock 2 in thread 1");
            try {
                TimeUnit.SECONDS.sleep(1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            lock2.lock();
            System.out.println("Lock 2 acquired in thread 1");

            lock2.unlock();
            System.out.println("Unlocked lock 2 in thread 1");
            lock1.unlock();
            System.out.println("Unlocked lock 1 in thread 1");
        });

        Thread thread2 = new Thread(() -> {
            lock2.lock();
            System.out.println("Lock 2 acquired in thread 2");
            System.out.println("Wating for lock 1 in thread 2");
            try {
                TimeUnit.SECONDS.sleep(1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            lock1.lock();
            System.out.println("Lock 1 acquired in thread 2");

            lock1.unlock();
            System.out.println("Unlocked lock 1 in thread 2");

            lock2.unlock();
            System.out.println("Unlocked lock 2 in thread 2");
        });

        thread1.start();
        thread2.start();
    }

}
