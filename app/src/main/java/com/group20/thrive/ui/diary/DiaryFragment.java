package com.group20.thrive.ui.diary;

import android.content.Intent;
import android.graphics.Paint;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CalendarView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import com.group20.thrive.R;
import com.group20.thrive.databinding.FragmentDiaryBinding;

public class DiaryFragment extends Fragment {

    private DiaryViewModel DiaryViewModel;
    private FragmentDiaryBinding binding;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        DiaryViewModel =
                new ViewModelProvider(this).get(DiaryViewModel.class);

        binding = FragmentDiaryBinding.inflate(inflater, container, false);
        View root = binding.getRoot();

        return root;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        TextView quoteTitle = view.findViewById(R.id.quoteTitle);
        quoteTitle.setPaintFlags(quoteTitle.getPaintFlags() | Paint.UNDERLINE_TEXT_FLAG);

        CalendarView calendarView = view.findViewById(R.id.calendarView);
        calendarView.setOnDateChangeListener((calendarView1, year, month, dayOfMonth) -> {
            Intent intent = new Intent(getActivity(), DiaryEntriesActivity.class);
            intent.putExtra("year", year);
            intent.putExtra("month", month+1); // Jan = 0 -> Dec = 11
            intent.putExtra("dayOfMonth", dayOfMonth);
            startActivity(intent);
        });
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}