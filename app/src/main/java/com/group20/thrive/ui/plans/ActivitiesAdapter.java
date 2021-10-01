package com.group20.thrive.ui.plans;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.group20.thrive.R;
import com.group20.thrive.database.Activity;

import java.util.ArrayList;
import java.util.List;

public class ActivitiesAdapter extends RecyclerView.Adapter<ActivitiesAdapter.ViewHolder>{

    private List<Activity> activities = new ArrayList<>();
    Context mContext;

    public void setActivities(List<Activity> newData) { activities = newData; }

    ActivitiesAdapter(Context mContext) {
        this.mContext = mContext;
    }

    @Override
    @NonNull
    public ActivitiesAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.recyclerview_activities, parent, false);
        ActivitiesAdapter.ViewHolder viewHolder = new ActivitiesAdapter.ViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull ActivitiesAdapter.ViewHolder holder, int position) {
        if (activities.get(position).getActivityType().equals("userActivity")) {
            holder.activityImage.setImageResource(R.drawable.thinking);
        } else if(activities.get(position).getActivityType().equals("exercise")) {
            holder.activityImage.setImageResource(R.drawable.running_icon);
        } else {
            holder.activityImage.setImageResource(R.drawable.meditation_icon);
        }
        holder.activityName.setText(activities.get(position).getActivityName());
        String lenText = activities.get(position).getActivityLen() + " min";
        holder.activityTime.setText(lenText);
    }

    @Override
    public int getItemCount() {
        return activities.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        public ImageView activityImage;
        public TextView activityName;
        public TextView activityTime;
        public CardView activity;

        public ViewHolder(View itemView) {
            super(itemView);
            activityImage = itemView.findViewById(R.id.activityImage);
            activityName = itemView.findViewById(R.id.activityName);
            activityTime = itemView.findViewById(R.id.activityTime);
            activity = itemView.findViewById(R.id.activity);
            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View view) {
            int position = getLayoutPosition();
            if (mContext instanceof AssignActivityActivity) {
                ((AssignActivityActivity)mContext).onItemClick(activities.get(position));
            }
        }
    }
}