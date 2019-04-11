package com.piyush.practice.streams;

import com.piyush.practice.domain.model.Student;

import java.util.List;
import java.util.stream.Stream;

import static java.util.Arrays.asList;

/**
 * @author Piyush Kumar.
 * @since 4/9/19.
 */
public class StreamWithFlatMapExample {

    public static void main(String[] args) {
        Student student1 = Student.builder().id(1).name("Piyush").courses(new String[]{"Btech","Mtech"}).build();
        Student student2 = Student.builder().id(2).name("ABC").courses(new String[]{"Btech"}).build();
        Student student3 = Student.builder().id(3).name("XYZ").courses(new String[]{"Bsc","Msc"}).build();

        List<Student> students = asList(student1, student2, student3);
        Stream<Student> studentStream = students.stream();
        Stream<String[]> unflattenStream = studentStream.map(Student::getCourses);
        Stream<String> flattenStream = unflattenStream.flatMap(Stream::of);
        flattenStream.forEach(System.out::println);
    }
}
