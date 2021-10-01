package com.group20.thrive.database;

import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity
public class ActivityRecord {
    @PrimaryKey (autoGenerate = true)
    public int recordId;
    public String recordTime; // date format dd/MM/yyyy
    public int activityId;
    public String activityType; // exercise || meditation || user
    public int recordLength; // in seconds

    public ActivityRecord(String recordTime, int activityId, String activityType, int recordLength) {
        this.recordTime = recordTime;
        this.activityId = activityId;
        this.activityType = activityType;
        this.recordLength = recordLength;
    }

    public int getRecordId() { return recordId; }

    public String getRecordTime() { return recordTime; }

    public int getActivityId() { return activityId; }

    public String getActivityType() { return activityType; }

    public int getRecordLength() { return recordLength; }

    public void setRecordId (int recordId) { this.recordId = recordId; }
}
