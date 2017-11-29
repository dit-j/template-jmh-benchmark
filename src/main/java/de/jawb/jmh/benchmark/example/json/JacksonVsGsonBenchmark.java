package de.jawb.jmh.benchmark.example.json;

import java.util.concurrent.TimeUnit;

import org.openjdk.jmh.annotations.Benchmark;
import org.openjdk.jmh.annotations.Fork;
import org.openjdk.jmh.annotations.Measurement;
import org.openjdk.jmh.annotations.Scope;
import org.openjdk.jmh.annotations.State;
import org.openjdk.jmh.annotations.Warmup;
import org.openjdk.jmh.infra.Blackhole;

import de.jawb.jmh.benchmark.example.json.model.PersonLoader;
import de.jawb.jmh.benchmark.example.json.model.PersonLoader.Mapper;

@State(Scope.Benchmark)
@Fork(value = 1)
@Warmup(iterations = 3, time = 500, timeUnit = TimeUnit.MILLISECONDS)
@Measurement(iterations = 6, time = 2000, timeUnit = TimeUnit.MILLISECONDS)
public class JacksonVsGsonBenchmark {

    @Benchmark
    public void jackson(Blackhole bh) {
        bh.consume(PersonLoader.load(Mapper.Jackson));
    }

    @Benchmark
    public void gson(Blackhole bh) {
        bh.consume(PersonLoader.load(Mapper.Gson));
    }
}
