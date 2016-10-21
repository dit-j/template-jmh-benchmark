package de.jawb.jmh.benchmark.example.bool;

import java.util.BitSet;

public class BitSetArray implements IBoolArray {

    private BitSet data;

    public BitSetArray(int length) {
        data = new BitSet(length);
    }

    @Override
    public boolean get(int i) {
        return data.get(i);
    }

//    @Override
//    public boolean set(int i) {
//        boolean old = get(i);
//        data.set(i);
//        return old;
//    }
    
    @Override
    public void set(int i) {
        data.set(i);
    }

    @Override
    public void reset() {
        data.clear();
    }

    @Override
    public int length() {
        return data.size();
    }

    @Override
    public int cardinality() {
        return data.cardinality();
    }
}
