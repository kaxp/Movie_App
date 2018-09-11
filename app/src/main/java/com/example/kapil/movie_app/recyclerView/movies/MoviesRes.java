package com.example.kapil.movie_app.recyclerView.movies;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class MoviesRes {
    @SerializedName("status")
    @Expose
    public boolean status;
    @SerializedName("movieList")
    public List<Movies> movieObjectList;
}
