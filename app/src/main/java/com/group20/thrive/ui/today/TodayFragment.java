package com.group20.thrive.ui.today;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.group20.thrive.R;
import com.group20.thrive.databinding.FragmentTodayBinding;
import com.group20.thrive.ui.diary.DiaryViewModel;
import com.group20.thrive.ui.plans.PlansViewModel;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.Locale;
import java.util.TimeZone;

public class TodayFragment extends Fragment {

    private TodayViewModel TodayViewModel;
//    private FragmentTodayBinding binding;

    TodayAdapter todayAdapter;
    private RecyclerView recyclerView;
    private DiaryViewModel diaryViewModel;
    @SuppressLint("FragmentLiveDataObserve")
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
        Calendar calendar = Calendar.getInstance(TimeZone.getDefault());

        int year = calendar.get(Calendar.YEAR);
        int month = calendar.get(Calendar.MONTH) + 1;
        int dayOfMonth = calendar.get(Calendar.DAY_OF_MONTH);
        String date = "";
        if(month < 10){
            date = String.format(Locale.ENGLISH,"%d/0%d/%d", dayOfMonth, month, year);
        }
        else
            date = String.format(Locale.ENGLISH,"%d/%d/%d", dayOfMonth, month, year);
//        todayAdapter = new TodayAdapter(inflater.getContext(), R.layout.listvew_today, todayArrayList);
//        lvToday.setAdapter(todayAdapter);
        recyclerView = view.findViewById(R.id.recyclerview_fragment_today);
        todayAdapter = new TodayAdapter(getActivity());
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getActivity(), RecyclerView.VERTICAL, false);
        recyclerView.setLayoutManager(linearLayoutManager);
        diaryViewModel = new ViewModelProvider.AndroidViewModelFactory(this.getActivity().getApplication()).create(DiaryViewModel.class);
        diaryViewModel.getAllEntries(date).observe(this, newData -> {
            todayAdapter.setDiaryList(newData);
            todayAdapter.notifyDataSetChanged();
            System.out.println(newData);
        });
        recyclerView.setAdapter(todayAdapter);
        return view;
    }

//    @Override
//    public void onDestroyView() {
//        super.onDestroyView();
//        binding = null;
//    }
//
//    private List<Today> getListToday(){
//        List<Today> list = new ArrayList<>();
//        List<ExerciseToday> exerciseTodays = new ArrayList<>();
//        exerciseTodays.add(new ExerciseToday(R.drawable.img, "Push up", "70 minutes"));
//        exerciseTodays.add(new ExerciseToday(R.drawable.img, "Push up", "70 minutes"));
//        exerciseTodays.add(new ExerciseToday(R.drawable.img, "Push up", "70 minuter"));
//        exerciseTodays.add(new ExerciseToday(R.drawable.img, "Push up", "70 minutes"));
//        exerciseTodays.add(new ExerciseToday(R.drawable.img, "Push up", "70 minutes"));
//        exerciseTodays.add(new ExerciseToday(R.drawable.img, "Push up", "70 minutes"));
//        exerciseTodays.add(new ExerciseToday(R.drawable.img, "Push up", "70 minuter"));
//        exerciseTodays.add(new ExerciseToday(R.drawable.img, "Push up", "70 minutes"));
//        list.add(new Today(R.drawable.run_image, "70%", "Excersices", exerciseTodays));
//        list.add(new Today(R.drawable.run_image, "70%", "Excersices", exerciseTodays));
//        list.add(new Today(R.drawable.run_image, "70%", "Excersices", exerciseTodays));
//        list.add(new Today(R.drawable.run_image, "70%", "Excersices", exerciseTodays));
//        list.add(new Today(R.drawable.run_image, "70%", "Excersices", exerciseTodays));
//        return list;
//    }
}