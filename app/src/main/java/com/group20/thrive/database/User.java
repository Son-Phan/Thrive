package com.group20.thrive.database;

import androidx.annotation.NonNull;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "user")
public class User {
    @PrimaryKey
    @NonNull
    public String userName;
    public int exerciseGoal;
    public int meditationGoal;
    public int sleepGoal;
    public int currentStreak;
    public int longestStreak;

    public User(String userName, int exerciseGoal, int meditationGoal, int sleepGoal, int currentStreak, int longestStreak) {
        this.userName = userName;
        this.exerciseGoal = exerciseGoal;
        this.meditationGoal = meditationGoal;
        this.sleepGoal = sleepGoal;
        this.currentStreak = currentStreak;
        this.longestStreak = longestStreak;
    }

    public String getUserName() { return userName; }

    public int getExerciseGoal() { return exerciseGoal; }

    public int getMeditationGoal() { return meditationGoal; }

    public int getSleepGoal() { return sleepGoal; }

    public int getCurrentStreak() { return currentStreak; }

    public int getLongestStreak() { return longestStreak; }

    public void setUserName(String userName) { this.userName = userName; }

    public void setExerciseGoal(int exerciseGoal) { this.exerciseGoal = exerciseGoal; }

    public void setMeditationGoal(int meditationGoal) { this.meditationGoal = meditationGoal; }

    public void setSleepGoal(int sleepGoal) { this.sleepGoal = sleepGoal; }

    public void setCurrentStreak(int currentStreak) { this.currentStreak = currentStreak; }

    public void setLongestStreak(int longestStreak) { this.longestStreak = longestStreak; }
}