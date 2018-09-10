package com.twu.biblioteca;

import java.util.ArrayList;

public class BookList implements MenuOption {
    private ArrayList<Book> bookList = new ArrayList<Book>();

    public String getMenuOptionTitle() {
        return "List Book";
    }

    public void addBook(Book book) {
        bookList.add(book);
    }

    public void printBookList() {
        for (int i = 0; i < bookList.size(); i++) {
            String output = (i + 1) + ". ";
            output += bookList.get(i).getTitle();
            output += "(" + bookList.get(i).getYearPublished() + "): ";
            output += bookList.get(i).isAvailable() ? "Available" : "Not Available";
            System.out.println(output);
        }
    }

    public void printDescription() {
        System.out.println("Book List");
        System.out.println("---------");
        System.out.println("To borrow a book, type borrow <book number>. Likewise to return a book, type return <book number>.");
        System.out.println(" ");
    }

    public void borrowBook(int bookIndex) {
        Book book = bookList.get(bookIndex);
        if (book.isAvailable()) {
            book.setAvailability(false);
            System.out.println("Thank you! Enjoy the book!");
        } else {
            System.out.println("That book is not available.");
        }
    }

    public void returnBook(int bookIndex) {
        Book book = bookList.get(bookIndex);
        if (!book.isAvailable()) {
            book.setAvailability(true);
            System.out.println("Thank you for returning the book.");
        } else {
            System.out.println("That is not a valid book to return.");
        }
    }

    public boolean isBorrow(String input) {
        if (input.matches("borrow \\d+")) {
            return true;
        }
        return false;
    }

    public boolean isReturn(String input) {
        if (input.matches("return \\d+")) {
            return true;
        }
        return false;
    }

    public boolean isBookValid(String input) {
        int bookNumber = getBookIndex(input);
        if (bookNumber >= 0 && bookNumber < bookList.size()) {
            return true;
        }
        return false;
    }

    public int getBookIndex(String input) {
        return Integer.parseInt(input.replaceAll("(\\D{6}\\s)(\\d+)", "$2")) - 1;
    }

    public boolean checkUserInput(String userInput) {
        System.out.println(" ");
        if (userInput.equals("q") || userInput.equals("b")) {
            return false;
        } else if (isBorrow(userInput)) {
            if (isBookValid(userInput)) {
                int bookIndex = getBookIndex(userInput);
                borrowBook(bookIndex);
            } else {
                System.out.println("That book is not available.");
            }
        } else if (isReturn(userInput)) {
            if (isBookValid(userInput)) {
                int bookIndex = getBookIndex(userInput);
                returnBook(bookIndex);
            } else {
                System.out.println("That is not a valid book to return.");
            }
        } else {
            System.out.println("Select a valid option!");
        }
        System.out.println(" ");
        return true;
    }

    public boolean start() {

        boolean running = true;

        String userInput = null;

        printDescription();

        while (running) {
            printBookList();

            Helper helper = new Helper();
            userInput = helper.getUserInput("What would you like to do? ").toLowerCase();

            running = checkUserInput(userInput);
        }

        if (userInput.equals("q")) {
            return false;
        } else {
            return true;
        }
    }
}
