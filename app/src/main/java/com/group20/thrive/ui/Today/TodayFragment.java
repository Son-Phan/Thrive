package com.group20.thrive.ui.Today;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.group20.thrive.Plans;
import com.group20.thrive.PlansAdapter;
import com.group20.thrive.R;
import com.group20.thrive.databinding.FragmentTodayBinding;
import com.group20.thrive.ui.Plans.ExercisesFragment;

import java.util.ArrayList;
import java.util.List;

public class TodayFragment extends Fragment {

    private TodayViewModel TodayViewModel;
    private FragmentTodayBinding binding;
    ListView lvToday;
    ArrayList<Today> todayArrayList;
    TodayAdapter todayAdapter;
    private RecyclerView recyclerView;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
//        TodayViewModel =
//                new ViewModelProvider(this).get(TodayViewModel.class);
//
//        binding = FragmentTodayBinding.inflate(inflater, container, false);
//        View root = binding.getRoot();
//
//        final TextView textView = binding.textToday;
//        TodayViewModel.getText().observe(getViewLifecycleOwner(), textView::setText);
//        return root;
        View view = inflater.inflate(R.layout.fragment_today, container, false);

//        todayAdapter = new TodayAdapter(inflater.getContext(), R.layout.listvew_today, todayArrayList);
//        lvToday.setAdapter(todayAdapter);
        recyclerView = view.findViewById(R.id.recyclerview_fragment_today);
        todayAdapter = new TodayAdapter(getActivity());
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getActivity(), RecyclerView.VERTICAL, false);
        recyclerView.setLayoutManager(linearLayoutManager);
        todayAdapter.setData(getListToday());
        recyclerView.setAdapter(todayAdapter);
        return view;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }

    private List<Today> getListToday(){
        List<Today> list = new ArrayList<>();
        List<ExerciseToday> exerciseTodays = new ArrayList<>();
        exerciseTodays.add(new ExerciseToday(R.drawable.img, "Push up", "70 minutes"));
        exerciseTodays.add(new ExerciseToday(R.drawable.img, "Push up", "70 minutes"));
        exerciseTodays.add(new ExerciseToday(R.drawable.img, "Push up", "70 minuter"));
        exerciseTodays.add(new ExerciseToday(R.drawable.img, "Push up", "70 minutes"));
        list.add(new Today(R.drawable.run_image, "Excersices", "70%", exerciseTodays));
        list.add(new Today(R.drawable.run_image, "Excersices", "70%", exerciseTodays));
        list.add(new Today(R.drawable.run_image, "Excersices", "70%", exerciseTodays));
        list.add(new Today(R.drawable.run_image, "Excersices", "70%", exerciseTodays));
        list.add(new Today(R.drawable.run_image, "Excersices", "70%", exerciseTodays));
        list.add(new Today(R.drawable.run_image, "Excersices", "70%", exerciseTodays));
        list.add(new Today(R.drawable.run_image, "Excersices", "70%", exerciseTodays));
        list.add(new Today(R.drawable.run_image, "Excersices", "70%", exerciseTodays));
        return list;
    }
}