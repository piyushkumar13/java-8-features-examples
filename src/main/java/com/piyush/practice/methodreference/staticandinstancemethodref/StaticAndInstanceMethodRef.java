package com.piyush.practice.methodreference.staticandinstancemethodref;

/**
 * @author Piyush Kumar.
 * @since 8/10/18.
 */
public class StaticAndInstanceMethodRef {

    public void printDetails(String name, int age){
        System.out.printf("The name is {%s} and age is {%d}.", name, age);
    }

    public static void listDetails(){
        System.out.println("The name is Piyush Kumar and age is 28 years.");
    }

    public static void main(String[] args) {
        FuncInterfaceForInstanceMethod instanceMethod = new StaticAndInstanceMethodRef()::printDetails;
        instanceMethod.execute("Piyush Kumar", 28);
        FuncInterfaceForStaticMethod staticMethod = StaticAndInstanceMethodRef::listDetails;
        staticMethod.execute();
    }
}
