package com.twu.biblioteca;
import java.util.*;

public class Biblioteca {
    private Menu menu = new Menu();
    private BookList bookList = new BookList(this);
    private MovieList movieList = new MovieList(this);
    private User loggedInUser = null;
    private UserDB userDB = new UserDB();
    private Login login = new Login(this, userDB);

    public Biblioteca () {
        initialiseMovieList();
        initialiseMenu();
    }

   public void initialiseMovieList() {
        ArrayList<String> titleList = new ArrayList<String>(Arrays.asList("Zootopia", "Big Hero 6", "The Incredibles"));
        ArrayList<String> yearList = new ArrayList<String>(Arrays.asList("2016", "2014", "2004"));
       ArrayList<String> directorList = new ArrayList<String>(Arrays.asList("Byron Howard", "Don Hall", "Brad Bird"));
       ArrayList<MovieRating> ratingList = new ArrayList<>(Arrays.asList(MovieRating.EIGHT, MovieRating.UNRATED, MovieRating.NINE));
        for (int i = 0; i < titleList.size(); i++) {
            Movie movie = new Movie(titleList.get(i), yearList.get(i),directorList.get(i), ratingList.get(i));
            movieList.addItem(movie);
        }
    }

    public void initialiseMenu() {
        menu.addMenuOption(bookList);
        menu.addMenuOption(movieList);
        menu.addMenuOption(login);
    }

    public void printWelcomeMessage() {
        System.out.println(" ");
        System.out.println("Welcome to Biblioteca!");
        System.out.println("----------------------");
        System.out.println("There's much you can do here!");
        System.out.println("At any point in time of your session with us, feel free to type back to go to a previous page or type quit to leave.");
    }



    public User getLoggedInUser() {
        return loggedInUser;
    }

    public void setLoggedInUser(User loggedInUser) {
        this.loggedInUser = loggedInUser;
    }

    public Menu getMenu() {
        return menu;
    }

    public void startBiblioteca() {
        printWelcomeMessage();
        menu.start();
        System.out.println("See you again soon!");
    }
}
