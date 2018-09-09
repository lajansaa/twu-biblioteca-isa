package com.twu.biblioteca;

public class Book {
    private String title;
    private String yearPublished;
    private boolean availability = true;

    public void setTitle(String title) {
        this.title = title;
    }

    public String getTitle() {
        return title;
    }

    public void setYearPublished(String yearPublished) {
        this.yearPublished = yearPublished;
    }

    public String getYearPublished() {
        return yearPublished;
    }

    public void setAvailability(boolean availability) {
        this.availability = availability;
    }

    public boolean isAvailable() {
        return availability;
    }
}
