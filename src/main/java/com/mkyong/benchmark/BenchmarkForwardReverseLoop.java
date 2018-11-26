package com.mkyong.benchmark;

import org.openjdk.jmh.annotations.*;
import org.openjdk.jmh.runner.Runner;
import org.openjdk.jmh.runner.RunnerException;
import org.openjdk.jmh.runner.options.Options;
import org.openjdk.jmh.runner.options.OptionsBuilder;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

@BenchmarkMode(Mode.AverageTime)
@OutputTimeUnit(TimeUnit.MILLISECONDS)
@Fork(value = 1, jvmArgs = {"-Xms2G", "-Xmx2G"})
@Warmup(iterations = 5)
@Measurement(iterations = 10)
public class BenchmarkForwardReverseLoop {

    private static final int N = 10_000_000;

    private static List<String> DATA_FOR_TESTING = createData();

    public static void main(String[] argv) throws RunnerException {
        Options opt = new OptionsBuilder()
                .include(BenchmarkForwardReverseLoop.class.getSimpleName())
                .forks(1)
                .build();

        new Runner(opt).run();
    }

    @Benchmark
    public void forwardLoop() {
        for (int i = 0; i < DATA_FOR_TESTING.size(); i++) {
            String s = DATA_FOR_TESTING.get(i);
            //System.out.println(s);
        }
    }

    @Benchmark
    public void reverseLoop() {
        for (int i = DATA_FOR_TESTING.size() - 1; i >= 0; i--) {
            String s = DATA_FOR_TESTING.get(i);
            //System.out.println(s);
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
