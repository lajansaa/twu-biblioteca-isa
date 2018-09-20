package com.twu.biblioteca;

public class Movie extends Item {
    private String director;
    private MovieRating rating;

    public Movie(String title, String year, String director, MovieRating rating) {
        super(title, year);
        this.director = director;
        this.rating = rating;
    }

    public String getDirector() {
        return director;
    }

    public String getRating() {
        return rating.toS();
    }

}
