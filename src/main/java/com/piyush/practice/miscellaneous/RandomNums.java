package com.piyush.practice.miscellaneous;

import java.util.Random;

/*
* Refer : https://www.geeksforgeeks.org/java/generating-random-numbers-in-java/
* */
public class RandomNums {

    public static void main(String[] args) {
        Random random = new Random();

        System.out.println("Int Random Number");
        int int1 = random.nextInt();
        System.out.println("int1 : " + int1);

        // Generate random number from 0 to 9
        System.out.println("Generate random number from 0 to 9");
        int int2 = random.nextInt(10);
        System.out.println("int2 : " + int2);

        // Generate random number from 1 to 10
        System.out.println("Generate random number from 1 to 10");
        int int3 = random.nextInt(10) + 1;
        System.out.println("int3 : " + int3);

        // Generate random number in given range
        System.out.println("Generate random number in given range");
        int min = 50;
        int max = 90;
        int int4 = random.nextInt((max-min) + 1) + min;
        System.out.println("int4 : " + int4);

        System.out.println("Boolean Random");
        boolean bool1 = random.nextBoolean();
        System.out.println("bool1 : " + bool1);

        System.out.println("Double Random");
        double double1 = random.nextDouble();
        System.out.println("double1 : " + double1);
    }
}
