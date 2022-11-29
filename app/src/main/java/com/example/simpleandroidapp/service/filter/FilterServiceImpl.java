package com.example.simpleandroidapp.service.filter;

import androidx.lifecycle.MutableLiveData;

import com.example.simpleandroidapp.model.Movie;
import com.example.simpleandroidapp.repository.api.repository.ApiRepositoryImpl;
import com.example.simpleandroidapp.repository.filter.repository.FilterRepositoryImpl;

import java.util.List;

public class FilterServiceImpl implements FilterService{
    private final FilterRepositoryImpl repository;
    private final ApiRepositoryImpl apiRepository;


    public FilterServiceImpl() {
        repository = FilterRepositoryImpl.getInstance();
        apiRepository = ApiRepositoryImpl.getInstance();
    }

    @Override
    public MutableLiveData<List<Movie>> getMovieList() {
        MutableLiveData<List<Movie>> list = new MutableLiveData<>();
        repository.getMovieList(list::setValue);
        return list;
    }

    @Override
    public MutableLiveData<List<Movie>> getListSearchByKeyword() {
        return (MutableLiveData<List<Movie>>) apiRepository.getMovieListByKeyword();
    }
}
