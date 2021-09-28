package com.group20.thrive.ui.profile;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.github.mikephil.charting.charts.BarChart;
import com.github.mikephil.charting.components.XAxis;
import com.github.mikephil.charting.data.BarData;
import com.github.mikephil.charting.data.BarDataSet;
import com.github.mikephil.charting.data.BarEntry;
import com.github.mikephil.charting.formatter.IndexAxisValueFormatter;
import com.github.mikephil.charting.interfaces.datasets.IBarDataSet;
import com.group20.thrive.R;

import java.util.ArrayList;
import java.util.List;

public class SummaryMeditationFragment extends Fragment {

    private com.group20.thrive.ui.profile.ProfileViewModel ProfileViewModel;
    private BarChart chart;
    private TextView noData;
    private TextView streakCount;

    private static final String PREF_NAME = "MyPrefs";

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_summary_meditation, container, false);

        ProfileViewModel =
                new ViewModelProvider(this).get(com.group20.thrive.ui.profile.ProfileViewModel.class);

        streakCount = view.findViewById(R.id.meditationStreakCount);
        TextView averageTime = view.findViewById(R.id.meditationAverageTime);
        TextView goalTime = view.findViewById(R.id.meditationGoalTime);

        ProfileViewModel.getUser().observe(getActivity(), newData -> {
            String goal = newData.getExerciseGoal() + " min";
            goalTime.setText(goal);
        });

        ProfileViewModel.getRecordsOfActivityType("meditation").observe(getActivity(), newData -> {
            int sum = 0;
            for (int i = 0; i < newData.size(); i++) { sum += newData.get(i).getRecordLength(); }
            float avgTime = (float) sum / newData.size() / 60;
            String text = round(avgTime, 1) + " min";
            averageTime.setText(text);
        });

        return view;
    }

    @Override
    public void onStart() {
        super.onStart();

        SharedPreferences sharedPrefs = getActivity().getSharedPreferences(PREF_NAME, Context.MODE_PRIVATE);
        streakCount.setText(String.valueOf(sharedPrefs.getInt("meditationStreak", 0)));
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        chart = view.findViewById(R.id.meditationBarChart);

        chart.getDescription().setEnabled(false);

        noData = view.findViewById(R.id.noData);

        ProfileViewModel.getRecordsOfActivityTypeInAWeek("meditation").observe(getActivity(), this::setUpGraph);
    }

    public void setUpGraph(List<Record> recordList) {

        if (recordList.isEmpty()) { noData.setVisibility(View.VISIBLE); }

        List<String> xAxisValues = new ArrayList<>();

        for (int i = recordList.size()-1; i > -1; i--) {
            xAxisValues.add(recordList.get(i).getRecordTime().substring(0, 5));
        }

        XAxis xAxis = chart.getXAxis();
        xAxis.setValueFormatter(new IndexAxisValueFormatter(xAxisValues));
        xAxis.setPosition(XAxis.XAxisPosition.BOTTOM);
        xAxis.setDrawGridLines(false);
        ArrayList<BarEntry> values = new ArrayList<>();

        for (int i = 0; i < recordList.size(); i++) {
            float val = (float) recordList.get(i).getRecordLength() / 60;
            values.add(new BarEntry(i, val));
        }

        BarDataSet set1;

        if (chart.getData() != null &&
                chart.getData().getDataSetCount() > 0) {
            set1 = (BarDataSet) chart.getData().getDataSetByIndex(0);
            set1.setValues(values);
            chart.getData().notifyDataChanged();
            chart.notifyDataSetChanged();

        } else {
            set1 = new BarDataSet(values, "minutes");

            int color = ContextCompat.getColor(getActivity(), android.R.color.holo_red_light);

            set1.setColor(color);

            ArrayList<IBarDataSet> dataSets = new ArrayList<>();
            dataSets.add(set1);

            BarData data = new BarData(dataSets);
            data.setValueTextSize(10f);
            data.setBarWidth(0.9f);

            chart.setData(data);
            chart.invalidate();
        }
    }

    // https://stackoverflow.com/a/35833800/13728158
    public static float round(float number, int scale) {
        int pow = 10;
        for (int i = 1; i < scale; i++)
            pow *= 10;
        float tmp = number * pow;
        return ( (float) ( (int) ((tmp - (int) tmp) >= 0.5f ? tmp + 1 : tmp) ) ) / pow;
    }
}