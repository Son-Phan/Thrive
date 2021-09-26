package com.group20.thrive.database;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;

import com.group20.thrive.ui.profile.MoodCount;

import java.util.ArrayList;
import java.util.List;

@Dao
public interface DiaryDao {

    @Insert
    void insertAll(Diary... diaries);

    @Insert
    void addDiary(Diary diary);

    @Query("SELECT * FROM Diary WHERE entryDate = :entryDate")
    List<Diary> getEntries(String entryDate);

    @Query("SELECT * FROM Diary WHERE entryDate = :entryDate")
    LiveData<List<Diary>> getAllEntries(String entryDate);

    @Query("SELECT COUNT(DISTINCT entryDate) FROM DIARY")
    LiveData<Integer> getNumOfEntryDays();

    @Query("SELECT entryMood AS mood, COUNT(*) AS moodCount  FROM Diary GROUP BY entryMood")
    LiveData<List<MoodCount>> getMoodCount();
}
