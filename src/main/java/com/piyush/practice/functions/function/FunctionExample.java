package com.piyush.practice.functions.function;

import java.util.List;
import java.util.function.Function;

import static java.util.Arrays.asList;

/**
 * @author Piyush Kumar.
 * @since 8/10/18.
 */
public class FunctionExample {

    public static void main(String[] args) {
        Function<List<String>, Integer> function1 = list -> list.size();
        int count = function1.apply(asList("Piyush", "Kumar"));
        System.out.println("The number of names in the list are ::: " + count);
    }
}