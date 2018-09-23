import org.junit.Before;
import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

public class MovieListTest {
    private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
    private Biblioteca bib = new Biblioteca();
    private LoggedInUser loggedInUser = new LoggedInUser();
    private MovieList mockMovieList = new MovieList(loggedInUser);
    private User mockUser = new User();

    @Before
    public void setUpStreams() {
        System.setOut(new PrintStream(outContent));
    }

    @Before
    public void setLoggedInUser() {
        mockUser.setName("Mock Name");
        mockUser.setRole("librarian");
        mockUser.setNumber("9876543");
        loggedInUser.setLoggedInUser(mockUser);
    }

    @Test
    public void printList() {
        mockMovieList.printList();
//        assertEquals("1. Mock Title (2018), Mock Director, 5 / 10: Not Available (Borrowed by: Mock Name - 9876543)\n", outContent.toString());
    }
}