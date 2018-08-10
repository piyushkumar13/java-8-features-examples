package com.piyush.practice.lambdaexp;

import com.piyush.practice.lambdaexp.functionalinterfaces.ILambdaExpThrowsException;

/**
 * @author Piyush Kumar.
 * @since 8/10/18.
 */
public class LambdaExpThrowsException {

    public static void main(String[] args) throws Exception {

        ILambdaExpThrowsException expThrowsException = () -> {
            System.out.println("This is lambda expression example");
            Thread.sleep(1000);
            System.out.println("which throws checked exception.");
        };

        expThrowsException.execute();
    }
}
