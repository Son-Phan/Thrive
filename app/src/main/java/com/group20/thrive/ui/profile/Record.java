package com.group20.thrive.ui.profile;

public class Record {

    String recordTime;
    int recordLength;

    public Record(String recordTime, int recordLength) {
        this.recordTime = recordTime;
        this.recordLength = recordLength;
    }

    public String getRecordTime() {
        return recordTime;
    }

    public int getRecordLength() {
        return recordLength;
    }
}
