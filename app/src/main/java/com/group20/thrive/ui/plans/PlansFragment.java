package com.group20.thrive.ui.plans;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import com.group20.thrive.Plans;
import com.group20.thrive.PlansAdapter;
import com.group20.thrive.R;
import com.group20.thrive.databinding.FragmentPlansBinding;

import java.util.ArrayList;

public class PlansFragment extends Fragment  {

    private PlansViewModel PlansViewModel;
    private FragmentPlansBinding binding;
    ListView lvPlans;
    ArrayList<Plans> plansArrayList;
    PlansAdapter plansAdapter;

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
        plansAdapter = new PlansAdapter(inflater.getContext(), R.layout.listview_plans, plansArrayList);
        lvPlans.setAdapter(plansAdapter);
        lvPlans.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                FragmentManager fm = getChildFragmentManager();
                FragmentTransaction ft =fm.beginTransaction();
                ft.replace(R.id.fragment_plans_layout, new ExercisesFragment());
                ft.commit();
            }
        });
        return view;
    }



    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
    private void init(View view){
        lvPlans = (ListView) view.findViewById(R.id.listviewPlans);
        plansArrayList = new ArrayList<>();
        plansArrayList.add(new Plans("Natural", R.drawable.img));
        plansArrayList.add(new Plans("Natural", R.drawable.img_1));
        plansArrayList.add(new Plans("Natural", R.drawable.img_2));
        plansArrayList.add(new Plans("Natural", R.drawable.img_3));
        plansArrayList.add(new Plans("Natural", R.drawable.img));
        plansArrayList.add(new Plans("Natural", R.drawable.img_1));
        plansArrayList.add(new Plans("Natural", R.drawable.img_2));
        plansArrayList.add(new Plans("Natural", R.drawable.img_3));
        plansArrayList.add(new Plans("Natural", R.drawable.img));
        plansArrayList.add(new Plans("Natural", R.drawable.img_1));
        plansArrayList.add(new Plans("Natural", R.drawable.img_2));
        plansArrayList.add(new Plans("Natural", R.drawable.img_3));


    }
}