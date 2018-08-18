package com.piyush.practice.miscellaneous;

import java.util.StringJoiner;

/**
 * @author Piyush Kumar.
 * @since 8/18/18.
 */
public class StringJoinerExample {

    public static void main(String[] args) {
        StringJoiner joiner = new StringJoiner(",");

        System.out.println(joiner.add("Piyush").add("Satish").add("Iswar"));

        StringJoiner joiner1 = new StringJoiner(",","Sir","Hi");
        System.out.println(joiner1.add("Piyush").add("Satish").add("Iswar"));

        System.out.println(String.join("/", new String[]{"Piyush","Satish","Iswar"}));
    }
}
