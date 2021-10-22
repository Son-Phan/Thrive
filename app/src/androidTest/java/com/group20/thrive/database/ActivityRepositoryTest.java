package com.group20.thrive.database;

import static org.junit.Assert.*;

import android.app.Application;
import android.content.Context;

import androidx.room.Room;
import androidx.test.core.app.ApplicationProvider;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class ActivityRepositoryTest {
    private ThriveDatabase thriveDatabase;
    private ActivityRepository activityRepository;
    private ActivityDao activityDao;
    private  Activity activity;
    @Before
    public void setUp() throws Exception {
        Context context = ApplicationProvider.getApplicationContext();
        thriveDatabase = Room.databaseBuilder(context, ThriveDatabase.class,
                ThriveDatabase.THRIVE_DATABASE_NAME).build();
        activityDao = thriveDatabase.activityDao();
        activity = new Activity("trung", "Work", 10, "Work hard", "word");
        activityDao.insertAll(activity);
        Application application = ApplicationProvider.getApplicationContext();
        activityRepository = new ActivityRepository(application);

    }

    @After
    public void tearDown() throws Exception {
        activityRepository.deleteActivity("Work");
        thriveDatabase.close();
    }

    @Test
    public void getActivityName() {
        assertEquals(activityRepository.getActivityList("Work").get(0).getActivityName(), activityDao.getActivityList("Work").get(0).getActivityName());
    }

    @Test
    public void getActivityType() {
        assertEquals(activityRepository.getActivityList("Work").get(0).getActivityType(), activityDao.getActivityList("Work").get(0).getActivityType());
    }

    @Test
    public void getActivityLen() {
        assertEquals(activityRepository.getActivityList("Work").get(0).getActivityLen(), activityDao.getActivityList("Work").get(0).getActivityLen());
    }

    @Test
    public void getActivityDesc() {
        assertEquals(activityRepository.getActivityList("Work").get(0).getActivityDesc(), activityDao.getActivityList("Work").get(0).getActivityDesc());
    }

    @Test
    public void getActivityList(){
        assertNotNull(activityRepository.getActivityList("Work"));
    }


    @Test
    public void getActivity(){
        assertNotNull(activityRepository.getActivity(1));
    }
}