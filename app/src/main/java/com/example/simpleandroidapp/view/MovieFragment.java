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
import com.example.simpleandroidapp.viewmodel.MovieViewModel;

public class MovieFragment extends Fragment {
    private EditText title, genres, releaseDate, overview, actors, plot, poster, imdbRating;
    private Button addToFavorites;
    private MovieViewModel viewModel;

    public MovieFragment() {
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
        viewModel = new ViewModelProvider(this).get(MovieViewModel.class);
        viewModel.init();
        return view;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        addToFavorites.setOnClickListener((v -> {
            Movie movie = new Movie();

            movie.setTitle(title.getText().toString());
            movie.setGenres(genres.getText().toString());
            movie.setReleaseDate(releaseDate.getText().toString());
            movie.setOverview(overview.getText().toString());
            movie.setActors(actors.getText().toString());
            movie.setPlot(plot.getText().toString());
            movie.setPoster(poster.getText().toString());
            movie.setImdbRating(imdbRating.getText().toString());

            viewModel.addMovieToFavourite(movie);
        }));
    }

    private void findViews(View view) {
        //title = view.findViewById(R.id.movie_title);
        //genres = view.findViewById(R.id.movie_genres);
        //releaseDate = view.findViewById(R.id.movie_releaseDate);
        //overview = view.findViewById(R.id.movie_overview);
        //actors = view.findViewById(R.id.movie_actors);
        //plot = view.findViewById(R.id.movie_plot);
        //poster = view.findViewById(R.id.movie_poster);
        //imdbRating = imdbRating.findViewById(R.id.movie_imdbRatings);
    }
}
