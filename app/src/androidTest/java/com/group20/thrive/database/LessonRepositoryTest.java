package com.group20.thrive.database;

import static org.junit.Assert.*;

import android.content.Context;

import androidx.room.Room;
import androidx.test.core.app.ApplicationProvider;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class LessonRepositoryTest {
    private ThriveDatabase thriveDatabase;
    private LessonRepository lessonRepository;
    private LessonDao lessonDao;
    private Lesson lesson;

    @Before
    public void setUp() throws Exception {
        Context context = ApplicationProvider.getApplicationContext();
        thriveDatabase = Room.databaseBuilder(context, ThriveDatabase.class,
                ThriveDatabase.THRIVE_DATABASE_NAME).build();
        lessonDao = thriveDatabase.lessonDao();
        lesson = new Lesson(10, 10, "nothing");
        lessonDao.insertAll(lesson);
        lessonRepository = new LessonRepository(ApplicationProvider.getApplicationContext());
    }

    @After
    @Test
    public void deleteLesson() throws Exception {
        lessonRepository.deleteLesson(10);
        thriveDatabase.close();
    }
    @Test
    public void planId(){
        assertEquals(lessonRepository.getLessonOfPlan_list(10).get(0).getPlanId(), lessonDao.getLessonsOfPlan_list(10).get(0).getPlanId());
    }
    @Test
    public void getLessonDesc(){
        assertEquals(lessonRepository.getLessonOfPlan_list(10).get(0).getLessonDesc(), lessonDao.getLessonsOfPlan_list(10).get(0).getLessonDesc());
    }
    @Test
    public void getLessonDay(){
        assertEquals(lessonRepository.getLessonOfPlan_list(10).get(0).getLessonDay(), lessonDao.getLessonsOfPlan_list(10).get(0).getLessonDay());
    }
    @Test
    public void getLessonId(){
        assertEquals(lessonRepository.getLessonOfPlan_list(10).get(0).getLessonId(), lessonDao.getLessonsOfPlan_list(10).get(0).getLessonId());
    }
    @Test
    public void getLesson() {
        assertNotNull(lessonRepository.getLesson(10));
    }

    @Test
    public void getLessonsOfPlan() {
        assertNotNull(lessonRepository.getLessonsOfPlan(10));
    }

    @Test
    public void getLessonsWithActivities() {
        assertNotNull(lessonRepository.getLessonsWithActivities());
    }

    @Test
    public void getActivitiesOfLesson() {
        assertNotNull(lessonRepository.getActivitiesOfLesson(15));
    }

    @Test
    public void getActivityTimeOfDay() {
        assertNotNull(lessonRepository.getActivityTimeOfDay(4));
    }

    @Test
    public void getLessonOfPlan_list(){
        assertNotNull(lessonRepository.getLessonOfPlan_list(10));
    }
}