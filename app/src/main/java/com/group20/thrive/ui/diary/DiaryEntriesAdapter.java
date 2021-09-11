package com.group20.thrive.ui.diary;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.fragment.app.FragmentActivity;
import androidx.recyclerview.widget.RecyclerView;

import com.group20.thrive.R;
import com.group20.thrive.database.Diary;
import com.group20.thrive.ui.today.ExerciseToday;
import com.group20.thrive.ui.today.ExerciseTodayAdapter;
import com.group20.thrive.ui.today.Today;


import java.util.List;

public class DiaryEntriesAdapter extends RecyclerView.Adapter<DiaryEntriesAdapter.DiaryEntriesViewHolder> {

    public void setDiaryList(List<Diary> diaryList) {
        this.diaryList = diaryList;
    }

    protected List<Diary> diaryList;
    protected Context context;
    public DiaryEntriesAdapter(Context context) {
        this.context = context;
    }

    @NonNull
    @Override
    public DiaryEntriesAdapter.DiaryEntriesViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.fragment_activity_in_diary_page, parent, false);

        return new DiaryEntriesViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull DiaryEntriesViewHolder holder, int position) {
        Diary diary = diaryList.get(position);
        if(diary == null){
            return;
        }
        holder.textView1.setText(diary.getEntryDate());
        holder.textView2.setText(Integer.toString(diary.getActivityDuration()));
        holder.textView3.setText(diary.getEntryActivities());
    }

    @Override
    public int getItemCount() {
        return diaryList != null?  diaryList.size(): 0;
    }
    public class DiaryEntriesViewHolder extends RecyclerView.ViewHolder{
        public TextView textView1, textView2, textView3;
        public DiaryEntriesViewHolder(@NonNull View itemView) {
            super(itemView);
            textView1 = itemView.findViewById(R.id.textView4);
            textView2 = itemView.findViewById(R.id.textView5);
            textView3 = itemView.findViewById(R.id.textView6);

        }
    }
}