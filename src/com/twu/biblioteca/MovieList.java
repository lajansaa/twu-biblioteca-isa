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

    public boolean isLibrarian(int i) {
        return bib.getLoggedInUser().getRole().equals("librarian");
    }

    public boolean isItemUnavailable(int i) {
        return !movieList.get(i).isAvailable();
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
            if (bib.getLoggedInUser() != null) {
                if (isLibrarian(i) && isItemUnavailable(i)) {
                    output += " (Borrowed by: " + movieList.get(i).getBorrower().getName() + " - " + movieList.get(i).getBorrower().getNumber() + ")";
                }
            }
            System.out.println(output);
        }
    }
}
