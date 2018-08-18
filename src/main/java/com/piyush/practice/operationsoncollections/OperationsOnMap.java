package com.piyush.practice.operationsoncollections;

import com.piyush.practice.domain.model.Student;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;
import java.util.concurrent.ConcurrentHashMap;

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

        System.out.println("\n-----------------------------ConcurrentHashMap operations---------------------------------");

        ConcurrentHashMap<Integer, UUID> uuidConcurrentHashMap = new ConcurrentHashMap<>();

        for (int i = 1; i <= 100; i++) {
            uuidConcurrentHashMap.put(i, UUID.randomUUID());
        }

        /* Here, 5 defines 5 elements will be processed at one time i.e in parallel. We can also say that 5 threads at a time working on
         * this hashmap. */
        uuidConcurrentHashMap.forEach(5, (k, v) -> {
            System.out.println("My threads used "+Thread.currentThread().getName());
            System.out.println("The key is ::: " + k + " The value is ::: " + v + " The Thread is ::: " + Thread.currentThread().getName());
        });

        uuidConcurrentHashMap.forEachKey(5, k -> System.out.println("The key is ::: " + k));
        uuidConcurrentHashMap.forEachValue(5, v -> System.out.println("The value is ::: " + v));
        uuidConcurrentHashMap.forEachEntry(5, e -> System.out.println("The entry is ::: " + e + " in which key is ::: " + e.getKey() + " and value is ::: " + e.getValue()));

        /* We can also search in ConcurrentHashMap. We have four search operations search(most generic one), searchEntries, searchKeys
         * and searchValues. */
        UUID searchedValue = uuidConcurrentHashMap.search(5, (k, v) -> {
            if (k == 30) {
                return v;
            }
            return null;
        });

        System.out.println("Searched value is ::: " + searchedValue);

        /* We can also have reduce method which will reduce the value of map to a single value. There are other methods as well like
         * reduceEntries, reduceKeys, reduceValues.*/
        String reductionResult = uuidConcurrentHashMap.reduce(5, (k, v) -> {
            return k + "-" + v;
        }, (result1, result2) -> {
            return result1 + "," + result2;
        });

        System.out.println("The reduction result is ::: " + reductionResult);
    }

}
