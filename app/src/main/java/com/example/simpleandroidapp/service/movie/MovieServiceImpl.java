package com.example.simpleandroidapp.service.movie;

import androidx.lifecycle.MutableLiveData;

import com.example.simpleandroidapp.model.Movie;
import com.example.simpleandroidapp.repository.movie.repository.MovieRepository;
import com.example.simpleandroidapp.repository.movie.repository.MovieRepositoryImpl;

import java.util.List;

public class MovieServiceImpl implements MovieService{
    private final MovieRepository movieRepository;

    public MovieServiceImpl() {
        this.movieRepository = MovieRepositoryImpl.getInstance();
    }

    @Override
    public void addMovieToFavourite(Movie movie) {
        movieRepository.addMovieToFavourite(movie);
    }

    @Override
    public MutableLiveData<List<Movie>> getFavouriteMovieList() {
        MutableLiveData<List<Movie>> list = new MutableLiveData<>();
        movieRepository.getFavouriteList(list::setValue);
        return list;
    }
}
