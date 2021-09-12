package com.group20.thrive.ui.diary;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;

import com.group20.thrive.R;
import com.group20.thrive.ui.plans.PlansViewModel;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

public class DiaryEntriesActivity extends AppCompatActivity {
    private RecyclerView recyclerView;
    private DiaryEntriesAdapter diaryEntriesAdapter;
    private DiaryViewModel diaryViewModel;
    private String date = "";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_diary_entries);

        Intent intent = getIntent();
        int year = intent.getIntExtra("year", 2021);
        int month = intent.getIntExtra("month", 10);
        int dayOfMonth = intent.getIntExtra("dayOfMonth", 22);

        date = "";
        if(month < 10){
            date = String.format(Locale.ENGLISH,"%d/0%d/%d", dayOfMonth, month, year);
        }
        else
            date = String.format(Locale.ENGLISH,"%d/%d/%d", dayOfMonth, month, year);

        setTitle(date);

        ActionBar actionBar = getSupportActionBar();
        assert actionBar != null;
        actionBar.setDisplayHomeAsUpEnabled(true);
        recyclerView = findViewById(R.id.recyclerview_in_diary_entries);
        diaryEntriesAdapter = new DiaryEntriesAdapter(this);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this, RecyclerView.VERTICAL, false);
        recyclerView.setLayoutManager(linearLayoutManager);
        diaryViewModel = new ViewModelProvider.AndroidViewModelFactory(this.getApplication()).create(DiaryViewModel.class);

        diaryViewModel.getAllEntries(date).observe(this, newData -> {
            diaryEntriesAdapter.setDiaryList(newData);
            diaryEntriesAdapter.notifyDataSetChanged();
            System.out.println(newData);
        });
        recyclerView.setAdapter(diaryEntriesAdapter);
        Intent intent_1 = new Intent(this,SurveyMoodActivity.class);
        Button entryBtt = (Button) findViewById(R.id.addEntry_in_diary_entries);
        entryBtt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                intent_1.putExtra("Date", date);
                startActivity(intent_1);
            }
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

}