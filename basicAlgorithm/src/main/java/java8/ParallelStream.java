package java8;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;

public class ParallelStream {
    public static void main(String[] args) {

        System.setProperty("java.util.concurrent.ForkJoinPool.common.parallelism", "100");
        List<Integer> numbers = new ArrayList<>();
        IntStream.range(0, 100).forEach(numbers::add);
        /*numbers.parallelStream()
                .forEach(out::println);*/
        long start=System.currentTimeMillis();
        numbers.parallelStream().forEach(integer -> {


            try {
                Thread.sleep(10000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(integer);
        });
        System.out.println("finish");
        System.out.println(System.currentTimeMillis()-start);
    }
}
