package de.jawb.jmh.benchmark.example.jvm;

import java.util.List;

public class ForLoop {

    private final List<Integer> list;

    public ForLoop(List<Integer> list) {
        this.list = list;
    }

    public long sum() {
        long sum = 0;
        for (int i = 0; i < list.size(); i++) {
            Integer integer = list.get(i);
            sum += integer;
        }
        return sum;
    }

    public void addInteger(Integer i) {
        list.add(i);
    }

}
