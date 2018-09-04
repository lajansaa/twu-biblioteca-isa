package com.twu.biblioteca;
import java.util.*;

public class Biblioteca {
    private ArrayList<String> menu = new ArrayList<String>();
    private ArrayList<String> bookList = new ArrayList<String>();
    private boolean running = true;

    public Biblioteca () {
        initialiseMenu();
        initialiseCatalog();
    }

    public void printWelcomeMessage() {
        System.out.println("Welcome to Biblioteca!");
        System.out.println("----------------------");
        System.out.println("There's much you can do here!");
        System.out.println("At any point in time of your session with us, feel free to type b to go back to a previous page or type q to quit.");
        System.out.println(" ");
    }

    public void printMenu() {
        System.out.println("Menu");
        System.out.println("----");
        System.out.println("Type the number of an action you would like to take:");
        System.out.println(" ");
        for (int i = 0; i < menu.size(); i++) {
            System.out.println((i + 1) + ". " + menu.get(i));
        }
        System.out.println(" ");
    }

    public void initialiseMenu() {
        menu.add("List Books");
    }

    public void initialiseCatalog() {

    }

    public void startBiblioteca() {
        printWelcomeMessage();
        printMenu();
        Helper helper = new Helper();

        while (running) {
            String userInput = helper.getUserInput("What would you like to do? ");
            if (userInput.equals("1")) {

            }
            if (userInput.equals("q")) {
                running = false;
            }
        }
    }
}
