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

    enum Type {CheckWithinRangeTest, CheckUserInputTest, DUMMYTEST};
    @Parameterized.Parameters
    public static Collection<Object[]> data() {
        return Arrays.asList(new Object[][] {
                {Type.DUMMYTEST, "dummy", true},
                {Type.CheckWithinRangeTest, "1", true},
                {Type.CheckWithinRangeTest, "2", false},
                {Type.CheckWithinRangeTest, "invalid", false},
                {Type.CheckUserInputTest, "q", false},
                {Type.CheckUserInputTest, "b", true},
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
        Assume.assumeTrue(type == MenuTest.Type.DUMMYTEST);
        ArrayList<MenuOption> mockList = new ArrayList<MenuOption>();
        mockList.add(mockMenuOption);
        assertEquals(mockList, mockMenu.getList());
    }

    @Test
    public void printMenu() {
        Assume.assumeTrue(type == MenuTest.Type.DUMMYTEST);
        mockMenu.printMenu();
        assertEquals("1. Test Mock\n", outContent.toString());
    }

    @Test
    public void checkWithinRange() {
        Assume.assumeTrue(type == MenuTest.Type.CheckWithinRangeTest);
        assertEquals(expected, mockMenu.checkWithinRange(input));
    }

    @Test
    public void checkUserInput() {
        Assume.assumeTrue(type == MenuTest.Type.CheckUserInputTest);
        assertEquals(expected, mockMenu.checkUserInput(input));
    }

}