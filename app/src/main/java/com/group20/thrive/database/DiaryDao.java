package com.group20.thrive.database;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;

import java.util.ArrayList;
import java.util.List;

@Dao
public interface DiaryDao {

    @Insert
    void insertAll(Diary... diaries);

    @Query("SELECT * FROM Diary WHERE entryDate = :entryDate")
    List<Diary> getEntries(String entryDate);
}
