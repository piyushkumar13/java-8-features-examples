package com.piyush.practice.defaulstaticmethodsininterface;

/**
 * @author Piyush Kumar.
 * @since 8/10/18.
 */
public interface ExampleWithFunctionalInterface {

    void execute();

    default void display() {

        System.out.println("This is the default method.");
    }

    static void message() {

        System.out.println("This is the static method.");
    }
}