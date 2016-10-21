package de.jawb.jmh.benchmark;

import java.util.concurrent.TimeUnit;

import org.openjdk.jmh.annotations.Benchmark;
import org.openjdk.jmh.annotations.Fork;
import org.openjdk.jmh.annotations.Measurement;
import org.openjdk.jmh.annotations.Param;
import org.openjdk.jmh.annotations.Setup;
import org.openjdk.jmh.annotations.Warmup;
import org.openjdk.jmh.infra.Blackhole;
import org.openjdk.jmh.runner.Runner;
import org.openjdk.jmh.runner.RunnerException;
import org.openjdk.jmh.runner.options.Options;
import org.openjdk.jmh.runner.options.OptionsBuilder;

import de.jawb.jmh.benchmark.example.bool.BitSetArray;
import de.jawb.jmh.benchmark.example.bool.IBoolArray;
import de.jawb.jmh.benchmark.example.bool.SimpleArray;

@Fork(value = 3)
@Warmup(iterations = 4, time = 200, timeUnit = TimeUnit.MILLISECONDS)
@Measurement(iterations = 3, time = 1, timeUnit = TimeUnit.SECONDS)
public class BenchmarkMain {

    @Param({ "100", "1000", "10000", "100000", "1000000", "10000000" })
    private int        length;

    private IBoolArray simple;
    private IBoolArray bitset;

    @Setup
    public void setup() {
        simple = new SimpleArray(length);
        bitset = new BitSetArray(length);
    }

    private void doit(Blackhole bh, IBoolArray arr) {
        for (int i = 1; i < arr.length(); i *= 10) {
            arr.set(i);
        }
        for (int i = 1; i < arr.length(); i *= 10) {
            bh.consume(arr.get(i));
        }
        bh.consume(arr.cardinality());
        arr.reset();
    }

    @Benchmark
    public void simple(Blackhole bh) {
        doit(bh, simple);
    }

    @Benchmark
    public void bitset(Blackhole bh) {
        doit(bh, bitset);
    }

    public static void main(String[] args) throws RunnerException {
        
        Options opt = new OptionsBuilder() //
                .include(BenchmarkMain.class.getSimpleName())
                .build();

        new Runner(opt).run();
    }
}
