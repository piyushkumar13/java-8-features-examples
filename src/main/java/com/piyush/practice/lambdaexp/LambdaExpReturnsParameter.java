package com.piyush.practice.lambdaexp;

import com.piyush.practice.lambdaexp.functionalinterfaces.ILambdaExpReturnsParameter;

/**
 * @author Piyush Kumar.
 * @since 8/10/18.
 */
public class LambdaExpReturnsParameter {

    public static void main(String[] args) {
        ILambdaExpReturnsParameter expReturnsParameter = name -> "The author's name is : "+name;
        String result = expReturnsParameter.execute("Piyush Kumar");
        System.out.println(result);
    }
}
