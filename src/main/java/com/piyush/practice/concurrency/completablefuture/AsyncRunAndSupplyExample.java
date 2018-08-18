package com.piyush.practice.concurrency.completablefuture;

import java.util.concurrent.*;

/**
 * @author Piyush Kumar.
 * @since 8/15/18.
 */
public class AsyncRunAndSupplyExample {

    public static void main(String[] args) throws ExecutionException, InterruptedException {

        CompletableFuture<Void> voidCompletableFuture = CompletableFuture.runAsync(() -> {
            System.out.println("Inside run async run by ::: ");
            try {
                TimeUnit.SECONDS.sleep(3);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("With thread in run ::: " + Thread.currentThread().getName());

        });// We can also pass executors as the second parameter in runAsync() method.

        CompletableFuture<String> supplyAsyncFuture = CompletableFuture.supplyAsync(() -> {

            System.out.println("Inside supply async");

            try {
                TimeUnit.SECONDS.sleep(2);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("With thread in supply::: " + Thread.currentThread().getName());
            return "Hello";
        }); // We can also pass executors as the second parameter in supplyAsync() method.

        System.out.println("This line executes firsts..");

        while (!voidCompletableFuture.isDone() || !supplyAsyncFuture.isDone()) { //Blocking code
            System.out.println(".");
        }
        System.out.println("DONE");
        System.out.println(supplyAsyncFuture.get()); // supplyAsyncFuture.get() Blocking code.

        System.out.println("This line executes only after supplyAsyncFuture.get resolved..");
    }
}
