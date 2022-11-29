package com.example.simpleandroidapp.view;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.simpleandroidapp.R;
import com.example.simpleandroidapp.model.Movie;
import com.example.simpleandroidapp.view.adapter.FilterAdapter;
import com.example.simpleandroidapp.viewmodel.FilterByKeywordViewModel;

import java.util.ArrayList;
import java.util.List;

public class FilterByKeywordFragment extends Fragment {
    private TextView scoreFilter, yearFilter, keyword;
    private Button searchFilter;
    private FilterByKeywordViewModel viewModel;
    private FilterAdapter adapter;
    private RecyclerView recyclerView;
    private List<Movie> list;

    public FilterByKeywordFragment() {
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_filter,container, false);
        findViews(view);
        viewModel = new ViewModelProvider(this).get(FilterByKeywordViewModel.class);
        viewModel.init();
        initRecyclerView();
        list = new ArrayList<>();
        return view;
    }

    private void initRecyclerView() {
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        adapter = new FilterAdapter();
        recyclerView.setAdapter(adapter);
    }

    private void findViews(View view) {
        //scoreFilter = view.findViewById(R.id.score_filter);
        //yearFilter = view.findViewById(R.id.year_filter);
        //keyword = view.findViewById(R.id.keyword_filter);
        //searchFilter = view.findViewById(R.id.search_button_filter);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        initRecyclerView();
        viewModel.getMovies().observe(getViewLifecycleOwner(), new FilterListObserver());

        searchFilter.setOnClickListener((v -> {
            Movie movie = new Movie();

            movie.setReleaseDate(yearFilter.getText().toString());
            movie.setImdbRating(scoreFilter.getText().toString());
            movie.setTitle(keyword.getText().toString());

        }));
    }

    private class FilterListObserver implements Observer<List<Movie>> {
        @Override
        public void onChanged(List<Movie> list) {
            adapter.setMovieList(list);
            adapter.notifyDataSetChanged();
        }
    }
}
