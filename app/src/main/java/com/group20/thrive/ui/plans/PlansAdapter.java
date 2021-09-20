package com.group20.thrive.ui.plans;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.group20.thrive.R;
import com.group20.thrive.database.Plan;

import java.util.ArrayList;
import java.util.List;

public class PlansAdapter extends BaseAdapter {
    private Context context;
    private int layout;

    public void setPlanList(List<Plan> planList) {
        this.planList = planList;
    }

    private List<Plan> planList = new ArrayList<>();

    public PlansAdapter(Context context, int layout) {
        this.context = context;
        this.layout = layout;

    }

    @Override
    public int getCount() {
        return planList.size();
    }

    @Override
    public Plan getItem(int i) {
        return planList.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
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
        TextView planName = view.findViewById(R.id.planName);
        TextView planLen = view.findViewById(R.id.planLen);
        TextView planDesc = view.findViewById(R.id.planDesc);

        Plan plan = planList.get(i);

        planName.setText(plan.getPlanName());
        planLen.setText(String.valueOf(plan.getPlanLength()));

        if (plan.getPlanDescription().length() > 40) {
            String desc = plan.getPlanDescription().substring(0,40) + "...";
            planDesc.setText(desc);
        }
        else {
            planDesc.setText(plan.getPlanDescription());
        }

        return view;
    }
}
