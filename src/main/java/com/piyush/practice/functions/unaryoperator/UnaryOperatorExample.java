package com.piyush.practice.functions.unaryoperator;

import java.util.function.UnaryOperator;
import java.util.stream.Stream;

/**
 * @author Piyush Kumar.
 * @since 8/12/18.
 */
public class UnaryOperatorExample {

    public static void main(String[] args) {
        UnaryOperator<Integer> unaryOperator = i -> i * i;
        Stream.of(1,2,3,4,5,6).forEach(i ->  System.out.println(unaryOperator.apply(i)));
    }
}
