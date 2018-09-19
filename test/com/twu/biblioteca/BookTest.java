package com.twu.biblioteca;

import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

public class BookTest {
    private Book book = new Book("Endless Nights", "1967" );

    @Test
    public void getBook() {
        assertEquals("Endless Nights", book.getTitle());
    }

    @Test
    public void getYear() {
        assertEquals("1967", book.getYear());
    }

    @Test
    public void isAvailable() {
        book.setAvailability(false);
        assertEquals(false, book.isAvailable());
    }
}