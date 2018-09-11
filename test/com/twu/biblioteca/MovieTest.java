package com.twu.biblioteca;

import org.junit.Test;

import static org.junit.Assert.*;

public class MovieTest {
    Movie mockMovie = new Movie();

    @Test
    public void getTitle() {
        mockMovie.setTitle("Mock Movie");
        assertEquals("Mock Movie", mockMovie.getTitle());
    }

    @Test
    public void getYearReleased() {
        mockMovie.setYearReleased("2018");
        assertEquals("2018", mockMovie.getYearReleased());
    }

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