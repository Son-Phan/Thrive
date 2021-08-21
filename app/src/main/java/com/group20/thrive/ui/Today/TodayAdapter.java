package com.group20.thrive.ui.Today;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.group20.thrive.R;

import java.util.List;

public class TodayAdapter extends RecyclerView.Adapter<TodayAdapter.TodayAdapterViewHolder>{

    public TodayAdapter(Context context) {
        this.context = context;
    }


    public void setData(List<Today> list){
        this.todayList = list;
        notifyDataSetChanged();
    }
    protected Context context;
    protected List<Today> todayList;

    @NonNull
    @Override
    public TodayAdapterViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.listvew_today, parent, false);
        return new TodayAdapterViewHolder(view);
    }

    @Override
    public int getItemCount() {
        return todayList != null? todayList.size(): 0;
    }

    @Override
    public void onBindViewHolder(@NonNull TodayAdapterViewHolder holder, int position) {
        Today today = todayList.get(position);
        if (today == null){
            return;
        }
        holder.textView.setText(today.getTitleName());
        holder.textView1.setText(today.getPercentages());
        holder.imageView.setImageResource(today.getId());
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(context, RecyclerView.HORIZONTAL, false);
        holder.recyclerView.setLayoutManager(linearLayoutManager);
        ExerciseTodayAdapter exerciseTodayAdapter = new ExerciseTodayAdapter();
        exerciseTodayAdapter.setData(today.getExerciseTodayList());
        holder.recyclerView.setAdapter(exerciseTodayAdapter);
    }

    public class TodayAdapterViewHolder extends RecyclerView.ViewHolder{

        public TextView textView, textView1;
        public ImageView imageView;
        public ProgressBar progressBar;
        public RecyclerView recyclerView;
        public TodayAdapterViewHolder(@NonNull View itemView) {
            super(itemView);
            textView = itemView.findViewById(R.id.textviewNameExercises);
            progressBar = itemView.findViewById(R.id.progress_bar);
            textView1 = itemView.findViewById(R.id.textviewPercentage);
            imageView = itemView.findViewById(R.id.imageviewPicture_run);
            recyclerView = itemView.findViewById(R.id.recyclerview);
        }
    }

}
