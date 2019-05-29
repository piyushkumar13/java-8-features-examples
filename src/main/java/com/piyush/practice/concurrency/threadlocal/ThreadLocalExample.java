package com.piyush.practice.concurrency.threadlocal;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * Example to show if thread from the threadpool is already having the value and then this thread is reused, will it
 * have this value present. Answer is yes it will have. Since Threadlocal is nothing but a hashmap and it will contain
 * the value as long as you are not removing it from the Threadlocal by using remove() method.
 *
 * @author Piyush Kumar.
 * @since 5/27/19.
 */
public class ThreadLocalExample {

    private static ThreadLocal<Integer> local = new ThreadLocal<>();
    private static AtomicInteger atomicInteger = new AtomicInteger(1);

    public static void main(String[] args) throws Exception {

        ExecutorService service = Executors.newFixedThreadPool(2);
        Runnable runnable1 = () -> {
            local.remove();

            System.out.println("The thread name is ::: " + Thread.currentThread());
            System.out.println("The value of thread local before set is :::: " + local.get() + "for thread ::: " + Thread.currentThread().getName());

            local.set(atomicInteger.getAndIncrement());
            System.out.println("The value set for current thread "+ Thread.currentThread().getName() +  " is ::: " + local.get());

        };
        Runnable runnable2 = () -> {
            local.remove();

            System.out.println("The thread name is ::: " + Thread.currentThread().getName());
            System.out.println("The value of thread local before set is :::: " + local.get() + "for thread ::: " + Thread.currentThread().getName());


            local.set(atomicInteger.getAndIncrement());
            System.out.println("The value set for current thread "+ Thread.currentThread().getName() +  " is ::: " + local.get());
        };
        Runnable runnable3 = () -> {
            local.remove();

            System.out.println("The thread name is ::: " + Thread.currentThread().getName());
            System.out.println("The value of thread local before set is :::: " + local.get() + "for thread ::: " + Thread.currentThread().getName());


            local.set(atomicInteger.getAndIncrement());
            System.out.println("The value set for current thread "+ Thread.currentThread().getName() +  " is ::: " + local.get());

        };
        Runnable runnable4 = () -> {
            local.remove();

            System.out.println("The thread name is ::: " + Thread.currentThread().getName());
            System.out.println("The value of thread local before set is :::: " + local.get() + "for thread ::: " + Thread.currentThread().getName());


            local.set(atomicInteger.getAndIncrement());
            System.out.println("The value set for current thread "+ Thread.currentThread().getName() +  " is ::: " + local.get());

        };
        Runnable runnable5 = () -> {
            local.remove();

            System.out.println("The thread name is ::: " + Thread.currentThread().getName());
            System.out.println("The value of thread local before set is :::: " + local.get() + "for thread ::: " + Thread.currentThread().getName());


            local.set(atomicInteger.getAndIncrement());
            System.out.println("The value set for current thread "+ Thread.currentThread().getName() +  " is ::: " + local.get());

        };
        service.submit(runnable1);
        service.submit(runnable2);
        service.submit(runnable3);
        service.submit(runnable4);
        service.submit(runnable5);


        Thread.sleep(2000);
//        System.out.println(local.get());
        service.shutdown();
    }
}
