package com.group20.thrive.ui.diary;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;

import com.group20.thrive.R;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

public class DiaryEntriesActivity extends AppCompatActivity {
    private RecyclerView recyclerView;
    private DiaryEntriesAdapter diaryEntriesAdapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_diary_entries);

        Intent intent = getIntent();
        int year = intent.getIntExtra("year", 2021);
        int month = intent.getIntExtra("month", 10);
        int dayOfMonth = intent.getIntExtra("dayOfMonth", 22);

        String date = String.format(Locale.ENGLISH,"%d/%d/%d", dayOfMonth, month, year);
        setTitle(date);

        ActionBar actionBar = getSupportActionBar();
        assert actionBar != null;
        actionBar.setDisplayHomeAsUpEnabled(true);
        recyclerView = findViewById(R.id.recyclerview_in_diary_entries);
        diaryEntriesAdapter = new DiaryEntriesAdapter(this);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this, RecyclerView.VERTICAL, false);
        recyclerView.setLayoutManager(linearLayoutManager);
        diaryEntriesAdapter.setData(getDiaryEntriesProperties());
        recyclerView.setAdapter(diaryEntriesAdapter);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        if (item.getItemId() == android.R.id.home) {
            onBackPressed();
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
    private List<DiaryEntriesProperties> getDiaryEntriesProperties(){
        List<DiaryEntriesProperties> list = new ArrayList<>();
        list.add(new DiaryEntriesProperties("29/08/202", "4:39 am", "Workout"));
        list.add(new DiaryEntriesProperties("29/08/202", "4:39 am", "Workout"));
        list.add(new DiaryEntriesProperties("29/08/202", "4:39 am", "Workout"));
        return list;
    }
}