package com.group20.thrive.database;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.RewriteQueriesToDropUnusedColumns;
import androidx.room.RoomWarnings;
import androidx.room.Transaction;

import java.util.List;

@Dao
public interface LessonDao {

    @Insert
    void insertAll(List<Lesson> lessons);

    @Insert
    void insertLessonActivity(LessonActivityCrossRef lessonActivityCrossRef);

    @Query("SELECT * FROM Lesson WHERE lessonId = :lessonId")
    Lesson getLesson(int lessonId);

    @Query("SELECT * FROM Lesson WHERE planId = :planId")
    LiveData<List<Lesson>> getLessonsOfPlan(int planId);
    @Query("SELECT * FROM Lesson WHERE planId = :planId")
    List<Lesson> getLessonsOfPlan_list(int planId);
    @Transaction
    @Query("SELECT * FROM Lesson")
    List<LessonWithActivities> getLessonsWithActivities();

    @SuppressWarnings(RoomWarnings.CURSOR_MISMATCH)
    @RewriteQueriesToDropUnusedColumns
    @Query("SELECT * FROM Activity " +
            " INNER JOIN LessonActivityCrossRef ON LessonActivityCrossRef.activityId = Activity.activityId " +
            "WHERE LessonActivityCrossRef.lessonId LIKE :lessonId GROUP BY LessonActivityCrossRef.activityId")
    LiveData<List<Activity>> getActivitiesOfLesson(int lessonId);

    @Query("SELECT timeOfDay FROM LessonActivityCrossRef WHERE lessonId LIKE :lessonId AND activityId LIKE :activityId")
    LiveData<List<String>> getActivityTimeOfDay(int lessonId, int activityId);

    @Query("DELETE  FROM Lesson WHERE planId = :planId")
    void deleteLesson(Integer planId);
}
