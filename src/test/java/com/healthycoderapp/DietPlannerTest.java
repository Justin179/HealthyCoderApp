package com.healthycoderapp;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class DietPlannerTest {

    private DietPlanner dietPlanner;

    @BeforeEach // this method will be invoked before each method
    void setUp() {
        this.dietPlanner = new DietPlanner(20,30,50);
    }

    @AfterEach
    void tearDown() {
        System.out.println("A unit test is finished");
    }

    @Test
    void should_ReturnCorrectDietPlan_When_CorrectCoder() {
        // Given
        Coder coder = new Coder(1.82, 75.0, 26, Gender.MALE);
        DietPlan expected = new DietPlan(2202, 110, 73, 275);
        // When
        DietPlan actual = dietPlanner.calculateDiet(coder);

        // Then
        // assertEquals(expected,actual); // 這個也是比是不是同一個物件(same object in the memory)
        // 但沒有現成的方法可以比物件，所以採以下的寫法
        assertAll(
                ()-> assertEquals(expected.getCalories(), actual.getCalories()),
                ()-> assertEquals(expected.getProtein(), actual.getProtein()),
                ()-> assertEquals(expected.getFat(), actual.getFat()),
                ()-> assertEquals(expected.getCarbohydrate(), actual.getCarbohydrate())
        );
    }
}







