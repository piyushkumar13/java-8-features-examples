package com.piyush.practice.concurrency.completablefuture;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.function.Function;

/**
 * @author Piyush Kumar.
 * @since 8/15/18.
 */

/**
 * CompletableFuture is like promises in Javascript. CompletableFuture like promises says that it will return the value after some time
 * after doing the specified computation.
 * CompletableFuture unlike Future has huge amount of apis. CompletableFuture though a single class but with such massive amount of apis
 * makes it itself a framework.
 * CompletableFuture has api to mark the future complete or cancel explicitly and many more. Let’s say that you’ve written a function to fetch
 * the latest price of an e-commerce product from a remote API. Since this API call is time-consuming, you’re running it in a separate thread
 * and returning a Future from your function. Now, let’s say that If the remote API service is down, then you want to complete the Future manually
 * by the last cached price of the product.Can you do this with Future? No! But you can definitely do with the CompletableFuture.
 */
public class SimpleCompletableFutureExample {

    public CompletableFuture<String> getMessage(ExecutorService es) {
        CompletableFuture<String> completableFuture = new CompletableFuture<>();

         es.execute(() -> {
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            completableFuture.complete("Hello!!");
        });

        System.out.println("Execute firsts since async calls are there.");

        return completableFuture;
    }


    public static void main(String[] args) throws Exception{

//        System.out.println("Cores on my system ::: " + Runtime.getRuntime().availableProcessors()); // This gives how many cores are present in underlying processor.

        ExecutorService es = Executors.newFixedThreadPool(1);
        SimpleCompletableFutureExample futureExample = new SimpleCompletableFutureExample();
        CompletableFuture<String> completableFuture = futureExample.getMessage(es);
        System.out.println("The completable future result is ::: "+ completableFuture.get());

    }
}
