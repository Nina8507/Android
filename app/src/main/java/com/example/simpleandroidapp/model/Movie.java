package com.example.simpleandroidapp.model;

public class Movie {
    private String title;
    private String genres;
    private String releaseDate;
    private String overview;
    private String actors;
    private String plot;
    private String poster;
    private String imdbRating;

    public Movie() {
    }

    public Movie(String title, String genres, String releaseDate, String overview, String actors, String plot, String poster, String imdbRating) {
        this.title = title;
        this.genres = genres;
        this.releaseDate = releaseDate;
        this.overview = overview;
        this.actors = actors;
        this.plot = plot;
        this.poster = poster;
        this.imdbRating = imdbRating;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getGenres() {
        return genres;
    }

    public void setGenres(String genres) {
        this.genres = genres;
    }

    public String getReleaseDate() {
        return releaseDate;
    }

    public void setReleaseDate(String releaseDate) {
        this.releaseDate = releaseDate;
    }

    public String getOverview() {
        return overview;
    }

    public void setOverview(String overview) {
        this.overview = overview;
    }

    public String getActors() {
        return actors;
    }

    public void setActors(String actors) {
        this.actors = actors;
    }

    public String getPlot() {
        return plot;
    }

    public void setPlot(String plot) {
        this.plot = plot;
    }

    public String getPoster() {
        return poster;
    }

    public void setPoster(String poster) {
        this.poster = poster;
    }

    public String getImdbRating() {
        return imdbRating;
    }

    public void setImdbRating(String imdbRating) {
        this.imdbRating = imdbRating;
    }


    @Override
    public String toString() {
        return "Movie{" +
                "title='" + title + '\'' +
                ", genres='" + genres + '\'' +
                ", releaseDate='" + releaseDate + '\'' +
                ", overview='" + overview + '\'' +
                ", actors='" + actors + '\'' +
                ", plot='" + plot + '\'' +
                ", poster='" + poster + '\'' +
                ", imdbRating='" + imdbRating + '\'' +
                '}';
    }
}
