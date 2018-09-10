package com.twu.biblioteca;
import java.util.*;

public class Biblioteca {
    private Menu menu = new Menu();
    private BookList bookList = new BookList();
    private boolean running = true;

    public Biblioteca () {
        initialiseBookList();
        initialiseMenu();
    }

    public void initialiseBookList() {
        ArrayList<String> titleList = new ArrayList<String>(Arrays.asList("Murder on Orient Expressway", "The ABC Murders", "Crooked House"));
        ArrayList<String> yearPublishedList = new ArrayList<String>(Arrays.asList("1934", "1936", "1949"));
        for (int i = 0; i < titleList.size(); i++) {
            Book book = new Book();
            book.setTitle(titleList.get(i));
            book.setYearPublished(yearPublishedList.get(i));
            bookList.addBook(book);
        }
    }

    public void initialiseMenu() {
        menu.addMenuOption(bookList);

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
