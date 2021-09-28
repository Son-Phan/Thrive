package com.group20.thrive.database;

import static org.junit.Assert.*;

import android.content.Context;

import androidx.room.Room;
import androidx.test.core.app.ApplicationProvider;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class DiaryDaoTest {
    private ThriveDatabase thriveDatabase;
    private DiaryDao diaryDao;
    private Diary diary;
    @Before
    public void setUp() throws Exception {
        Context context = ApplicationProvider.getApplicationContext();
        thriveDatabase = Room.inMemoryDatabaseBuilder(context, ThriveDatabase.class).build();
        diaryDao = thriveDatabase.diaryDao();
        diary = new Diary("20/10/1111","10","Happy", 10, 30, "Sleep", "Sleep well");
        diaryDao.addDiary(diary);
    }

    @After
    public void tearDown() throws Exception {
        thriveDatabase.close();
    }

    @Test
    public void diaryDaoExist(){
        assertNotNull(diaryDao);
    }

    @Test
    public void getEntryDate(){
        assertEquals(diaryDao.getEntries("20/10/1111").get(0).getEntryDate(), diary.getEntryDate());
    }

    @Test
    public void getEntryTime(){
        assertEquals(diaryDao.getEntries("20/10/1111").get(0).getEntryTime(), diary.getEntryTime());
    }
    @Test
    public void getEntryMood(){
        assertEquals(diaryDao.getEntries("20/10/1111").get(0).getEntryMood(), diary.getEntryMood());
    }

    @Test
    public void getEntryNote(){
        assertEquals(diaryDao.getEntries("20/10/1111").get(0).getEntryNote(), diary.getEntryNote());
    }

    @Test
    public void getImageLocation(){
        assertEquals(diaryDao.getEntries("20/10/1111").get(0).getImageLocation(), diary.getImageLocation());
    }
    @Test
    public void getSleepDuration(){
        assertEquals(diaryDao.getEntries("20/10/1111").get(0).getSleepDuration(), diary.getSleepDuration());
    }
    @Test
    public void getEntryActivities(){
        assertEquals(diaryDao.getEntries("20/10/1111").get(0).getEntryActivities(), diary.getEntryActivities());
    }



}