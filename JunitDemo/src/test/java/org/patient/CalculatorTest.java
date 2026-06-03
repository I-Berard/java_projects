package org.patient;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class CalculatorTest {

    private Calculator calculator;

    @BeforeAll
    public void setup(){
        calculator = new Calculator();
        System.out.println("Created a new class for testing");
    }

    @Test
    public void addTest(){
        int actualResult = calculator.add(5,4);
        assertEquals(9, actualResult);
    }

    @Test
    public void subtrationTest(){
        int actualResult = calculator.subtract(7,2);
        assertEquals(5, actualResult);
    }
}