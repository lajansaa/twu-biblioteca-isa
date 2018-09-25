import org.junit.Test;
import org.junit.experimental.runners.Enclosed;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.mockito.Mock;

import java.util.Arrays;
import java.util.Collection;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.*;

@RunWith(Enclosed.class)
public class BookListTest {

    @RunWith(Parameterized.class)
    public static class IsBorrowOrReturnTest {
        private LoggedInUser loggedInUser = new LoggedInUser();
        private BorrowReturnList borrowReturnList = new BorrowReturnList();
        private BookList bookList = new BookList(loggedInUser, borrowReturnList);

        @Parameterized.Parameters
        public static Collection<Object[]> data() {
            return Arrays.asList(new Object[][]{
                    {"borrow 1", true},
                    {"borrow1", false},
                    {"return 1", true}
            });
        }

        private String input;
        private boolean expected;

        public IsBorrowOrReturnTest(String input, boolean expected) {
            this.input = input;
            this.expected = expected;
        }

        @Test
        public void isBorrowOrReturn() {
            assertEquals(expected, bookList.isBorrowOrReturn(input));
        }
    }

    @RunWith(Parameterized.class)
    public static class StartTest {
        private static LoggedInUser loggedInUser = new LoggedInUser();
        private static BorrowReturnList borrowReturnList = new BorrowReturnList();

        @Mock
        private static BookList bookList = spy( new BookList(loggedInUser, borrowReturnList));

        @Parameterized.Parameters
        public static Collection<Object[]> data() {
            return Arrays.asList(new Object[][]{
                    {"quit", null},
                    {"borrow 1", bookList},
                    {"invalid stuff", bookList}
            });
        }

        private String input;
        private Page expected;

        public StartTest(String input, Page expected) {
            this.input = input;
            this.expected = expected;
        }

        @Test
        public void start() {
            ActionAsker actionAsker = mock(ActionAsker.class);
            when(actionAsker.ask("What would you like to do? ")).thenReturn(input);
            assertEquals(expected, bookList.start(actionAsker));
        }

        @Test
        public void startWithBack() {
            ActionAsker actionAsker = mock(ActionAsker.class);
            when(actionAsker.ask("What would you like to do? ")).thenReturn("back");
            doReturn(bookList.start(actionAsker))
                    .when(bookList)
                    .newMenu(loggedInUser, borrowReturnList);

        }
    }
}