package com.example.simpleandroidapp.networking;

import com.example.simpleandroidapp.model.Movie;

import java.util.List;

public class MovieResponse {
    private String title;
    private String genres;
    private String releaseDate;
    private String overview;
    private String actors;
    private String plot;
    private String poster;
    private String imdbRating;

    private List<Movie> movies;

    public List<Movie> getMoviesByKeyword(){
        return movies;
    }

    public Movie getSearchedMovie(){
        return new Movie(title, genres, releaseDate, overview, actors, plot, poster, imdbRating);
    }
}
