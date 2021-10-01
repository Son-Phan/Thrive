package com.group20.thrive;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.group20.thrive.database.Activity;

public class ActivityInfoActivity extends AppCompatActivity {

    private boolean exercise; // true if exercise and false if meditation
    private boolean user; // true of user created activity

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_activity_info);

        ActionBar actionBar = getSupportActionBar();
        assert actionBar != null;
        actionBar.setDisplayHomeAsUpEnabled(true);

        Intent intent = getIntent();
        Activity activity = (Activity) intent.getSerializableExtra("activity");

        if (activity.getActivityType().equals("userActivity")) {
            setTitle("User Activity");
            user = true;
        } else if (activity.getActivityType().equals("exercise")) {
            setTitle("Exercise");
            exercise = true;
        } else {
            setTitle("Meditation");
            exercise = false;
        }

        TextView name = findViewById(R.id.exerciseName);
        TextView time = findViewById(R.id.exerciseTime);
        TextView desc = findViewById(R.id.exerciseDesc);

        name.setText(activity.getActivityName());
        time.setText(String.valueOf(activity.getActivityLen()));
        desc.setText(activity.getActivityDesc());

        //set thumbnail
        ImageView thumbnail = findViewById(R.id.thumbnail);
        if (user) {
            thumbnail.setImageResource(R.drawable.cat_motivation_meme_1);
        } else if (exercise) {
            thumbnail.setImageResource(R.drawable.exercise_thumbnail);
        } else {
            thumbnail.setImageResource(R.drawable.meditation_thumbnail);
        }

        // Instruction video for exercise
        if (exercise) {
            TextView illustrationText = findViewById(R.id.illustrationText);
            illustrationText.setVisibility(View.VISIBLE);
            ImageView playBtn = findViewById(R.id.playBtn);
            playBtn.setVisibility(View.VISIBLE);
            playBtn.setOnClickListener(view1 -> {
                Intent intent1 = new Intent(this, PlayVideoActivity.class);
                intent1.putExtra("resName", activity.getFileName());
                startActivity(intent1);
            });
        }

        Button startBtn = findViewById(R.id.startBtn);
        startBtn.setOnClickListener(view1 -> {
            if (exercise || user) {
                Intent intent2 = new Intent(this, ExerciseActivity.class);
                intent2.putExtra("activity", activity);
                startActivity(intent2);
            } else {
                Intent intent3 = new Intent(this, YoutubeViewActivity.class);
                intent3.putExtra("activity", activity);
                startActivity(intent3);
            }
        });
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        if (item.getItemId() == android.R.id.home) {
            onBackPressed();
            return true;
        }
        return super.onOptionsItemSelected(item);
    }
}