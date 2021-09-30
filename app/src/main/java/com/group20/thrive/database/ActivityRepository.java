package com.group20.thrive.database;

import android.app.Application;

import androidx.lifecycle.LiveData;

import java.util.List;

public class ActivityRepository {

    private ActivityDao mActivityDao;

    public ActivityRepository(Application application) {
        ThriveDatabase db = ThriveDatabase.getDatabase(application);
        mActivityDao = db.activityDao();
    }

    List<Activity> getActivityList(String activityType) { return mActivityDao.getActivityList(activityType); }

    public LiveData<List<Activity>> getAllActivities() { return mActivityDao.getAllActivities(); }

    Activity getActivity(int activityId) { return mActivityDao.getActivity(activityId); }


}
