import org.junit.Before;
import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

public class MovieListTest {
    private LoggedInUser loggedInUser = new LoggedInUser();
    private BorrowReturnList borrowReturnList = new BorrowReturnList();
    private MovieList movieList = new MovieList(loggedInUser, borrowReturnList);
    private User user = new User();

    @Before
    public void setLoggedInUser() {
        user.setName("Mock Name");
        user.setRole("librarian");
        user.setNumber("9876543");
        loggedInUser.setLoggedInUser(user);
    }

    @Test
    public void printList() {
        Display display = mock(Display.class);
        LoggedInUser loggedInUser = mock(LoggedInUser.class);
        BorrowReturnList borrowReturnList = mock(BorrowReturnList.class);
        Movie movie = mock(Movie.class);
        MovieList movieList = new MovieList(loggedInUser, borrowReturnList);

        when(borrowReturnList.isItemAvailable(movie)).thenReturn(false);
        when(loggedInUser.getLoggedInUser()).thenReturn(user);

        movieList.printList(display);
        verify(display).println("1. Zootopia (2016), Byron Howard, 8 / 10: Not Available (Borrowed by: Mock Name - 9876543)\n");
    }
}