package com.twu.biblioteca;

import java.util.ArrayList;
import java.util.Arrays;

public class MovieList extends ItemList {
    private ArrayList<Item> movieList;
    private LoggedInUser loggedInUser;

    public MovieList(LoggedInUser loggedInUser) {
        super("Movie", loggedInUser);
        this.movieList = this.getItemList();
        this.loggedInUser = loggedInUser;
        initialiseMovieList();
    }

    public void initialiseMovieList() {
        ArrayList<String> titleList = new ArrayList<>(Arrays.asList("Zootopia", "Big Hero 6", "The Incredibles"));
        ArrayList<String> yearList = new ArrayList<>(Arrays.asList("2016", "2014", "2004"));
        ArrayList<String> directorList = new ArrayList<>(Arrays.asList("Byron Howard", "Don Hall", "Brad Bird"));
        ArrayList<MovieRating> ratingList = new ArrayList<>(Arrays.asList(MovieRating.EIGHT, MovieRating.UNRATED, MovieRating.NINE));
        for (int i = 0; i < titleList.size(); i++) {
            Movie movie = new Movie(titleList.get(i), yearList.get(i),directorList.get(i), ratingList.get(i));
            addItem(movie);
        }
    }

    public void printList() {
        for (int i = 0; i < movieList.size(); i++) {
            String output = (i + 1) + ". ";
            Movie movie = (Movie) movieList.get(i);
            output += movie.getTitle();
            output += " (" + movie.getYear() + "), ";
            output += movie.getDirector() + ", ";
            output += movie.getRating() + ": ";
            output += movie.isAvailable() ? "Available" : "Not Available";

            boolean isLibrarian = loggedInUser.getLoggedInUser().getRole().equals("librarian");
            boolean isItemUnavailable = !movieList.get(i).isAvailable();

            if (loggedInUser.getLoggedInUser() != null) {
                if (isLibrarian && isItemUnavailable) {
                    output += " (Borrowed by: " + movieList.get(i).getBorrower().getName() + " - " + movieList.get(i).getBorrower().getNumber() + ")";
                }
            }
            System.out.println(output);
        }
    }
}
