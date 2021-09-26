package com.group20.thrive.ui.profile;

import android.graphics.Color;
import android.os.Bundle;
import android.text.SpannableString;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.fragment.app.Fragment;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.lifecycle.ViewModelProvider;

import com.github.mikephil.charting.animation.Easing;
import com.github.mikephil.charting.charts.PieChart;
import com.github.mikephil.charting.components.Legend;
import com.github.mikephil.charting.data.PieData;
import com.github.mikephil.charting.data.PieDataSet;
import com.github.mikephil.charting.data.PieEntry;
import com.github.mikephil.charting.formatter.PercentFormatter;
import com.github.mikephil.charting.utils.ColorTemplate;
import com.github.mikephil.charting.utils.MPPointF;
import com.group20.thrive.R;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SummaryDiaryFragment extends Fragment {

    private com.group20.thrive.ui.profile.ProfileViewModel ProfileViewModel;
    private PieChart chart;
    public TextView noData;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_summary_diary, container, false);

        ProfileViewModel =
                new ViewModelProvider(this).get(com.group20.thrive.ui.profile.ProfileViewModel.class);

        TextView diaryEntryCount = view.findViewById(R.id.diaryEntryCount);

        ProfileViewModel.getNumOfEntryDays().observe(getActivity(), newData -> diaryEntryCount.setText(String.valueOf(newData)));

        return view;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        chart = view.findViewById(R.id.pieChart);

        chart.setUsePercentValues(true);
        chart.getDescription().setEnabled(false);
        chart.setExtraOffsets(5, 10, 5, 5);

        chart.setDragDecelerationFrictionCoef(0.95f);

        chart.setCenterText(new SpannableString("Mood Count"));
        chart.setCenterTextSize(16f);

        chart.setDrawHoleEnabled(true);
        chart.setHoleColor(Color.TRANSPARENT);

        chart.setTransparentCircleColor(Color.WHITE);
        chart.setTransparentCircleAlpha(110);

        chart.setHoleRadius(58f);
        chart.setTransparentCircleRadius(61f);

        chart.setDrawCenterText(true);

        chart.setRotationAngle(0);
        // enable rotation of the chart by touch
        chart.setRotationEnabled(true);
        chart.setHighlightPerTapEnabled(true);

        chart.animateY(1400, Easing.EaseInOutQuad);

        Legend l = chart.getLegend();
        l.setVerticalAlignment(Legend.LegendVerticalAlignment.TOP);
        l.setHorizontalAlignment(Legend.LegendHorizontalAlignment.RIGHT);
        l.setOrientation(Legend.LegendOrientation.VERTICAL);
        l.setDrawInside(false);
        l.setXEntrySpace(7f);
        l.setYEntrySpace(0f);
        l.setYOffset(0f);

        // entry label styling
        chart.setEntryLabelColor(Color.WHITE);
        chart.setEntryLabelTextSize(11f);

        noData = view.findViewById(R.id.noData);

        ProfileViewModel.getMoodCount().observe(getActivity(), this::setData);
    }

    public void setData(List<MoodCount> moodCountList) {

        if (moodCountList.isEmpty()) { noData.setVisibility(View.VISIBLE); }

        List<String> moodList = Arrays.asList("awful", "bad", "medium", "good", "happy");

        ArrayList<PieEntry> values = new ArrayList<>();

        for (int i = 0; i < moodCountList.size(); i++) {
            values.add(new PieEntry((float) moodCountList.get(i).getMoodCount(), moodCountList.get(i).getMood()));
        }

        PieDataSet dataSet = new PieDataSet(values, "");
        dataSet.setSliceSpace(3f);
        dataSet.setIconsOffset(new MPPointF(0, 40));
        dataSet.setSelectionShift(5f);

        dataSet.setColors(ColorTemplate.COLORFUL_COLORS);

        PieData data = new PieData(dataSet);
        data.setValueFormatter(new PercentFormatter(chart));
        data.setValueTextSize(11f);
        data.setValueTextColor(Color.WHITE);
        chart.setData(data);

        chart.highlightValues(null);

        chart.invalidate();
    }
}