package com.group20.thrive.database;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;

@Dao
public interface ActivityRecordDao {

    @Insert
    void addRecord(ActivityRecord record);

    @Query("SELECT * FROM ActivityRecord WHERE activityType = :activityType")
    ActivityRecord getActivityRecord(String activityType);

}
