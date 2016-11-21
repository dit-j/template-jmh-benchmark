package de.jawb.jmh.benchmark.example.jvm;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openjdk.jmh.annotations.Benchmark;
import org.openjdk.jmh.annotations.Fork;
import org.openjdk.jmh.annotations.Measurement;
import org.openjdk.jmh.annotations.Scope;
import org.openjdk.jmh.annotations.Setup;
import org.openjdk.jmh.annotations.State;
import org.openjdk.jmh.annotations.Warmup;
import org.openjdk.jmh.infra.Blackhole;

@State(Scope.Benchmark)
@Fork(value = 2)
@Warmup(iterations = 4, time = 200, timeUnit = TimeUnit.MILLISECONDS)
@Measurement(iterations = 4, time = 1000, timeUnit = TimeUnit.MILLISECONDS)
public class ForLoopGlobalVsLocalBenchmark {

    private ForLoop          forLoopSimple;
    private ForLoopOptimized forLoopOptimized;

    @Setup
    public void setup() {
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < 100_000; i++) {
            list.add(i);
        }
        forLoopSimple = new ForLoop(list);
        forLoopOptimized = new ForLoopOptimized(list);
    }

    @Benchmark
    public void benchmarkForLoop(Blackhole bh) {
        bh.consume(forLoopSimple.sum());
    }

    @Benchmark
    public void benchmarkForLoopOptimized(Blackhole bh) {
        bh.consume(forLoopOptimized.sum());
    }
}
