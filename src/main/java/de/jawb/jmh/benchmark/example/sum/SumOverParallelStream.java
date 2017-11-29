package de.jawb.jmh.benchmark.example.sum;

import java.util.List;
import java.util.concurrent.atomic.LongAdder;

public class SumOverParallelStream extends ASumCalculator {
    
    public SumOverParallelStream(List<Integer> list) {
        super(list);
    }
    
    @Override
    public long sum() {
        LongAdder a = new LongAdder();
        this.list.parallelStream().forEach(a::add);
        return a.longValue();
    }
    
}
