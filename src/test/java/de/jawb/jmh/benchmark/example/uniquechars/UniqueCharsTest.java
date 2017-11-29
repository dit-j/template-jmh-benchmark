package de.jawb.jmh.benchmark.example.uniquechars;

import org.junit.Assert;
import org.junit.Test;

public class UniqueCharsTest {
    
    String s1 = "abcdefghijklmnopqrstuvxyzABCDEFGHIJKLMNOPQRTUVXYZ123456789-";
    String s2 = "abcdefghijklmnopqrstuvxyzABCDEFGHIJKLMNOPQRTUVXYZ123456789-+";
    
    @Test
    public void testEqualResult_A_1() {
        Assert.assertEquals(s2, UniqueChars.getDistinctCharString_A_1(s1, s2));
    }
    
    @Test
    public void testEqualResult_A_2() {
        Assert.assertEquals(s2, UniqueChars.getDistinctCharString_A_2(s1, s2));
    }
    
    @Test
    public void testEqualResult_A_3() {
        Assert.assertEquals(s2, UniqueChars.getDistinctCharString_A_3(s1, s2));
    }
    
    @Test
    public void testEqualResult_A_4() {
        Assert.assertEquals(s2, UniqueChars.getDistinctCharString_A_4(s1, s2));
    }
    
    // B
    
    @Test
    public void testEqualResult_B_1() {
        Assert.assertEquals(s2, UniqueChars.getDistinctCharString_B_1(s1, s2));
    }

    @Test
    public void testEqualResult_B_2() {
        Assert.assertEquals(s2, UniqueChars.getDistinctCharString_B_2(s1, s2));
    }

    @Test
    public void testEqualResult_B_3() {
        Assert.assertEquals(s2, UniqueChars.getDistinctCharString_B_3(s1, s2));
    }

    @Test
    public void testEqualResult_B_4() {
        Assert.assertEquals(s2, UniqueChars.getDistinctCharString_B_4(s1, s2));
    }
    
    //
    // C
    //
    
    @Test
    public void testEqualResult_C_1() {
        Assert.assertEquals(s2, UniqueChars.getDistinctCharString_C_1(s1, s2));
    }

    @Test
    public void testEqualResult_C_2() {
        Assert.assertEquals(s2, UniqueChars.getDistinctCharString_C_2(s1, s2));
    }

    @Test
    public void testEqualResult_C_3() {
        Assert.assertEquals(s2, UniqueChars.getDistinctCharString_C_3(s1, s2));
    }

    @Test
    public void testEqualResult_C_4() {
        Assert.assertEquals(s2, UniqueChars.getDistinctCharString_C_4(s1, s2));
    }

    //
    // D
    //
    
    @Test
    public void testEqualResult_D_1() {
        Assert.assertEquals(s2, UniqueChars.getDistinctCharString_D_1(s1, s2));
    }

    @Test
    public void testEqualResult_D_2() {
        Assert.assertEquals(s2, UniqueChars.getDistinctCharString_D_1(s1, s2));
    }

    @Test
    public void testEqualResult_D_3() {
        Assert.assertEquals(s2, UniqueChars.getDistinctCharString_D_1(s1, s2));
    }

    @Test
    public void testEqualResult_D_4() {
        Assert.assertEquals(s2, UniqueChars.getDistinctCharString_D_1(s1, s2));
    }
    
    //
    // E
    //
    
    @Test
    public void testEqualResult_E_1() {
        Assert.assertEquals(s2, UniqueChars.getDistinctCharString_E_1(s1, s2));
    }
    
    @Test
    public void testEqualResult_E_2() {
        Assert.assertEquals(s2, UniqueChars.getDistinctCharString_E_2(s1, s2));
    }

    //
    // F
    //
    
    @Test
    public void testEqualResult_F() {
        Assert.assertEquals(s2, UniqueChars.getDistinctCharString_F(s1, s2));
    }
}
