package com.group20.thrive.database;

import android.app.Application;

import java.util.List;

public class ActivityRepository {

    private ActivityDao mActivityDao;

    public ActivityRepository(Application application) {
        ThriveDatabase db = ThriveDatabase.getDatabase(application);
        mActivityDao = db.activityDao();
    }

    List<Activity> getActivityList(String activityType) { return mActivityDao.getActivityList(activityType); }

    Activity getActivity(int activityId) { return mActivityDao.getActivity(activityId); }
}
