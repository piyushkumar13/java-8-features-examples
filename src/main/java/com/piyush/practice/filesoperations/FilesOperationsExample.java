package com.piyush.practice.filesoperations;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

/**
 * @author Piyush Kumar.
 * @since 8/12/18.
 */
public class FilesOperationsExample {

    public static void main(String[] args) {

        Path path = Paths.get("samplefile.txt");

        System.out.println("--------------------------Files.lines Example--------------------------");

       /* We can also provide try like this. It actually automatically closes the resource,
        you dont have to close the resource manually. It was introduced in java 7.*/
        try (Stream<String> fileStream = Files.lines(path, Charset.forName("UTF-8"))) {
            fileStream.forEach(System.out::println);
        } catch (IOException e) {
            e.printStackTrace();
        }

        System.out.println("\n--------------------------Files.readAllLines Example--------------------");
        try {
            List<String> lines = Files.readAllLines(path);
            lines.forEach(System.out::println);
        } catch (IOException e) {
            e.printStackTrace();
        }

        System.out.println("\n--------------------------Files.readAllLines Example---------------------");
        try {
            BufferedReader linesReader = Files.newBufferedReader(path);
            linesReader.lines().forEach(System.out::println);
        } catch (IOException e) {
            e.printStackTrace();
        }

        System.out.println("\n--------------------------Files.write Example---------------------");
        String str = "Writting data to the file";
        try {
            Path path1 = Files.write(path, str.getBytes(), StandardOpenOption.WRITE);
            System.out.println("Written to file at path ::: " + path1.toUri().getPath());
        } catch (IOException e) {
            e.printStackTrace();
        }

        System.out.println("\n--------------------------Files.write with Collection Example---------------------");
        ArrayList<String> names = new ArrayList<>();
        names.add("Piyush");
        names.add("Satish");
        names.add("Iswar");
        names.add("Sourab");

        try {
            Path path1 = Files.write(path, names, Charset.forName("UTF-8"), StandardOpenOption.WRITE);
            System.out.println("Written to file at path ::: " + path1.toUri().getPath());
        } catch (IOException e) {
            e.printStackTrace();
        }

        System.out.println("\n--------------------------BufferedReader Example---------------------");
        try {
            BufferedReader reader = new BufferedReader(new FileReader("samplefile.txt"));
            reader.lines().forEach(System.out::println);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }
}