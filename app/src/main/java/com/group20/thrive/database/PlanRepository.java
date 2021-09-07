package com.group20.thrive.database;

import android.app.Application;
import java.util.List;

public class PlanRepository {

    private PlanDao mPlanDao;

    PlanRepository(Application application) {
        ThriveDatabase db = ThriveDatabase.getDatabase(application);
        mPlanDao = db.planDao();
    }

    List<Plan> getPlan() { return mPlanDao.getPlan(); }

    List<PlanWithLessons> getPlansWithLessons() { return mPlanDao.getPlansWithLessons(); }
}
