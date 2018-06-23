package com.semicolon.movieguide;

import com.google.gson.annotations.SerializedName;

public class Movie {
    private String title;
    @SerializedName("poster_path")
    private String posterURL;
    @SerializedName("backdrop_path")
    private String backdropURL;
    @SerializedName("overview")
    private String synopsis;
    @SerializedName("vote_average")
    private float rating;
    @SerializedName("release_date")
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
