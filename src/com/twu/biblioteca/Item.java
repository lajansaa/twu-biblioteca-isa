package com.twu.biblioteca;

public class Item {
    private String title;
    private String year;
    private boolean availability = true;
    private User borrower = null;

    public Item(String title, String year) {
        this.title = title;
        this.year = year;
    }

    public String getTitle() {
        return title;
    }

    public String getYear() {
        return year;
    }

}
