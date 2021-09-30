package com.group20.thrive.ui.today;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.group20.thrive.database.Activity;
import com.group20.thrive.database.ActivityRecordDao;
import com.group20.thrive.database.ActivityRepository;
import com.group20.thrive.database.Diary;
import com.group20.thrive.database.DiaryRepository;
import com.group20.thrive.database.LessonRepository;
import com.group20.thrive.database.User;
import com.group20.thrive.database.UserRepository;

import java.util.List;

public class TodayViewModel extends AndroidViewModel {

    private UserRepository userRepository;
    private LessonRepository lessonRepository;

    public TodayViewModel(@NonNull Application application) {
        super(application);
        userRepository = new UserRepository(application);
        lessonRepository = new LessonRepository(application);
    }

    public LiveData<User> getUser() { return userRepository.getUser(); }

    public LiveData<List<Activity>> getActivitiesOfCurrentLesson(int lessonId) {
        return lessonRepository.getActivitiesOfLesson(lessonId);
    }

    public LiveData<List<String>> getActivityTimeOfDay(int lessonId, int activityId) { return lessonRepository.getActivityTimeOfDay(lessonId, activityId); }
}