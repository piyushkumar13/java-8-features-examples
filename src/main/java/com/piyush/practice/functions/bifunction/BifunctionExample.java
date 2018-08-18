package com.piyush.practice.functions.bifunction;

import java.util.function.BiFunction;
import java.util.function.Function;

/**
 * @author Piyush Kumar.
 * @since 8/12/18.
 */
public class BifunctionExample {

    public static void main(String[] args) {
        BiFunction<Integer, Integer, Integer> biFunction = (numA, numB) -> (numA + numB);
        System.out.println(biFunction.apply(10, 20));

        Function<Integer, String> function1 = (numA) -> "The result of square is ::: " + (numA * numA);
        System.out.println(function1.apply(30));

        /*
         * andThen applies the 2nd function to the result of the first function. Result of biFunction is 3+4=7 and the result
         * of function1 is 7*7=49
         */
        System.out.println(biFunction.andThen(function1).apply(3, 4));
    }
}
