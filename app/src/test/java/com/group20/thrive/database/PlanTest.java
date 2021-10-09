package com.group20.thrive.database;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
class PlanTest {

    Plan plan;

    @BeforeEach
    public void setUp(){
        plan = new Plan("Exercise",  10, "You are the best");
        plan.setPlanId(10);
    }

    @Test
    void getPlanId() {
        assertEquals(10, plan.getPlanId());
    }

    @Test
    void getPlanName() {
        assertEquals("Exercise", plan.getPlanName());
    }

    @Test
    void getPlanLength() {
        assertEquals(10, plan.getPlanLength());
    }

    @Test
    void getPlanDescription() {
        assertEquals("You are the best", plan.getPlanDescription());
    }

    @Test
    void setPlanId() {
        plan.setPlanId(120);
        assertEquals(120,plan.getPlanId());
    }

    @Test
    @DisplayName("Should not create plan when all parameter are null")
    public void shouldThrowRunTimeExceptionWhenPlanTypeIsNull(){
        Assertions.assertThrows(RuntimeException.class, () -> {
            plan = new Plan(null, null, null);
        });

    }
}