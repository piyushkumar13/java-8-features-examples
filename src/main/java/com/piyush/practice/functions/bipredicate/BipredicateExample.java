package com.piyush.practice.functions.bipredicate;

import com.sun.tools.internal.ws.wsdl.document.soap.SOAPUse;

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

        System.out.println("---------------------------BiPredicate default method AND and OR----------------------");

        BiPredicate<String, String> biPredicate1 = (str1, str2) -> str1.length() == str2.length();


        /* Both the BiPredicate i.e biPredicate and biPredicate1 should take the same times. The result of the biPredicate
           gets applied to the result of the biPredicate1.*/
        System.out.println(biPredicate.or(biPredicate1).test("Piyush", "Kumara"));
        System.out.println(biPredicate.and(biPredicate1).test("Piyush", "Kumara"));

        System.out.println(biPredicate.negate().test("Piyush", "Kumara"));
    }
}
