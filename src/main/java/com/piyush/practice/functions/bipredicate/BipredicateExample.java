package com.piyush.practice.functions.bipredicate;

import java.util.function.BiPredicate;

/**
 * @author Piyush Kumar.
 * @since 8/12/18.
 */
public class BipredicateExample {

    public static void main(String[] args) {
        BiPredicate<String, String> biPredicate = (str1, str2) -> str1.equals(str2);
        String msg = biPredicate.test("Piyush", "Kumar") ? "The two strings are equal" : "The two strings are not equal";
        System.out.println(msg);

    }
}
