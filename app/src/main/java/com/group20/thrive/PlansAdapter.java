package com.group20.thrive;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.group20.thrive.database.Plan;

import java.util.ArrayList;
import java.util.List;

public class PlansAdapter extends BaseAdapter {
    private Context context;
    private int layout;

    public void setExerciseList(List<Plan> exerciseList) {
        this.exerciseList = exerciseList;
    }

    private List<Plan> exerciseList = new ArrayList<>();

    public PlansAdapter(Context context, int layout) {
        this.context = context;
        this.layout = layout;

    }


    @Override
    public int getCount() {
        return exerciseList.size();
    }

    @Override
    public Object getItem(int i) {
        return null;
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        view = inflater.inflate(layout, null);

        view = init(i, view);
        Animation animation = AnimationUtils.loadAnimation(context, R.anim.animation_scale);
        view.startAnimation(animation);

        return view;
    }

    protected View init(int i, View view){
        TextView txtTitleName = (TextView) view.findViewById(R.id.textviewTitleName);
        ImageView imagePicture = (ImageView) view.findViewById(R.id.imageviewPicture);
        Plan exercise = exerciseList.get(i);
        txtTitleName.setText(exercise.getPlanName());
        imagePicture.setImageResource(exercise.getImageLocation());
        return view;
    }
}
