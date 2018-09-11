package com.twu.biblioteca;

import java.util.ArrayList;

public class MovieList extends ItemList {
    private ArrayList<Item> movieList;

    public MovieList() {
        super("Movie");
        this.movieList = this.getItemList();
    }

    public void printList() {
        for (int i = 0; i < movieList.size(); i++) {
            String output = (i + 1) + ". ";
            Movie movie = (Movie) movieList.get(i);
            output += movie.getTitle();
            output += " (" + movie.getYear() + "), ";
            output += movie.getDirector() + ", ";
            output += movie.getRating() + "/10: ";
            output += movie.isAvailable() ? "Available" : "Not Available";
            System.out.println(output);
        }
    }
}
