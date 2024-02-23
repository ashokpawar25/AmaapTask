package com.ttp;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.shadow.com.univocity.parsers.common.input.LineSeparatorDetector;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class StringCalculatorByTddTest
{
    StringCalculatorByTdd instance = new StringCalculatorByTdd();

    @Test
    public void shouldReturnZeroWhenStringIsEmpty()
    {
        String result = instance.add("");
        assertEquals("0",result);
    }

//    @Test
//    public void validateInputOfStringType()
//    {
//
//        instance.add("1,2");
//        boolean validate=  instance.validate();
//        assertTrue(validate);
//    }

    @Test
    public  void shouldReturnTheSumOfNumbersFromInputString()
    {
        String result = instance.add("1,2");
        assertEquals(3,Integer.parseInt(result));
    }

//    @Test
//    public void shouldReturnSumForDecimalValues()
//    {
//        String result = instance.add("1.1,2.2");
//        assertEquals(3.3,Integer.parseInt(result));
//    }

    @Test
    public void shouldHandleTheCaseOfNewLineAsSeperator()
    {
        String result = instance.add("1\n2,3");
        assertEquals(6,Integer.parseInt(result));
    }

    @Test
    public void shouldAbleToChangeTheDelimeter()
    {
        String result = instance.add("//;\n1;2");
        assertEquals(3, Integer.parseInt(result));
    }

    @Test
    public void shouldAcceptTheStringDelimeter()
    {
        String result = instance.add("//sep\n2sep3");
        assertEquals(5,Integer.parseInt(result));
    }

    @Test
    public void sholudReturnTheErrorMessageOnMoreThanOneDelimeter()
    {
        String result = instance.add("//|\n1|2,3");
        assertEquals("'|' expected but ',' found at position 3.", result);
    }

    @Test
    public void shouldReturnSumForSingleNumberAlso()
    {
        String result = instance.add("1");
        assertEquals(1, Integer.parseInt(result));
    }

    @Test
    public void shouldAcceptTheNewLineAsDelemetr()
    {
        String result =instance.add("1\n2,3");
        assertEquals(6, Integer.parseInt(result));
    }

    @Test
    public void shouldHandleCaseOfConsecutiveDelimeterAndNewLine()
    {
        String result = instance.add("175.2,\n35");
        assertEquals("Number expected but '\\n' found at position 6.", result);
    }

    @Test
    void shouldHandleCaseOfInputStringEndWithDelimeter() {
        String result = instance.add("1,3,");
        assertEquals("Number expected but EOF found.", result);
    }

    @Test
    public void shouldHandleCaseOfSingleNegativeNumber() {
        String result = instance.add("-1,2");
        assertEquals("Negative not allowed : -1.0", result);
    }

    @Test
    public void shouldHandleCaseOfMyltipleNegativeNumbers()
    {
        String result = instance.add("2,-4,-5");
        assertEquals("Negative not allowed : -4.0 ,-5.0", result);
    }

}
