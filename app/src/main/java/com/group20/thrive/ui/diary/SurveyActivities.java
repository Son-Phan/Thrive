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

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

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
        CheckBox checkbox_good_sleep = (CheckBox)findViewById(R.id.checkbox_good_sleep);
        CheckBox checkbox_medium_sleep = (CheckBox)findViewById(R.id.checkbox_medium_sleep);
        CheckBox checkbox_bad_sleep = (CheckBox)findViewById(R.id.checkbox_bad_sleep);
        CheckBox checkbox_sleep_early = (CheckBox)findViewById(R.id.checkbox_sleep_early);
        CheckBox checkbox_eat_healthy = (CheckBox)findViewById(R.id.checkbox_eat_healthy);
        CheckBox checkbox_fat_foot = (CheckBox)findViewById(R.id.checkbox_fat_foot);
        CheckBox checkbox_homemade = (CheckBox)findViewById(R.id.checkbox_homemade);
        CheckBox checkbox_restaurant = (CheckBox)findViewById(R.id.checkbox_restaurant);
        CheckBox checkbox_delivery = (CheckBox)findViewById(R.id.checkbox_delivery);
        CheckBox checkbox_no_meat = (CheckBox)findViewById(R.id.checkbox_no_meat);
        CheckBox checkbox_no_sweets = (CheckBox)findViewById(R.id.checkbox_no_sweets);
        CheckBox checkbox_no_soda = (CheckBox)findViewById(R.id.checkbox_no_soda);
        checkbox_tv.setOnClickListener(this);
        checkbox_reading.setOnClickListener(this);
        checkbox_gaming.setOnClickListener(this);
        checkbox_sport.setOnClickListener(this);
        checkbox_relax.setOnClickListener(this);
        checkbox_good_sleep.setOnClickListener(this);
        checkbox_medium_sleep.setOnClickListener(this);
        checkbox_bad_sleep.setOnClickListener(this);
        checkbox_sleep_early.setOnClickListener(this);
        checkbox_eat_healthy.setOnClickListener(this);
        checkbox_fat_foot.setOnClickListener(this);
        checkbox_homemade.setOnClickListener(this);
        checkbox_restaurant.setOnClickListener(this);
        checkbox_delivery.setOnClickListener(this);
        checkbox_no_meat.setOnClickListener(this);
        checkbox_no_sweets.setOnClickListener(this);
        checkbox_no_soda.setOnClickListener(this);
        Intent intent_1 = new Intent(this, MainActivity.class);
        ImageButton save_button = (ImageButton) findViewById(R.id.save_button);
        SimpleDateFormat sdf = new SimpleDateFormat("HH:mm:ss");
        String currentDateandTime = sdf.format(new Date());
        save_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ThriveDatabase db = Room.databaseBuilder(getApplicationContext(),
                        ThriveDatabase.class, "thrive_database.db").allowMainThreadQueries().build();
                DiaryDao diaryDao = db.diaryDao();
                diaryDao.addDiary(new Diary(date,currentDateandTime, mood,imageLocation(mood), 60, activities.toString(), 40, "nothing"));

                startActivity(intent_1);
            }
        });
    }

    private int imageLocation(String mood){
        System.out.print(mood);
        if(mood.equals("happy"))
            return R.drawable.happy_image;
        if(mood.equals("good"))
            return R.drawable.good_image;
        if(mood.equals("medium"))
            return R.drawable.medium_image;
        if(mood.equals("bad"))
            return R.drawable.bad_image;
        return R.drawable.awful_image;
    }

    @Override
    public void onClick(View view) {
// now check that Is the view now checked?
        boolean checked = ((CheckBox) view).isChecked();

        switch(view.getId()) {
            case R.id.checkbox_tv:
                if (checked)
                    activities.add("movies & tv");
                else
                    activities.remove("movies & tv");
                break;
            case R.id.checkbox_reading:
                if (checked)
                    activities.add("reading");
                else
                    activities.remove("reading");
                break;
            case R.id.checkbox_gaming:
                if (checked)
                    activities.add("gaming");
                else
                    activities.remove("gaming");
                break;
            case R.id.checkbox_sport:
                if (checked)
                    activities.add("sport");
                else
                    activities.remove("sport");
                break;
            case R.id.checkbox_relax:
                if (checked)
                    activities.add("relax");
                else
                    activities.remove("relax");
                break;
            case R.id.checkbox_good_sleep:
                if (checked)
                    activities.add("good sleep");
                else
                    activities.remove("good sleep");
                break;
            case R.id.checkbox_medium_sleep:
                if (checked)
                    activities.add("medium sleep");
                else
                    activities.remove("medium sleep");
                break;
            case R.id.checkbox_bad_sleep:
                if (checked)
                    activities.add("bad sleep");
                else
                    activities.remove("bad sleep");
                break;
            case R.id.checkbox_sleep_early:
                if (checked)
                    activities.add("sleep early");
                else
                    activities.remove("sleep early");
                break;
            case R.id.checkbox_eat_healthy:
                if (checked)
                    activities.add("eat healthy");
                else
                    activities.remove("eat healthy");
                break;
            case R.id.checkbox_fat_foot:
                if (checked)
                    activities.add("fast food");
                else
                    activities.remove("fast food");
                break;
            case R.id.checkbox_homemade:
                if (checked)
                    activities.add("homemade");
                else
                    activities.remove("homemade");
                break;
            case R.id.checkbox_restaurant:
                if (checked)
                    activities.add("restaurant");
                else
                    activities.remove("restaurant");
                break;
            case R.id.checkbox_delivery:
                if (checked)
                    activities.add("delivery");
                else
                    activities.remove("delivery");
                break;
            case R.id.checkbox_no_meat:
                if (checked)
                    activities.add("no meat");
                else
                    activities.remove("no meat");
                break;
            case R.id.checkbox_no_sweets:
                if (checked)
                    activities.add("no sweets");
                else
                    activities.remove("no sweets");
                break;
            case R.id.checkbox_no_soda:
                if (checked)
                    activities.add("no soda");
                else
                    activities.remove("no soda");
                break;
        }

    }

}