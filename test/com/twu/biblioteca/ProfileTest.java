package com.twu.biblioteca;

import org.junit.Before;
import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.Assert.*;

public class ProfileTest {
    private ByteArrayOutputStream outContent = new ByteArrayOutputStream();
    private User mockUser = new User();
    private Profile mockProfile = new Profile(mockUser);

    @Before
    public void setUpStreams() {
        System.setOut(new PrintStream(outContent));
    }

    @Before
    public void setUpUser() {
        mockUser.setName("Mock Name");
        mockUser.setEmail("mock@mail.com");
        mockUser.setNumber("9876543");
        mockUser.setRole("librarian");
        mockUser.setLibraryNumber("987-9876");
        mockUser.setPassword("password");
        mockUser.setLoginStatus(false);
    }
    @Test
    public void checkUserInput() {
    }

    @Test
    public void printProfile() {
        String output = "Name: Mock Name\n";
        output += "Email: mock@mail.com\n";
        output += "Number: 9876543\n";
        mockProfile.printProfile();
        assertEquals(output, outContent.toString());
    }

}