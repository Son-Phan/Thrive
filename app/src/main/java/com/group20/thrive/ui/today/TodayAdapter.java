package com.group20.thrive.ui.today;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.group20.thrive.R;
import com.group20.thrive.database.Diary;

import java.util.List;

public class TodayAdapter extends RecyclerView.Adapter<TodayAdapter.TodayAdapterViewHolder>{

    public TodayAdapter(Context context) {
        this.context = context;
    }


    protected Context context;

    public void setDiaryList(List<Diary> diaryList) {
        this.diaryList = diaryList;
    }

    protected List<Diary> diaryList;

    @NonNull
    @Override
    public TodayAdapterViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.listvew_today, parent, false);
        return new TodayAdapterViewHolder(view);
    }

    @Override
    public int getItemCount() {
        return diaryList != null? diaryList.size(): 0;
    }

    @Override
    public void onBindViewHolder(@NonNull TodayAdapterViewHolder holder, int position) {
        Diary today = diaryList.get(position);
        if (today == null){
            return;
        }
        holder.textView.setText(today.getEntryActivities());
        holder.textView1.setText("60%");
        holder.imageView.setImageResource(R.drawable.img);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(context, RecyclerView.HORIZONTAL, false);
        holder.recyclerView.setLayoutManager(linearLayoutManager);
        ExerciseTodayAdapter exerciseTodayAdapter = new ExerciseTodayAdapter();
        exerciseTodayAdapter.setDiaryList(diaryList);
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
