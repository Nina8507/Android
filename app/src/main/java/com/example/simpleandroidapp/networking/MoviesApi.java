package com.example.simpleandroidapp.networking;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

public interface MoviesApi {
    @GET("/?t={movieName}&apikey=476d8ead")
    Call<MovieResponse> getSearchedMovie(@Path("Title") String movieName);

    @GET("/?s={movieName}&apikey=476d8ead")
    Call<MovieResponse> getMovieByTitleKeyword(@Path("Title") String keyword);//returns a list of 10 movies
}
