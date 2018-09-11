package com.twu.biblioteca;

import org.junit.Test;

import static org.junit.Assert.*;

public class MovieTest {
    Movie mockMovie = new Movie();

    @Test
    public void getDirector() {
        mockMovie.setDirector("Mock Director");
        assertEquals("Mock Director", mockMovie.getDirector());
    }

    @Test
    public void getRating() {
        assertEquals("unrated", mockMovie.getRating());
    }

}