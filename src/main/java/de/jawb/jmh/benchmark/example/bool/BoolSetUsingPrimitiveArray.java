package de.jawb.jmh.benchmark.example.bool;

import java.util.Arrays;

public class BoolSetUsingPrimitiveArray implements IBoolSet {
    
    private boolean[] data;
    
    public BoolSetUsingPrimitiveArray(int length) {
        data = new boolean[length];
    }
    
    @Override
    public boolean get(int i) {
        return data[i];
    }
    
    @Override
    public void set(int i) {
        data[i] = true;
    }
    
    @Override
    public void reset() {
        Arrays.fill(data, false);
    }
    
    @Override
    public int length() {
        return data.length;
    }
    
    @Override
    public int cardinality() {
        int i = 0;
        for (boolean b : data) {
            if (b) {
                ++i;
            }
        }
        return i;
    }
    
    @Override
    public String toString() {
        return "PrimitiveBoolSet " + Arrays.toString(data);
    }
}
