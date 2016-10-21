package de.jawb.jmh.benchmark.example.bool;

public interface IBoolArray {

    boolean get(int i);
//    boolean set(int i);
    void set(int i);
    void reset();
    int length();
    int cardinality();
    
}
