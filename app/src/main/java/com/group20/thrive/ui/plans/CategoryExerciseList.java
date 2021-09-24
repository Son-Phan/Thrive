package com.group20.thrive.ui.plans;

import com.group20.thrive.database.Activity;
import com.group20.thrive.database.Lesson;

import java.util.ArrayList;
import java.util.List;

public class CategoryExerciseList {

    private List<Activity> activities;

    public CategoryExerciseList(List<Activity> activities, String exerciseCategory) {
        this.activities = activities;
        this.exerciseCategory = exerciseCategory;
    }

    public List<Activity> getActivities() {
        return activities;
    }

    private String exerciseCategory;



    public String getExerciseCategory() {
        return exerciseCategory;
    }
}
