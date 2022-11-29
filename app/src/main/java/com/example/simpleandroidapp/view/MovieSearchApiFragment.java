package com.example.simpleandroidapp.view;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import com.example.simpleandroidapp.R;
import com.example.simpleandroidapp.model.Movie;
import com.example.simpleandroidapp.viewmodel.MovieApiViewModel;

public class MovieSearchApiFragment extends Fragment {
    private MovieApiViewModel viewModel;
    private EditText searchMovie;
    private Button searchButton;

    public MovieSearchApiFragment() {
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_movie_search_api, container, false);
        findViews(view);
        viewModel = new ViewModelProvider(this).get(MovieApiViewModel.class);
        viewModel.getSearchedMovie();
        return view;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        searchButton.setOnClickListener((v -> {
            Movie movie = new Movie();

            movie.setTitle(searchMovie.getText().toString());

            viewModel.searchedMovie(movie.getTitle());
        }));
    }

    private void findViews(View view) {
        searchMovie = view.findViewById(R.id.search_movie_by_title);
        searchButton = view.findViewById(R.id.search_movie_button);
    }
}
