package com.piyush.practice.lambdaexp;

import com.piyush.practice.lambdaexp.functionalinterfaces.ILamdaExpWithOneArg;

/**
 * @author Piyush Kumar.
 * @since 8/10/18.
 */
public class LambdaExpWithOneArg {


    public static void main(String[] args) {
        ILamdaExpWithOneArg expWithOneArg = name -> System.out.println("This is the lambda expression example.");
        expWithOneArg.execute("This is the lambda expression example.");
    }

    /*
    * We can also use method reference to println method of System.out since println signature with the abstract method of Functional
    * interface ILamdaExpWithOneArg.
    */
    /*
    public static void main(String[] args) {
        ILamdaExpWithOneArg expWithOneArg = System.out::println;
        expWithOneArg.execute("This is the lambda expression with method reference example.");
    }
    */
}
