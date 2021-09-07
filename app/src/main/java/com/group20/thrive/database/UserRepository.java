package com.group20.thrive.database;

import android.app.Application;

public class UserRepository {
    private UserDao mUserDao;
    private ActivityRecordDao mActivityRecordDao;

    UserRepository(Application application) {
        ThriveDatabase db = ThriveDatabase.getDatabase(application);
        mUserDao = db.userDao();
        mActivityRecordDao = db.activityRecordDao();
    }

    void addUser(User user) { ThriveDatabase.databaseWriteExecutor.execute(() -> mUserDao.addUser(user)); }

    User getUser() { return mUserDao.getUser(); }

    void addActivityRecord (ActivityRecord record) { ThriveDatabase.databaseWriteExecutor.execute(() -> mActivityRecordDao.addRecord(record)); }

    ActivityRecord getActivityRecord(String activityType) { return mActivityRecordDao.getActivityRecord(activityType); }
}
