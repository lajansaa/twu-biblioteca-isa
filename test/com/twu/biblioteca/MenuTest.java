package com.twu.biblioteca;

import org.junit.After;
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

class CreateMockMenuOption implements MenuOption {
    public String getMenuOptionTitle() {
        return "Test Mock";
    }
    public boolean start() {
        return true;
    }
}

@RunWith(Parameterized.class)
public class MenuTest {
    private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
    private final PrintStream originalOut = System.out;
    private Menu mockMenu = new Menu();
    private CreateMockMenuOption mockMenuOption = new CreateMockMenuOption();

    private String input;

    private boolean expected;

    public MenuTest(String input, boolean expected) {
        this.input = input;
        this.expected = expected;
    }

    @Before
    public void setUpStreams() {
        System.setOut(new PrintStream(outContent));
    }

    @Before
    public void addMockMenuOption() {
        mockMenu.addMenuOption(mockMenuOption);
    }

    @After
    public void restoreStreams() {
        System.setOut(originalOut);
    }

    @Test
    public void getList() {
        ArrayList<MenuOption> mockList = new ArrayList<MenuOption>();
        mockList.add(mockMenuOption);
        assertEquals(mockList, mockMenu.getList());
    }

    @Test
    public void printMenu() {
        mockMenu.printMenu();
        assertEquals("1. Test Mock\n", outContent.toString());
    }

    @Parameterized.Parameters
    public static Collection<Object[]> data() {
        return Arrays.asList(new Object[][] {
                {"1", true},
                {"2", false}
        });
    }

    @Test
    public void checkWithinRange() {
        assertEquals(expected, mockMenu.checkWithinRange(input));
    }
}