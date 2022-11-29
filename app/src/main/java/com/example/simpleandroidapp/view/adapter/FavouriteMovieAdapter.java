package com.example.simpleandroidapp.view.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.simpleandroidapp.R;
import com.example.simpleandroidapp.model.Movie;

import java.util.List;

public class FavouriteMovieAdapter extends RecyclerView.Adapter<FavouriteMovieAdapter.ViewHolder>{
    private final List<Movie> movieList;

    public FavouriteMovieAdapter(List<Movie> movieList){
        this.movieList = movieList;
    }

    @NonNull
    @Override
    public FavouriteMovieAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View view = inflater.inflate(R.layout.movie_item, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder viewHolder, int position) {
        Movie movie = movieList.get(position);
        
        viewHolder.movieTitle.setText(movie.getTitle());
        viewHolder.genres.setText(movie.getGenres());
        viewHolder.releaseDate.setText(movie.getReleaseDate());
        viewHolder.overview.setText(movie.getOverview());
        viewHolder.actors.setText(movie.getActors());
        viewHolder.plot.setText(movie.getPlot());
        viewHolder.poster.setText(movie.getPoster());
        viewHolder.imdbRating.setText(movie.getImdbRating());
    }

    @Override
    public int getItemCount() {
        return movieList.size();
    }

    class ViewHolder extends RecyclerView.ViewHolder{
        TextView movieTitle, genres, releaseDate, overview, actors;
        TextView plot, poster, imdbRating;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            //movieList = itemView.findViewById(R.id.movie_title);
            //genres = itemView.findViewById(R.id.movie_genres);
            //releaseDate = itemView.findViewById(R.id.movie_releaseDate);
            //overview = itemView.findViewById(R.id.movie_overview);
            //actors = itemView.findViewById(R.id.movie_actors);
            //plot = itemView.findViewById(R.id.movie_plot);
            //poster = itemView.findViewById(R.id.movie_poster);
            //imdbRating = itemView.findViewById(R.id.movie_imdbRatings);
        }
    }
}
