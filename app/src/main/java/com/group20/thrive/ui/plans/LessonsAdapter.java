package com.group20.thrive.ui.plans;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.group20.thrive.R;
import com.group20.thrive.database.Lesson;

import java.util.ArrayList;
import java.util.List;

public class LessonsAdapter extends RecyclerView.Adapter<LessonsAdapter.ViewHolder>{

    private List<Lesson> lessons = new ArrayList<>();
    Context mContext;

    public void setLessons(List<Lesson> newData) { lessons = newData; }

    LessonsAdapter(Context mContext) {
        this.mContext = mContext;
    }

    @Override
    @NonNull
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.recyclerview_lessons, parent, false);
        ViewHolder viewHolder = new ViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull LessonsAdapter.ViewHolder holder, int position) {
        String txt = "Day " + lessons.get(position).getLessonDay();
        holder.lessonDay.setText(txt);
    }

    @Override
    public int getItemCount() {
        return lessons.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        public TextView lessonDay;

        public ViewHolder(View itemView) {
            super(itemView);
            lessonDay = itemView.findViewById(R.id.lessonDay);
            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View view) {
            int position = getLayoutPosition();
            if (mContext instanceof PlanActivity) {
                ((PlanActivity)mContext).updateActivityView(lessons.get(position).getLessonId());
            }
        }
    }
}
