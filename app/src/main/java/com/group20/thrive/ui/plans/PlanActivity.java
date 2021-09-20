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
import android.widget.Toast;

import com.group20.thrive.ActivityInfoActivity;
import com.group20.thrive.R;
import com.group20.thrive.database.Activity;
import com.group20.thrive.database.Lesson;
import com.group20.thrive.database.Plan;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class PlanActivity extends AppCompatActivity{

    RecyclerView recyclerView;
    LessonsAdapter lessonsAdapter = new LessonsAdapter(this);
    private PlansViewModel plansViewModel;
    private List<Activity> activities;

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

        CardView activity1 = findViewById(R.id.activity1);
        CardView activity2 = findViewById(R.id.activity2);
        CardView activity3 = findViewById(R.id.activity3);
        activity1.setVisibility(View.VISIBLE);
        activity2.setVisibility(View.VISIBLE);
        activity3.setVisibility(View.VISIBLE);

        plansViewModel.getActivitiesOfCurrentLesson(lessonId).observe(this, newData -> {
            lessonActivities(newData);
            activities = new ArrayList<>(newData);
        });

        activity1.setOnClickListener(view1 -> onActivityClick(activities.get(0)));
        activity2.setOnClickListener(view1 -> onActivityClick(activities.get(1)));
        activity3.setOnClickListener(view1 -> onActivityClick(activities.get(2)));
    }

    public void lessonActivities(List<Activity> activities) {

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
        Intent intent = new Intent(this, ActivityInfoActivity.class);
        intent.putExtra("activity", activity);
        startActivity(intent);
    }
}