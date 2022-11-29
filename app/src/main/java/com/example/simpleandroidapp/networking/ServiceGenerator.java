package com.example.simpleandroidapp.networking;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class ServiceGenerator {
    private static final Retrofit.Builder retrofitBuilder = new Retrofit.Builder()
            .baseUrl("http://www.omdbapi.com")
            .addConverterFactory(GsonConverterFactory.create());

    private static final Retrofit retrofit = retrofitBuilder.build();

    private static final MoviesApi movieApi = retrofit.create(MoviesApi.class);

    private ServiceGenerator() {
    }

    public static MoviesApi getApi() {
        return movieApi;
    }
}
