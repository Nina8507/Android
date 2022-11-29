package com.example.simpleandroidapp.service.filter;

import androidx.lifecycle.MutableLiveData;

import com.example.simpleandroidapp.model.Movie;

import java.util.List;

public interface FilterService {
    MutableLiveData<List<Movie>> getMovieList();
    MutableLiveData<List<Movie>> getListSearchByKeyword();
}
