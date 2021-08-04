package com.group20.thrive;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ListView;

import java.util.ArrayList;

public class PlansTest extends AppCompatActivity {

    ListView lvExercise;
    ArrayList<Plans> exerciseArrayList;
    PlansAdapter exerciseAdapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_plans_test);
        init();
        exerciseAdapter = new PlansAdapter(this, R.layout.listview_plans, exerciseArrayList);
        lvExercise.setAdapter(exerciseAdapter);

    }

    private void init(){
        lvExercise = (ListView) findViewById(R.id.listviewExercises);
        exerciseArrayList = new ArrayList<>();
        exerciseArrayList.add(new Plans("Natural", R.drawable.img));
        exerciseArrayList.add(new Plans("Natural", R.drawable.img_1));
        exerciseArrayList.add(new Plans("Natural", R.drawable.img_2));
        exerciseArrayList.add(new Plans("Natural", R.drawable.img_3));
        exerciseArrayList.add(new Plans("Natural", R.drawable.img));
        exerciseArrayList.add(new Plans("Natural", R.drawable.img_1));
        exerciseArrayList.add(new Plans("Natural", R.drawable.img_2));
        exerciseArrayList.add(new Plans("Natural", R.drawable.img_3));
        exerciseArrayList.add(new Plans("Natural", R.drawable.img));
        exerciseArrayList.add(new Plans("Natural", R.drawable.img_1));
        exerciseArrayList.add(new Plans("Natural", R.drawable.img_2));
        exerciseArrayList.add(new Plans("Natural", R.drawable.img_3));
    }
}