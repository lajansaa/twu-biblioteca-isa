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
    private BookList mockBookList = new BookList(null);
    private Book mockBook = new Book("Mock Book", "2018");

    enum Type {IsBorrowTest, IsBookValidTest, CheckUserInputTest, DummyTest};
    @Parameterized.Parameters
    public static Collection<Object[]> data() {
        return Arrays.asList(new Object[][] {
                {Type.DummyTest, "dummy", true},
                {Type.IsBorrowTest, "borrow 1", true},
                {Type.IsBorrowTest, "borrow1", false},
                {Type.IsBookValidTest, "borrow 1", true},
                {Type.IsBookValidTest, "borrow 2", false},
                {Type.CheckUserInputTest, "quit", false},
                {Type.CheckUserInputTest, "back", false},
                {Type.CheckUserInputTest, "0", true},
                {Type.CheckUserInputTest, "invalid", true}
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
        mockBookList.addItem(mockBook);
    }

    @Test
    public void printBookList() {
        Assume.assumeTrue(type == Type.DummyTest);
        mockBookList.printList();
        assertEquals("1. Mock Book(2018): Available\n", outContent.toString());
    }

    @Test
    public void isBorrow() {
        Assume.assumeTrue(type == Type.IsBorrowTest);
        assertEquals(expected, mockBookList.isBorrow(input));
    }

    @Test
    public void getBookIndex() {
        Assume.assumeTrue(type == Type.DummyTest);
        assertEquals(0, mockBookList.getItemIndex("borrow 1"));
    }

    @Test
    public void isBookValid() {
        Assume.assumeTrue(type == Type.IsBookValidTest);
        assertEquals(expected, mockBookList.isItemValid(input));
    }

    @Test
    public void borrowBook() {
        Assume.assumeTrue(type == Type.DummyTest);
        mockBook.setAvailability(true);
        mockBookList.borrowItem(0);
        assertEquals("Thank you! Enjoy the book!\n", outContent.toString());
    }

    @Test
    public void isReturn() {
        Assume.assumeTrue(type == Type.DummyTest);
        assertEquals(true, mockBookList.isReturn("return 1"));
    }

    @Test
    public void returnBook() {
        Assume.assumeTrue(type == Type.DummyTest);
        mockBook.setAvailability(false);
        mockBookList.returnItem(0);
        assertEquals("Thank you for returning the book.\n", outContent.toString());
    }

    @Test
    public void checkUserInput() {
        Assume.assumeTrue(type == Type.CheckUserInputTest);
        assertEquals(expected, mockBookList.checkUserInput(input));
    }
}