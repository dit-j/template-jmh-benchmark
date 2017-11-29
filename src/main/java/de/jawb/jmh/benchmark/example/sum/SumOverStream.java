package de.jawb.jmh.benchmark.example.sum;

import java.util.List;

public class SumOverStream extends ASumCalculator {
    
    public SumOverStream(List<Integer> list) {
        super(list);
    }
    
    @Override
    public long sum() {
        return this.list.stream().mapToInt(Integer::intValue).sum();
    }
    
}
