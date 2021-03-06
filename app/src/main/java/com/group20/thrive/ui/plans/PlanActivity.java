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
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.PopupWindow;
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
    private PopupWindow accessReassignActivity;
    private int lessonID;

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
        lessonID = lessonId;

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

        activityCardViews.get(0).setOnClickListener(view -> accessReassignActivity(view, morningActivity, "morning"));
        activityCardViews.get(1).setOnClickListener(view -> accessReassignActivity(view, afternoonActivity, "afternoon"));
        activityCardViews.get(2).setOnClickListener(view -> accessReassignActivity(view, eveningActivity, "evening"));

        assignButtons.get(0).setOnClickListener((view -> onAssignBtnClick(lessonId, "morning", false)));
        assignButtons.get(1).setOnClickListener((view -> onAssignBtnClick(lessonId, "afternoon", false)));
        assignButtons.get(2).setOnClickListener((view -> onAssignBtnClick(lessonId, "evening", false)));
    }

    // set up activity card views
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
                    if (activities.get(finalI).activityType.equals("userActivity")) {
                        activityImages.get(j).setImageResource(R.drawable.thinking);
                    } else if (activities.get(finalI).activityType.equals("meditation")) {
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

    public void accessReassignActivity(View view, Activity activity, String timeOfDay) {
        // inflate the layout of the popup window
        LayoutInflater inflater = (LayoutInflater)
                getSystemService(LAYOUT_INFLATER_SERVICE);
        View popupView = inflater.inflate(R.layout.popup_window_activity_access_reassign, null);

        // create the popup window
        int width = LinearLayout.LayoutParams.WRAP_CONTENT;
        int height = LinearLayout.LayoutParams.WRAP_CONTENT;
        boolean focusable = true; // lets taps outside the popup also dismiss it
        accessReassignActivity = new PopupWindow(popupView, width, height, true);

        // show the popup window
        // which view you pass in doesn't matter, it is only used for the window token
        accessReassignActivity.showAtLocation(view, Gravity.CENTER, 0, 0);

        Button accessActivityBtn = popupView.findViewById(R.id.accessActivityBtn);
        Button reassignActivityBtn = popupView.findViewById(R.id.reassignActivityBtn);

        accessActivityBtn.setOnClickListener(v -> {
            onAccessActivityClick(activity);
            accessReassignActivity.dismiss();
        });
        reassignActivityBtn.setOnClickListener(v -> {
            onAssignBtnClick(lessonID, timeOfDay, true);
            accessReassignActivity.dismiss();
        });
    }

    public void onAccessActivityClick(Activity activity) {
        Intent intent = new Intent(this, ActivityInfoActivity.class);
        intent.putExtra("activity", activity);
        startActivity(intent);
    }

    public void onAssignBtnClick(int lessonId, String timeOfDay, boolean reassign) {
        Intent intent = new Intent(this, AssignActivityActivity.class);
        intent.putExtra("lessonId", lessonId);
        intent.putExtra("timeOfDay", timeOfDay);
        intent.putExtra("reassign", reassign);
        startActivity(intent);
    }
}