package com.group20.thrive.database;

import static org.junit.Assert.*;

import android.content.Context;

import androidx.room.Room;
import androidx.test.core.app.ApplicationProvider;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class PlanRepositoryTest {
    private ThriveDatabase thriveDatabase;
    private PlanDao planDao;
    private Plan plan;
    private PlanRepository planRepository;
    @Before
    public void setUp() throws Exception {
        Context context = ApplicationProvider.getApplicationContext();
        thriveDatabase = Room.databaseBuilder(context, ThriveDatabase.class,
                ThriveDatabase.THRIVE_DATABASE_NAME).build();
        planDao = thriveDatabase.planDao();
        plan = new Plan("trung",10,"nothing");
        planDao.addPlan(plan);
        planRepository = new PlanRepository(ApplicationProvider.getApplicationContext());
    }

    @After
    @Test
    public void deletePlan() throws Exception {
        planRepository.deletePlan("trung");
        thriveDatabase.close();
    }

    @Test
    public void getPlanName(){
        assertEquals(planRepository.getEachPlan("trung").getPlanName(), planDao.getEachPlan("trung").getPlanName());
    }
    @Test
    public void getPlanLength(){
        assertEquals(planRepository.getEachPlan("trung").getPlanLength(), planDao.getEachPlan("trung").getPlanLength());
    }
    @Test
    public void getPlanId(){
        assertEquals(planRepository.getEachPlan("trung").getPlanId(), planDao.getEachPlan("trung").getPlanId());
    }
    @Test
    public void getPlanDescription(){
        assertEquals(planRepository.getEachPlan("trung").getPlanDescription(), planDao.getEachPlan("trung").getPlanDescription());
    }


    @Test
    public void getAllPlans() {
        assertNotNull(planRepository.getAllPlans());
    }

    @Test
    public void getPlan() {
        assertNotNull(planRepository.getPlan());
    }


    @Test
    public void getPlansWithLessons() {
        assertNotNull(planRepository.getPlansWithLessons());
    }

    @Test
    public void getUserPlan() {
        assertNotNull(planRepository.getUserPlan());
    }


}