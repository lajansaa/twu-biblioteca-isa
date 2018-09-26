import org.junit.Test;
import static org.mockito.Mockito.*;

public class BorrowReturnListTest {
    private BorrowReturnList borrowReturnList = new BorrowReturnList();
    private LoggedInUser loggedInUser = new LoggedInUser();
    private BookList bookList = new BookList(loggedInUser, borrowReturnList);
    private Display display = mock(Display.class);
    private User user = new User();
    private User user2 = new User();

    @Test
    public void startBorrowLoggedIn() {
        borrowReturnList.start("borrow 1", "book", bookList.getItemList(), user, display);
        verify(display).println("Thank you! Enjoy the book!");

        borrowReturnList.start("borrow 1", "book", bookList.getItemList(), user, display);
        verify(display).println("That book is not available.");
    }

    @Test
    public void startBorrowInvalidBook() {
        borrowReturnList.start("borrow 5", "book", bookList.getItemList(), user, display);
        verify(display).println("That is not a valid book to borrow or return.");
    }

    @Test
    public void startBorrowNotLoggedIn() {
        borrowReturnList.start("borrow 1", "book", bookList.getItemList(), null, display);
        verify(display).println("You need to login to borrow or return a book.");
    }

    @Test
    public void startReturnOfBorrower() {
        borrowReturnList.start("borrow 1", "book", bookList.getItemList(), user, display);
        borrowReturnList.start("return 1", "book", bookList.getItemList(), user, display);
        verify(display).println("Thank you for returning the book.");
    }

    @Test
    public void startReturnOfNonBorrower() {
        borrowReturnList.start("borrow 1", "book", bookList.getItemList(), user, display);
        borrowReturnList.start("return 1", "book", bookList.getItemList(), user2, display);
        verify(display).println("You are not the borrower of this book.");
    }

    @Test
    public void startReturnOfAvailableBook() {
        borrowReturnList.start("return 2", "book", bookList.getItemList(), user2, display);
        verify(display).println("That is not a valid book to return.");
    }

}