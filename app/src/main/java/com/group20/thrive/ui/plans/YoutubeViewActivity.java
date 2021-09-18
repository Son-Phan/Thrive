package com.group20.thrive.ui.plans;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.webkit.WebChromeClient;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.MediaController;

import com.group20.thrive.R;

public class YoutubeViewActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ActionBar actionBar = getSupportActionBar();
        assert actionBar != null;
        actionBar.setDisplayHomeAsUpEnabled(true);
        setContentView(R.layout.activity_youtube_view);
        Intent intent = getIntent();
        String video = intent.getStringExtra("video");
        WebView videoWeb;
        videoWeb = findViewById(R.id.videoView);

        videoWeb.getSettings().setJavaScriptEnabled(true);
        videoWeb.getSettings().setDomStorageEnabled(true);
        videoWeb.setWebChromeClient(new WebChromeClient());
        videoWeb.loadData(new YouTubeVideos(video).getVideoUrl(),  "text/html" , "utf-8" );

        videoWeb.setWebViewClient(new loadWebView());
    }
    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        if (item.getItemId() == android.R.id.home) {
            onBackPressed();
            return true;
        }
        return super.onOptionsItemSelected(item);
    }
    private class loadWebView extends WebViewClient {
        @Override
        public boolean shouldOverrideUrlLoading(WebView view, String url) {
            view.loadUrl(url);
            return true;
        }
    }

}