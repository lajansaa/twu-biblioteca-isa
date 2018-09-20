package com.twu.biblioteca;

import org.junit.Assume;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import sun.rmi.runtime.Log;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;

import static org.junit.Assert.*;

@RunWith(Parameterized.class)
public class MenuTest {
    private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
    private Menu mockMenu = new Menu(new LoggedInUser());

    enum Type {CheckWithinRangeTest, CheckUserInputTest, DummyTest};
    @Parameterized.Parameters
    public static Collection<Object[]> data() {
        return Arrays.asList(new Object[][] {
                {Type.DummyTest, "dummy", true},
                {Type.CheckWithinRangeTest, "1", true},
                {Type.CheckWithinRangeTest, "2", false},
                {Type.CheckWithinRangeTest, "invalid", false},
                {Type.CheckUserInputTest, "quit", false},
                {Type.CheckUserInputTest, "back", true},
                {Type.CheckUserInputTest, "invalid", true}
        });
    }
    private Type type;
    private String input;
    private boolean expected;

    public MenuTest(Type type, String input, boolean expected) {
        this.type = type;
        this.input = input;
        this.expected = expected;
    }

    @Before
    public void setUpStreams() {
        System.setOut(new PrintStream(outContent));
    }

    @Test
    public void getList() {
        Assume.assumeTrue(type == Type.DummyTest);
        ArrayList<MenuOption> mockList = new ArrayList<>();
        assertEquals(mockList, mockMenu.getList());
    }

    @Test
    public void printMenu() {
        Assume.assumeTrue(type == Type.DummyTest);
        mockMenu.printMenu();
        assertEquals("1. Mock Option\n", outContent.toString());
    }

    @Test
    public void checkWithinRange() {
        Assume.assumeTrue(type == Type.CheckWithinRangeTest);
        assertEquals(expected, mockMenu.checkWithinRange(input));
    }

    @Test
    public void checkUserInput() {
        Assume.assumeTrue(type == Type.CheckUserInputTest);
        assertEquals(expected, mockMenu.checkUserInput(input));
    }

    @Test
    public void removeMenuOption() {
        Assume.assumeTrue(type == Type.DummyTest);
        mockMenu.removeMenuOption("Mock Option");
        assertEquals(0, mockMenu.getList().size());
    }

}