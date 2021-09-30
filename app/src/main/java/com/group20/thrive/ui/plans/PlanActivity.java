package com.group20.thrive.ui.plans;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;
import androidx.core.content.ContextCompat;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.group20.thrive.ActivityInfoActivity;
import com.group20.thrive.R;
import com.group20.thrive.database.Activity;
import com.group20.thrive.database.Plan;

import java.util.Arrays;
import java.util.List;

public class PlanActivity extends AppCompatActivity{

    RecyclerView recyclerView;
    LessonsAdapter lessonsAdapter = new LessonsAdapter(this);
    private PlansViewModel plansViewModel;
    private Activity morningActivity;
    private Activity afternoonActivity;
    private Activity eveningActivity;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_plan);
        ActionBar actionBar = getSupportActionBar();
        assert actionBar != null;
        actionBar.setDisplayHomeAsUpEnabled(true);

        Intent intent = getIntent();
        Plan plan = (Plan) intent.getSerializableExtra("plan");

        TextView planName = findViewById(R.id.planName);
        TextView planLen = findViewById(R.id.planLen);
        TextView planDesc = findViewById(R.id.planDesc);

        planName.setText(plan.getPlanName());
        planLen.setText(String.valueOf(plan.getPlanLength()));
        planDesc.setText(plan.getPlanDescription());

        recyclerView = findViewById(R.id.recyclerViewLessons);

        LinearLayoutManager layoutManager
                = new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false);
        recyclerView.setLayoutManager(layoutManager);

        DividerItemDecoration itemDecorator = new DividerItemDecoration(this, DividerItemDecoration.HORIZONTAL);
        itemDecorator.setDrawable(ContextCompat.getDrawable(this, R.drawable.divider));
        recyclerView.addItemDecoration(itemDecorator);

        plansViewModel = new ViewModelProvider(this).get(PlansViewModel.class);
        plansViewModel.getLessonsOfPlan(plan.getPlanId()).observe(this, newData -> {
            lessonsAdapter.setLessons(newData);
            lessonsAdapter.notifyDataSetChanged();
        });

        recyclerView.setAdapter(lessonsAdapter);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        if (item.getItemId() == android.R.id.home) {
            onBackPressed();
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    public void updateActivityView(int lessonId) {

        List<CardView> activityCardViews = Arrays.asList(
                findViewById(R.id.activity1),
                findViewById(R.id.activity2),
                findViewById(R.id.activity3));

        List<Button> assignButtons = Arrays.asList(
                findViewById(R.id.assignBtn1),
                findViewById(R.id.assignBtn2),
                findViewById(R.id.assignBtn3));

        assignButtons.get(0).setVisibility(View.VISIBLE);
        assignButtons.get(1).setVisibility(View.VISIBLE);
        assignButtons.get(2).setVisibility(View.VISIBLE);

        plansViewModel.getActivitiesOfCurrentLesson(lessonId).observe(this, newData -> lessonActivities(lessonId, newData, activityCardViews));

        activityCardViews.get(0).setOnClickListener(view -> onActivityClick(morningActivity));
        activityCardViews.get(1).setOnClickListener(view -> onActivityClick(afternoonActivity));
        activityCardViews.get(2).setOnClickListener(view -> onActivityClick(eveningActivity));

        assignButtons.get(0).setOnClickListener((view -> onAssignBtnClick(lessonId, "morning")));
        assignButtons.get(1).setOnClickListener((view -> onAssignBtnClick(lessonId, "afternoon")));
        assignButtons.get(2).setOnClickListener((view -> onAssignBtnClick(lessonId, "evening")));
    }

    public void lessonActivities(int lessonId, List<Activity> activities, List<CardView> activityCardViews) {
        morningActivity = null;
        afternoonActivity = null;
        eveningActivity = null;

        List<ImageView> activityImages = Arrays.asList(
                findViewById(R.id.activity1Image),
                findViewById(R.id.activity2Image),
                findViewById(R.id.activity3Image));

        List<TextView> activityNames = Arrays.asList(
                findViewById(R.id.activity1Name),
                findViewById(R.id.activity2Name),
                findViewById(R.id.activity3Name));

        List<TextView> activityTimes = Arrays.asList(
                findViewById(R.id.activity1Time),
                findViewById(R.id.activity2Time),
                findViewById(R.id.activity3Time));

        for (int i = 0; i < activities.size(); i++) {
            int finalI = i;
            plansViewModel.getActivityTimeOfDay(lessonId, activities.get(i).getActivityId()).observe(this, newData -> {
                for (int k = 0; k < newData.size(); k++) {
                    int j;
                    if (newData.get(k).equals("morning")) {
                        j = 0;
                        morningActivity = activities.get(finalI);
                    }
                    else if (newData.get(k).equals("afternoon")) {
                        j = 1;
                        afternoonActivity = activities.get(finalI);
                    }
                    else { //evening
                        j = 2;
                        eveningActivity = activities.get(finalI);
                    }

                    if (activities.get(finalI).activityType.equals("meditation")) {
                        activityImages.get(j).setImageResource(R.drawable.meditation_icon);
                    } else {
                        activityImages.get(j).setImageResource(R.drawable.running_icon);
                    }
                    activityNames.get(j).setText(activities.get(finalI).activityName);
                    String lenText = activities.get(finalI).getActivityLen() + " min" + "   (" + newData.get(k) + ")";
                    activityTimes.get(j).setText(lenText);

                    activityCardViews.get(j).setVisibility(View.VISIBLE);
                    activityImages.get(j).setVisibility(View.VISIBLE);
                    activityNames.get(j).setVisibility(View.VISIBLE);
                    activityTimes.get(j).setVisibility(View.VISIBLE);
                }
            });
        }

        if (morningActivity == null) {
            activityCardViews.get(0).setVisibility(View.INVISIBLE);
        }
        if (afternoonActivity == null) {
            activityCardViews.get(1).setVisibility(View.INVISIBLE);
        }
        if (eveningActivity == null) {
            activityCardViews.get(2).setVisibility(View.INVISIBLE);
        }
    }

    public void onActivityClick(Activity activity) {
        Intent intent = new Intent(this, ActivityInfoActivity.class);
        intent.putExtra("activity", activity);
        startActivity(intent);
    }

    public void onAssignBtnClick(int lessonId, String timeOfDay) {
        Intent intent = new Intent(this, AssignActivityActivity.class);
        intent.putExtra("lessonId", lessonId);
        intent.putExtra("timeOfDay", timeOfDay);
        startActivity(intent);
    }
}