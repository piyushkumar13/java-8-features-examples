package com.piyush.practice.concurrency.completablefuture;

/**
 * @author Piyush Kumar.
 * @since 8/18/18.
 */

import java.util.concurrent.CompletableFuture;

/**
 * thenCombine() is used to combine two independent CompletableFuture.
 */
public class ThenCombineExample {

    public static void main(String[] args) {

        CompletableFuture<String> helloCompletableFuture = CompletableFuture.supplyAsync(() -> "Hello ");
        CompletableFuture<String> worldCompletableFuture = CompletableFuture.supplyAsync(() -> "World!!");

        helloCompletableFuture.thenCombine(worldCompletableFuture, (helloCF, worldCF)-> helloCF + worldCF).thenAccept(System.out::println);
    }
}
