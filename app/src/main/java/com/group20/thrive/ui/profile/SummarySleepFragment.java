package com.group20.thrive.ui.profile;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.group20.thrive.R;
import com.jjoe64.graphview.GraphView;
import com.jjoe64.graphview.series.DataPoint;
import com.jjoe64.graphview.series.LineGraphSeries;

public class SummarySleepFragment extends Fragment {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_summary_sleep, container, false);

        GraphView graphView = view.findViewById(R.id.pieChart);

        LineGraphSeries<DataPoint> series = new LineGraphSeries<>(new DataPoint[]{
                new DataPoint(0,4),
                new DataPoint(1,3),
                new DataPoint(2,5),
                new DataPoint(4,7),
                new DataPoint(7,6)
        });

        graphView.setTitle("temp graph view");
        graphView.setTitleColor(R.color.black);
        graphView.setTitleTextSize(36);
        graphView.addSeries(series);

        return view;
    }
}