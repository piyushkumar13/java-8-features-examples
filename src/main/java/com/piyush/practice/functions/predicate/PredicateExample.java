package com.piyush.practice.functions.predicate;

import java.util.function.Predicate;

/**
 * @author Piyush Kumar.
 * @since 8/10/18.
 */
public class PredicateExample {

    public static void main(String[] args) {
        Predicate<String> pEval1 = (name) -> name.length() > 5;
        System.out.println(pEval1.test("Piyush"));


        Predicate<String> pEval2 = (name) -> name.endsWith("sh");
        System.out.println(pEval2.test("Kumar"));

        System.out.println(pEval1.and(pEval2).test("Kumara"));
        System.out.println(pEval1.or(pEval2).test("Kumara"));
        System.out.println(pEval1.negate().test("Piyush"));


    }
}
