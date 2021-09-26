package com.group20.thrive.ui.profile;

public class MoodCount {

    String mood;
    int moodCount;

    public MoodCount(String mood, int moodCount) {
        this.mood = mood;
        this.moodCount = moodCount;
    }

    public String getMood() {
        return mood;
    }

    public int getMoodCount() {
        return moodCount;
    }
}
