package com.piyush.practice.streams.infinitestreams;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * @author Piyush Kumar.
 * @since 8/11/18.
 */
public class InfiniteStreamExample {

    public static void main(String[] args) {

        System.out.println("\n----------------Creating infinite stream-----------------------------------");
        Stream<Integer> infiniteStream = Stream.iterate(1, i -> i+2);
        List<Integer> limitedList = infiniteStream.limit(10).collect(Collectors.toList());
        System.out.println(limitedList);

        System.out.println("\n----------------Creating infinite stream for custom types-------------------");
        Stream<UUID> infiniteSteamForUUID = Stream.generate(UUID::randomUUID);
        List<UUID> uuids = infiniteSteamForUUID.skip(10).limit(10).collect(Collectors.toList()); // here skip will skip first 10 UUIDs and then start considering UUIDs.
        uuids.forEach(System.out::println);

    }
}
