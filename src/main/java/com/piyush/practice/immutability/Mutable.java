package com.piyush.practice.immutability;

/**
 * Refer link : https://stackoverflow.com/a/12306696/5527839
 * 
 * @author Piyush Kumar.
 * @since 2020-04-18.
 */
public class Mutable extends Immutable {
    private int realValue;

    public Mutable(int value) {
        super(value);

        realValue = value;
    }

    public int getValue() {
        return realValue;
    }

    public void setValue(int newValue) {
        realValue = newValue;
    }

    public static void main(String[] arg) {
        Mutable obj = new Mutable(4);
        Immutable immObj = (Immutable) obj;
        System.out.println(immObj.getValue());
        obj.setValue(8);
        System.out.println(immObj.getValue());
    }
}