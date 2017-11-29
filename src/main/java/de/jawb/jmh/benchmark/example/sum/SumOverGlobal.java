package de.jawb.jmh.benchmark.example.sum;

import java.util.List;

public class SumOverGlobal extends ASumCalculator {
    
    public SumOverGlobal(List<Integer> list) {
        super(list);
    }
    
    @Override
    public long sum() {
        long sum = 0;
        for (int i = 0; i < this.list.size(); i++) {
            sum += this.list.get(i);
        }
        return sum;
    }
    
}
