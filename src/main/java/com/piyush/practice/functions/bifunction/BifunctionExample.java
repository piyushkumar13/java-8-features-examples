package com.piyush.practice.functions.bifunction;

import java.util.function.BiFunction;

/**
 * @author Piyush Kumar.
 * @since 8/12/18.
 */
public class BifunctionExample {

    public static void main(String[] args) {
        BiFunction<Integer, Integer, String> biFunction = (numA, numB) -> "The result is ::: " + (numA + numB);
        System.out.println(biFunction.apply(10, 20));
    }
}
