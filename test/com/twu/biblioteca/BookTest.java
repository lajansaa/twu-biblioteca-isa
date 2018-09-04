package com.twu.biblioteca;

import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

public class BookTest {

    @Test
    public void getBook() {
        Book book = new Book();
        book.setTitle("Endless Nights");
        assertEquals(book.getTitle(), "Endless Nights");
    }

    @Test
    public void getYearPublished() {
        Book book = new Book();
        book.setYearPublished("1993");
        assertEquals(book.getYearPublished(), "1993");
    }
}