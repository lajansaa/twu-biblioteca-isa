package com.twu.biblioteca;

import org.junit.Before;
import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.Assert.*;

public class MovieListTest {
    private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
    private Movie mockMovie = new Movie();
    private MovieList mockMovieList = new MovieList(null);

    @Before
    public void setUpStreams() {
        System.setOut(new PrintStream(outContent));
    }

    @Before
    public void addMockMovie() {
        mockMovie.setTitle("Mock Title");
        mockMovie.setYear("2018");
        mockMovie.setDirector("Mock Director");
        mockMovie.setRating("5");
        mockMovieList.addItem(mockMovie);
    }

    @Test
    public void printList() {
        mockMovieList.printList();
        assertEquals("1. Mock Title (2018), Mock Director, 5/10: Available\n", outContent.toString());
    }
}