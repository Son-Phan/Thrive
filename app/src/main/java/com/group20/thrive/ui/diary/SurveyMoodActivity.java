package com.group20.thrive.ui.diary;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.RadioButton;
import android.widget.RadioGroup;

import com.group20.thrive.R;


public class SurveyMoodActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_survey_mood);
        RadioGroup rg = (RadioGroup) findViewById(R.id.radioGroup);
        Intent intent = getIntent();
        Intent intent_1 = new Intent(this, SurveyActivities.class);
        rg.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int i) {
                RadioButton rb =  (RadioButton) findViewById(i);
                intent_1.putExtra("Date", intent.getStringExtra("Date"));
                String mood = rb.getContentDescription().toString();
                System.out.println(mood);
                intent_1.putExtra("mood", mood);
                startActivity(intent_1);
            }
        });

    }
}