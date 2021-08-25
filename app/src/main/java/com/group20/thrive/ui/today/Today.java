package com.group20.thrive.ui.today;

import java.util.List;

public class Today {

    public Today(int id, String percentages, String titleName, List<ExerciseToday> exerciseTodayList) {
        this.id = id;
        this.percentages = percentages;
        this.titleName = titleName;
        this.exerciseTodayList = exerciseTodayList;
    }

    private int id;
    private String percentages;
    private String titleName;
    private List<ExerciseToday> exerciseTodayList;
    public String getTitleName() {
        return titleName;
    }

    public void setTitleName(String titleName) {
        this.titleName = titleName;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getPercentages() {
        return percentages;
    }

    public void setPercentages(String percentages) {
        this.percentages = percentages;
    }


    public List<ExerciseToday> getExerciseTodayList() {
        return exerciseTodayList;
    }

    public void setExerciseTodayList(List<ExerciseToday> exerciseTodayList) {
        this.exerciseTodayList = exerciseTodayList;
    }
}
