package com.group20.thrive.database;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Transaction;

import java.util.List;

@Dao
public interface PlanDao {

    @Insert
    void addPlan(Plan plan);

    @Query("select * from `plan`")
    List<Plan> getPlan();

    @Query("select * from `plan`")
    LiveData<List<Plan>> getAllPlans();

    @Transaction
    @Query("select * from `plan`")
    List<PlanWithLessons> getPlansWithLessons();

    @Query("SELECT * FROM `plan` WHERE planId LIKE (SELECT planId FROM User)")
    LiveData<Plan> getUserPlan();
    @Query("DELETE  FROM `plan` WHERE planName = :planName")
    void deletePlan(String planName);
    @Query("SELECT * FROM `plan` WHERE planName = :planName")
    Plan getEachPlan(String planName);
}