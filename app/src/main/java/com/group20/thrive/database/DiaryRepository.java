package com.group20.thrive.database;

import android.app.Application;

import androidx.lifecycle.LiveData;

import com.group20.thrive.ui.profile.MoodCount;

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

    public LiveData<Integer> getNumOfEntryDays() { return mDiaryDao.getNumOfEntryDays(); }

    public LiveData<List<MoodCount>> getMoodCount() { return mDiaryDao.getMoodCount(); }

    public void deleteDiary(String entryMood){ mDiaryDao.deleteDiary(entryMood);}
}
