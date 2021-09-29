package com.group20.thrive.database;

import static org.junit.Assert.*;

import android.content.Context;

import androidx.room.Room;
import androidx.test.core.app.ApplicationProvider;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class DiaryRepositoryTest {
    private ThriveDatabase thriveDatabase;
    private DiaryDao diaryDao;
    private DiaryRepository diaryRepository;
    private Diary diary;
    @Before
    public void setUp() throws Exception {
        Context context = ApplicationProvider.getApplicationContext();
        thriveDatabase = Room.databaseBuilder(context, ThriveDatabase.class,
                ThriveDatabase.THRIVE_DATABASE_NAME).build();
        diaryDao = thriveDatabase.diaryDao();
        diary = new Diary("11/11/1111","11pm", "happy",2,60,"eat","nothing");
        diaryDao.addDiary(diary);
        diaryRepository = new DiaryRepository(ApplicationProvider.getApplicationContext());

    }

    @After
    public void tearDown() throws Exception {
        diaryRepository.deleteDiary("happy");
    }

    @Test
    public void getAllEntries() {
        assertNotNull(diaryRepository.getAllEntries("11/11/1111"));
    }

    @Test
    public void getEntries() {
        assertNotNull(diaryRepository.getEntries("11/11/1111"));
    }

    @Test
    public void getNumOfEntryDays() {
        assertNotNull(diaryRepository.getNumOfEntryDays());
    }

    @Test
    public void getMoodCount() {
        assertNotNull(diaryRepository.getMoodCount());
    }

    @Test
    public void getEntryDate() {
        assertEquals(diaryRepository.getEntries("11/11/1111").get(0).getEntryDate(), diaryDao.getEntries("11/11/1111").get(0).getEntryDate());
    }

    @Test
    public void getEntryMood() {
        assertEquals(diaryRepository.getEntries("11/11/1111").get(0).getEntryMood(), diaryDao.getEntries("11/11/1111").get(0).getEntryMood());
    }

    @Test
    public void getEntryNote() {
        assertEquals(diaryRepository.getEntries("11/11/1111").get(0).getEntryNote(), diaryDao.getEntries("11/11/1111").get(0).getEntryNote());
    }

    @Test
    public void getEntryActivities() {
        assertEquals(diaryRepository.getEntries("11/11/1111").get(0).getEntryActivities(), diaryDao.getEntries("11/11/1111").get(0).getEntryActivities());
    }

    @Test
    public void getEntryTime() {
        assertEquals(diaryRepository.getEntries("11/11/1111").get(0).getEntryTime(), diaryDao.getEntries("11/11/1111").get(0).getEntryTime());
    }

    @Test
    public void getSleepDuration() {
        assertEquals(diaryRepository.getEntries("11/11/1111").get(0).getSleepDuration(), diaryDao.getEntries("11/11/1111").get(0).getSleepDuration());
    }

    @Test
    public void getImageLocation() {
        assertEquals(diaryRepository.getEntries("11/11/1111").get(0).getImageLocation(), diaryDao.getEntries("11/11/1111").get(0).getImageLocation());
    }


}