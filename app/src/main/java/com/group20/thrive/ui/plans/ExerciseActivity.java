package com.group20.thrive.ui.plans;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;

import com.group20.thrive.Exercises;
import com.group20.thrive.ExercisesAdapter;
import com.group20.thrive.PlansTest;
import com.group20.thrive.R;

import java.util.ArrayList;

public class ExerciseActivity extends AppCompatActivity implements View.OnClickListener{

    ListView lvExercise;
    ArrayList<Exercises> exerciseArrayList;
    ExercisesAdapter exerciseAdapter;
    Button exit_button;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_exercise);
        init();
        exerciseAdapter = new ExercisesAdapter(this, R.layout.listview_exercises, exerciseArrayList);
        lvExercise.setAdapter(exerciseAdapter);
        exit_button = (Button) findViewById(R.id.button_exit);
        exit_button.setOnClickListener(this);
    }
    @Override
    public void onClick(View view) {
        Intent intent = new Intent(ExerciseActivity.this, PlansTest.class);
        startActivity(intent);
        overridePendingTransition(R.anim.animation_exit_activity, R.anim.animation_enter_down_activity);
    }

    private void init(){
        lvExercise = (ListView) findViewById(R.id.listviewExercises);
        exerciseArrayList = new ArrayList<>();
        exerciseArrayList.add(new Exercises("Natural", "The desirable end goal of the " +
                "Thrive at Work process is a an action plan for your business, " +
                "which delivers on a wellness strategy; which in turn fits with your " +
                "organisation’s overall strategy and enables the business and its people."));
        exerciseArrayList.add(new Exercises("Natural", "The desirable end goal of the " +
                "Thrive at Work process is a an action plan for your business, " +
                "which delivers on a wellness strategy; which in turn fits with your " +
                "organisation’s overall strategy and enables the business and its people."));
        exerciseArrayList.add(new Exercises("Natural", "The desirable end goal of the " +
                "Thrive at Work process is a an action plan for your business, " +
                "which delivers on a wellness strategy; which in turn fits with your " +
                "organisation’s overall strategy and enables the business and its people."));
        exerciseArrayList.add(new Exercises("Natural", "The desirable end goal of the " +
                "Thrive at Work process is a an action plan for your business, " +
                "which delivers on a wellness strategy; which in turn fits with your " +
                "organisation’s overall strategy and enables the business and its people."));
        exerciseArrayList.add(new Exercises("Natural", "The desirable end goal of the " +
                "Thrive at Work process is a an action plan for your business, " +
                "which delivers on a wellness strategy; which in turn fits with your " +
                "organisation’s overall strategy and enables the business and its people."));
        exerciseArrayList.add(new Exercises("Natural", "The desirable end goal of the " +
                "Thrive at Work process is a an action plan for your business, " +
                "which delivers on a wellness strategy; which in turn fits with your " +
                "organisation’s overall strategy and enables the business and its people."));
        exerciseArrayList.add(new Exercises("Natural", "The desirable end goal of the " +
                "Thrive at Work process is a an action plan for your business, " +
                "which delivers on a wellness strategy; which in turn fits with your " +
                "organisation’s overall strategy and enables the business and its people."));
        exerciseArrayList.add(new Exercises("Natural", "The desirable end goal of the " +
                "Thrive at Work process is a an action plan for your business, " +
                "which delivers on a wellness strategy; which in turn fits with your " +
                "organisation’s overall strategy and enables the business and its people."));
        exerciseArrayList.add(new Exercises("Natural", "The desirable end goal of the " +
                "Thrive at Work process is a an action plan for your business, " +
                "which delivers on a wellness strategy; which in turn fits with your " +
                "organisation’s overall strategy and enables the business and its people."));
        exerciseArrayList.add(new Exercises("Natural", "The desirable end goal of the " +
                "Thrive at Work process is a an action plan for your business, " +
                "which delivers on a wellness strategy; which in turn fits with your " +
                "organisation’s overall strategy and enables the business and its people."));


    }


}