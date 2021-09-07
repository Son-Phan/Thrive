package com.group20.thrive.database;

import androidx.room.Embedded;
import androidx.room.Junction;
import androidx.room.Relation;

import java.util.List;

public class LessonWithActivities {
    @Embedded public Lesson lesson;
    @Relation(
            parentColumn = "lessonId",
            entityColumn = "activityId",
            associateBy = @Junction(LessonActivityCrossRef.class)
    )
    public List<Activity> activities;
}
