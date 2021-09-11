package com.group20.thrive.ui.today;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.group20.thrive.database.Diary;
import com.group20.thrive.database.DiaryRepository;

import java.util.List;

public class TodayViewModel extends AndroidViewModel {

    private MutableLiveData<String> mText;
    private DiaryRepository mRepository;
    public TodayViewModel(@NonNull Application application) {
        super(application);
        mRepository = new DiaryRepository(application);
    }

    public LiveData<String> getText() {
        return mText;
    }
    public LiveData<List<Diary>> getAllEntries(String entryDate) {
        System.out.println(entryDate);
        return mRepository.getAllEntries(entryDate);
    }
    List<Diary> getEntries(String entryDate) { return mRepository.getEntries(entryDate); }
}