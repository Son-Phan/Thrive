package com.group20.thrive.ui.today;

public class ExerciseToday {
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitleName() {
        return titleName;
    }

    public void setTitleName(String titleName) {
        this.titleName = titleName;
    }

    public String getDuration() {
        return duration;
    }

    public void setDuration(String duration) {
        this.duration = duration;
    }

    public ExerciseToday(int id, String titleName, String duration) {
        this.id = id;
        this.titleName = titleName;
        this.duration = duration;
    }

    private int id;
    private String titleName;
    private String duration;

}
