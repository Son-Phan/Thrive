package com.group20.thrive.ui.diary;

import androidx.appcompat.app.AppCompatActivity;
import androidx.room.Room;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.ImageButton;

import com.group20.thrive.MainActivity;
import com.group20.thrive.R;
import com.group20.thrive.database.Diary;
import com.group20.thrive.database.DiaryDao;
import com.group20.thrive.database.ThriveDatabase;

import java.util.ArrayList;

public class SurveyActivities extends AppCompatActivity implements View.OnClickListener {

    private ArrayList<String> activities;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_survey_activities);
        Intent intent = getIntent();
        String date = intent.getStringExtra("Date");
        String mood = intent.getStringExtra("mood");
        activities = new ArrayList<>();

        CheckBox checkbox_tv = (CheckBox)findViewById(R.id.checkbox_tv);
        CheckBox checkbox_reading = (CheckBox)findViewById(R.id.checkbox_reading);
        CheckBox checkbox_gaming = (CheckBox)findViewById(R.id.checkbox_gaming);
        CheckBox checkbox_sport = (CheckBox)findViewById(R.id.checkbox_sport);
        CheckBox checkbox_relax = (CheckBox)findViewById(R.id.checkbox_relax);
        checkbox_tv.setOnClickListener(this);
        checkbox_reading.setOnClickListener(this);
        checkbox_gaming.setOnClickListener(this);
        checkbox_sport.setOnClickListener(this);
        checkbox_relax.setOnClickListener(this);
        Intent intent_1 = new Intent(this, MainActivity.class);
        ImageButton save_button = (ImageButton) findViewById(R.id.save_button);
        save_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ThriveDatabase db = Room.databaseBuilder(getApplicationContext(),
                        ThriveDatabase.class, "thrive_database.db").allowMainThreadQueries().build();
                DiaryDao diaryDao = db.diaryDao();
                diaryDao.addDiary(new Diary(date, mood, 60, activities.toString(), 40, "nothing"));

                startActivity(intent_1);
            }
        });
    }



    @Override
    public void onClick(View view) {
// now check that Is the view now checked?
        boolean checked = ((CheckBox) view).isChecked();

        switch(view.getId()) {
            case R.id.checkbox_tv:
                if (checked)
                    activities.add("checkbox_tv|");
                else
                    activities.remove("checkbox_tv|");
                break;
            case R.id.checkbox_reading:
                if (checked)
                    activities.add("checkbox_reading|");
                else
                    activities.remove("checkbox_reading|");
                break;
            case R.id.checkbox_gaming:
                if (checked)
                    activities.add("checkbox_gaming|");
                else
                    activities.remove("checkbox_gaming|");
                break;
            case R.id.checkbox_sport:
                if (checked)
                    activities.add("checkbox_sport|");
                else
                    activities.remove("checkbox_sport|");
                break;
            case R.id.checkbox_relax:
                if (checked)
                    activities.add("checkbox_relax|");
                else
                    activities.remove("checkbox_relax|");
                break;
        }

    }

}