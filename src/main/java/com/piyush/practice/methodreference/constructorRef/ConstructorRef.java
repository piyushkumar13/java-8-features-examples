package com.piyush.practice.methodreference.constructorRef;

/**
 * @author Piyush Kumar.
 * @since 8/10/18.
 */
public class ConstructorRef {
    private String name;
    private int age;

    private ConstructorRef(String name, int age){
        this.name = name;
        this.age = age;
    }

    public static void main(String[] args) {
        FuncInterfaceForConstructor forConstructor = ConstructorRef::new;
        ConstructorRef ref = forConstructor.factoryObj("Piyush", 28);
        System.out.println("The name is ::: "+ ref.name + " and the age is ::: "+ ref.age);
    }
}
