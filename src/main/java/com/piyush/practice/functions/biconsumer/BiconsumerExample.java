package com.piyush.practice.functions.biconsumer;

import com.piyush.practice.domain.model.Student;

import java.util.HashMap;
import java.util.Map;
import java.util.function.BiConsumer;

/**
 * @author Piyush Kumar.
 * @since 8/12/18.
 */
public class BiconsumerExample {

    public static void main(String[] args) {
        Map<Integer, Student> studentMap = new HashMap<>();
        studentMap.put(1001, Student.builder().id(1001).name("PiyushK").address("Bangalore").build());
        studentMap.put(1002, Student.builder().id(1002).name("IswarS").address("Bangalore").build());
        studentMap.put(1003, Student.builder().id(1003).name("SatishP").address("Bangalore").build());
        studentMap.put(1004, Student.builder().id(1004).name("VikasS").address("Delhi").build());
        studentMap.put(1005, Student.builder().id(1005).name("AnandA").address("Delhi").build());
        studentMap.put(1006, Student.builder().id(1006).name("HimanshuT").address("Delhi").build());
        studentMap.put(1007, Student.builder().id(1007).name("NileshK").address("Delhi").build());

        BiConsumer<Integer, Student> biConsumer = (id, student) -> System.out.println("The id is ::: " + id + " The student is ::: " + student);

        studentMap.forEach(biConsumer);

        System.out.println("\n-----------------BiConsumer andThen default method------------------------");

        BiConsumer<Integer, Integer> biConsumer1 = (num1, num2) -> System.out.println("Adder result is ::: " + (num1 + num2));
        BiConsumer<Integer, Integer> biConsumer2 = (num1, num2) -> System.out.println("Multiplier result is ::: " + (num1 * num2));

        biConsumer1.andThen(biConsumer2).accept(10, 30);
    }
}
