package com.group20.thrive.database;

import androidx.room.Entity;
import androidx.room.ForeignKey;
import androidx.room.PrimaryKey;

@Entity(tableName = "lesson")
public class Lesson {
    @PrimaryKey(autoGenerate = true)
    public int lessonId;
    public int planId;
    public int lessonDay;
    public String lessonDesc;

    public Lesson(int planId, int lessonDay, String lessonDesc) {
        this.planId = planId;
        this.lessonDay = lessonDay;
        this.lessonDesc = lessonDesc;
    }

    public int getLessonId() { return lessonId; }

    public int getPlanId() { return planId; }

    public String getLessonDesc() { return lessonDesc; }

    public void setLessonId(int lessonId) { this.lessonId = lessonId; }
}