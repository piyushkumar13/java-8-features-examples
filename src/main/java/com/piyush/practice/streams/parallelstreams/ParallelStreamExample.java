package com.piyush.practice.streams.parallelstreams;

import com.piyush.practice.domain.model.Student;

import java.util.ArrayList;
import java.util.Arrays;
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
     * <p>
     * Note : If you notice the output of the program, it will not give the result in the order though linkedlist maintains the order. Thats
     * because multiple threads are working on the linkedlist.
     */
    private void executeParallelStream(List<Student> students) {
        students.parallelStream().peek(student -> {
            System.out.println("This is peek for " + student);
        }).forEach(System.out::println);

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

//        new ParallelStreamExample().executeParallelStream(students);


//        System.out.println("\n-------------------------Parallel Stream from IntStream,DoubleStream and LongStream------------");
//
//        IntStream integerStream = IntStream.range(1, 10).parallel();
//        System.out.println("Whether integerStream is parallel or not :: " + integerStream.isParallel());
//
//        System.out.println("\n--------------------------Converting parallel stream to sequential stream-----------------------");
//
//        /*
//        * We can convert the parallel stream to sequential stream by sequential() method. We can also convert the sequential stream to
//        * parallel stream by parallel() method.
//        */
//        IntStream seqIntegerStream = integerStream.sequential();
//        System.out.println("Whether seqIntegerStream is parallel or not :: " + integerStream.isParallel());
//
//        System.out.println(Runtime.getRuntime().availableProcessors());

//
//        IntStream stream1 = IntStream.range(0, 100000);
//
//        long startTime1 = System.currentTimeMillis();
//        stream1.forEach(i -> {});
//        long endTime1 = System.currentTimeMillis();
//        System.out.println("the time taken on parallel with for each ordered "+(endTime1-startTime1));


//        IntStream stream = IntStream.range(1, 100000);
//
//        long startTime = System.currentTimeMillis();
//        stream.parallel().filter(i -> {
//            System.out.println("filter for i :: " + i);
//            return i%2 == 0;
//        }).skip(2).forEach((i) -> { // you can change to forEach also
//            System.out.println("yo"+i +"yo");
//
//        } );
//        long endTime = System.currentTimeMillis();
//        System.out.println("the time taken on parllel for each "+(endTime-startTime));


        List<Integer> someList = Arrays.asList(1,2,3,4,5);
//        someList.stream().map(i -> {
//            System.out.println("Normal Stream : "+i);
//            return i*2;
//        }).forEach(System.out::println); // this is sequential stream


        System.out.println("this is parallel stream");


        someList.parallelStream().map(i -> {
            System.out.println(Thread.currentThread().getName()+" Parallel Stream : "+i);
            return i*2;
        }).forEachOrdered(System.out::println);



    }

}
