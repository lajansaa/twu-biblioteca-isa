package com.twu.biblioteca;

import java.util.ArrayList;

public class MovieList extends ItemList {
    private ArrayList<Item> movieList;
    private Biblioteca bib;

    public MovieList(Biblioteca bib) {
        super("Movie", bib);
        this.movieList = this.getItemList();
        this.bib = bib;
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
