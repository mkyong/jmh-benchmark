package com.mkyong.benchmark;

import org.openjdk.jmh.annotations.*;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.TimeUnit;

/*
http://hg.openjdk.java.net/code-tools/jmh/file/tip/jmh-samples/src/main/java/org/openjdk/jmh/samples/
*/
@BenchmarkMode(Mode.AverageTime)
@OutputTimeUnit(TimeUnit.MILLISECONDS)
@Fork(value = 2, jvmArgs = {"-Xms2G", "-Xmx2G"})
//@Warmup(iterations = 3)
//@Measurement(iterations = 8)
public class BenchmarkLoop {

    private static final int N = 10_000_000;

    private static List<String> DATA_FOR_TESTING = createData();

    /*public static void main(String[] args) throws RunnerException {

        Options opt = new OptionsBuilder()
                .include(BenchmarkLoop.class.getSimpleName())
                .forks(1)
                .build();

        new Runner(opt).run();
    }*/

    @Benchmark
    public void loopFor() {
        for (int i = 0; i < DATA_FOR_TESTING.size(); i++) {
            String s = DATA_FOR_TESTING.get(i);
        }
    }

    @Benchmark
    public void loopWhile() {
        int i = 0;
        while (i < DATA_FOR_TESTING.size()) {
            String s = DATA_FOR_TESTING.get(i);
            i++;
        }
    }

    @Benchmark
    public void loopForEach() {
        for (String s : DATA_FOR_TESTING) {
        }
    }

    @Benchmark
    public void loopIterator() {
        Iterator<String> iterator = DATA_FOR_TESTING.iterator();
        while (iterator.hasNext()) {
            String next = iterator.next();
        }
    }

    private static List<String> createData() {

        List<String> data = new ArrayList<>();

        for (int i = 0; i < N; i++) {
            data.add("Number : " + i);
        }

        return data;
    }

}
