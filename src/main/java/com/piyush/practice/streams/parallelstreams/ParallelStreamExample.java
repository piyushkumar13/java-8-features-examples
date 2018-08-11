package com.piyush.practice.streams.parallelstreams;

import com.piyush.practice.domain.model.Student;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Piyush Kumar.
 * @since 8/11/18.
 */
public class ParallelStreamExample {

    /**
     * These days we have multicore processor, to use the capability of multicore processors parallelstream() api is very convinient.
     * It spawns up the multiple threads each thread running in the underlying processor's cores. Hence, it is very fast if you are
     * iterating over huge amount of data.
     * Before Java 8, to use the capability of multi core, you manually have to write the multithreaded program which will run on the multiple
     * cores. But now you dont have to write lot of code to handle multithreading, just one call to parallelstream() will do it for you.
     *
     * Note : If you notice the output of the program, it will not give the result in the order though linkedlist maintains the order. Thats
     * because multiple threads are working on the linkedlist.
     */
    private void executeParallelStream(List<Student> students){
        students.parallelStream().forEach(System.out::println);

    }

    public static void main(String[] args) {
        List<Student> students = new ArrayList<>();
        students.add(Student.builder().id(1).name("Piyush").address("Bangalore").build());
        students.add(Student.builder().id(2).name("Vikas").address("New Delhi").build());
        students.add(Student.builder().id(3).name("Anand").address("New Delhi").build());
        students.add(Student.builder().id(4).name("Nitin").address("New Delhi").build());
        students.add(Student.builder().id(5).name("Nilesh").address("New Delhi").build());
        students.add(Student.builder().id(6).name("Himanshu").address("New Delhi").build());
        students.add(Student.builder().id(7).name("Iswar").address("Bangalore").build());
        students.add(Student.builder().id(8).name("Satish").address("Bangalore").build());
        students.add(Student.builder().id(9).name("Saurabh").address("New Delhi").build());
        students.add(Student.builder().id(10).name("Teenu").address("New Delhi").build());
        students.add(Student.builder().id(11).name("Hitesh").address("New Delhi").build());

        new ParallelStreamExample().executeParallelStream(students);
    }

}
