package com.piyush.practice.methodreference.constructorRef;

/**
 * @author Piyush Kumar.
 * @since 8/10/18.
 */
@FunctionalInterface
public interface FuncInterfaceForConstructor {
    ConstructorRef factoryObj(String name, int age);
}
