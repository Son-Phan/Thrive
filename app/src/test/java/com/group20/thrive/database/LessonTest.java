package com.group20.thrive.database;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import org.junit.runners.Parameterized;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
class LessonTest {

    Lesson lesson;
    @BeforeEach
    public void setup(){
        lesson = new Lesson(1,10);
    }
    @Test
    void getLessonId() {

    }

    @Test
    void getPlanId() {
        assertEquals(1, lesson.getPlanId());
    }

    @Test
    void getLessonDay() {
        assertEquals(10, lesson.getLessonDay());
    }

    @Test
    void setLessonId() {
        lesson.setLessonId(10);
        assertEquals(10, lesson.getLessonId());
    }

    @Test
    @DisplayName("Should not create lesson when all parameter are null")
    public void shouldThrowRunTimeExceptionWhenLessonDescIsNull(){
        Assertions.assertThrows(RuntimeException.class, () -> {
            Lesson lesson = new Lesson(null,null);
        });

    }
}