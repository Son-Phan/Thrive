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

import java.util.List;

public class ExerciseTodayAdapter extends RecyclerView.Adapter<ExerciseTodayAdapter.ExerciseTodayViewHolder> {

    private List<ExerciseToday> exerciseTodays;

    public void setData(List<ExerciseToday> list){
        this.exerciseTodays = list;
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public ExerciseTodayViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_int_listview_exercises, parent, false);

        return new ExerciseTodayViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ExerciseTodayViewHolder holder, int position) {
        ExerciseToday exerciseToday = exerciseTodays.get(position);
        if(exerciseToday == null){
            return;
        }
        holder.textView1.setText(exerciseToday.getTitleName());
        holder.textView2.setText(exerciseToday.getDuration());
        holder.imageView.setImageResource(exerciseToday.getId());


    }

    @Override
    public int getItemCount() {
        return exerciseTodays != null?  exerciseTodays.size(): 0;
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
