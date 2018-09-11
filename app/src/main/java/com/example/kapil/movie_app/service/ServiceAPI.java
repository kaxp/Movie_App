package com.example.kapil.movie_app.service;

import com.example.kapil.movie_app.recyclerView.movies.MoviesRes;

import retrofit2.Call;
import retrofit2.http.GET;

public interface ServiceAPI {
    @GET("movies/getAllMovies")
    Call <MoviesRes> fetchAllMovies();

}
