package com.group20.thrive.database;

import android.app.Application;

import androidx.lifecycle.LiveData;

public class UserRepository {
    private UserDao mUserDao;
    private ActivityRecordDao mActivityRecordDao;

    public UserRepository(Application application) {
        ThriveDatabase db = ThriveDatabase.getDatabase(application);
        mUserDao = db.userDao();
        mActivityRecordDao = db.activityRecordDao();
    }

    public void addUser(User user) { ThriveDatabase.databaseWriteExecutor.execute(() -> mUserDao.addUser(user)); }

    public LiveData<User> getUser() { return mUserDao.getUser(); }

    public void addActivityRecord (ActivityRecord record) { ThriveDatabase.databaseWriteExecutor.execute(() -> mActivityRecordDao.addRecord(record)); }

    public ActivityRecord getActivityRecord(String activityType) { return mActivityRecordDao.getActivityRecord(activityType); }
}
