package com.group20.thrive.database;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
class UserTest {

    User user;
    @BeforeEach
    public void setUp(){
        user = new User("trung", 10,15,20,1,1);
    }
    @Test
    void getUserName() {
        assertEquals("trung", user.getUserName());
    }

    @Test
    void getExerciseGoal() {
        assertEquals(10, user.getExerciseGoal());
    }

    @Test
    void getMeditationGoal() {
        assertEquals(15, user.getMeditationGoal());
    }

    @Test
    void getSleepGoal() {
        assertEquals(20, user.getUserActivityGoal());
    }

    @Test
    void getCurrentPlan() {
        assertEquals(1, user.getCurrentPlan());
    }

    @Test
    void getCurrentLesson() {
        assertEquals(1, user.getCurrentLesson());
    }

    @Test
    void setUserName() {
        user.setUserName("john");
        assertEquals("john", user.getUserName());
    }

    @Test
    void setExerciseGoal() {
        user.setExerciseGoal(19);
        assertEquals(19, user.getExerciseGoal());
    }

    @Test
    void setMeditationGoal() {
        user.setMeditationGoal(3544);
        assertEquals(3544, user.getMeditationGoal());
    }

    @Test
    void setUserActivityGoal() {
        user.setUserActivityGoal(354);
        assertEquals(354, user.getUserActivityGoal());
    }

    @Test
    void setCurrentPlan() {
        user.setCurrentPlan(14);
        assertEquals(14, user.getCurrentPlan());
    }

    @Test
    void setCurrentLesson() {
        user.setCurrentLesson(15);
        assertEquals(15, user.getCurrentLesson());
    }
}