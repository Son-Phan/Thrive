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

    @Query("SELECT planId FROM `plan` WHERE planName LIKE :planName")
    Integer getPlanId(String planName);

    @Query("SELECT planName FROM `plan` WHERE planId LIKE :planId")
    String getPlanName(int planId);

    @Query("select * from `plan`")
    LiveData<List<Plan>> getAllPlans();

    @Transaction
    @Query("select * from `plan`")
    List<PlanWithLessons> getPlansWithLessons();

    @Query("SELECT * FROM `plan` WHERE planId LIKE (SELECT currentPlan FROM User)")
    LiveData<Plan> getUserPlan();

    @Query("SELECT planName FROM `plan`")
    LiveData<List<String>> getAllPlanNames();

    @Query("select * from `plan`")
    List<Plan> getPlan();
    @Query("DELETE FROM `plan` WHERE planName = :planName")
    void deletePlan(String planName);
    @Query("SELECT * FROM `plan` WHERE planName = :planName")
    Plan getEachPlan(String planName);
}