package com.piyush.practice.functions.supplier;

import java.util.function.Supplier;

/**
 * @author Piyush Kumar.
 * @since 8/10/18.
 */
public class SupplierExample {

    public static void main(String[] args) {
        Supplier<Integer> supplier = "Piyush Kumar"::length;
        System.out.println("The number of characters in the name is ::: " + supplier.get());
    }
}