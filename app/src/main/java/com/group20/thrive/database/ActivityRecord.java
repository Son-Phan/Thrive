package com.group20.thrive.database;

import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity
public class ActivityRecord {
    @PrimaryKey (autoGenerate = true)
    public int recordId;
    public String recordTime;
    public String activityType; // exercise || meditation
    public int recordLength; // in minutes

    public ActivityRecord(String recordTime, String activityType, int recordLength) {
        this.recordTime = recordTime;
        this.activityType = activityType;
        this.recordLength = recordLength;
    }

    public int getRecordId() { return recordId; }

    public String getRecordTime() { return recordTime; }

    public String getActivityType() { return activityType; }

    public int getRecordLength() { return recordLength; }

    public void setRecordId (int recordId) { this.recordId = recordId; }
}
