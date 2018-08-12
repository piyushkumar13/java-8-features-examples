package com.piyush.practice.filesoperations;

import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.stream.Stream;

/**
 * @author Piyush Kumar.
 * @since 8/12/18.
 */
public class FilesOperationsExample {

    public static void main(String[] args) {

        Path path = Paths.get("samplefile.txt");

       /* We can also provide try like this. It actually automatically closes the resource,
        you dont have to close the resource manually. It was introduced in java 7.*/
        try (Stream<String> fileStream = Files.lines(path, Charset.forName("UTF-8"))) {
            fileStream.forEach(System.out::println);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}