package com.twu.biblioteca;

public class Movie extends Item {
    private String director;
    private String rating = "unrated";

    public Movie(String title, String year, String director, String rating) {
        super(title, year);
        this.director = director;
        this.rating = rating;
    }

    public Movie(String title, String year, String director) {
        super(title, year);
        this.director = director;
    }

    public String getDirector() {
        return director;
    }

    public String getRating() {
        return rating;
    }

}
