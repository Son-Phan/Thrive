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

    public LessonActivityCrossRef(int lessonId, int activityId) {
        this.lessonId = lessonId;
        this.activityId = activityId;
    }

    public int getLessonId() { return lessonId; }

    public int getActivityId() { return activityId; }
}
