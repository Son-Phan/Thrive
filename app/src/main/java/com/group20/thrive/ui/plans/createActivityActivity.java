package com.group20.thrive.ui.plans;

import androidx.appcompat.app.AppCompatActivity;
import androidx.room.Room;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.group20.thrive.MainActivity;
import com.group20.thrive.R;
import com.group20.thrive.database.Activity;
import com.group20.thrive.database.ActivityDao;
import com.group20.thrive.database.ActivityRecord;
import com.group20.thrive.database.ActivityRecordDao;
import com.group20.thrive.database.Lesson;
import com.group20.thrive.database.LessonActivityCrossRef;
import com.group20.thrive.database.LessonDao;
import com.group20.thrive.database.Plan;
import com.group20.thrive.database.PlanDao;
import com.group20.thrive.database.ThriveDatabase;
import com.group20.thrive.database.UserDao;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Executors;

public class createActivityActivity extends AppCompatActivity {

    private int lessonId;
    private String timeOfDay;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_activity);

        setTitle("New Activity");

        Intent intent = getIntent();
        lessonId = intent.getIntExtra("lessonId", 0);
        timeOfDay = intent.getStringExtra("timeOfDay");

        Button createBtn = findViewById(R.id.createActivityBtn);

        createBtn.setOnClickListener(view -> onDoneBtnClick());
    }

    public void onDoneBtnClick() {
        EditText activityNameInput = findViewById(R.id.activityNameInput);
        EditText activityLenInput = findViewById(R.id.activityLenInput);
        EditText activityDescInput = findViewById(R.id.activityDescInput);

        String activityName = activityNameInput.getText().toString();
        String activityLength = activityLenInput.getText().toString();
        String activityDesc = activityDescInput.getText().toString();

        if (activityName.isEmpty() || activityLength.isEmpty()) {
            Toast.makeText(this, "So...can you at least give me the name and time?", Toast.LENGTH_SHORT).show();
        } else {
            int activityLen = Integer.parseInt(activityLength);
            if (activityDesc.isEmpty()) { activityDesc = "You should have typed something here cause I have no idea what this is about."; }
            addNewActivity(activityName, activityLen, activityDesc);
            Intent intent = new Intent(this, MainActivity.class);
            intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
            startActivity(intent);
        }
    }

    public void addNewActivity(String activityName, int activityLen, String activityDesc) {
        Executors.newSingleThreadExecutor().execute(() -> {
            ThriveDatabase db = Room.databaseBuilder(getApplicationContext(), ThriveDatabase.class,
                    ThriveDatabase.THRIVE_DATABASE_NAME).build();
            ActivityDao activityDao = db.activityDao();
            LessonDao lessonDao = db.lessonDao();
            activityDao.addActivity(new Activity(activityName, "user", activityLen, activityDesc, "null"));
            int activityId = activityDao.getActivityId(activityName);
            lessonDao.insertLessonActivity(new LessonActivityCrossRef(lessonId, activityId, timeOfDay));
            db.close();
        });
    }
}