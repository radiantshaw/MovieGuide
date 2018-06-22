package com.semicolon.movieguide;

public class Movie {
    private String title;
    private String posterURL;
    private String backdropURL;
    private String synopsis;
    private float rating;
    private String releaseDate;

    public Movie(String title, String posterURL, String backdropURL, String synopsis, float rating, String releaseDate) {
        this.title = title;
        this.posterURL = posterURL;
        this.backdropURL = backdropURL;
        this.synopsis = synopsis;
        this.rating = rating;
        this.releaseDate = releaseDate;
    }

    public String getTitle() {
        return title;
    }

    public String getPosterURL() {
        return posterURL;
    }

    public String getSynopsis() {
        return synopsis;
    }

    public float getRating() {
        return rating;
    }

    public String getReleaseDate() {
        return releaseDate;
    }

    public String getBackdropURL() {
        return backdropURL;
    }

    public void setBackdropURL(String backdropURL) {
        this.backdropURL = backdropURL;
    }
}
