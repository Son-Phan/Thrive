package com.group20.thrive.ui.plans;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProvider;

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

    ExercisesAdapter exerciseAdapter;
    Button exit_button;
    private PlansViewModel plansViewModel;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_exercise);
        ActionBar actionBar = getSupportActionBar();
        assert actionBar != null;
        actionBar.setDisplayHomeAsUpEnabled(true);
        init();
        exerciseAdapter = new ExercisesAdapter(this, R.layout.listview_exercises);
        plansViewModel = new ViewModelProvider.AndroidViewModelFactory(this.getApplication()).create(PlansViewModel.class);
        plansViewModel.getAllPlans().observe(this, newData -> {
            exerciseAdapter.setExerciseList(newData);
            exerciseAdapter.notifyDataSetChanged();
            System.out.println(newData);
        });
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



    }


}