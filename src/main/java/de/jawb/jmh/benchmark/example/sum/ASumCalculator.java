package de.jawb.jmh.benchmark.example.sum;

import java.util.List;

public abstract class ASumCalculator {
    
    protected final List<Integer> list;
    
    public ASumCalculator(List<Integer> list) {
        this.list = list;
    }
    
    public abstract long sum();
    
    public final void addInteger(Integer i) {
        list.add(i);
    }
    
    @Override
    public String toString() {
        return this.getClass().getSimpleName();
    }
    
}
