package com.group20.thrive.ui.profile;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.group20.thrive.database.ActivityRecord;
import com.group20.thrive.database.ActivityRepository;
import com.group20.thrive.database.DiaryRepository;
import com.group20.thrive.database.User;
import com.group20.thrive.database.UserRepository;

import java.util.List;

public class ProfileViewModel extends AndroidViewModel {

    private UserRepository userRepository;
    private DiaryRepository diaryRepository;

    public ProfileViewModel(@NonNull Application application) {
        super(application);
        userRepository = new UserRepository(application);
        diaryRepository = new DiaryRepository(application);
    }

    public LiveData<User> getUser() { return userRepository.getUser(); }

    public LiveData<List<Record>> getRecordsOfActivityTypeInAWeek(String activityType) { return userRepository.getRecordsOfActivityTypeInAWeek(activityType); }

    public LiveData<List<Record>> getRecordsOfActivityType(String activityType) { return userRepository.getRecordsOfActivityType(activityType); }

    public LiveData<Integer> getTotalMoodCount() { return diaryRepository.getTotalMoodCount(); }

    public LiveData<List<MoodCount>> getMoodCount() { return diaryRepository.getMoodCount(); }

    public LiveData<TodayRecord> getTimeSpentOfActivityTypeInADay(String recordTime, String activityType) { return userRepository.getTimeSpentOfActivityTypeInADay(recordTime, activityType); }
}