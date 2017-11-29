package de.jawb.jmh.benchmark.example.sum;

import java.util.List;

public class SumOverLocal extends ASumCalculator {
    
    public SumOverLocal(List<Integer> list) {
        super(list);
    }
    
    @Override
    public long sum() {
        final List<Integer> local = this.list;
        long sum = 0;
        for (int i = 0; i < local.size(); i++) {
            sum += local.get(i);
        }
        return sum;
    }
}
