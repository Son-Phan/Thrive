package com.group20.thrive.ui.plans;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import com.group20.thrive.database.Plan;
import com.group20.thrive.database.PlanRepository;

import java.util.List;

public class PlansViewModel extends AndroidViewModel {
    private PlanRepository mPlanRepository;
    private MutableLiveData<String> mText;
    private LiveData<List<Plan>> mAllPlans;
    public PlansViewModel(@NonNull Application application) {
//        mText = new MutableLiveData<>();
//        mText.setValue("This is notifications fragment");
        super(application);
        mPlanRepository = new PlanRepository(application);
        mAllPlans = mPlanRepository.getAllPlans();
    }
    public LiveData<List<Plan>> getAllPlans() {
        return mAllPlans;
    }

    public List<Plan> getPlan() {
        return mPlanRepository.getPlan();
    }
    public LiveData<String> getText() {
        return mText;
    }
}