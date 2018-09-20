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

    public void printList(User loggedInUser) {
        for (int i = 0; i < movieList.size(); i++) {
            String output = (i + 1) + ". ";
            Movie movie = (Movie) movieList.get(i);
            output += movie.getTitle();
            output += " (" + movie.getYear() + "), ";
            output += movie.getDirector() + ", ";
            output += movie.getRating() + ": ";
            output += movie.isAvailable() ? "Available" : "Not Available";

            boolean isLibrarian = loggedInUser.getRole().equals("librarian");
            boolean isItemUnavailable = !movieList.get(i).isAvailable();

            if (loggedInUser != null) {
                if (isLibrarian && isItemUnavailable) {
                    output += " (Borrowed by: " + movieList.get(i).getBorrower().getName() + " - " + movieList.get(i).getBorrower().getNumber() + ")";
                }
            }
            System.out.println(output);
        }
    }
}
