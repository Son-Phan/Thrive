package com.group20.thrive.database;
import static org.junit.Assert.*;

import android.content.Context;

import androidx.room.Room;
import androidx.test.core.app.ApplicationProvider;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.util.List;

public class ActivityDaoTest {
    private ActivityDao activityDao;
    private  ThriveDatabase thriveDatabase;
    private  List<Activity> activityList;
    private  Activity activity;
    @Before
    public void setUp() throws Exception {
        Context context = ApplicationProvider.getApplicationContext();
        thriveDatabase = Room.inMemoryDatabaseBuilder(context, ThriveDatabase.class).build();
        activityDao = thriveDatabase.activityDao();
        activity = new Activity("trung", "Work", 10, "Work hard", "word");
        activityDao.insertAll(activity);
        activityList = activityDao.getActivityList("Work");
    }

    @After
    public void tearDown() throws Exception {
        thriveDatabase.close();
    }

    @Test
    public void activityListNotNull()throws Exception{
        assertNotNull(activityList);
    }
    @Test
    public void getActivityLen(){
        assertEquals(activityList.get(0).getActivityLen(), activity.getActivityLen());
    }
    @Test
    public void getActivityDesc(){
        assertEquals(activityList.get(0).getActivityDesc(), activity.getActivityDesc());
    }
    @Test
    public void getActivityType(){
        assertEquals(activityList.get(0).getActivityType(), activity.getActivityType());
    }
}