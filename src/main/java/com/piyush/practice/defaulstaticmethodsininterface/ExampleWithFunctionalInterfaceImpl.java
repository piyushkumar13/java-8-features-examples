package com.piyush.practice.defaulstaticmethodsininterface;

/**
 * @author Piyush Kumar.
 * @since 8/10/18.
 */
public class ExampleWithFunctionalInterfaceImpl implements ExampleWithFunctionalInterface {

    @Override
    public void execute() {

        System.out.println("Execute method call inside implementing class.");
        display();
    }

    /*
    * We can also override the default method. So, the display() call in execute() will call the overridden implementation not the
    * default implementation.
    * */
    /*
    @Override
    public void display(){
        System.out.println("Overridden default method.");
    }*/

    public static void main(String[] args) {
        ExampleWithFunctionalInterface.message();

        ExampleWithFunctionalInterface exampleWithFunctionalInterface = () -> System.out.println("This is lambda expression.");
        ExampleWithFunctionalInterface exampleWithFunctionalInterface1 = new ExampleWithFunctionalInterfaceImpl();

        exampleWithFunctionalInterface.execute();
        exampleWithFunctionalInterface1.execute();

        /* It means the lambda expression also instantiate the interface reference.*/
        exampleWithFunctionalInterface1.display();
    }
}
