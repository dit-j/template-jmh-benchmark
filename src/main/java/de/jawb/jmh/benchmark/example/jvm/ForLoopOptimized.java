package de.jawb.jmh.benchmark.example.jvm;

import java.util.List;

public class ForLoopOptimized {

    private final List<Integer> list;

    public ForLoopOptimized(List<Integer> list) {
        this.list = list;
    }

    public long sum() {
        List<Integer> local = list;
        long sum = 0;
        for (int i = 0; i < local.size(); i++) {
            Integer integer = local.get(i);
            sum += integer;
        }
        return sum;
    }

    public void addInteger(Integer i) {
        list.add(i);
    }

}
