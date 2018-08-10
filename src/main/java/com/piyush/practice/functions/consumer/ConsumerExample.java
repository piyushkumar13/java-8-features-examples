package com.piyush.practice.functions.consumer;

import java.util.function.Consumer;

/**
 * @author Piyush Kumar.
 * @since 8/10/18.
 */
public class ConsumerExample {

    public static void main(String[] args) {
        Consumer<String> consumer = name -> System.out.println("The authors name is ::: "+ name);
        consumer.accept("Piyush Kumar");
    }
}
