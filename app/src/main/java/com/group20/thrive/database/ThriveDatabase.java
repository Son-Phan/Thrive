package com.group20.thrive.database;

import android.content.Context;

import androidx.annotation.NonNull;
import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;
import androidx.room.migration.Migration;
import androidx.sqlite.db.SupportSQLiteDatabase;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

@Database(entities = {Plan.class, Lesson.class, Activity.class, Diary.class, User.class, ActivityRecord.class, LessonActivityCrossRef.class}, version = 1)
public abstract class ThriveDatabase extends RoomDatabase {

    public static final String THRIVE_DATABASE_NAME = "thrive_database";
    public abstract UserDao userDao();
    public abstract ActivityRecordDao activityRecordDao();
    public abstract PlanDao planDao();
    public abstract LessonDao lessonDao();
    public abstract ActivityDao activityDao();
    public abstract DiaryDao diaryDao();

    private static volatile ThriveDatabase INSTANCE;
    private static final int NUMBER_OF_THREADS = 4;
    static final ExecutorService databaseWriteExecutor =
            Executors.newFixedThreadPool(NUMBER_OF_THREADS);

    static ThriveDatabase getDatabase(final Context context) {
        if (INSTANCE == null) {
            synchronized (ThriveDatabase.class) {
                if (INSTANCE == null) {
                    INSTANCE = Room.databaseBuilder(context.getApplicationContext(),
                            ThriveDatabase.class, THRIVE_DATABASE_NAME)
                            .createFromAsset("database/thrive_database.db")
                            .build();
                }
            }
        }
        return INSTANCE;
    }
}
