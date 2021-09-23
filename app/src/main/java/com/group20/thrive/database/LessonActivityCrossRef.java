package com.group20.thrive.database;


import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.ForeignKey;
import androidx.room.Index;

@Entity(primaryKeys = {"lessonId", "activityId"})
public class LessonActivityCrossRef {
    @ColumnInfo(index = true)
    public int lessonId;
    @ColumnInfo(index = true)
    public int activityId;
    public String timeOfDay;

    public LessonActivityCrossRef(int lessonId, int activityId, String timeOfDay) {
        this.lessonId = lessonId;
        this.activityId = activityId;
        this.timeOfDay = timeOfDay;
    }

    public int getLessonId() { return lessonId; }

    public int getActivityId() { return activityId; }

    public String getTimeOfDay() { return timeOfDay; }
}
