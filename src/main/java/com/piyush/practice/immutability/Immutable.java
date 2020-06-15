package com.piyush.practice.immutability;

/**
 * Refer link : https://stackoverflow.com/a/12306696/5527839
 *
 * @author Piyush Kumar.
 * @since 2020-04-18.
 */
public class Immutable {
    private final int value;

    public Immutable(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }
}
