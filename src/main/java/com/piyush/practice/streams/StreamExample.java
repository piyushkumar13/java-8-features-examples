package com.piyush.practice.streams;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static java.util.Arrays.asList;

/**
 * @author Piyush Kumar.
 * @since 8/10/18.
 */
public class StreamExample {

    public static void main(String[] args) {

        List<String> names = asList("Piyush", "Vikas", "Sheel", "Anand", "Iswar", "Satish", "Ruc","Anu");

        Stream<String> listStream = names.stream();
        List<Integer> namesLength = listStream.map(String::length).collect(Collectors.toList());
        System.out.println("The names lengths are ::: " + namesLength);

        /* We have to create stream again because once stream is used it gets closed.*/
        listStream = names.stream();
        List<String> newNamesList = listStream.filter(name -> name.length() == 6).collect(Collectors.toList());
        System.out.println("The new list of names is ::: " + newNamesList);

        listStream = names.stream();
        long count = listStream.filter(name -> name.length() == 3).count();
        System.out.println("The count of names is ::: " + count);

        listStream = names.stream();
        List<String> sortedNames = listStream.filter(name -> name.length() == 5).sorted().collect(Collectors.toList());
        System.out.println("The names in sorted order are ::: " + sortedNames);

        listStream = names.stream();
        String lastMinLengthName = listStream.min((s1,s2) -> s1.length() - s2.length()).get();
        System.out.println("The names with minimum length ::: " + lastMinLengthName);

        newNamesList.stream().forEach(System.out::println);
        //or
        newNamesList.forEach(System.out::println);

        String[] namesArray = newNamesList.stream().toArray(String[]::new);

        System.out.println("Converting list to array ::: ");
        for (String name : namesArray){
            System.out.println(name);
        }

        System.out.println("Using stream of method");
        Stream.of("ABC","XYZ","abc","xyz").forEach(System.out::println);

        System.out.println("Converting arrays to stream");
        String[] arr = new String[]{"pqrs","abcd"};
        Stream<String> stringStream = Arrays.stream(arr);
        stringStream.forEach(System.out::println);

        System.out.println("Using stream builder");
        Stream<String> streamBuilder = Stream.<String>builder().add("adb").add("acd").build();
        streamBuilder.forEachOrdered(System.out::println);

    }
}
