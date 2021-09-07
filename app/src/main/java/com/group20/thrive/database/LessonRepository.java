package com.group20.thrive.database;

import android.app.Application;

import java.util.List;

public class LessonRepository {

    private LessonDao mLessonDao;

    LessonRepository(Application application) {
        ThriveDatabase db = ThriveDatabase.getDatabase(application);
        mLessonDao = db.lessonDao();
    }

    Lesson getLesson(int lessonId) { return mLessonDao.getLesson(lessonId); }

    List<LessonWithActivities> getLessonsWithActivities() { return mLessonDao.getLessonsWithActivities(); }
}