package com.twu.biblioteca;
import java.util.*;

public class Biblioteca {
    private Menu menu = new Menu();
    private BookList bookList = new BookList();
    private MovieList movieList = new MovieList();
    private boolean running = true;

    public Biblioteca () {
        initialiseBookList();
        initialiseMovieList();
        initialiseMenu();
    }

    public void initialiseBookList() {
        ArrayList<String> titleList = new ArrayList<String>(Arrays.asList("Murder on Orient Expressway", "The ABC Murders", "Crooked House"));
        ArrayList<String> yearList = new ArrayList<String>(Arrays.asList("1934", "1936", "1949"));
        for (int i = 0; i < titleList.size(); i++) {
            Book book = new Book();
            book.setTitle(titleList.get(i));
            book.setYear(yearList.get(i));
            bookList.addItem(book);
        }
    }

   public void initialiseMovieList() {
        ArrayList<String> titleList = new ArrayList<String>(Arrays.asList("Zootopia", "Big Hero 6", "The Incredibles"));
        ArrayList<String> yearList = new ArrayList<String>(Arrays.asList("2016", "2014", "2004"));
       ArrayList<String> directorList = new ArrayList<String>(Arrays.asList("Byron Howard", "Don Hall", "Brad Bird"));
       ArrayList<String> ratingList = new ArrayList<String>(Arrays.asList("8", "7", "8"));
        for (int i = 0; i < titleList.size(); i++) {
            Movie movie = new Movie();
            movie.setTitle(titleList.get(i));
            movie.setYear(yearList.get(i));
            movie.setDirector(directorList.get(i));
            movie.setRating(ratingList.get(i));
            movieList.addItem(movie);
        }
    }

    public void initialiseMenu() {
        menu.addMenuOption(bookList);
        menu.addMenuOption(movieList);

    }

    public void printWelcomeMessage() {
        System.out.println("Welcome to Biblioteca!");
        System.out.println("----------------------");
        System.out.println("There's much you can do here!");
        System.out.println("At any point in time of your session with us, feel free to type b to go back to a previous page or type q to quit.");
        System.out.println(" ");
    }

    public void startBiblioteca() {
        printWelcomeMessage();
        menu.start();
        System.out.println("See you again soon!");
    }
}
