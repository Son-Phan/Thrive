package com.group20.thrive.ui.plans;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.room.Room;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.group20.thrive.ActivityInfoActivity;
import com.group20.thrive.R;
import com.group20.thrive.database.Activity;
import com.group20.thrive.database.ActivityRecord;
import com.group20.thrive.database.ActivityRecordDao;
import com.group20.thrive.database.Plan;
import com.group20.thrive.database.PlanDao;
import com.group20.thrive.database.ThriveDatabase;

import java.util.concurrent.Executors;

public class CreateNewPlanActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_new_plan);
        ActionBar actionBar = getSupportActionBar();
        assert actionBar != null;
        actionBar.setDisplayHomeAsUpEnabled(true);
        EditText planName = findViewById(R.id.planName);
        EditText planLen = findViewById(R.id.planLen);
        EditText planDesc = findViewById(R.id.planDesc);
        Button save_res = findViewById(R.id.save_result);
        save_res.setOnClickListener(view -> {
            boolean completely = true;
            if(TextUtils.isEmpty(planName.getText().toString())){
                completely = false;
                notifyFillInfo("plan name box");
            }
            if(TextUtils.isEmpty(planLen.getText().toString()))
            {
                completely = false;
                notifyFillInfo("plan last box");
            }
            if(TextUtils.isEmpty(planDesc.getText().toString())){
                completely = false;
                notifyFillInfo("plan description box");
            }
            if(completely)
                onActivityClick(planName.getText().toString(), planLen.getText().toString(), planDesc.getText().toString());
        });

    }
    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        if (item.getItemId() == android.R.id.home) {
            onBackPressed();
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
    public void onActivityClick(String name, String len, String desc) {

        addDatabase(name,len,desc);
        onBackPressed();
    }
    public void addDatabase(String name, String len, String desc){
        Executors.newSingleThreadExecutor().execute(() -> {
            ThriveDatabase db = Room.databaseBuilder(getApplicationContext(), ThriveDatabase.class,
                    ThriveDatabase.THRIVE_DATABASE_NAME).build();
            PlanDao planDao = db.planDao();
            planDao.addPlan(new Plan(name,"EM",0,Integer.parseInt(len),desc));
        });
    }
    public void notifyFillInfo(String box) {
        Toast.makeText(this, "Please fill the information in " + box, Toast.LENGTH_SHORT).show();
    }
}