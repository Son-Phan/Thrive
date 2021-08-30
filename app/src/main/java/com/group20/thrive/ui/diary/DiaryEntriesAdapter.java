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
import com.group20.thrive.ui.today.ExerciseToday;
import com.group20.thrive.ui.today.ExerciseTodayAdapter;
import com.group20.thrive.ui.today.Today;


import java.util.List;

public class DiaryEntriesAdapter extends RecyclerView.Adapter<DiaryEntriesAdapter.DiaryEntriesViewHolder> {

    protected List<DiaryEntriesProperties> diaryEntriesPropertiesList;
    protected Context context;
    public DiaryEntriesAdapter(Context context) {
        this.context = context;
    }
    public void setData(List<DiaryEntriesProperties> list){
        this.diaryEntriesPropertiesList = list;
        notifyDataSetChanged();
    }
    @NonNull
    @Override
    public DiaryEntriesAdapter.DiaryEntriesViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.fragment_activity_in_diary_page, parent, false);

        return new DiaryEntriesViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull DiaryEntriesViewHolder holder, int position) {
        DiaryEntriesProperties diaryEntriesProperties= diaryEntriesPropertiesList.get(position);
        if(diaryEntriesProperties == null){
            return;
        }
        holder.textView1.setText(diaryEntriesProperties.getDay());
        holder.textView2.setText(diaryEntriesProperties.getTime());
        holder.textView3.setText(diaryEntriesProperties.getActivity());
    }

    @Override
    public int getItemCount() {
        return diaryEntriesPropertiesList != null?  diaryEntriesPropertiesList.size(): 0;
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