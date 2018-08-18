package com.piyush.practice.concurrency.completablefuture;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

/**
 * @author Piyush Kumar.
 * @since 8/18/18.
 */

/**
 * thenApply() is used to combine two independent CompletableFuture.
 */
public class ThenComposeExample {

    private static CompletableFuture<String> getMessage() {

        return CompletableFuture.supplyAsync(() -> "Hello!!");
    }

    /**
     * The problem with thenApply is if you return a CompletableFuture from thenApply, the return type of this method will
     * be nested CompletableFuture as happening in the following example - return type of CompletableFuture.thenApply(..) is
     * CompletableFuture<CompletableFuture<String>> due to which next chained method will take CompletableFuture as an input to the
     * lambda function rather than any primitive, wrapper or user defined object. To flatten such kind of behavior we use thenCompose.
     */
    public static void main(String[] args) {

        CompletableFuture<CompletableFuture<String>> completableFutureForThenApply = CompletableFuture.supplyAsync(ThenComposeExample::getMessage);
        completableFutureForThenApply.thenApply(cf -> {
            System.out.println("The input here is CompletableFuture :::" + cf);
            return cf; //thenApply will return CompletableFuture as nested CompletableFuture i.e CompletableFuture<CompletableFuture<String>>
        }).thenAccept(cf -> {
            System.out.println("The input here is CompletableFuture" + cf);
        });

        /* Flattening result with thenCompose */

        CompletableFuture<CompletableFuture<String>> completableFutureForThenCompose = CompletableFuture.supplyAsync(ThenComposeExample::getMessage);
        completableFutureForThenCompose.thenCompose(cf -> {
            System.out.println("The input here is CompletableFuture object only :::" + cf);
            return cf; // Here s is CompletableFuture which will get flattened by thenCompose and passed to thenAccept as String
        }).thenAccept(s -> {
            System.out.println("The input here is String object ::: " + s);
        });
    }
}
