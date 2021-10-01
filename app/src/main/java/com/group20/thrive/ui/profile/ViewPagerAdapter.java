package com.group20.thrive.ui.profile;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.viewpager2.adapter.FragmentStateAdapter;

public class ViewPagerAdapter extends FragmentStateAdapter {

    private final Fragment[] mFragments = new Fragment[] {
            new SummaryExerciseFragment(),
            new SummaryMeditationFragment(),
            new SummarySleepFragment(),
            new SummaryMoodFragment()
    };

    public final String[] mFragmentNames = new String[] {
            "Exercise",
            "Meditate",
            "Sleep",
            "Mood"
    };

    public ViewPagerAdapter(FragmentActivity fa){
        super(fa);
    }

    @Override
    public int getItemCount() {
        return mFragments.length;
    }

    @Override
    public long getItemId(int position) {
        return super.getItemId(position);
    }

    @NonNull
    @Override
    public Fragment createFragment(int position) {
        return mFragments[position];
    }
}