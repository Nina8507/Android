package com.example.simpleandroidapp.viewmodel;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import com.example.simpleandroidapp.model.Movie;
import com.example.simpleandroidapp.service.filter.FilterService;
import com.example.simpleandroidapp.service.filter.FilterServiceImpl;

import java.util.List;

public class FilterByKeywordViewModel extends AndroidViewModel {
    private MutableLiveData<List<Movie>> list;
    private final FilterService service;

    public FilterByKeywordViewModel(@NonNull Application application) {
        super(application);
        service = new FilterServiceImpl();
    }

    public void init() {
        list = service.getListSearchByKeyword();
    }

    public LiveData<List<Movie>> getMovies() {
        return list;
    }
}
