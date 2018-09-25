import org.junit.Test;

import static org.junit.Assert.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class MenuTest {
    private LoggedInUser loggedInUser = new LoggedInUser();
    private BorrowReturnList borrowReturnList = new BorrowReturnList();
    private Menu menu = new Menu(loggedInUser, borrowReturnList);

    @Test
    public void startBack() {
        ActionAsker actionAsker = mock(ActionAsker.class);
        when(actionAsker.ask("What do you want to do? ")).thenReturn("back");
        assertEquals(menu, menu.start(actionAsker));
    }

    @Test
    public void startListBook() {
        ActionAsker actionAsker = mock(ActionAsker.class);
        when(actionAsker.ask("What do you want to do? ")).thenReturn("1");
        assertEquals(menu.getMenuList().get(0), menu.start(actionAsker));
    }

}