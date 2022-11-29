package com.example.simpleandroidapp.service.movie;

import androidx.lifecycle.MutableLiveData;

import com.example.simpleandroidapp.model.Movie;

import java.util.List;

public interface MovieService {
    void addMovieToFavourite(Movie movie);
    MutableLiveData<List<Movie>> getFavouriteMovieList();
}
