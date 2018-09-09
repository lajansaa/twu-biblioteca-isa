package com.twu.biblioteca;

import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

public class BookTest {
    private Book book = new Book();

    @Test
    public void getBook() {
        book.setTitle("Endless Nights");
        assertEquals("Endless Nights", book.getTitle());
    }

    @Test
    public void getYearPublished() {
        book.setYearPublished("1967");
        assertEquals("1967", book.getYearPublished());
    }

    @Test
    public void isAvailable() {
        book.setAvailability(false);
        assertEquals(false, book.isAvailable());
    }
}