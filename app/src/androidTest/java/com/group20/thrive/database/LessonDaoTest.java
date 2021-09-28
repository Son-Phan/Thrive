package com.group20.thrive.database;

import static org.junit.Assert.*;

import android.content.Context;

import androidx.room.Room;
import androidx.test.core.app.ApplicationProvider;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class LessonDaoTest {
    private ThriveDatabase thriveDatabase;
    private LessonDao lessonDao;
    private Lesson lesson;

    @Before
    public void setUp() throws Exception {
        Context context = ApplicationProvider.getApplicationContext();
        thriveDatabase = Room.inMemoryDatabaseBuilder(context, ThriveDatabase.class).build();
        lessonDao = thriveDatabase.lessonDao();
        lesson = new Lesson(10,19,"Work hard");
        lessonDao.insertAll(lesson);
    }

    @After
    public void tearDown() throws Exception {
        thriveDatabase.close();
    }

    @Test
    public void getLessonDesc(){
        assertEquals(lessonDao.getLesson(1).getLessonDesc(), lesson.getLessonDesc());
    }
    @Test
    public void getLessonDay(){
        assertEquals(lessonDao.getLesson(1).getLessonDay(), lesson.getLessonDay());
    }@Test
    public void getPlanId(){
        assertEquals(lessonDao.getLesson(1).getPlanId(), lesson.getPlanId());
    }

}