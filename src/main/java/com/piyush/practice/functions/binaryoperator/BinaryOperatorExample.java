package com.piyush.practice.functions.binaryoperator;

import com.piyush.practice.domain.model.Student;

import java.util.*;
import java.util.function.BinaryOperator;
import java.util.function.UnaryOperator;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * @author Piyush Kumar.
 * @since 8/12/18.
 */
public class BinaryOperatorExample {

    public static void main(String[] args) {
        BinaryOperator<Integer> binaryOperator = (i, j) -> i * j;

        Map<Integer, Integer> map = new HashMap<>();
        map.put(1, 2);
        map.put(2, 3);
        map.put(3, 4);
        map.put(4, 5);
        map.put(5, 6);

        map.forEach((i, j) -> System.out.println(binaryOperator.apply(i, j)));

        System.out.println("------------------------------Grouping By, minBy and maxBy example--------------------------");

        List<Student> students = new ArrayList<>();

        students.add(Student.builder().id(1001).name("Piyush Kumar").address("Bangalore").markPercentage(84).subject("Science").build());
        students.add(Student.builder().id(1002).name("Vikas").address("Delhi").markPercentage(80).subject("Science").build());
        students.add(Student.builder().id(1003).name("Anand").address("Delhi").markPercentage(81).subject("Science").build());
        students.add(Student.builder().id(1004).name("Sourabh").address("Delhi").markPercentage(82).subject("Science").build());
        students.add(Student.builder().id(1005).name("Teenu").address("Delhi").markPercentage(84).subject("commerce").build());
        students.add(Student.builder().id(1006).name("Neeraj").address("Delhi").markPercentage(85).subject("commerce").build());
        students.add(Student.builder().id(1007).name("Sumit").address("Delhi").markPercentage(82).subject("commerce").build());
        students.add(Student.builder().id(1008).name("Amarjeet").address("Delhi").markPercentage(86).subject("commerce").build());
        students.add(Student.builder().id(1009).name("Deepak").address("Delhi").markPercentage(80).subject("commerce").build());


        Comparator<Student> studentComparator = Comparator.comparing(Student::getMarkPercentage);

        BinaryOperator<Student> binaryOperator1 = BinaryOperator.maxBy(studentComparator);
        System.out.println(binaryOperator1.apply(students.get(7), students.get(1)));

        BinaryOperator<Student> binaryOperator2 = BinaryOperator.minBy(studentComparator);
        System.out.println(binaryOperator2.apply(students.get(0), students.get(1)));

        /* We can also use Collectors.minBy(..) to get the minimum marks. */
        Map<String, Optional<Student>> optionalMap = students.stream().collect(Collectors.groupingBy(Student::getSubject, Collectors.maxBy(studentComparator)));

        optionalMap.forEach((subject, marks) -> {
            System.out.println("The subject is ::: "+ subject);
            System.out.println("The student with maximum marks is :::: " + marks.orElse(null));
        });
    }
}
