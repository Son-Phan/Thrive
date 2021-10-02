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

    public LiveData<List<String>> getActivityNamesOfType(String activityType) { return mActivityDao.getActivityNamesOfType(activityType); }

    Activity getActivity(int activityId) { return mActivityDao.getActivity(activityId); }
    void deleteActivity(String activityType) {  mActivityDao.deleteActivityOfType(activityType); }
}
