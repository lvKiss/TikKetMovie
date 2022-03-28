package com.example.ticketmovie.movieapp.activities;

import android.annotation.TargetApi;
import android.os.Build;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

import com.example.lib.Model.PhimModel;
import com.example.ticketmovie.R;
import com.pierfrancescosoffritti.androidyoutubeplayer.core.player.YouTubePlayer;
import com.pierfrancescosoffritti.androidyoutubeplayer.core.player.listeners.AbstractYouTubePlayerListener;
import com.pierfrancescosoffritti.androidyoutubeplayer.core.player.views.YouTubePlayerView;

import android.webkit.WebChromeClient;
import android.webkit.PermissionRequest;
import android.webkit.WebView;
import android.widget.TextView;


public class TrailerMovieActivity extends AppCompatActivity {
    public YouTubePlayerView youTubePlayerView;
    TextView thongtin;
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.trailer_movie);
        PhimModel phimModel = (PhimModel) getIntent().getSerializableExtra("phimModel");
        youTubePlayerView=findViewById(R.id.abc);
        getLifecycle().addObserver(youTubePlayerView);
        String trailer = MovieDetailActivity.a.split("!!!")[0];
        String thongtinphim = MovieDetailActivity.a.split("!!!")[1];
        thongtin = (TextView) findViewById(R.id.thongtinphim);
        thongtin.setText(thongtinphim);
        youTubePlayerView.addYouTubePlayerListener(new AbstractYouTubePlayerListener() {
            @Override
            public void onReady(YouTubePlayer youTubePlayer) {
                youTubePlayer.loadVideo(trailer, 0);
            }
        });
    }
}
