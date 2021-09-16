package com.group20.thrive;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.widget.ImageView;
import android.widget.MediaController;
import android.widget.TextView;
import android.widget.VideoView;

import com.group20.thrive.database.Activity;

import java.lang.annotation.Documented;
import java.lang.reflect.Field;

public class ExerciseActivity extends AppCompatActivity {

    private Activity activity;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_exercise);

        setTitle("Exercise");

        ActionBar actionBar = getSupportActionBar();
        assert actionBar != null;
        actionBar.setDisplayHomeAsUpEnabled(true);

        Intent intent = getIntent();
        activity = (Activity) intent.getSerializableExtra("activity");

        TextView name = findViewById(R.id.exerciseName);
        TextView time = findViewById(R.id.exerciseTime);
        TextView desc = findViewById(R.id.exerciseDesc);

        name.setText(activity.getActivityName());
        time.setText(String.valueOf(activity.getActivityLen()));
        desc.setText(activity.getActivityDesc());

        ImageView playBtn = findViewById(R.id.playBtn);
        playBtn.setOnClickListener(view1 -> {
            Intent intent1 = new Intent(this, PlayVideoActivity.class);
            intent1.putExtra("resName", activity.getFileName());
            startActivity(intent1);
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