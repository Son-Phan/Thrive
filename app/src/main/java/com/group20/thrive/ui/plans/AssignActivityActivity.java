package com.group20.thrive.ui.plans;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.room.Room;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.group20.thrive.R;
import com.group20.thrive.database.Activity;
import com.group20.thrive.database.LessonActivityCrossRef;
import com.group20.thrive.database.LessonDao;
import com.group20.thrive.database.ThriveDatabase;

import java.util.concurrent.Executors;

public class AssignActivityActivity extends AppCompatActivity {

    private int lessonId;
    private String timeOfDay;
    private boolean reassign;
    private RecyclerView recyclerView;
    private ActivitiesAdapter activitiesAdapter = new ActivitiesAdapter(this);
    private PlansViewModel plansViewModel;
    private Activity chosenActivity = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_assign_activity);

        setTitle("Assign Activity");

        Intent intent = getIntent();
        lessonId = intent.getIntExtra("lessonId", 0);
        timeOfDay = intent.getStringExtra("timeOfDay");
        reassign = intent.getBooleanExtra("reassign", false);

        TextView instruction = findViewById(R.id.instruction);
        String text = "Select the activity you want to do in the " + timeOfDay;
        instruction.setText(text);

        recyclerView = findViewById(R.id.recyclerViewActivities);
        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);

        DividerItemDecoration itemDecorator = new DividerItemDecoration(this, DividerItemDecoration.VERTICAL);
        itemDecorator.setDrawable(ContextCompat.getDrawable(this, R.drawable.divider_horizontal));
        recyclerView.addItemDecoration(itemDecorator);

        plansViewModel = new ViewModelProvider(this).get(PlansViewModel.class);
        plansViewModel.getAllActivities().observe(this,  newData -> {
            activitiesAdapter.setActivities(newData);
            activitiesAdapter.notifyDataSetChanged();
        });

        recyclerView.setAdapter(activitiesAdapter);

        Button assignBtn = findViewById(R.id.assignBtn);
        assignBtn.setOnClickListener(view -> onAssignBtnClick());
        Button createBtn = findViewById(R.id.createBtn);
        createBtn.setOnClickListener(view -> onCreateBtnClick());
    }

    public void onItemClick(Activity activity){
        Toast.makeText(this, "You have chosen " + activity.getActivityName(), Toast.LENGTH_SHORT).show();
        chosenActivity = activity;
    }

    public void onAssignBtnClick() {
        if (chosenActivity == null) {
            Toast.makeText(this, "Please choose an activity", Toast.LENGTH_SHORT).show();
        } else {
            Executors.newSingleThreadExecutor().execute(() -> {
                ThriveDatabase db = Room.databaseBuilder(getApplicationContext(), ThriveDatabase.class,
                        ThriveDatabase.THRIVE_DATABASE_NAME).build();
                LessonDao lessonDao = db.lessonDao();
                if (reassign) {
                    lessonDao.updateAssignActivity(chosenActivity.getActivityId(), lessonId, timeOfDay);
                } else {
                lessonDao.insertLessonActivity(new LessonActivityCrossRef(lessonId, chosenActivity.getActivityId(), timeOfDay));
                }
                db.close();
            });
            onBackPressed();
        }
    }

    public void onCreateBtnClick() {
        Intent intent = new Intent(this, createActivityActivity.class);
        intent.putExtra("lessonId", lessonId);
        intent.putExtra("timeOfDay", timeOfDay);
        startActivity(intent);
    }
}