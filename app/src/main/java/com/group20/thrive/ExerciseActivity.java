package com.group20.thrive;

import androidx.appcompat.app.AppCompatActivity;
import androidx.room.Room;

import android.content.Intent;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.group20.thrive.database.Activity;
import com.group20.thrive.database.ActivityRecord;
import com.group20.thrive.database.ActivityRecordDao;
import com.group20.thrive.database.ThriveDatabase;
import com.group20.thrive.database.UserRepository;

import java.util.Locale;
import java.util.concurrent.Executors;

import java.time.format.DateTimeFormatter;
import java.time.ZoneId;
import java.time.ZonedDateTime;

public class ExerciseActivity extends AppCompatActivity {

    private Activity activity;

    private long startTimeInMillis = 60000; // == 1min
    private CountDownTimer countDownTimer;
    private long timeLeftInMillis;
    private boolean timerRunning;

    private TextView timer;
    private TextView tip;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_exercise);

        setTitle("Exercise");

        Intent intent = getIntent();
        activity = (Activity) intent.getSerializableExtra("activity");

        TextView title = findViewById(R.id.title);
        title.setText(activity.getActivityName());

        startTimeInMillis *= activity.getActivityLen(); // 1 x len minutes
        startTimeInMillis += 1000; // +1s because timer start right after activity start
        timeLeftInMillis = startTimeInMillis;

        Button finishBtn = findViewById(R.id.finishBtn);
        timer = findViewById(R.id.timer);
        tip = findViewById(R.id.tip);
        tip.setText("TIP \n Click on the timer to pause and click again to resume");

        startTimer();

        timer.setOnClickListener(view1 -> {
            if (timerRunning) {
                pauseTimer();
            } else {
                startTimer();
            }
        });

        finishBtn.setOnClickListener(view1 -> {
            countDownTimer.cancel();
            updateActivityRecord();
            onBackPressed();
        });
    }

    private void startTimer() {
        countDownTimer = new CountDownTimer(timeLeftInMillis, 1000) {
            @Override
            public void onTick(long millisUntilFinished) {
                timeLeftInMillis = millisUntilFinished;
                updateTimer();
                updateTip();
            }

            @Override
            public void onFinish() {
                timerRunning = false;
                countDownTimer.cancel();
                Toast.makeText(ExerciseActivity.this,
                        "Congratulation! You have finished " + activity.getActivityName() + " exercise.",
                        Toast.LENGTH_SHORT).show();
                updateActivityRecord();
                onBackPressed();
            }
        }.start();

        timerRunning = true;
    }

    private void pauseTimer() {
        countDownTimer.cancel();
        timerRunning = false;
    }

    private void updateTimer() {
        int minutes = (int) (timeLeftInMillis / 1000) / 60;
        int seconds = (int) (timeLeftInMillis / 1000) % 60;

        String timeLeftFormatted = String.format(Locale.getDefault(), "%02d:%02d", minutes, seconds);

        timer.setText(timeLeftFormatted);
    }

    private void updateTip() {
        if (startTimeInMillis - timeLeftInMillis > 60000) {
            tip.setText("TIP \n It is recommended to take a 30-45 seconds break between sets");
        }
    }

    private void updateActivityRecord() {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        String date = ZonedDateTime.now(ZoneId.systemDefault()).format(formatter);
        int exerciseTime = (int) (startTimeInMillis - timeLeftInMillis) / 1000;
        Executors.newSingleThreadExecutor().execute(() -> {
            ThriveDatabase db = Room.databaseBuilder(getApplicationContext(), ThriveDatabase.class,
                    ThriveDatabase.THRIVE_DATABASE_NAME).build();
            ActivityRecordDao activityRecordDao = db.activityRecordDao();
            activityRecordDao.addRecord(new ActivityRecord(date, activity.getActivityId(), "exercise", exerciseTime));
        });
    }

}