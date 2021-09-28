package com.group20.thrive.ui.profile;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.room.Room;
import androidx.viewpager2.widget.ViewPager2;

import com.group20.thrive.R;
import com.group20.thrive.SettingsActivity;
import com.group20.thrive.database.ThriveDatabase;
import com.group20.thrive.database.User;
import com.group20.thrive.databinding.FragmentProfileBinding;
import com.google.android.material.tabs.TabLayout;
import com.google.android.material.tabs.TabLayoutMediator;

import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.util.concurrent.Executors;

public class ProfileFragment extends Fragment {

    private com.group20.thrive.ui.profile.ProfileViewModel ProfileViewModel;
    private FragmentProfileBinding binding;
    private ViewPager2 mViewPager;

    private final String exercise = "exercise";
    private final String meditation = "meditation";
    private final String sleep = "sleep";

    private String today;

    private static final String PREF_NAME = "MyPrefs";

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        ProfileViewModel =
                new ViewModelProvider(this).get(com.group20.thrive.ui.profile.ProfileViewModel.class);

        binding = FragmentProfileBinding.inflate(inflater, container, false);
        View root = binding.getRoot();

        return root;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        TabLayout tabLayout = view.findViewById(R.id.tabLayout);

        mViewPager = view.findViewById(R.id.viewPager);
        mViewPager.setAdapter(new com.group20.thrive.ui.profile.ViewPagerAdapter(getActivity()));

        new TabLayoutMediator(tabLayout, mViewPager,
                (tab, position) -> tab.setText(((com.group20.thrive.ui.profile.ViewPagerAdapter) (mViewPager.getAdapter())).mFragmentNames[position])
        ).attach();

        ImageButton btn = view.findViewById(R.id.imageButton);

        btn.setOnClickListener(view1 -> {
            Intent intent = new Intent (getActivity(), SettingsActivity.class);
            startActivity(intent);
        });
    }

    @Override
    public void onStart() {
        super.onStart();

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        today = ZonedDateTime.now(ZoneId.systemDefault()).format(formatter);

        ProfileViewModel.getTimeSpentOfActivityTypeInADay(today, exercise).observe(this, newData -> {
            if (newData.getNumOfRecords() > 0)
                updateStreak(newData.getTotalTimeSpent(), exercise);
        });
        ProfileViewModel.getTimeSpentOfActivityTypeInADay(today, meditation).observe(this, newData -> {
            if (newData.getNumOfRecords() > 0)
                updateStreak(newData.getTotalTimeSpent(), meditation);
        });
        ProfileViewModel.getTimeSpentOfActivityTypeInADay(today, sleep).observe(this, newData -> {
            if (newData.getNumOfRecords() > 0)
                updateStreak(newData.getTotalTimeSpent(), sleep);
        });
    }

    public void updateStreak(int timeSpent, String activityType) {
        SharedPreferences sharedPrefs = getActivity().getSharedPreferences(PREF_NAME, Context.MODE_PRIVATE);
        Executors.newSingleThreadExecutor().execute(() -> {
            ThriveDatabase db = Room.databaseBuilder(getActivity().getApplicationContext(), ThriveDatabase.class,
                    ThriveDatabase.THRIVE_DATABASE_NAME).build();
            User user = db.userDao().getCurrUser();
            SharedPreferences.Editor editor = sharedPrefs.edit();
            int goal = 60;
            int lastDay = Integer.parseInt(today.substring(0,2)) -1;
            String yesterday = lastDay + today.substring(2);
            String streakKey = activityType + "Streak";
            String dateKey = activityType + "Date";
            int streakCount = sharedPrefs.getInt(streakKey, 0);
            String date = sharedPrefs.getString(dateKey, "00/00/0000");

            if (activityType.equals(exercise)) { goal *= user.getExerciseGoal(); }
            else if (activityType.equals(meditation)) { goal *= user.getMeditationGoal(); }
            else { goal *= user.getSleepGoal(); }

            if (timeSpent >= goal) {
                if (date.equals(yesterday)) { streakCount += 1; }
                else { streakCount = 1; }
                editor.putInt(streakKey, streakCount);
                editor.putString(dateKey, today);
            }
            editor.apply();
            db.close();
        });
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}