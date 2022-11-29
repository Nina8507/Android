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

public class FilterAdapter extends RecyclerView.Adapter<FilterAdapter.ViewHolder>{
    private List<Movie> movieList;

    public void setMovieList(List<Movie> movieList){
        this.movieList = movieList;
    }
    @NonNull
    @Override
    public FilterAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View view = inflater.inflate(R.layout.movie_item, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull FilterAdapter.ViewHolder holder, int position) {
        Movie movie = movieList.get(position);

        holder.title.setText(movie.getTitle());
        holder.poster.setText(movie.getPoster());
        holder.plot.setText(movie.getPlot());
        holder.releaseDate.setText(movie.getReleaseDate());
        holder.imdbScore.setText(movie.getImdbRating());
    }

    @Override
    public int getItemCount() {
        return movieList.size();
    }

    class ViewHolder extends RecyclerView.ViewHolder{
        TextView title, poster, plot, releaseDate, imdbScore;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            //title = itemView.findViewById(R.id.movie_title);
            //poster = itemView.findViewById(R.id.movie_poster);
            //plot = itemView.findViewById(R.id.movie_plot);
            //releaseDate = itemView.findViewById(R.id.movie_releaseDate);
            //imdbScore = itemView.findViewById(R.id.movie_imdbScore);
        }
    }
}
