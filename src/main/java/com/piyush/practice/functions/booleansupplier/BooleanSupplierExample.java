package com.piyush.practice.functions.booleansupplier;

import java.util.function.BooleanSupplier;

/**
 * @author Piyush Kumar.
 * @since 8/12/18.
 */
public class BooleanSupplierExample {

    public static void main(String[] args) {
        BooleanSupplier booleanSupplier = () -> true;
        System.out.println(booleanSupplier.getAsBoolean());

        int x = 100;
        int y = 101;

        booleanSupplier = () -> x > y;
        System.out.println(booleanSupplier.getAsBoolean());
    }
}
