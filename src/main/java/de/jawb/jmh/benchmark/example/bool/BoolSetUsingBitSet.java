package de.jawb.jmh.benchmark.example.bool;

import java.util.BitSet;

public class BoolSetUsingBitSet implements IBoolSet {

    private BitSet data;

    public BoolSetUsingBitSet(int length) {
        data = new BitSet(length);
    }

    @Override
    public boolean get(int i) {
        return data.get(i);
    }
    
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
    
    @Override
    public String toString() {
        return "BitSetArray " + this.data.toString();
    }
    
    public static void main(String[] args) {
        BoolSetUsingBitSet a = new BoolSetUsingBitSet(10);
        a.set(1);
        a.set(3);
        a.set(5);
        
        System.out.println(a.get(7));
    }
}
