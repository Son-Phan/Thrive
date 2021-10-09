package com.group20.thrive.database;

import static org.junit.Assert.*;

import android.content.Context;

import androidx.room.Room;
import androidx.test.core.app.ApplicationProvider;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class PlanDaoTest {
    private ThriveDatabase thriveDatabase;
    private PlanDao planDao;
    private Plan plan;
    @Before
    public void setUp() throws Exception {
        Context context = ApplicationProvider.getApplicationContext();
        thriveDatabase = Room.inMemoryDatabaseBuilder(context, ThriveDatabase.class).build();
        planDao = thriveDatabase.planDao();
        plan = new Plan("trung", 10, "Work hard");
        planDao.addPlan(plan);
    }

    @After
    public void tearDown() throws Exception {
        thriveDatabase.close();
    }

    @Test
    public void planDaoExist(){
        assertNotNull(planDao);
    }

    @Test
    public void getPlanName(){
        assertEquals(planDao.getPlan().get(0).getPlanName(), plan.getPlanName());
    }

    @Test
    public void getPlanDescription(){
        assertEquals(planDao.getPlan().get(0).getPlanDescription(), plan.getPlanDescription());
    }
    @Test
    public void getPlanLength(){
        assertEquals(planDao.getPlan().get(0).getPlanLength(), plan.getPlanLength());
    }

}