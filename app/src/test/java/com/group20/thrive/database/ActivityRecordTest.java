package com.group20.thrive.database;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class ActivityRecordTest {

    ActivityRecord activityRecord;
    @BeforeEach
    void setUp() {
        activityRecord = new ActivityRecord("15",10,"something", 199);
    }

    @Test
    void getRecordId() {
        assertEquals(0, activityRecord.getRecordId());
    }

    @Test
    void getRecordTime() {
        assertEquals("15", activityRecord.getRecordTime());
    }

    @Test
    void getActivityName() {
        assertEquals(10, activityRecord.getActivityName());
    }

    @Test
    void getActivityType() {
        assertEquals("something", activityRecord.getActivityType());
    }

    @Test
    void getRecordLength() {
        assertEquals(199, activityRecord.getRecordLength());
    }

    @Test
    void setRecordId() {
        activityRecord.setRecordId(14);
        assertEquals(14, activityRecord.getRecordId());
    }
}