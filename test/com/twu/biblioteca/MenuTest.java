package com.twu.biblioteca;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.ArrayList;

import static org.junit.Assert.*;

class CreateMockMenuOption implements MenuOption {
    public String getMenuOptionTitle() {
        return "Test Mock";
    }
    public boolean start() {
        return true;
    }
}

public class MenuTest {
    private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
    private final PrintStream originalOut = System.out;
    private Menu mockMenu = new Menu();
    private CreateMockMenuOption mockMenuOption = new CreateMockMenuOption();

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
}