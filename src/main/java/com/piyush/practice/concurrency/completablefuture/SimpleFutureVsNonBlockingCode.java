package com.piyush.practice.concurrency.completablefuture;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

/**
 * @author Piyush Kumar.
 * @since 8/15/18.
 */
public class SimpleFutureVsNonBlockingCode {

    public static void main(String[] args) throws Exception {
        ExecutorService es = Executors.newFixedThreadPool(4);

        Future<String> future = es.submit(() -> {
            System.out.println("Executing future..");

            Thread.sleep(2000);
            System.out.println("Now");
            return "Hello";
        });


        /* To mark future complete, we need to use future.get(). If we dont use future.get(), then thread will never complete and it will
         * always remain in execution state.*/
        System.out.println("The value of the future is ::: " + future.get()); // Problem here is future.get() is blocking. Any line of code after it will be blocked till future gets resolved.
        es.shutdown();

        System.out.println("------------------------------------Non blocking code with Java 8 CompletableFuture---------");
        CompletableFuture.supplyAsync(() -> "Hello").thenAccept(System.out::println);
        CompletableFuture.supplyAsync(() -> "world").thenAccept(System.out::println);
        System.out.println("Executing..");

    }
}
