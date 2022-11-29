package com.example.simpleandroidapp.repository.api.repository;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import com.example.simpleandroidapp.model.Movie;

import java.util.List;

public interface ApiRepository {
    LiveData<Movie> getSearchedMovie(String title);
    MutableLiveData<List<Movie>> getMovieByKeyword(String keyword);
}
