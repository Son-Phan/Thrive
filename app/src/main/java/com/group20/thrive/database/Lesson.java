package com.group20.thrive.database;

import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "lesson")
public class Lesson {
    @PrimaryKey(autoGenerate = true)
    public int lessonId;
    public int planId;
    public int lessonDay;

    public Lesson(Integer planId, Integer lessonDay) {
        this.planId = planId;
        this.lessonDay = lessonDay;
    }

    public int getLessonId() { return lessonId; }

    public int getPlanId() { return planId; }

    public int getLessonDay() { return lessonDay; }

    public void setLessonId(int lessonId) { this.lessonId = lessonId; }
}