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


import java.util.ArrayList;
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
        holder.textView1.setText(diary.getEntryMood());
        holder.textView2.setText(diary.getEntryTime());

        String [] diaryActivities = diary.getEntryActivities().split(",");

        String result = "";
        for(int i = 0; i < diaryActivities.length; i += 1){

            result += diaryActivities[i];
            if(i < diaryActivities.length - 1)
                result += " \u25CF ";
        }
        result = result.substring(1,result.length()-1);
        holder.textView3.setText(result);
        holder.imageView.setImageResource(diary.getImageLocation());
    }

    @Override
    public int getItemCount() {
        return diaryList != null?  diaryList.size(): 0;
    }
    public class DiaryEntriesViewHolder extends RecyclerView.ViewHolder{
        public TextView textView1, textView2, textView3;
        public ImageView imageView;
        public DiaryEntriesViewHolder(@NonNull View itemView) {
            super(itemView);
            textView1 = itemView.findViewById(R.id.textView4);
            textView2 = itemView.findViewById(R.id.textView5);
            textView3 = itemView.findViewById(R.id.textView6);
            imageView = itemView.findViewById(R.id.imageView2);
        }
    }
}