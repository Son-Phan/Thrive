package com.group20.thrive;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
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
        lvExercise.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Intent intent = new Intent(lvExercise.getContext(),ExerciseActivity.class);
                lvExercise.getContext().startActivity(intent);
                overridePendingTransition(R.anim.animation_enter_up_activity, R.anim.animation_exit_activity);
            }
        });
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