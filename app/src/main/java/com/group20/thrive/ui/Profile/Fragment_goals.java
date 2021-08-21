package com.group20.thrive.ui.Profile;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.group20.thrive.R;
import com.group20.thrive.ui.Today.ExerciseToday;
import com.group20.thrive.ui.Today.Today;

import java.util.ArrayList;
import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link Fragment_goals#newInstance} factory method to
 * create an instance of this fragment.
 */
public class Fragment_goals extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public Fragment_goals() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment fragment_goals.
     */
    // TODO: Rename and change types and number of parameters
    public static Fragment_goals newInstance(String param1, String param2) {
        Fragment_goals fragment = new Fragment_goals();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }


    GoalsAdapter profileAdapter;
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
        View view = inflater.inflate(R.layout.fragment_goals, container, false);

//        todayAdapter = new TodayAdapter(inflater.getContext(), R.layout.listvew_today, todayArrayList);
//        lvToday.setAdapter(todayAdapter);
        recyclerView = view.findViewById(R.id.recyclerview_fragment_today);
        profileAdapter = new GoalsAdapter(getActivity());
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getActivity(), RecyclerView.VERTICAL, false);
        recyclerView.setLayoutManager(linearLayoutManager);
        profileAdapter.setData(getListToday());
        recyclerView.setAdapter(profileAdapter);
        return view;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
    }

    private List<Today> getListToday(){
        List<Today> list = new ArrayList<>();
        List<ExerciseToday> exerciseTodays = new ArrayList<>();
        exerciseTodays.add(new ExerciseToday(R.drawable.img, "Push up", "70 minutes"));
        exerciseTodays.add(new ExerciseToday(R.drawable.img, "Push up", "70 minutes"));
        exerciseTodays.add(new ExerciseToday(R.drawable.img, "Push up", "70 minuter"));
        exerciseTodays.add(new ExerciseToday(R.drawable.img, "Push up", "70 minutes"));
        exerciseTodays.add(new ExerciseToday(R.drawable.img, "Push up", "70 minutes"));
        exerciseTodays.add(new ExerciseToday(R.drawable.img, "Push up", "70 minutes"));
        exerciseTodays.add(new ExerciseToday(R.drawable.img, "Push up", "70 minuter"));
        exerciseTodays.add(new ExerciseToday(R.drawable.img, "Push up", "70 minutes"));
        list.add(new Today(R.drawable.run_image, "70%", "Excersices", exerciseTodays));
        list.add(new Today(R.drawable.run_image, "70%", "Excersices", exerciseTodays));
        list.add(new Today(R.drawable.run_image, "70%", "Excersices", exerciseTodays));
        list.add(new Today(R.drawable.run_image, "70%", "Excersices", exerciseTodays));
        list.add(new Today(R.drawable.run_image, "70%", "Excersices", exerciseTodays));
        return list;
    }
}