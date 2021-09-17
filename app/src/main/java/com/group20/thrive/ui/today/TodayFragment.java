package com.group20.thrive.ui.today;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.cardview.widget.CardView;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import com.group20.thrive.ActivityInfoActivity;
import com.group20.thrive.R;
import com.group20.thrive.database.Activity;
import com.group20.thrive.databinding.FragmentTodayBinding;

import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


public class TodayFragment extends Fragment {

    private TodayViewModel todayViewModel;
    private FragmentTodayBinding binding;
    private int lessonId;
    private List<Activity> activities;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        todayViewModel =
                new ViewModelProvider(this).get(TodayViewModel.class);

        binding = FragmentTodayBinding.inflate(inflater, container, false);
        View root = binding.getRoot();

        return root;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        todayGreetings(view);

        CardView activity1 = view.findViewById(R.id.activity1);
        CardView activity2 = view.findViewById(R.id.activity2);
        CardView activity3 = view.findViewById(R.id.activity3);

        todayViewModel.getUser().observe(getActivity(), newData -> {
            lessonId = newData.getCurrentLesson();
            todayViewModel.getActivitiesOfCurrentLesson(lessonId).observe(getActivity(), newActivities -> {
                todayActivities(view, newActivities);
                activities = new ArrayList<>(newActivities);
            });
        });

        activity1.setOnClickListener(view1 -> onActivityClick(activities.get(0)));
        activity2.setOnClickListener(view1 -> onActivityClick(activities.get(1)));
        activity3.setOnClickListener(view1 -> onActivityClick(activities.get(2)));
    }

    public void todayGreetings(View view) {

        TextView greetings = view.findViewById(R.id.greetings);

        int currentTime = ZonedDateTime.now(ZoneId.systemDefault()).getHour();

        String text;

        if (currentTime > 6 && currentTime < 12) { text = "Good Morning!"; }
        else if (currentTime > 12 && currentTime < 18) { text = "Good Afternoon!"; }
        else { text = "Good Evening!"; }

        greetings.setText(text);
    }

    public void todayActivities(View view, List<Activity> activities) {

        List<ImageView> activityImages = Arrays.asList(
                view.findViewById(R.id.activity1Image),
                view.findViewById(R.id.activity2Image),
                view.findViewById(R.id.activity3Image));

        List<TextView> activityNames = Arrays.asList(
                view.findViewById(R.id.activity1Name),
                view.findViewById(R.id.activity2Name),
                view.findViewById(R.id.activity3Name));

        List<TextView> activityTimes = Arrays.asList(
                view.findViewById(R.id.activity1Time),
                view.findViewById(R.id.activity2Time),
                view.findViewById(R.id.activity3Time));

        for (int i = 0; i < activities.size(); i++) {
            if (activities.get(i).activityType.equals("meditation")) {
                activityImages.get(i).setImageResource(R.drawable.meditation_icon);
            } else {
                activityImages.get(i).setImageResource(R.drawable.running_icon);
            }
            activityNames.get(i).setText(activities.get(i).activityName);
            activityTimes.get(i).setText(String.valueOf(activities.get(i).activityLen));
        }
    }

    public void onActivityClick(Activity activity) {
        Intent intent = new Intent(getActivity(), ActivityInfoActivity.class);
        intent.putExtra("activity", activity);
        startActivity(intent);
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}