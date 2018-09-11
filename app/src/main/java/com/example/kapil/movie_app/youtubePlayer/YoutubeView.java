package com.example.kapil.movie_app.youtubePlayer;

import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import com.example.kapil.movie_app.R;
import com.example.kapil.movie_app.recyclerView.movies.Movies;
import com.google.android.youtube.player.YouTubeBaseActivity;
import com.google.android.youtube.player.YouTubeInitializationResult;
import com.google.android.youtube.player.YouTubePlayer;
import com.google.android.youtube.player.YouTubePlayerView;
import com.google.android.youtube.player.internal.m;

import java.util.ArrayList;
import java.util.List;

import static android.content.ContentValues.TAG;

public class YoutubeView extends YouTubeBaseActivity {

    private View tv_youTube;

    private static final String TAG = "YoutubeView";

    private YouTubePlayerView mYouTubePlayerView;
    YouTubePlayer.OnInitializedListener mOnInitializedListner;
    private Movies m;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_youtube_view);

        tv_youTube = findViewById(R.id.youtube_detail);

           setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_SENSOR_LANDSCAPE);


        m = getIntent().getParcelableExtra("Movies_Video");
        tv_youTube.setVisibility(View.VISIBLE);
        Log.d(TAG, "onCreate: Video Started");


        mYouTubePlayerView = findViewById(R.id.youtube_detail);

        mOnInitializedListner = new YouTubePlayer.OnInitializedListener() {
            @Override
            public void onInitializationSuccess(YouTubePlayer.Provider provider, YouTubePlayer youTubePlayer, boolean b) {

                Log.d(TAG, "onInitializationSuccess: Done Initialize");

                youTubePlayer.loadVideo(m.VideoLink);
            }

            @Override
            public void onInitializationFailure(YouTubePlayer.Provider provider, YouTubeInitializationResult youTubeInitializationResult) {

                Log.d(TAG, "onInitializationFailure: Failed to Initialize");
            }
        };


        mYouTubePlayerView.initialize(YoutubeConfig.getApiKey(),mOnInitializedListner);




    }
}
