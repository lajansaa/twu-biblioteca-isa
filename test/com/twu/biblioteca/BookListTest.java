package com.twu.biblioteca;

import org.junit.After;
import org.junit.Assume;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;

import static org.junit.Assert.*;

@RunWith(Parameterized.class)
public class BookListTest {
    private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
    private final PrintStream originalOut = System.out;
    private BookList mockBookList = new BookList();
    private Book mockBook = new Book();

    enum Type {ISBORROWTEST, ISBOOKVALIDTEST};
    @Parameterized.Parameters
    public static Collection<Object[]> data() {
        return Arrays.asList(new Object[][] {
                {Type.ISBORROWTEST, "borrow 1", true},
                {Type.ISBORROWTEST, "borrow1", false},
                {Type.ISBOOKVALIDTEST, "borrow 1", true},
                {Type.ISBOOKVALIDTEST, "borrow 2", false},
        });
    }
    private Type type;
    private String input;
    private boolean expected;

    public BookListTest(Type type, String input, boolean expected) {
        this.type = type;
        this.input = input;
        this.expected = expected;
    }

    @Before
    public void setUpStreams() {
        System.setOut(new PrintStream(outContent));
    }

    @Before
    public void addMockBook() {
        mockBook.setTitle("Mock Book");
        mockBook.setYearPublished("2018");
        mockBookList.addBook(mockBook);
    }

    @After
    public void restoreStreams() {
        System.setOut(originalOut);
    }

    @Test
    public void printBookList() {
        mockBookList.printBookList();
        assertEquals("1. Mock Book, 2018\n", outContent.toString());
    }

    @Test
    public void isBorrow() {
        Assume.assumeTrue(type == Type.ISBORROWTEST);
        assertEquals(expected, mockBookList.isBorrow(input));
    }

    @Test
    public void isBookValid() {
        Assume.assumeTrue(type == Type.ISBOOKVALIDTEST);
        assertEquals(expected, mockBookList.isBookValid(input));
    }
}