package com.group20.thrive.ui.plans;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.ListView;

import com.group20.thrive.R;

import java.util.ArrayList;

public class PlanActivity extends AppCompatActivity{



    ExercisesAdapter exerciseAdapter;
    Button exit_button;
    private PlansViewModel plansViewModel;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_plan);
        ActionBar actionBar = getSupportActionBar();
        assert actionBar != null;
        actionBar.setDisplayHomeAsUpEnabled(true);

        ArrayList<String> days = new ArrayList<>();
        days.add("Day 7");
        days.add("Day 6");
        days.add("Day 5");
        days.add("Day 4");
        days.add("Day 3");
        days.add("Day 2");
        days.add("Day 1");
        RecyclerView recyclerView = findViewById(R.id.listviewExercises);
        recyclerView.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, true));
        exerciseAdapter = new ExercisesAdapter(this, days);
//        plansViewModel = new ViewModelProvider.AndroidViewModelFactory(this.getApplication()).create(PlansViewModel.class);
//        plansViewModel.getAllPlans().observe(this, newData -> {
//            exerciseAdapter.setExerciseList(newData);
//            exerciseAdapter.notifyDataSetChanged();
//            System.out.println(newData);
//        });
        recyclerView.setAdapter(exerciseAdapter);

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