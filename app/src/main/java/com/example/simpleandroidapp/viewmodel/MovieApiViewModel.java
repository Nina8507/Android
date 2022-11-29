package com.example.simpleandroidapp.viewmodel;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import com.example.simpleandroidapp.model.Movie;
import com.example.simpleandroidapp.repository.api.repository.ApiRepository;
import com.example.simpleandroidapp.repository.api.repository.ApiRepositoryImpl;

public class MovieApiViewModel extends AndroidViewModel {
    private final ApiRepository repository;
    private final MutableLiveData<Movie> searchedMovie;

    public MovieApiViewModel(@NonNull Application application) {
        super(application);
        repository = ApiRepositoryImpl.getInstance();
        searchedMovie = new MutableLiveData<>();
    }

    public void searchedMovie(String movieTitle){
        repository.getSearchedMovie(movieTitle);
    }

    public LiveData<Movie> getSearchedMovie(){
        return searchedMovie;
    }
}
