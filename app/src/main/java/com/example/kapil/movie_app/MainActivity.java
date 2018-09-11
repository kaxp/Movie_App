package com.example.kapil.movie_app;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

import com.example.kapil.movie_app.recyclerView.adapter.CustomRVAdapter;
import com.example.kapil.movie_app.recyclerView.callback.OnMovieCellClick;
import com.example.kapil.movie_app.recyclerView.movies.Movies;
import com.example.kapil.movie_app.recyclerView.movies.MoviesRes;
import com.example.kapil.movie_app.service.ServiceAPI;
import com.google.android.youtube.player.YouTubePlayerView;

import java.util.ArrayList;

import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends AppCompatActivity implements OnMovieCellClick {

    public RecyclerView rv_movie;
    private ImageView img_search;
    private ImageView img_more;
    private ImageView expand_menu;



    CustomRVAdapter mAdapter;
    ArrayList<Movies> mList;

    private static final String TAG = MainActivity.class.getSimpleName();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        rv_movie= findViewById(R.id.rv_movies);
        img_search = findViewById(R.id.img_search);
        img_more = findViewById(R.id.img_more);
        expand_menu= findViewById(R.id.expand_menu);



        img_search.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(MainActivity.this, "Search Clicked", Toast.LENGTH_SHORT).show();
            }
        });

        img_more.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(MainActivity.this, "More Clicked", Toast.LENGTH_SHORT).show();
            }
        });

        expand_menu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(MainActivity.this, "Expand Menu Clicked", Toast.LENGTH_SHORT).show();
            }
        });


        callAPI();

        rv_movie.setHasFixedSize(true);
        mList = new ArrayList<>();
//
//        Movies m1 = new Movies("http://t0.gstatic.com/images?q=tbn:ANd9GcR7gFSo85szXEdjrPsBO992eUhkX0qwALaQWdCj-BOfcaU0kpH-", "http://t0.gstatic.com/images?q=tbn:ANd9GcR7gFSo85szXEdjrPsBO992eUhkX0qwALaQWdCj-BOfcaU0kpH-","Your Name", (2016), "Drama/Fantasy", "Makoto Shinkai", 8.4, "U/A", "1h 52m", "Two strangers find themselves linked in a bizarre way. When a connection forms, will distance be the only thing to keep them apart?", 105848 );
//        Movies m2 = new Movies("http://t1.gstatic.com/images?q=tbn:ANd9GcS6MveoDoJOg9-wMvtHE4ak_-HDZeYS1egb9PwRcf8lhrtcppMc", "http://t1.gstatic.com/images?q=tbn:ANd9GcS6MveoDoJOg9-wMvtHE4ak_-HDZeYS1egb9PwRcf8lhrtcppMc","Spirated Away", (2001), "Fantasy/Mystery ", "Hayao Miyazaki", 8.6, "U/A", "2h 5m", "During her family's move to the suburbs, a sullen 10-year-old girl wanders into a world ruled by gods, witches, and spirits, and where humans are changed into beasts.", 522038 );
//        Movies m3 = new Movies("http://t2.gstatic.com/images?q=tbn:ANd9GcTvrIHJfasS6poy34esN1O5hZonXaiqfEZb4WbnbAa9qJCIL8_9","http://t2.gstatic.com/images?q=tbn:ANd9GcTvrIHJfasS6poy34esN1O5hZonXaiqfEZb4WbnbAa9qJCIL8_9","Deadpool", (2016), "Science fiction film/Action", "Tim Miller", 8.1, "U/A", "1h 49m", "A fast-talking mercenary with a morbid sense of humor is subjected to a rogue experiment that leaves him with accelerated healing powers and a quest for revenge.", 759034);
//        Movies m4 = new Movies("https://j.b5z.net/i/u/6127364/i/inception_75_ezr2.jpg","https://j.b5z.net/i/u/6127364/i/inception_75_ezr2.jpg","Inception", (2010), "Science fiction film/Thrille", "Christopher Nolan", 8.8, "U/A", "2h 28m", "A thief who steals corporate secrets through the use of dream-sharing technology is given the inverse task of planting an idea into the mind of a CEO.", 1742101 );
//        Movies m5 = new Movies("http://www.westalexfilms.com/wp-content/uploads/2016/10/WestalexFilms-The-Prestige-Movie-Poster-Are-You-Watching-Closely.jpg","http://www.westalexfilms.com/wp-content/uploads/2016/10/WestalexFilms-The-Prestige-Movie-Poster-Are-You-Watching-Closely.jpg","The Prestige", (2006), "Science fiction film/Thriller ", "Christopher Nolan", 8.5, "U/A", "2h 10m", "After a tragic accident, two stage magicians engage in a battle to create the ultimate illusion while sacrificing everything they have to outwit each other.", 1011934 );
//        Movies m6 = new Movies("https://s3-ap-southeast-2.amazonaws.com/fna-wordpress-website06/wp-content/uploads/2018/08/07105721/Shutter-Island-1440x960.jpg","https://s3-ap-southeast-2.amazonaws.com/fna-wordpress-website06/wp-content/uploads/2018/08/07105721/Shutter-Island-1440x960.jpg","Shutter Island", (2010), "Thriller/Drama", "Martin Scorsese", 8.1, "U/A", "2h 18m", "In 1954, a U.S. Marshal investigates the disappearance of a murderer, who escaped from a hospital for the criminally insane.", 951194);
//
//        mList.add(m1);
//        mList.add(m2);
//        mList.add(m3);
//        mList.add(m4);
//        mList.add(m5);
//        mList.add(m6);


        RecyclerView.LayoutManager lm = new LinearLayoutManager(this);
        rv_movie.setLayoutManager(lm);

        mAdapter = new CustomRVAdapter(this, mList, this);
        rv_movie.setAdapter(mAdapter);
    }

    @Override
    public void onMovieCellClickedListener(Movies m) {
        Intent intent = new Intent(MainActivity.this,Detailed_Page.class);
        intent.putExtra("movie_name", m );
        startActivity(intent);

    }

    private void callAPI() {

        HttpLoggingInterceptor i = new HttpLoggingInterceptor(new HttpLoggingInterceptor.Logger() {
            @Override
            public void log(String message) {
                Log.e(TAG, "connection : " + message );
            }
        });


                i.setLevel(HttpLoggingInterceptor.Level.BODY);
                OkHttpClient c =new OkHttpClient.Builder()
                        .addInterceptor(i)
                        .build();
        Retrofit mRetrofit = new Retrofit.Builder()
                            .addConverterFactory(GsonConverterFactory.create())
                            .baseUrl("http://192.168.43.27:4000/")
                            .client(c)
                            .build();

        ServiceAPI mServiceAPI = mRetrofit.create(ServiceAPI.class);
        Call<MoviesRes> call = mServiceAPI.fetchAllMovies();
        call.enqueue(new Callback<MoviesRes>() {
            @Override
            public void onResponse(Call<MoviesRes> call, Response<MoviesRes> response) {
                // res = response.body();

                MoviesRes res= response.body();

                if (res.status){
                    mList.addAll(res.movieObjectList);
                    mAdapter.notifyDataSetChanged();
                }

            }

            @Override
            public void onFailure(Call<MoviesRes> call, Throwable t) {

            }
        });



}

}
