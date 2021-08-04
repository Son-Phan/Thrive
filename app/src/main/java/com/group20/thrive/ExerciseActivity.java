package com.group20.thrive;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ListView;

import java.util.ArrayList;

public class ExerciseActivity extends AppCompatActivity {

    ListView lvExercise;
    ArrayList<Exercises> exerciseArrayList;
    ExercisesAdapter exerciseAdapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_exercise);
        init();
        exerciseAdapter = new ExercisesAdapter(this, R.layout.listview_plans, exerciseArrayList);
        lvExercise.setAdapter(exerciseAdapter);

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