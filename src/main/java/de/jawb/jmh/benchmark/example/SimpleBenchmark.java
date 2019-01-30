package de.jawb.jmh.benchmark.example;

import org.openjdk.jmh.Main;
import org.openjdk.jmh.annotations.*;

import java.util.concurrent.TimeUnit;

@State(Scope.Benchmark)
@Fork(value = 1)
@Warmup(iterations = 3, time = 300, timeUnit = TimeUnit.MILLISECONDS)
@Measurement(iterations = 10, time = 1, timeUnit = TimeUnit.SECONDS)
@BenchmarkMode(Mode.Throughput)
public class SimpleBenchmark {

    int[] array;

    @Setup
    public void setup() {
        this.array = new int[100_000];
    }


    @Benchmark
    public void dec_all() {
        for(int i = 0; i < this.array.length; i++){
            this.array[i]--;
        }
    }

    @Benchmark
    public void dec_half() {
        for(int i = 0; i < this.array.length; i+=2){
            this.array[i]--;
        }
    }

    public static void main(String... args) throws Exception{
        Main.main(args);
    }
}
