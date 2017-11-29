package de.jawb.jmh.benchmark.example.bool;

import java.util.Arrays;
import java.util.Collection;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

@RunWith(Parameterized.class)
public class BitSetBenchmarkTest {
    
    private IBoolSet set;
    
    public BitSetBenchmarkTest(IBoolSet set) {
        this.set = set;
    }
    
    @Parameters
    public static Collection<Object> data() {
        return Arrays.asList(new BoolSetUsingBitSet(10), new BoolSetUsingPrimitiveArray(10));
    }
    
    @Test
    public void testPrimitiveBoolSet() {
        
        set.set(1);
        set.set(3);
        set.set(5);
        
        Assert.assertTrue(set.get(1));
        Assert.assertTrue(set.get(3));
        Assert.assertTrue(set.get(5));
        
        Assert.assertFalse(set.get(0));
        Assert.assertFalse(set.get(2));
        Assert.assertFalse(set.get(4));
        Assert.assertFalse(set.get(6));
        Assert.assertFalse(set.get(7));
        Assert.assertFalse(set.get(8));
        
        Assert.assertTrue(set.cardinality() == 3);
    }
}
