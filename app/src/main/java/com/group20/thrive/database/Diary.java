package com.group20.thrive.database;

import androidx.room.Entity;
import androidx.room.PrimaryKey;

import java.util.ArrayList;

@Entity(tableName = "diary")
public class Diary {
    @PrimaryKey(autoGenerate = true)
    public int entryId;
    public String entryDate;
    public String entryTime;
    public String entryMood; // depressed - sad - fine - optimistic - happy
    public int sleepDuration; // hours
    public String entryActivities; // activities separate by comma
    public String entryNote;
    public int imageLocation;

    public Diary(String entryDate, String entryTime, String entryMood, int imageLocation, int sleepDuration, String entryActivities, String entryNote) {
        this.entryDate = entryDate;
        this.entryMood = entryMood;
        this.entryTime = entryTime;
        this.imageLocation = imageLocation;
        this.sleepDuration = sleepDuration;
        this.entryActivities = entryActivities;
        this.entryNote = entryNote;
    }

    public String getEntryDate() { return entryDate; }

    public String getEntryTime() {
        return entryTime;
    }

    public String getEntryMood() { return entryMood; }

    public int getImageLocation() {
        return imageLocation;
    }

    public int getSleepDuration() { return sleepDuration; }

    public String getEntryActivities() { return entryActivities; }

    public String getEntryNote() { return entryNote; }

    public void setEntryId(int entryId) { this.entryId = entryId; }
}


