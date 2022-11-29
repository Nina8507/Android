package com.example.simpleandroidapp.viewmodel;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import com.example.simpleandroidapp.model.Movie;
import com.example.simpleandroidapp.service.movie.MovieService;
import com.example.simpleandroidapp.service.movie.MovieServiceImpl;

import java.util.List;

public class MovieViewModel extends AndroidViewModel {
    private MovieService service;
    private MutableLiveData<List<Movie>> favouriteList;

    public MovieViewModel(@NonNull Application application) {
        super(application);
        service = new MovieServiceImpl();
    }

    public void init(){
        favouriteList = service.getFavouriteMovieList();
    }

    public void addMovieToFavourite(Movie movie) {
        service.addMovieToFavourite(movie);
    }

    public LiveData<List<Movie>> getFavouriteMovieList(){
        return favouriteList;
    }
}
