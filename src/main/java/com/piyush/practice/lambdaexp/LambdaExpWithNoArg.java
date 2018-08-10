package com.piyush.practice.lambdaexp;

import com.piyush.practice.lambdaexp.functionalinterfaces.ILambdaExpWithNoArg;

/**
 * @author Piyush Kumar.
 * @since 8/10/18.
 */
public class LambdaExpWithNoArg {

    public static void main(String[] args) {
        ILambdaExpWithNoArg expWithNoArg = () -> System.out.println("This is lambda expression example");
        expWithNoArg.execute();
    }
}
