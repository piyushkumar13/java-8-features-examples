package com.piyush.practice.streams;

import java.util.Arrays;
import java.util.Optional;
import java.util.OptionalInt;
import java.util.stream.IntStream;
import java.util.stream.Stream;

/**
 * @author Piyush Kumar.
 * @since 8/12/18.
 */

/**
 * reduce() method(or reduction) enables the user to provide their custom implementation for the terminal operations.
 */
public class StreamWithReductionExample {

    public static void main(String[] args) {
        /* The lambda expression passed to the reduce() is actually accumulator which specifies a logic for aggregation of elements. */
        OptionalInt optionalInt = IntStream.range(1, 4).reduce((a, b) -> a + b);

        /* Optional class or its specification classes like OptionalInt, OptionalLong etc are used to define the return values. But why to
        * return value in the Optional class. Because consider an example array which has all even numbers and you have created a stream for this array
        * and applied a map() with lambda expression to find odd. Here, the result will be null since there is no odd value. So, in such scenarios,
        * Optional class has some apis which allows you to return value if its present(present based on your map() lambda exp) else some default value or
        * you can define the value.
        *
        * Optional class makes your code more readable.
        * */
        System.out.println(optionalInt.isPresent() ? optionalInt.getAsInt() : null);
        //or
        optionalInt.ifPresent(System.out::println); // If value is present then perform some operation as per lambda exp.
        //or
        System.out.println(optionalInt.orElse(10)); // Returns the value if present else return the value you have passed in orElse() method, here 10.

        Optional<String> stringOptional = Stream.of("abc", "pk", "kumar", "piyush").reduce(String::concat);
        stringOptional.ifPresent(System.out::println);

        int value = IntStream.range(1, 4).reduce(10, (a, b) -> a + b);// here 10 is identity i.e some value which will be added to the overall result.
        System.out.println("The value is ::: " + value);


    }
}
