package com.group20.thrive.database;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;
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
}
