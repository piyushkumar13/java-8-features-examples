package com.piyush.practice.lambdaexp;

/**
 * @author Piyush Kumar.
 * @since 8/10/18.
 */
public class ThreadsWithLambdaExp {

    public static void main(String[] args) throws Exception {
        Runnable runnable = () -> {
            for (int i = 0; i < 10; i++) {
                System.out.println("This is child thread ::: " + Thread.currentThread().getName());
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        };

        Thread myThread = new Thread(runnable);
        myThread.start();

        /* I can also replace above line by
        *
        Thread myThread = new Thread(() -> {
            for (int i = 0; i < 10; i++) {
                System.out.println("This is child thread ::: " + Thread.currentThread().getName());
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });
        myThread.start();
        *
        * */

        Thread.sleep(1000);
        for (int i = 0; i < 10; i++) {
            System.out.println("This is main thread ::: " + Thread.currentThread().getName());
        }
    }
}
