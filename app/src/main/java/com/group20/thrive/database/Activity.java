package com.group20.thrive.database;

import androidx.room.Entity;
import androidx.room.PrimaryKey;


@Entity(tableName = "activity")
public class Activity {
    @PrimaryKey(autoGenerate = true)
    public int activityId;
    public String activityName;
    public String activityType; // exercise || meditation
    public int activityLen;     // minutes
    public String activityDesc;
    public String fileName;

    public Activity (String activityName, String activityType, int activityLen, String activityDesc, String fileName) {
        this.activityName = activityName;
        this.activityType = activityType;
        this.activityLen = activityLen;
        this.activityDesc = activityDesc;
        this.fileName = fileName;
    }

    public int getActivityId () { return activityId; }

    public String getActivityName () { return activityName; }

    public String getActivityType () { return activityType; }

    public int getActivityLen () { return activityLen; }

    public String getActivityDesc () { return activityDesc; }

    public String getFileName () { return fileName; }

    public void setActivityId (int activityId) { this.activityId = activityId; }

}
