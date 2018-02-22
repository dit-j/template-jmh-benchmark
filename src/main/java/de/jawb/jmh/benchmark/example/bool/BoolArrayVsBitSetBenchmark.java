package de.jawb.jmh.benchmark.example.bool;

import java.util.concurrent.TimeUnit;

import org.openjdk.jmh.annotations.Benchmark;
import org.openjdk.jmh.annotations.BenchmarkMode;
import org.openjdk.jmh.annotations.Fork;
import org.openjdk.jmh.annotations.Measurement;
import org.openjdk.jmh.annotations.Mode;
import org.openjdk.jmh.annotations.Param;
import org.openjdk.jmh.annotations.Scope;
import org.openjdk.jmh.annotations.Setup;
import org.openjdk.jmh.annotations.State;
import org.openjdk.jmh.annotations.Warmup;
import org.openjdk.jmh.infra.Blackhole;

@State(Scope.Benchmark)
@Fork(value = 1)
@Warmup(iterations = 3, time = 500, timeUnit = TimeUnit.MILLISECONDS)
@Measurement(iterations = 100, time = 2000, timeUnit = TimeUnit.MILLISECONDS)
public class BoolArrayVsBitSetBenchmark {

    @Param({ "900000000" })
    private int      length;

    private IBoolSet primitive;
    private IBoolSet bitset;

    @Setup
    public void setup() {
        primitive = new BoolSetUsingPrimitiveArray(length);
        bitset = new BoolSetUsingBitSet(length);
    }

    private void doit(Blackhole bh, IBoolSet arr) {
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
    @BenchmarkMode(Mode.SingleShotTime)
    public void primitive(Blackhole bh) {
        doit(bh, primitive);
    }

    @Benchmark
    @BenchmarkMode(Mode.SingleShotTime)
    public void bitset(Blackhole bh) {
        doit(bh, bitset);
    }
}
