package com.group20.thrive.database;

import android.app.Application;

import java.util.List;

public class DiaryRepository {

    private DiaryDao mDiaryDao;

    DiaryRepository(Application application) {
        ThriveDatabase db = ThriveDatabase.getDatabase(application);
        mDiaryDao = db.diaryDao();
    }

    List<Diary> getEntries(String entryDate) { return mDiaryDao.getEntries(entryDate); }
}
