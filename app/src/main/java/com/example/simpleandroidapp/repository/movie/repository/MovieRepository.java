package com.example.simpleandroidapp.repository.movie.repository;

import androidx.lifecycle.MutableLiveData;

import com.example.simpleandroidapp.model.Movie;
import com.example.simpleandroidapp.repository.FirestoreCallback;

import java.util.List;

public interface MovieRepository {
    void addMovieToFavourite(Movie movie);
    MutableLiveData<List<Movie>> getFavouriteList(FirestoreCallback<List<Movie>> callback);
}
