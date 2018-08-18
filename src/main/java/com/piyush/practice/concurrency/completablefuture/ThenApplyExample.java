package com.piyush.practice.concurrency.completablefuture;

import com.piyush.practice.domain.model.Student;

import java.util.concurrent.*;

/**
 * @author Piyush Kumar.
 * @since 8/15/18.
 */

/**
 * thenApply() is used to combine two independent CompletableFuture.
 * In the following example, I am using executorservice as the 2nd argument to supplyAsyn method. If I am not putting executor service,
 * the program is getting terminated without executing the defined implementation. Without executor service, it uses the default forkjoin common pool
 * and getting terminated if thread from common pool is used. But Why? Here is the answer - refer <a href="https://stackoverflow.com/questions/51879659/completablefuture-is-not-getting-executed-if-i-use-the-executorservice-pool-its/51880799?noredirect=1#comment90715163_51880799">this</a>.
 */
public class ThenApplyExample {

    public static void main(String[] args) throws Exception {
        ExecutorService es = Executors.newCachedThreadPool();
        CompletableFuture<Student> studentCompletableFuture = CompletableFuture.supplyAsync(() -> {
            System.out.println("The thread is :: " + Thread.currentThread().getName() + Thread.currentThread().isDaemon());

            try {

                TimeUnit.SECONDS.sleep(2);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            return 3;

        }, es).thenApply(i -> {

            for (int j = 0; j <= i; j++) {
                System.out.println("Inside first then apply");
            }
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("First then apply is finished");
            return ++i;

        }).thenApply(i -> {
            System.out.println("Inside 2nd then apply");
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("Inside 2nd then apply stopped");

            return i++;

        }).thenApply(i -> {
            System.out.println("Inside 3nd then apply");
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("Inside 3nd then apply stopped");
            return "The i is ::: " + i;

        }).thenApply(s -> Student.builder().id(1).name(s).address("Some address").build());

        System.out.println("Executing..");
        System.out.println("Executing..");
        System.out.println("Executing..");
        System.out.println("Executing..");
        System.out.println("Executing..");

        es.shutdown();
//        studentCompletableFuture.get(); //blocks the code. Here, we have to block the code to get the result. If we dont block the program will exit
        //i.e main thread will exit and the computation done by threads will be killed.
    }
}
