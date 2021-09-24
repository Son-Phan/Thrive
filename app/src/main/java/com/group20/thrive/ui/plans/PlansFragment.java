package com.group20.thrive.ui.plans;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.cardview.widget.CardView;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import com.group20.thrive.R;
import com.group20.thrive.database.Plan;

public class PlansFragment extends Fragment {

    ListView lvPlans;
    PlansAdapter plansAdapter;
    PlansViewModel plansViewModel;
    Plan userPlan;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_plans, container, false);

        lvPlans = view.findViewById(R.id.listviewPlans);
        plansAdapter = new PlansAdapter(inflater.getContext(), R.layout.listview_plans);
        plansViewModel = new ViewModelProvider.AndroidViewModelFactory(this.getActivity().getApplication()).create(PlansViewModel.class);
        plansViewModel.getAllPlans().observe(getViewLifecycleOwner(), newData -> {
            plansViewModel.getUserPlan().observe(getViewLifecycleOwner(), newData1 -> {
                newData.remove(newData1.getPlanId() -1);
                plansAdapter.setPlanList(newData);
                plansAdapter.notifyDataSetChanged();
            });
        });

        lvPlans.setAdapter(plansAdapter);

        lvPlans.setOnItemClickListener((adapterView, view1, i, l) -> {
            Intent intent = new Intent(getActivity(), PlanActivity.class);
            intent.putExtra("plan", plansAdapter.getItem(i));
            startActivity(intent);
        });
        return view;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        TextView planName = view.findViewById(R.id.planName);
        TextView planLen = view.findViewById(R.id.planLen);
        TextView planDesc = view.findViewById(R.id.planDesc);

        plansViewModel.getUserPlan().observe(getActivity(), newData -> {
            userPlan = newData;
            planName.setText(userPlan.getPlanName());
            planLen.setText(String.valueOf(userPlan.getPlanLength()));
            if (userPlan.getPlanDescription().length() > 40) {
                String desc = userPlan.getPlanDescription().substring(0,40) + "...";
                planDesc.setText(desc);
            }
            else {
                planDesc.setText(userPlan.getPlanDescription());
            }
        });

        CardView currentPlan = view.findViewById(R.id.currentPlan);

        currentPlan.setOnClickListener(view1 -> {
            Intent intent = new Intent(getActivity(), PlanActivity.class);
            intent.putExtra("plan", userPlan);
            startActivity(intent);
        });

        Button createNewPlanButton = view.findViewById(R.id.createPlan);

        createNewPlanButton.setOnClickListener(view1 -> {
            Intent intent = new Intent(getActivity(), CreateNewPlanActivity.class);
            startActivity(intent);
        });
    }
}