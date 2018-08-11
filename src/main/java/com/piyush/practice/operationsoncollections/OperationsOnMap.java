package com.piyush.practice.operationsoncollections;

import com.piyush.practice.domain.model.Student;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Piyush Kumar.
 * @since 8/11/18.
 */
public class OperationsOnMap {

    public static void main(String[] args) {
        Map<Integer, Student> studentMap = new HashMap<>();
        studentMap.put(1, Student.builder().id(1).name("Piyush Kumar").address("Bangalore").build());
        studentMap.put(2, Student.builder().id(1).name("Iswar").address("Bangalore").build());
        studentMap.put(3, Student.builder().id(1).name("Satish").address("Bangalore").build());

        studentMap.forEach((key, value) -> System.out.println("The key is ::: " + key + " The value is :::: " + value));
    }
}
