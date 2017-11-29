package de.jawb.jmh.benchmark.example.sum;

import java.util.List;
import java.util.Random;
import java.util.concurrent.TimeUnit;
import java.util.stream.Collectors;

import org.openjdk.jmh.annotations.Benchmark;
import org.openjdk.jmh.annotations.Fork;
import org.openjdk.jmh.annotations.Measurement;
import org.openjdk.jmh.annotations.Scope;
import org.openjdk.jmh.annotations.Setup;
import org.openjdk.jmh.annotations.State;
import org.openjdk.jmh.annotations.Warmup;
import org.openjdk.jmh.infra.Blackhole;

@State(Scope.Benchmark)
@Fork(value = 1)
@Warmup(iterations = 4, time = 500, timeUnit = TimeUnit.MILLISECONDS)
@Measurement(iterations = 6, time = 2000, timeUnit = TimeUnit.MILLISECONDS)
public class SumBenchmark {
    
    private ASumCalculator global;
    private ASumCalculator local;
    private ASumCalculator stream;
    private ASumCalculator streamParallel;
    
    @Setup
    public void setup() {
        List<Integer> list = new Random().ints(0, 100).limit(100_000).boxed().collect(Collectors.toList());
        global = new SumOverGlobal(list);
        local = new SumOverLocal(list);
        stream = new SumOverStream(list);
        streamParallel = new SumOverParallelStream(list);
    }
    
    @Benchmark
    public void benchmark_OverGlobal(Blackhole bh) {
        bh.consume(global.sum());
    }
    
    @Benchmark
    public void benchmark_OverLocal(Blackhole bh) {
        bh.consume(local.sum());
    }
    
    @Benchmark
    public void benchmark_OverStream(Blackhole bh) {
        bh.consume(stream.sum());
    }
    
    @Benchmark
    public void benchmark_OverStreamParallel(Blackhole bh) {
        bh.consume(streamParallel.sum());
    }
}
