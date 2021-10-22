package com.group20.thrive.database;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class ActivityTest {

    @Test
    void getActivityId() {
    }
    @Test
    public void checkValidLenActivity(){
        Activity activity = new Activity("Push up","Work out", 0, "Try the best","Nothing");
        assertEquals(false, activity.checkValidLenActivity());
        activity = new Activity("Push up","Work out", 30, "Try the best","Nothing");
        assertEquals(true, activity.checkValidLenActivity());
        activity = new Activity("Push up","Work out", 61, "Try the best","Nothing");
        assertEquals(false, activity.checkValidLenActivity());
    }
    @Test
    void getActivityName() {
        Activity activity = new Activity("Push up","Work out", 10, "Try the best","Nothing");
        assertEquals("Push up", activity.getActivityName());
    }

    @Test
    void getActivityType() {
        Activity activity = new Activity("Push up","Work out", 10, "Try the best","Nothing");
        assertEquals("Work out", activity.getActivityType());
    }

    @Test
    void getActivityLen() {
        Activity activity = new Activity("Push up","Work out", 10, "Try the best","Nothing");
        assertEquals(10, activity.getActivityLen());
    }

    @Test
    void getActivityDesc() {
        Activity activity = new Activity("Push up","Work out", 10, "Try the best","Nothing");
        assertEquals("Try the best", activity.getActivityDesc());
    }

    @Test
    void getFileName() {
        Activity activity = new Activity("Push up","Work out", 10, "Try the best","Nothing");
        assertEquals("Nothing", activity.getFileName());
    }

    @Test
    void setActivityId() {
    }
}