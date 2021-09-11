package com.group20.thrive.database;

import androidx.room.Entity;
import androidx.room.PrimaryKey;

import java.util.ArrayList;

@Entity(tableName = "diary")
public class Diary {
    @PrimaryKey(autoGenerate = true)
    public int entryId;
    public String entryDate; // dd-MM-yyyy HH:mm:ss
    public String entryMood; // depressed - sad - fine - optimistic - happy
    public int sleepDuration; // hours
    public String entryActivities; // activities separate by comma
    public String entryNote;

    public int getActivityDuration() {
        return activityDuration;
    }

    public int activityDuration;

    public Diary(String entryDate, String entryMood, int sleepDuration, String entryActivities,int activityDuration, String entryNote) {
        this.entryDate = entryDate;
        this.entryMood = entryMood;
        this.sleepDuration = sleepDuration;
        this.entryActivities = entryActivities;
        this.activityDuration = activityDuration;
        this.entryNote = entryNote;
    }

    public String getEntryDate() { return entryDate; }

    public String getEntryMood() { return entryMood; }

    public int getSleepDuration() { return sleepDuration; }

    public String getEntryActivities() { return entryActivities; }

    public String getEntryNote() { return entryNote; }

    public void setEntryId(int entryId) { this.entryId = entryId; }
}


