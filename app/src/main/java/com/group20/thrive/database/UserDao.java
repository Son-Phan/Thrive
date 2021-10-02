package com.group20.thrive.database;


import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

@Dao
public interface UserDao {

    @Insert
    void addUser(User user);

    @Query("SELECT * FROM User")
    User getCurrUser();

    @Query("SELECT * FROM User")
    LiveData<User> getUser();

    @Query("UPDATE User SET userName = :newUserName")
    void updateUserName(String newUserName);

    @Query("UPDATE User SET exerciseGoal = :newExerciseGoal")
    void updateExerciseGoal(int newExerciseGoal);

    @Query("UPDATE User SET meditationGoal = :newMeditationGoal")
    void updateMeditationGoal(int newMeditationGoal);

    @Query("UPDATE User SET userActivityGoal = :newUserActivityGoal")
    void updateUserActivityGoal(int newUserActivityGoal);

    @Query("UPDATE User SET currentPlan = :newCurrentPlan")
    void updateCurrentPlan(int newCurrentPlan);

    @Query("UPDATE User SET currentLesson = (SELECT lessonId FROM lesson WHERE planId = :planId LIMIT 1)")
    void updateCurrentLesson(int planId);
}
