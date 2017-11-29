package de.jawb.jmh.benchmark.example.bool;

public interface IBoolSet {

    boolean get(int i);
    void set(int i);
    void reset();
    int length();
    int cardinality();
    
}
