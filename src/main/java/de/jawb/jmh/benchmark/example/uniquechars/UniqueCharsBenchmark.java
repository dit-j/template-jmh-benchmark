package de.jawb.jmh.benchmark.example.uniquechars;

import java.util.concurrent.TimeUnit;

import org.openjdk.jmh.annotations.Benchmark;
import org.openjdk.jmh.annotations.Fork;
import org.openjdk.jmh.annotations.Measurement;
import org.openjdk.jmh.annotations.Scope;
import org.openjdk.jmh.annotations.State;
import org.openjdk.jmh.annotations.Warmup;
import org.openjdk.jmh.infra.Blackhole;

import de.jawb.jmh.benchmark.example.util.ResourceLoader;

//
// http://codereview.stackexchange.com/questions/147603/returning-distinct-characters-in-combined-strings
//

@State(Scope.Benchmark)
@Fork(value = 1)
@Warmup(iterations = 3, time = 500, timeUnit = TimeUnit.MILLISECONDS)
@Measurement(iterations = 4, time = 2000, timeUnit = TimeUnit.MILLISECONDS)
public class UniqueCharsBenchmark {

    private final static String s1 = ResourceLoader.getContent("s1.txt"), s2 = ResourceLoader.getContent("s2.txt");
    
    @Benchmark
    public void uniqueChars_A_1(Blackhole bh) {
        bh.consume(UniqueChars.getDistinctCharString_A_1(s1, s2));
    }

    @Benchmark
    public void uniqueChars_A_2(Blackhole bh) {
        bh.consume(UniqueChars.getDistinctCharString_A_2(s1, s2));
    }

    @Benchmark
    public void uniqueChars_A_3(Blackhole bh) {
        bh.consume(UniqueChars.getDistinctCharString_A_3(s1, s2));
    }

    @Benchmark
    public void uniqueChars_A_4(Blackhole bh) {
        bh.consume(UniqueChars.getDistinctCharString_A_4(s1, s2));
    }
    
    //
    // B
    //

    @Benchmark
    public void uniqueChars_B_1(Blackhole bh) {
        bh.consume(UniqueChars.getDistinctCharString_B_1(s1, s2));
    }

    @Benchmark
    public void uniqueChars_B_2(Blackhole bh) {
        bh.consume(UniqueChars.getDistinctCharString_B_2(s1, s2));
    }

    @Benchmark
    public void uniqueChars_B_3(Blackhole bh) {
        bh.consume(UniqueChars.getDistinctCharString_B_3(s1, s2));
    }

    @Benchmark
    public void uniqueChars_B_4(Blackhole bh) {
        bh.consume(UniqueChars.getDistinctCharString_B_4(s1, s2));
    }
    
    //
    // C
    //

    @Benchmark
    public void uniqueChars_C_1(Blackhole bh) {
        bh.consume(UniqueChars.getDistinctCharString_C_1(s1, s2));
    }
    
    @Benchmark
    public void uniqueChars_C_2(Blackhole bh) {
        bh.consume(UniqueChars.getDistinctCharString_C_2(s1, s2));
    }

    @Benchmark
    public void uniqueChars_C_3(Blackhole bh) {
        bh.consume(UniqueChars.getDistinctCharString_C_3(s1, s2));
    }

    @Benchmark
    public void uniqueChars_C_4(Blackhole bh) {
        bh.consume(UniqueChars.getDistinctCharString_C_4(s1, s2));
    }
    
    //
    // D
    //

    @Benchmark
    public void uniqueChars_D_1(Blackhole bh) {
        bh.consume(UniqueChars.getDistinctCharString_D_1(s1, s2));
    }

    @Benchmark
    public void uniqueChars_D_2(Blackhole bh) {
        bh.consume(UniqueChars.getDistinctCharString_D_2(s1, s2));
    }

    @Benchmark
    public void uniqueChars_D_3(Blackhole bh) {
        bh.consume(UniqueChars.getDistinctCharString_D_3(s1, s2));
    }

    @Benchmark
    public void uniqueChars_D_4(Blackhole bh) {
        bh.consume(UniqueChars.getDistinctCharString_D_4(s1, s2));
    }
    
    //
    // E
    //
    
    @Benchmark
    public void uniqueChars_E_1(Blackhole bh) {
        bh.consume(UniqueChars.getDistinctCharString_E_1(s1, s2));
    }
    
    @Benchmark
    public void uniqueChars_E_2(Blackhole bh) {
        bh.consume(UniqueChars.getDistinctCharString_E_2(s1, s2));
    }

    //
    // F
    //
    
    @Benchmark
    public void uniqueChars_F(Blackhole bh) {
        bh.consume(UniqueChars.getDistinctCharString_F(s1, s2));
    }
}
