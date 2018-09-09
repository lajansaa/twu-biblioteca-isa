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
            System.out.println((i + 1) + ". " + bookList.get(i).getTitle() + ", " + bookList.get(i).getYearPublished());
        }
    }

    public void printDescription() {
        System.out.println("Book List");
        System.out.println("---------");
        System.out.println("To borrow a book, type borrow <book number>. Likewise to return a book, type return <book number>.");
        System.out.println(" ");
    }

    public String borrowBook(String bookIndex) {
        return "Book borrowed successfully";
    }

    public String returnBook(String bookIndex) {
        return "Book returned successfully";
    }

    public boolean start() {

        boolean running = true;
        Helper helper = new Helper();
        String userInput = null;

        printDescription();

        while (running) {
            printBookList();

            userInput = helper.getUserInput("What would you like to do? ").toLowerCase();

            if (userInput.equals("q") || userInput.equals("b")) {
                running = false;
            } else if (isBorrow(userInput)) {
                if (isBookValid(userInput)) {

                } else {

                }
                System.out.println(borrowBook("1"));
            } else if (userInput.equals("return")) {
                System.out.println(returnBook("1"));
            } else {
                System.out.println("Please select a valid option!");
            }
        }

        if (userInput.equals("q")) {
            return false;
        } else {
            return true;
        }
    }

    public boolean isBorrow(String input) {
        if (input.matches("borrow \\d+")) {
            return true;
        }
        return false;
    }

    public boolean isBookValid(String input) {
        int bookNumber = Integer.parseInt(input.replaceAll("(borrow )(\\d+)", "$2"));
        if (bookNumber > 0 && bookNumber <= bookList.size()) {
            return true;
        }
        return false;
    }
}
