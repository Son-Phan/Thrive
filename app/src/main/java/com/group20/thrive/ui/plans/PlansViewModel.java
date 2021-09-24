package com.group20.thrive.ui.plans;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

import com.group20.thrive.database.Activity;
import com.group20.thrive.database.Lesson;
import com.group20.thrive.database.LessonRepository;
import com.group20.thrive.database.Plan;
import com.group20.thrive.database.PlanRepository;

import java.util.List;

public class PlansViewModel extends AndroidViewModel {
    private PlanRepository planRepository;
    private LessonRepository lessonRepository;
    private LiveData<List<Plan>> mAllPlans;

    public PlansViewModel(@NonNull Application application) {
        super(application);
        planRepository = new PlanRepository(application);
        lessonRepository = new LessonRepository(application);
        lessonRepository = new LessonRepository(application);
        mAllPlans = planRepository.getAllPlans();
    }
    public LiveData<List<Plan>> getAllPlans() {
        return mAllPlans;
    }

    public List<Plan> getPlan() {
        return planRepository.getPlan();
    }

    public LiveData<Plan> getUserPlan() { return planRepository.getUserPlan(); }

    public LiveData<List<Lesson>> getLessonsOfPlan(int planId) { return lessonRepository.getLessonsOfPlan(planId); }

    public LiveData<List<Activity>> getActivitiesOfCurrentLesson(int lessonId) {
        return lessonRepository.getActivitiesOfLesson(lessonId);
    }

    public LiveData<String> getActivityTimeOfDay(int activityId) { return lessonRepository.getActivityTimeOfDay(activityId); }
}