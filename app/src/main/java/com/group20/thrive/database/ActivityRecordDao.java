package com.group20.thrive.database;

import android.icu.text.AlphabeticIndex;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;

import com.group20.thrive.ui.profile.Record;
import com.group20.thrive.ui.profile.TodayRecord;

import java.util.List;

@Dao
public interface ActivityRecordDao {

    @Insert
    void addRecord(ActivityRecord record);

    @Query("SELECT * FROM ActivityRecord WHERE activityType = :activityType")
    ActivityRecord getActivityRecord(String activityType);

    @Query("SELECT recordTime, AVG(recordLength) AS recordLength FROM (SELECT * FROM ACTIVITYRECORD WHERE activityType LIKE :activityType) GROUP BY recordTime ORDER BY recordTime DESC LIMIT 7")
    LiveData<List<Record>> getRecordsOfActivityTypeInAWeek(String activityType);

    @Query("SELECT recordTime, AVG(recordLength) AS recordLength FROM (SELECT * FROM ACTIVITYRECORD WHERE activityType LIKE :activityType) GROUP BY recordTime")
    LiveData<List<Record>> getRecordsOfActivityType(String activityType);

    @Query("SELECT COUNT(*) AS numOfRecords, SUM(recordLength) AS totalTimeSpent FROM ActivityRecord WHERE recordTime LIKE :recordTime AND activityType LIKE :activityType")
    LiveData<TodayRecord> getTimeSpentOfActivityTypeInADay(String recordTime, String activityType);
}
