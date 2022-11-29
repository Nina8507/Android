package com.example.simpleandroidapp.repository.api.repository;

import static android.content.ContentValues.TAG;

import android.util.Log;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import com.example.simpleandroidapp.model.Movie;
import com.example.simpleandroidapp.networking.MovieResponse;
import com.example.simpleandroidapp.networking.MoviesApi;
import com.example.simpleandroidapp.networking.ServiceGenerator;

import java.util.List;

import okhttp3.internal.annotations.EverythingIsNonNull;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ApiRepositoryImpl implements ApiRepository{
    private static ApiRepositoryImpl instance;
    private final MutableLiveData<Movie> searchedMovie;
    private final MutableLiveData<List<Movie>> movieByKeyword;

    private ApiRepositoryImpl(){
        searchedMovie = new MutableLiveData<>();
        movieByKeyword = new MutableLiveData<>();
    }

    public static synchronized ApiRepositoryImpl getInstance() {
        if (instance == null) {
            instance = new ApiRepositoryImpl();
        }
        return instance;
    }

    public MutableLiveData<Movie> getSearchedMovie(String movieTitle) {
        MoviesApi movieApi = ServiceGenerator.getApi();
        Call<MovieResponse> call = movieApi.getSearchedMovie(movieTitle);
        call.enqueue(new Callback<MovieResponse>() {
            @EverythingIsNonNull
            @Override
            public void onResponse(Call<MovieResponse> call, Response<MovieResponse> response) {
                if (response.isSuccessful()) {
                    searchedMovie.setValue(response.body().getSearchedMovie());
                    Log.d(TAG, "On api call");
                }
            }

            @EverythingIsNonNull
            @Override
            public void onFailure(Call<MovieResponse> call, Throwable t) {
                Log.d(TAG, "API response");
            }
        });
        return searchedMovie;
    }

    public MutableLiveData<List<Movie>> getMovieByKeyword(String keyword){
        MoviesApi api = ServiceGenerator.getApi();
        Call<MovieResponse> call = api.getMovieByTitleKeyword(keyword);
        call.enqueue(new Callback<MovieResponse>() {
            @EverythingIsNonNull
            @Override
            public void onResponse(Call<MovieResponse> call, Response<MovieResponse> response) {
                if (response.isSuccessful()) {
                    movieByKeyword.setValue(response.body().getMoviesByKeyword());
                    Log.d(TAG, "On api call");
                }
            }


            @EverythingIsNonNull
            @Override
            public void onFailure(Call<MovieResponse> call, Throwable t) {
                Log.d(TAG, "API response");
            }
        });

        return movieByKeyword;
    }

    public LiveData<List<Movie>> getMovieListByKeyword(){
        return movieByKeyword;
    }
}
