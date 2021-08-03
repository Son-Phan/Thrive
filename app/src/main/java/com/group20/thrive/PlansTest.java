package com.group20.thrive;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Adapter;
import android.widget.ListView;

import java.util.ArrayList;

public class PlansTest extends AppCompatActivity {

    ListView lvExercise;
    ArrayList<Exercise> exerciseArrayList;
    ExerciseAdapter exerciseAdapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_plans_test);
        init();
        exerciseAdapter = new ExerciseAdapter(this, R.layout.listview_exercise, exerciseArrayList);
        lvExercise.setAdapter(exerciseAdapter);
    }

    private void init(){
        lvExercise = (ListView) findViewById(R.id.listviewExercises);
        exerciseArrayList = new ArrayList<>();
        exerciseArrayList.add(new Exercise("Natural", R.drawable.img));
        exerciseArrayList.add(new Exercise("Natural", R.drawable.img_1));
        exerciseArrayList.add(new Exercise("Natural", R.drawable.img_2));
        exerciseArrayList.add(new Exercise("Natural", R.drawable.img_3));
        exerciseArrayList.add(new Exercise("Natural", R.drawable.img));
        exerciseArrayList.add(new Exercise("Natural", R.drawable.img_1));
        exerciseArrayList.add(new Exercise("Natural", R.drawable.img_2));
        exerciseArrayList.add(new Exercise("Natural", R.drawable.img_3));
        exerciseArrayList.add(new Exercise("Natural", R.drawable.img));
        exerciseArrayList.add(new Exercise("Natural", R.drawable.img_1));
        exerciseArrayList.add(new Exercise("Natural", R.drawable.img_2));
        exerciseArrayList.add(new Exercise("Natural", R.drawable.img_3));
    }
}