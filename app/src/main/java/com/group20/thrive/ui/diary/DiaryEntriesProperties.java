package com.group20.thrive.ui.diary;

public class DiaryEntriesProperties {
    public DiaryEntriesProperties(String day, String time, String activity) {
        this.day = day;
        this.time = time;
        this.activity = activity;
    }

    private String day;
    private String time;

    public String getDay() {
        return day;
    }

    public void setDay(String day) {
        this.day = day;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getActivity() {
        return activity;
    }

    public void setActivity(String activity) {
        this.activity = activity;
    }

    private String activity;

}
