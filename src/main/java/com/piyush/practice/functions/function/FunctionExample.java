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
        Function<List<String>, Integer> function = list -> list.size();
        int count = function.apply(asList("Piyush", "Kumar"));
        System.out.println("The number of names in the list are ::: " + count);

        System.out.println("-------------------Default method example--------------------------");

        Function<Integer, Integer> function1 = numA -> numA + 10;

        Function<Integer, Integer> function2 = numB -> numB * 10;

        /* Here, first function2 will be applied to the passed value i.e 3 and then function1 will be applied to the result.
         * Here, result will be 40. */
        int composeResult = function1.compose(function2).apply(3);
        System.out.println("The result of the composed function is ::: " + composeResult);

        /* Here, first function1 will be applied to the passed value i.e 3 and then function2 will be applied to the result.
         * Here, the result will be 130.*/
        int andThenResult = function1.andThen(function2).apply(3);
        System.out.println("The result of the andThen function is ::: " + andThenResult);
    }
}