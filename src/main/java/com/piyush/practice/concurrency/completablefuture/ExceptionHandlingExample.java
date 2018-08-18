package com.piyush.practice.concurrency.completablefuture;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @author Piyush Kumar.
 * @since 8/18/18.
 */
public class ExceptionHandlingExample {

    public static void main(String[] args) {

        System.out.println("---------------------------exceptionally example----------------------------");
        CompletableFuture.supplyAsync(() -> "some result ").thenApply(s -> {
            throw new RuntimeException("Testing Exception");
            // return s + "processed";

        }).exceptionally(ex -> {
            System.out.println("Some exception occurred ::: " + ex);
            return "unknown result";

        }).thenAccept(System.out::println);


        System.out.println("\n---------------------------handle example----------------------------");
        CompletableFuture.supplyAsync(() -> "some result ").thenApply(s -> {
            throw new RuntimeException("Testing Exception");
            // return s + "processed";

        }).handle((res, ex) -> {
            System.out.println("Some exception occurred ::: " + ex);
            System.out.println("The response is ::: " + res); // res is null
            return "unknown result";

        }).thenAccept(System.out::println);

    }
}
