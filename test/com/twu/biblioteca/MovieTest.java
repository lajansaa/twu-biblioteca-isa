package com.twu.biblioteca;

import org.junit.Test;

import static org.junit.Assert.*;

public class MovieTest {
    private Movie mockMovie = new Movie("Mock Title", "2018", "Mock Director");

    @Test
    public void getDirector() {
        assertEquals("Mock Director", mockMovie.getDirector());
    }

    @Test
    public void getRating() {
        assertEquals("unrated", mockMovie.getRating());
    }

}