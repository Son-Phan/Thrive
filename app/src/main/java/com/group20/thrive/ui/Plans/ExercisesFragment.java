package com.group20.thrive.ui.Plans;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import com.group20.thrive.ExerciseActivity;
import com.group20.thrive.Exercises;
import com.group20.thrive.ExercisesAdapter;
import com.group20.thrive.Plans;
import com.group20.thrive.PlansAdapter;
import com.group20.thrive.R;
//import com.group20.thrive.databinding.FragmentPlansBinding;

import java.util.ArrayList;

public class ExercisesFragment extends Fragment  {


    ListView lvExercise;
    ArrayList<Exercises> exerciseArrayList;
    ExercisesAdapter exerciseAdapter;


    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_plans, container, false);
        init(view);
        exerciseAdapter = new ExercisesAdapter(inflater.getContext(), R.layout.listview_exercises, exerciseArrayList);
        lvExercise.setAdapter(exerciseAdapter);
        return view;
    }


    private void init(View view){
        lvExercise = (ListView) view.findViewById(R.id.listviewPlans);
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