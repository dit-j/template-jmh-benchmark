package de.jawb.jmh.benchmark.example.uniquechars;

import java.util.concurrent.TimeUnit;

import org.openjdk.jmh.annotations.Benchmark;
import org.openjdk.jmh.annotations.Fork;
import org.openjdk.jmh.annotations.Measurement;
import org.openjdk.jmh.annotations.Scope;
import org.openjdk.jmh.annotations.State;
import org.openjdk.jmh.annotations.Warmup;
import org.openjdk.jmh.infra.Blackhole;

//
// http://codereview.stackexchange.com/questions/147603/returning-distinct-characters-in-combined-strings
//

@State(Scope.Benchmark)
@Fork(value = 1)
@Warmup(iterations = 4, time = 200, timeUnit = TimeUnit.MILLISECONDS)
@Measurement(iterations = 3, time = 500, timeUnit = TimeUnit.MILLISECONDS)
public class UniqueCharsBenchmark {

    private static String s1 = "61de454e-1cd5-4512-97bb-8469b61c17e2455899e2-d4dd-4da2-bfce-7b1b3209a78e", s2 = "b3c6374c-9280-4403-aae7-767aeed965a42dfe166c-e17c-4c2a-8ca1-e51d5f155d9b";

    @Benchmark
    public void uniqueChars_A_1(Blackhole bh) {
        bh.consume(UniqueChars.getDistinctCharString_A_1(s1, s2));
    }

    @Benchmark
    public void uniqueChars_A_2(Blackhole bh) {
        bh.consume(UniqueChars.getDistinctCharString_A_2(s1, s2));
    }

    @Benchmark
    public void uniqueChars_B_1(Blackhole bh) {
        bh.consume(UniqueChars.getDistinctCharString_B_1(s1, s2));
    }

}
