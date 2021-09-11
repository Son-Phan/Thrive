package com.group20.thrive.database;

import android.app.Application;

import androidx.lifecycle.LiveData;

import java.util.List;

public class DiaryRepository {

    private DiaryDao mDiaryDao;
    public DiaryRepository(Application application) {
        ThriveDatabase db = ThriveDatabase.getDatabase(application);
        mDiaryDao = db.diaryDao();

    }
    public LiveData<List<Diary>> getAllEntries(String entryDate) {
        return mDiaryDao.getAllEntries(entryDate);
    }
    public List<Diary> getEntries(String entryDate) { return mDiaryDao.getEntries(entryDate); }
}
