package com.group20.thrive.ui.diary;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;

import com.group20.thrive.R;

import java.util.Locale;

public class DiaryEntriesActivity extends AppCompatActivity {

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