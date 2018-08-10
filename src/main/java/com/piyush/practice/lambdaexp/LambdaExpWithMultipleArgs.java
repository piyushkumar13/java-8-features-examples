package com.piyush.practice.lambdaexp;

import com.piyush.practice.lambdaexp.functionalinterfaces.ILambdaExpWithMutlipleArgs;

/**
 * @author Piyush Kumar.
 * @since 8/10/18.
 */
public class LambdaExpWithMultipleArgs {

    public static void main(String[] args) {
        ILambdaExpWithMutlipleArgs expWithMutlipleArgs = (id, name) -> System.out.printf("The dummy id is  %d and name is %s", id, name);
        expWithMutlipleArgs.execute(1,"Piyush Kumar");
    }
}
