package com.group20.thrive.database;

import android.app.Application;

import androidx.lifecycle.LiveData;

import java.util.List;

public class PlanRepository {

    private PlanDao mPlanDao;
    private LiveData<List<Plan>> mAllPlans;
    public PlanRepository(Application application) {
        ThriveDatabase db = ThriveDatabase.getDatabase(application);
        mPlanDao = db.planDao();
        mAllPlans = mPlanDao.getAllPlans();
    }
    public LiveData<List<Plan>> getAllPlans() {
        return mAllPlans;
    }
    public List<Plan> getPlan() { return mPlanDao.getPlan(); }

    void insert(Plan plan) {
        ThriveDatabase.databaseWriteExecutor.execute(() -> mPlanDao.addPlan(plan));
    }

    List<PlanWithLessons> getPlansWithLessons() { return mPlanDao.getPlansWithLessons(); }

    public LiveData<Plan> getUserPlan() { return mPlanDao.getUserPlan(); }

    public void deletePlan(String planName) { mPlanDao.deletePlan(planName);}
    public Plan getEachPlan(String planName) {return mPlanDao.getEachPlan(planName);}
}
