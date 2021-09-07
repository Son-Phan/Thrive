package com.group20.thrive.database;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Transaction;

import java.util.List;

@Dao
public interface PlanDao {

    @Insert
    void insertAll(Plan... plans);

    @Query("SELECT * from [Plan]")
    List<Plan> getPlan();

    @Transaction
    @Query("SELECT * FROM [Plan]")
    List<PlanWithLessons> getPlansWithLessons();
}