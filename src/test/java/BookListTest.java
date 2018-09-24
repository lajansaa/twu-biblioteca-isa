import org.junit.Assume;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.Arrays;
import java.util.Collection;

import static org.junit.Assert.assertEquals;

@RunWith(Parameterized.class)
public class BookListTest {
    private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
    private LoggedInUser loggedInUser = new LoggedInUser();
    private BookList mockBookList = new BookList(loggedInUser);

    enum Type {IsBorrowTest, IsBookValidTest, CheckUserInputTest, DummyTest};
    @Parameterized.Parameters
    public static Collection<Object[]> data() {
        return Arrays.asList(new Object[][] {
                {Type.DummyTest, "dummy", true},
                {Type.IsBorrowTest, "borrow 1", true},
                {Type.IsBorrowTest, "borrow1", false},
                {Type.IsBookValidTest, "borrow 1", true},
                {Type.IsBookValidTest, "borrow 4", false},
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

    @Test
    public void printBookList() {
        Assume.assumeTrue(type == Type.DummyTest);
        mockBookList.printList();
        assertEquals("1. Mock Book(2018): Available\n", outContent.toString());
    }

    @Test
    public void isBorrowOrReturn() {
        Assume.assumeTrue(type == Type.IsBorrowTest);
        assertEquals(expected, mockBookList.isBorrowOrReturn(input));
    }

    @Test
    public void checkUserInput() {
        Assume.assumeTrue(type == Type.CheckUserInputTest);
        assertEquals(expected, mockBookList.checkUserInput(input));
    }
}