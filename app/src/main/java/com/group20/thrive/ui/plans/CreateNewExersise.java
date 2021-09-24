package com.group20.thrive.ui.plans;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.MenuItem;

import com.group20.thrive.R;
import com.group20.thrive.database.Activity;
import com.group20.thrive.database.Lesson;

import java.util.ArrayList;
import java.util.List;

public class CreateNewExersise extends AppCompatActivity {
    private PlansViewModel plansViewModel;
    private RecyclerView recyclerView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_new_exersise);
        ActionBar actionBar = getSupportActionBar();
        assert actionBar != null;
        actionBar.setDisplayHomeAsUpEnabled(true);
        recyclerView = findViewById(R.id.exercise_radio_list);
        LinearLayoutManager layoutManager
                = new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false);
        recyclerView.setLayoutManager(layoutManager);

        DividerItemDecoration dividerItemDecoration =
                new DividerItemDecoration(recyclerView.getContext(),
                        DividerItemDecoration.VERTICAL);
        recyclerView.addItemDecoration(dividerItemDecoration);
        CreateNewExerciseAdapter createNewExerciseAdapter = new CreateNewExerciseAdapter( this);
        plansViewModel = new ViewModelProvider(this).get(PlansViewModel.class);
        plansViewModel.getmAllActivities().observe(this, newData -> {
            System.out.println(newData);
            createNewExerciseAdapter.setCategoryExerciseLists(newData);
        });
        recyclerView.setAdapter(createNewExerciseAdapter);
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