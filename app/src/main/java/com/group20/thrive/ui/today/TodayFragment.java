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
    private List<Activity> myActivities;
    private String timeOfDay;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        todayViewModel =
                new ViewModelProvider(this).get(TodayViewModel.class);

        binding = FragmentTodayBinding.inflate(inflater, container, false);

        return binding.getRoot();
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
                myActivities = new ArrayList<>(newActivities);
                todayActivities(view, newActivities);
            });
        });

        activity1.setOnClickListener(view1 -> onActivityClick(myActivities.get(0)));
        activity2.setOnClickListener(view1 -> onActivityClick(myActivities.get(1)));
        activity3.setOnClickListener(view1 -> onActivityClick(myActivities.get(2)));
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

        List<TextView> noActivities = Arrays.asList(
                view.findViewById(R.id.noActivity1),
                view.findViewById(R.id.noActivity2),
                view.findViewById(R.id.noActivity3));

        for (int i = 0; i < activities.size(); i++) {
            int finalI = i;
            todayViewModel.getActivityTimeOfDay(activities.get(i).getActivityId()).observe(getActivity(), newData -> {
                timeOfDay = newData;

                int j;
                if (timeOfDay.equals("morning")) { j = 0;}
                else if (timeOfDay.equals("afternoon")) { j = 1;}
                else { j = 2; } // evening

                if (activities.get(finalI).activityType.equals("meditation")) {
                    activityImages.get(j).setImageResource(R.drawable.meditation_icon);
                } else {
                    activityImages.get(j).setImageResource(R.drawable.running_icon);
                }
                activityNames.get(j).setText(activities.get(finalI).activityName);
                String lenText = activities.get(finalI).getActivityLen() + " min";
                activityTimes.get(j).setText(lenText);

                activityImages.get(j).setVisibility(View.VISIBLE);
                activityNames.get(j).setVisibility(View.VISIBLE);
                activityTimes.get(j).setVisibility(View.VISIBLE);
                noActivities.get(j).setVisibility(View.INVISIBLE);
                myActivities.set(j, activities.get(finalI));
            });
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