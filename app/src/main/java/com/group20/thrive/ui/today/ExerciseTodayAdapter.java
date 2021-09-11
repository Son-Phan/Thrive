package com.group20.thrive.ui.today;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.group20.thrive.R;
import com.group20.thrive.database.Diary;

import java.util.List;

public class ExerciseTodayAdapter extends RecyclerView.Adapter<ExerciseTodayAdapter.ExerciseTodayViewHolder> {

    private List<Diary> diaryList;

    public List<Diary> getDiaryList() {
        return diaryList;
    }

    public void setDiaryList(List<Diary> diaryList) {
        this.diaryList = diaryList;
    }

    @NonNull
    @Override
    public ExerciseTodayViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_int_listview_exercises, parent, false);

        return new ExerciseTodayViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ExerciseTodayViewHolder holder, int position) {
        Diary diary = diaryList.get(position);
        if(diary == null){
            return;
        }
        holder.textView1.setText(diary.getEntryActivities());
        holder.textView2.setText(Integer.toString(diary.getActivityDuration()));
        holder.imageView.setImageResource(R.drawable.img);


    }

    @Override
    public int getItemCount() {
        return diaryList != null?  diaryList.size(): 0;
    }

    public class ExerciseTodayViewHolder extends RecyclerView.ViewHolder{
        private TextView textView1, textView2;
        private ImageView imageView;
        private Button button;
        public ExerciseTodayViewHolder(@NonNull View itemView) {
            super(itemView);
            textView1 = itemView.findViewById(R.id.textView1);
            textView2 = itemView.findViewById(R.id.textView2);
            imageView = itemView.findViewById(R.id.imageView1);
            button = itemView.findViewById(R.id.button1);
        }
    }
}
