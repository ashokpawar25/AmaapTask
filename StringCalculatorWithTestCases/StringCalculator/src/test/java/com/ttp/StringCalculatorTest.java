package com.ttp;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class StringCalculatorTest {
    String result="";
    StringCalculator stringCalculator=new StringCalculator();
    @BeforeEach
    void startup() {
        result = "";
    }

    @Test
    public void testEmptyString()
    {
        result = stringCalculator.add("");
        assertEquals("0", result);
    }

    @Test
    public void testBasicAddition()
    {
        result = stringCalculator.add("1,2,3");
        assertEquals("6", result);
    }

    @Test
    public void useDifferentDelimeter()
    {
        result = stringCalculator.add("//;\n1;2");
        assertEquals("3", result);
    }

    @Test
    public void testWithDifferentDelimeterAndNewLine()
    {
        result = stringCalculator.add("//|\n1|2|3");
        assertEquals("6", result);
    }

    @Test
    public void testWithTextDelimeter()
    {
        result = stringCalculator.add("//sep\n2sep3");
        assertEquals("5",result);
    }

    @Test
    public void testMultipleDelimeter()
    {
        result = stringCalculator.add("//|\n1|2,3");
        assertEquals("'|' expected but ',' found at position 3.", result);
    }

    @Test
    public void testSingleNumber()
    {
        result = stringCalculator.add("1");
        assertEquals("1", result);
    }

    @Test
    public void testDecimalNumbers()
    {
        result = stringCalculator.add("1.1,2.2");
        assertEquals("3.3", result);
    }

    @Test
    public void testNewLineWithOrigingalDelimeater()
    {
        result =stringCalculator.add("1\n2,3");
        assertEquals("6", result);
    }

    @Test
    public void testNewLineAfterDelimeter()
    {
        result = stringCalculator.add("175.2,\n35");
        assertEquals("Number expected but '\\n' found at position 6.", result);
    }

    @Test
    public void testEndWithDelimeter()
    {
        result = stringCalculator.add("175.2,\n35");
        assertEquals("Number expected but '\\n' found at position 6.", result);
    }

    @Test
    public void testSingleNegativeNumber() {
        result = stringCalculator.add("-1,2");
        assertEquals("Negative not allowed : -1.0", result);
    }

    @Test
    public  void testMultipleNegativeNumber()
    {
        result = stringCalculator.add("2,-4,-5");
        assertEquals("Negative not allowed : -4.0 ,-5.0", result);
    }
}