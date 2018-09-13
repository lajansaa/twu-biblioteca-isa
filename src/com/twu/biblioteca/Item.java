package com.twu.biblioteca;

public class Item {
    private String title;
    private String year;
    private boolean availability = true;
    private User borrower = null;

    public void setTitle(String title) {
        this.title = title;
    }

    public String getTitle() {
        return title;
    }

    public void setYear(String year) {
        this.year = year;
    }

    public String getYear() {
        return year;
    }

    public void setAvailability(boolean availability) {
        this.availability = availability;
    }

    public boolean isAvailable() {
        return availability;
    }

    public void setBorrower(User borrower) {
        this.borrower = borrower;
    }

    public User getBorrower() {
        return borrower;
    }
}
