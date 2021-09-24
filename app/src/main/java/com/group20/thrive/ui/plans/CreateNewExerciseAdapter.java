package com.group20.thrive.ui.plans;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.group20.thrive.R;
import com.group20.thrive.database.Activity;
import com.group20.thrive.database.Lesson;

import java.util.ArrayList;
import java.util.List;

public class CreateNewExerciseAdapter extends
        RecyclerView.Adapter<CreateNewExerciseAdapter.ViewHolder> {



    private List<Activity> categoryExerciseLists  = new ArrayList<>();
    Context context;
    private RadioGroup lastCheckedRadioGroup = null;

    public CreateNewExerciseAdapter(Context context) {

        this.context = context;
    }
    public void setCategoryExerciseLists(List<Activity> categoryExerciseLists) {

        this.categoryExerciseLists = categoryExerciseLists;

    }
    @NonNull
    @Override
    public CreateNewExerciseAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.activity_choice_radio_group, parent, false);
        ViewHolder viewHolder = new ViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull CreateNewExerciseAdapter.ViewHolder holder, int position) {
        Activity categoryExerciseList = categoryExerciseLists.get(position);
        holder.category_exercise.setText(categoryExerciseList.getActivityName());
        holder.category_exercise.setTextSize(30);
        int id = (position+1)*100;
        RadioButton rb = new RadioButton(CreateNewExerciseAdapter.this.context);
        rb.setId(id++);
        rb.setText(categoryExerciseList.getActivityName());
        rb.setTextSize(30);
        System.out.println("trungasdasdas");
        holder.exerciseRadio.addView(rb);
    }

    @Override
    public int getItemCount() {
        return this.categoryExerciseLists.size();
    }
    public class ViewHolder extends RecyclerView.ViewHolder {

        public TextView category_exercise;
        public RadioGroup exerciseRadio;

        public ViewHolder(View view) {
            super(view);
            category_exercise = (TextView) view.findViewById(R.id.category_exercise);
            exerciseRadio = (RadioGroup) view.findViewById(R.id.exercise_radio);

            exerciseRadio.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
                @Override
                public void onCheckedChanged(RadioGroup radioGroup, int i) {
                    //since only one package is allowed to be selected
                    //this logic clears previous selection
                    //it checks state of last radiogroup and
                    // clears it if it meets conditions
                    if (lastCheckedRadioGroup != null
                            && lastCheckedRadioGroup.getCheckedRadioButtonId()
                            != radioGroup.getCheckedRadioButtonId()
                            && lastCheckedRadioGroup.getCheckedRadioButtonId() != -1) {
                        lastCheckedRadioGroup.clearCheck();


                    }
                    lastCheckedRadioGroup = radioGroup;

                }
            });
        }
    }
}
