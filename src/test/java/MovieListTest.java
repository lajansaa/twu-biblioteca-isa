import org.junit.Before;
import org.junit.Test;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

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

        borrowReturnList.start("borrow 1", "movie", movieList.getItemList(), user, display);
        movieList.printList(display);

        verify(display).println("1. Zootopia (2016), Byron Howard, 8 / 10: Not Available (Borrowed by: Mock Name - 9876543)");
    }
}