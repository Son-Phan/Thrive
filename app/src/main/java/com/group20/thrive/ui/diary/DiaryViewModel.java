package com.group20.thrive.ui.diary;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.group20.thrive.database.Diary;
import com.group20.thrive.database.DiaryRepository;

import java.util.List;

public class DiaryViewModel extends AndroidViewModel {

    private MutableLiveData<String> mText;
    private DiaryRepository mRepository;
    public DiaryViewModel(@NonNull Application application) {
        super(application);
        mRepository = new DiaryRepository(application);
    }
    public LiveData<List<Diary>> getAllEntries(String entryDate) {
        System.out.println(entryDate);
        return mRepository.getAllEntries(entryDate);
    }
    List<Diary> getEntries(String entryDate) { return mRepository.getEntries(entryDate); }
    public LiveData<String> getText() {
        return mText;
    }
}