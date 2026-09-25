package com.piyush.practice.streams;

import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class StreamCollectors {


    public static void main(String[] args) {

        System.out.println("################# Joining #################### ");
        Stream<String> strStream1 = Stream.of("Piyush", "Prakhyat", "Birendra", "Gaurav", "Amogh");
        String joinedNames = strStream1.collect(Collectors.joining(","));
        System.out.println("The joined names are :: " + joinedNames);

        System.out.println("################# toSet #################### ");
        Stream<String> strStream2 = Stream.of("Piyush", "Piyush", "Birendra", "Gaurav", "Amogh");
        Set<String> strSet = strStream2.collect(Collectors.toSet());
        System.out.println("Set  :: " + strSet);

        System.out.println("################# toCollection #################### ");
        Stream<String> strStream3 = Stream.of("Piyush", "Prakhyat", "Birendra", "Gaurav", "Amogh");
        LinkedList<String> stringLinkedList = strStream3.collect(Collectors.toCollection(LinkedList::new));
        System.out.println("LinkedList :: " + stringLinkedList);

        System.out.println("################# toMap #################### ");
        Stream<String> strStream4 = Stream.of("Piyush", "Prakhyat", "Birendra", "Gaurav", "Amogh");
        Map<String, Integer> strMap = strStream4.collect(Collectors.toMap(String::valueOf, String::length));
        System.out.println("Map :: " + strMap);

        System.out.println("################# partitioningBy #################### ");
        Stream<Integer> intStream1 = Stream.of(9, 8, 1, 2, 4, 3, 5, 7);
        Map<Boolean, List<Integer>> partitionMap = intStream1.collect(Collectors.partitioningBy(i -> i % 2 == 0));
        System.out.println("Partition :: " + partitionMap);


        System.out.println("################# groupingBy #################### ");
        Stream<String> strStream5 = Stream.of("Piyush", "Prakhyat", "Birendra", "Gaurav", "Amogh");
        Map<Character, List<String>> charListMap = strStream5.collect(Collectors.groupingBy(s -> s.charAt(0)));
        System.out.println("groupingBy :: " + charListMap);

        System.out.println("################# groupingBy 2 #################### ");
        Stream<String> strStream6 = Stream.of("Piyush", "Prakhyat", "Birendra", "Gaurav", "Amogh");
        Map<Character, Long> charCountMap = strStream6.collect(Collectors.groupingBy(s -> s.charAt(0), Collectors.counting()));
        System.out.println("groupingBy 2 :: " + charCountMap);

        System.out.println("################# groupingBy 3 #################### ");
        Stream<String> strStream7 = Stream.of("Piyush", "Prakhyat", "Birendra", "Gaurav", "Amogh");
        Map<Character, List<Integer>> charListCountMap = strStream7.collect(Collectors.groupingBy(s -> s.charAt(0), Collectors.mapping(String::length, Collectors.toList())));
        System.out.println("groupingBy 3 :: " + charListCountMap);

        System.out.println("################# groupingBy 4 #################### ");
        Stream<String> strStream8 = Stream.of("Piyush", "Prakhyat", "Birendra", "Gaurav", "Amogh");
        Map<Character, List<String>> charListMap2 = strStream8.collect(Collectors.groupingBy(s -> s.charAt(0), Collectors.toList()));
        System.out.println("groupingBy 4 :: " + charListMap2);
    }
}
