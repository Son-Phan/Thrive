package com.group20.thrive.ui.plans;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import com.group20.thrive.Plans;
import com.group20.thrive.PlansAdapter;
import com.group20.thrive.R;
import com.group20.thrive.database.ThriveDatabase;

import java.util.ArrayList;

public class PlansFragment extends Fragment  {


//    private FragmentPlansBinding binding;
    ListView lvPlans;
    ArrayList<Plans> plansArrayList;
    PlansAdapter plansAdapter;
    private PlansViewModel plansViewModel;
    @SuppressLint("FragmentLiveDataObserve")
    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
//        PlansViewModel =
//                new ViewModelProvider(this).get(PlansViewModel.class);
//
//        binding = FragmentPlansBinding.inflate(inflater, container, false);
//        View root = binding.getRoot();
//
//        final TextView textView = binding.textPlans;
//        PlansViewModel.getText().observe(getViewLifecycleOwner(), textView::setText);
        View view = inflater.inflate(R.layout.fragment_plans, container, false);
        init(view);
        plansAdapter = new PlansAdapter(inflater.getContext(), R.layout.listview_plans);
        plansViewModel = new ViewModelProvider.AndroidViewModelFactory(this.getActivity().getApplication()).create(PlansViewModel.class);
        plansViewModel.getAllPlans().observe(this, newData -> {
            plansAdapter.setExerciseList(newData);
            plansAdapter.notifyDataSetChanged();
            System.out.println(newData);
        });

        lvPlans.setAdapter(plansAdapter);

        lvPlans.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Intent intent = new Intent(getActivity(), ExerciseActivity.class);
                startActivity(intent);

            }
        });
        return view;
    }



//    @Override
//    public void onDestroyView() {
//        super.onDestroyView();
//        binding = null;
//    }

    private void init(View view){
        lvPlans = (ListView) view.findViewById(R.id.listviewPlans);




    }
}