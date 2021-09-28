package com.group20.thrive.ui.profile;

public class TodayRecord {

    int numOfRecords;
    int totalTimeSpent;

    public TodayRecord(int numOfRecords, int totalTimeSpent) {
        this.numOfRecords = numOfRecords;
        this.totalTimeSpent = totalTimeSpent;
    }

    public int getNumOfRecords() {
        return numOfRecords;
    }

    public int getTotalTimeSpent() {
        return totalTimeSpent;
    }
}
