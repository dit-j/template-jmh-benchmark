package de.jawb.jmh.benchmark.example.sum;

import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

@RunWith(Parameterized.class)
public class SumBenchmarkTest {
    
    private final long           expectedResult;
    private final ASumCalculator sumCalculator;
    
    public SumBenchmarkTest(ASumCalculator calculator, long expectedSum) {
        this.sumCalculator = calculator;
        this.expectedResult = expectedSum;
    }
    
    @Parameters
    public static Collection<Object[]> data() {
        
        List<Integer> list  = new Random()
                                .ints(0, 1000)  // range
                                .limit(100)     // Liste enthaelt 100 Zahlen
                                .boxed()        // nicht als primitiv-Array sondern als Integer.java
                                .collect(Collectors.toList());
        
        long expectedSum    = list.stream().mapToInt(Integer::intValue).sum();
        
        Object[][] data = new Object[][] { 
            { new SumOverGlobal(list),          expectedSum }, 
            { new SumOverLocal(list),           expectedSum }, 
            { new SumOverStream(list),          expectedSum }, 
            { new SumOverParallelStream(list),  expectedSum }, 
        };
        return Arrays.asList(data);
    }
    
    @Test
    public void testSum() {
        Assert.assertTrue(expectedResult == sumCalculator.sum());
    }
}
