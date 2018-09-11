package com.example.kapil.movie_app;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.VideoView;

import com.example.kapil.movie_app.recyclerView.movies.Movies;
import com.example.kapil.movie_app.youtubePlayer.YoutubeConfig;
import com.example.kapil.movie_app.youtubePlayer.YoutubeView;
import com.google.android.youtube.player.YouTubeBaseActivity;
import com.google.android.youtube.player.YouTubeInitializationResult;
import com.google.android.youtube.player.YouTubePlayer;
import com.google.android.youtube.player.YouTubePlayerView;
import com.squareup.picasso.Picasso;

import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.List;

public class Detailed_Page extends YouTubeBaseActivity {


    public TextView tv_title;
    public TextView tv_year;
    public TextView tv_rating;
    public TextView tv_reviews;
    public TextView tv_genre;
    public TextView tv_duration;
    public TextView tv_summary;
    private ImageView img_thumb;
    private ImageView thumbnailImage;
    private Button detail_button;
    Movies m;


    private static final String TAG = "Detailed_Page";


//    private YouTubePlayerView mYouTubePlayerView;
//    YouTubePlayer.OnInitializedListener mOnInitializedListner;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detailed__page);

        Log.d(TAG, "onCreate: Starting.");


        tv_title=findViewById(R.id.detail_title);
        tv_year = findViewById(R.id.detail_year);
        tv_rating= findViewById(R.id.detail_rating);
        tv_reviews=findViewById(R.id.detail_review);
        tv_genre = findViewById(R.id.detail_genre);
        tv_duration = findViewById(R.id.detail_duration);
        tv_summary = findViewById(R.id.detail_summary);
        thumbnailImage = findViewById(R.id.detail_image);
        detail_button= findViewById(R.id.detail_button);
        img_thumb = findViewById(R.id.img_thumb);


//        mYouTubePlayerView = findViewById(R.id.youtube);
//
//        mOnInitializedListner = new YouTubePlayer.OnInitializedListener() {
//            @Override
//            public void onInitializationSuccess(YouTubePlayer.Provider provider, YouTubePlayer youTubePlayer, boolean b) {
//
//                Log.d(TAG, "onInitializationSuccess: Done Initialize");
//
//                youTubePlayer.loadVideo(m.VideoLink);
//            }
//
//            @Override
//            public void onInitializationFailure(YouTubePlayer.Provider provider, YouTubeInitializationResult youTubeInitializationResult) {
//
//                Log.d(TAG, "onInitializationFailure: Failed to Initialize");
//            }
//        };

        detail_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {



                Log.d(TAG, "onClick: Initializing YouTube Player");
//              mYouTubePlayerView.initialize(YoutubeConfig.getApiKey(),mOnInitializedListner);
//
//              mYouTubePlayerView.setVisibility(View.VISIBLE);

              Intent intent = new Intent(Detailed_Page.this, YoutubeView.class);
              intent.putExtra("Movies_Video", m);
              startActivity(intent);
            }
        });


        Intent intent = getIntent();
        m = intent.getParcelableExtra("movie_name");


        Picasso.with(this)
                .load(m.ThumbnailImage)
                .into(thumbnailImage);

        tv_year.setText(String.valueOf(m.Year));

        tv_rating.setText(String.valueOf(m.Rating));


        NumberFormat f = NumberFormat.getInstance();

        Picasso.with(this)
                .load("https://img.youtube.com/vi/"+m.VideoLink+"/0.jpg")
                .into(img_thumb);


//        tv_reviews.setText(String.valueOf("Based on" + f.format(m.Reviews) + "reviews"));




        tv_genre.setText(m.Genre);

        tv_duration.setText(m.Duration);

        tv_summary.setText(m.Summary);




    }
}
