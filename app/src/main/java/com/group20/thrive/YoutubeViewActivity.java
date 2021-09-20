package com.group20.thrive;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.room.Room;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.webkit.WebChromeClient;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Button;
import android.widget.MediaController;
import android.widget.Toast;

import com.group20.thrive.ExerciseActivity;
import com.group20.thrive.R;
import com.group20.thrive.database.Activity;
import com.group20.thrive.database.ActivityRecord;
import com.group20.thrive.database.ActivityRecordDao;
import com.group20.thrive.database.ThriveDatabase;

import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.util.concurrent.Executors;

public class YoutubeViewActivity extends AppCompatActivity {

    private Activity activity;
    private long startTime;
    private long endTIme;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_youtube_view);

        setTitle("Meditation");

        Intent intent = getIntent();
        activity = (Activity) intent.getSerializableExtra("activity");
        String video = activity.getFileName();

        WebView videoWeb;
        videoWeb = findViewById(R.id.videoView);
        videoWeb.getSettings().setJavaScriptEnabled(true);
        videoWeb.getSettings().setDomStorageEnabled(true);
        videoWeb.setWebChromeClient(new WebChromeClient());
        videoWeb.loadData(video,  "text/html" , "utf-8" );

        videoWeb.setWebViewClient(new loadWebView());

        startTime = System.currentTimeMillis();

        Button finish = findViewById(R.id.finishBtn);
        finish.setOnClickListener(view1 -> {
            Toast.makeText(this,
                    "Congratulation! You have finished " + activity.getActivityName() + " meditation.",
                    Toast.LENGTH_SHORT).show();
            onBackPressed();
        });
    }

    private class loadWebView extends WebViewClient {
        @Override
        public boolean shouldOverrideUrlLoading(WebView view, String url) {
            view.loadUrl(url);
            return true;
        }
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        updateActivityRecord();
    }

    private void updateActivityRecord() {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        String date = ZonedDateTime.now(ZoneId.systemDefault()).format(formatter);
        int meditateTime = (int) (System.currentTimeMillis() - startTime) / 1000;
        Executors.newSingleThreadExecutor().execute(() -> {
            ThriveDatabase db = Room.databaseBuilder(getApplicationContext(), ThriveDatabase.class,
                    ThriveDatabase.THRIVE_DATABASE_NAME).build();
            ActivityRecordDao activityRecordDao = db.activityRecordDao();
            activityRecordDao.addRecord(new ActivityRecord(date, activity.getActivityId(), activity.getActivityType(), meditateTime));
        });
    }
}