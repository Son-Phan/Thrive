package com.group20.thrive.ui.plans;

import androidx.appcompat.app.AppCompatActivity;
import androidx.room.Room;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.group20.thrive.R;
import com.group20.thrive.database.Lesson;
import com.group20.thrive.database.LessonDao;
import com.group20.thrive.database.Plan;
import com.group20.thrive.database.PlanDao;
import com.group20.thrive.database.ThriveDatabase;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Executors;

public class CreatePlanActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_plan);

        setTitle("New Plan");

        Button doneBtn = findViewById(R.id.doneBtn);

        doneBtn.setOnClickListener(view -> onDoneBtnClick());
    }

    public void onDoneBtnClick() {
        EditText planNameInput = findViewById(R.id.planNameInput);
        EditText planLenInput = findViewById(R.id.planLenInput);
        EditText planDescInput = findViewById(R.id.planDescInput);

        String planName = planNameInput.getText().toString();
        String planLength = planLenInput.getText().toString();
        String planDesc = planDescInput.getText().toString();

        if (planName.isEmpty() || planLength.isEmpty()) {
            Toast.makeText(this, "Please enter your plan name and length", Toast.LENGTH_SHORT).show();
        } else {
            int planLen = Integer.parseInt(planLength);
            if (planDesc.isEmpty()) { planDesc = "No description."; }
            addNewPlan(planName, planLen, planDesc);
            onBackPressed();
        }
    }

    public void addNewPlan(String planName, int planLen, String planDesc) {
        Executors.newSingleThreadExecutor().execute(() -> {
            ThriveDatabase db = Room.databaseBuilder(getApplicationContext(), ThriveDatabase.class,
                    ThriveDatabase.THRIVE_DATABASE_NAME).build();
            PlanDao planDao = db.planDao();
            LessonDao lessonDao = db.lessonDao();
            planDao.addPlan(new Plan(planName, "EM", 0, planLen, planDesc));
            int planId = planDao.getPlanId(planName);
            List<Lesson> lessons = new ArrayList<>();
            for (int i = 1; i < planLen+1; i++) {
                lessons.add(new Lesson(planId, i, "empty"));
            }
            lessonDao.insertAll(lessons);
            db.close();
        });
    }
}