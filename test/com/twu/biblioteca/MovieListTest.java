package com.twu.biblioteca;

import org.junit.Before;
import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.Assert.*;

public class MovieListTest {
    private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
    private Biblioteca bib = new Biblioteca();
    private MovieList mockMovieList = new MovieList(bib);
    private Movie mockMovie = new Movie();
    User mockUser = new User();

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
        mockMovie.setAvailability(false);
        mockMovie.setBorrower(mockUser);
        mockMovieList.addItem(mockMovie);
    }

    @Before
    public void setLoggedInUser() {
        mockUser.setName("Mock Name");
        mockUser.setRole("librarian");
        mockUser.setNumber("9876543");
        bib.setLoggedInUser(mockUser);
    }

    @Test
    public void isLibrarianAndItemNotAvailable() {
        assertEquals(true, mockMovieList.isLibrarianAndItemNotAvailable(0));
    }

    @Test
    public void printList() {
        mockMovieList.printList();
        assertEquals("1. Mock Title (2018), Mock Director, 5/10: Not Available (Borrowed by: Mock Name - 9876543)\n", outContent.toString());
    }
}