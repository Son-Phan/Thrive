package com.group20.thrive.database;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.RewriteQueriesToDropUnusedColumns;
import androidx.room.Transaction;

import java.util.List;

@Dao
public interface LessonDao {

    @Insert
    void insertAll(Lesson... lessons);

    @Query("SELECT * FROM Lesson WHERE lessonId = :lessonId")
    Lesson getLesson(int lessonId);

    @Transaction
    @Query("SELECT * FROM Lesson")
    List<LessonWithActivities> getLessonsWithActivities();

    @RewriteQueriesToDropUnusedColumns
    @Query("SELECT * FROM Activity " +
            " INNER JOIN LessonActivityCrossRef ON LessonActivityCrossRef.activityId = Activity.activityId " +
            "WHERE LessonActivityCrossRef.lessonId LIKE :lessonId")
    LiveData<List<Activity>> getActivitiesOfLesson(int lessonId);
}
