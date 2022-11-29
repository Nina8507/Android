package com.example.simpleandroidapp.repository.filter.repository;

import androidx.lifecycle.MutableLiveData;

import com.example.simpleandroidapp.model.Movie;
import com.example.simpleandroidapp.repository.FirestoreCallback;

import java.util.List;

public interface FilterRepository {
    MutableLiveData<List<Movie>> getMovieList(FirestoreCallback<List<Movie>> callback);
}
