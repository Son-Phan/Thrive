package com.group20.thrive.database;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;

import java.util.List;

@Dao
public interface ActivityDao {

    @Insert
    void insertAll(Activity... activities);

    @Query("SELECT * FROM Activity WHERE activityType = :activityType")
    List<Activity> getActivityList(String activityType);

    @Query("SELECT * FROM Activity")
    LiveData<List<Activity>> getAllActivities();

    @Query("SELECT * FROM Activity WHERE activityId = :activityId")
    Activity getActivity(int activityId);

}
