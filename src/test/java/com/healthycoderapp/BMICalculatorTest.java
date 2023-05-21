package com.healthycoderapp;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.function.Executable;


import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class BMICalculatorTest {

    @BeforeAll // run once at the beginning
    static void beforeAll(){
        System.out.println("before all unit tests");
    }

    @AfterAll
    static void afterAll(){
        System.out.println("after all unit tests");
    }

    @Test
    void should_ReturnTrue_When_DietRecommended(){
        // given
        double weight = 89.0;
        double height = 1.72;
        // when
        boolean dietRecommended = BMICalculator.isDietRecommended(weight, height);
        // then
        assertTrue(dietRecommended);
    }

    @Test
    void should_ReturnFalse_When_DietNotRecommended(){
        // given
        double weight = 50.0;
        double height = 1.92;
        // when
        boolean dietRecommended = BMICalculator.isDietRecommended(weight, height);
        // then
        assertFalse(dietRecommended);
    }

    // should_XXX_When_XXX
    @Test
    void should_ThrowArithmeticException_When_HeightZero(){
        // given
        double weight = 50.0;
        double height = 0.0;

        // when
        Executable executable = () -> BMICalculator.isDietRecommended(weight, height);
        // Executable means will not be executed immediately

        // then
        assertThrows(ArithmeticException.class, executable);
    }

    @Test
    void should_ReturnCoderWithWorstBMI_When_CoderListNotEmpty(){
        // given
        ArrayList<Coder> coders = new ArrayList<>();
        coders.add(new Coder(1.80,60.0));
        coders.add(new Coder(1.82,98.0));
        coders.add(new Coder(1.82,64.7));

        // when
        Coder coderWithWorstBMI = BMICalculator.findCoderWithWorstBMI(coders);

        // then
        assertAll(
                () -> assertEquals(1.82,coderWithWorstBMI.getHeight()),
                () -> assertEquals(98.0,coderWithWorstBMI.getWeight())
        );
    }

    @Test
    void should_ReturnNull_When_CoderListEmpty(){
        // given
        ArrayList<Coder> coders = new ArrayList<>();

        // when
        Coder coderWithWorstBMI = BMICalculator.findCoderWithWorstBMI(coders);

        // then
        assertNull(coderWithWorstBMI);
    }

    @Test
    void should_ReturnCorrectBMIScoreArray_When_CoderLIstNotEmpty() {
        // given
        ArrayList<Coder> coders = new ArrayList<>();
        coders.add(new Coder(1.80,60.0));
        coders.add(new Coder(1.82,98.0));
        coders.add(new Coder(1.82,64.7));
        double[] expected = {18.52,29.59,19.53};

        // When
        double[] bmiScores = BMICalculator.getBMIScores(coders);

        // Then
//        assertEquals(expected,bmiScores); // check if they are the same object in memory
        // should use assertArrayEquals instead
        assertArrayEquals(expected,bmiScores);
    }
}