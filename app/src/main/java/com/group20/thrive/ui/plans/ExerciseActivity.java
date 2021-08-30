package com.group20.thrive.ui.plans;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;

import com.group20.thrive.Exercises;
import com.group20.thrive.ExercisesAdapter;
import com.group20.thrive.PlansTest;
import com.group20.thrive.R;

import java.util.ArrayList;

public class ExerciseActivity extends AppCompatActivity{

    ListView lvExercise;
    ArrayList<Exercises> exerciseArrayList;
    ExercisesAdapter exerciseAdapter;
    Button exit_button;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_exercise);
        ActionBar actionBar = getSupportActionBar();
        assert actionBar != null;
        actionBar.setDisplayHomeAsUpEnabled(true);
        init();
        exerciseAdapter = new ExercisesAdapter(this, R.layout.listview_exercises, exerciseArrayList);
        lvExercise.setAdapter(exerciseAdapter);

    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        if (item.getItemId() == android.R.id.home) {
            onBackPressed();
            return true;
        }

        return super.onOptionsItemSelected(item);
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