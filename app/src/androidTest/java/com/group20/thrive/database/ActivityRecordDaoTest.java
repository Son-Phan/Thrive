package com.group20.thrive.database;

import static org.junit.Assert.*;

import android.content.Context;

import androidx.room.Room;
import androidx.test.core.app.ApplicationProvider;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class ActivityRecordDaoTest {

    private ThriveDatabase thriveDatabase;
    private ActivityRecordDao activityRecordDao;
    private ActivityRecord activityRecord;

    @Before
    public void setUp() throws Exception {
        Context context = ApplicationProvider.getApplicationContext();
        thriveDatabase = Room.inMemoryDatabaseBuilder(context, ThriveDatabase.class).build();
        activityRecordDao = thriveDatabase.activityRecordDao();
        activityRecord = new ActivityRecord("10", 25, "Work", 199);
        activityRecordDao.addRecord(activityRecord);

    }

    @After
    public void tearDown() throws Exception {
        thriveDatabase.close();
    }

    @Test
    public void activityRecordExist(){
        assertNotNull(activityRecordDao);
    }

    @Test
    public void getRecordTime(){
        assertEquals(activityRecordDao.getActivityRecord("Work").getRecordTime(), activityRecord.getRecordTime());
    }

    @Test
    public void getActivityType(){
        assertEquals(activityRecordDao.getActivityRecord("Work").getActivityType(), activityRecord.getActivityType());
    }

    @Test
    public void getActivityLength(){
        assertEquals(activityRecordDao.getActivityRecord("Work").getRecordLength(), activityRecord.getRecordLength());
    }
}