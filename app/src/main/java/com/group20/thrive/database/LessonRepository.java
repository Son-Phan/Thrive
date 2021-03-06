package com.group20.thrive.database;

import android.app.Application;

import androidx.lifecycle.LiveData;

import java.util.List;

public class LessonRepository {

    private LessonDao mLessonDao;

    public LessonRepository(Application application) {
        ThriveDatabase db = ThriveDatabase.getDatabase(application);
        mLessonDao = db.lessonDao();
    }

    public Lesson getLesson(int lessonId) { return mLessonDao.getLesson(lessonId); }

    public LiveData<List<Lesson>> getLessonsOfPlan(int planId) { return mLessonDao.getLessonsOfPlan(planId); }

    public List<LessonWithActivities> getLessonsWithActivities() { return mLessonDao.getLessonsWithActivities(); }

    public LiveData<List<Activity>> getActivitiesOfLesson(int lessonId) { return mLessonDao.getActivitiesOfLesson(lessonId); }

    public LiveData<List<String>> getActivityTimeOfDay(int lessonId, int activityId) { return mLessonDao.getActivityTimeOfDay(lessonId, activityId); }

    public void deleteLesson(int planId) { mLessonDao.deleteLesson(planId);}
    public List<Lesson> getLessonOfPlan_list(int planId) { return  mLessonDao.getLessonsOfPlan_list(planId);}
}