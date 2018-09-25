import org.junit.Before;
import org.junit.Test;

import static org.mockito.Mockito.*;

public class LogoutTest {
    private LoggedInUser loggedInUser;
    private BorrowReturnList borrowReturnList;
    private ActionAsker actionAsker;
    private Logout logout;

    @Before
    public void setUp() {
        borrowReturnList = mock(BorrowReturnList.class);
        loggedInUser = mock(LoggedInUser.class);
        logout = spy( new Logout(loggedInUser, borrowReturnList));
        actionAsker = mock(ActionAsker.class);
    }

    @Test
    public void startLogout() {
        when(actionAsker.ask("What would you like to do? (logout/back/quit) ")).thenReturn("logout");

        logout.start(actionAsker);

        verify(loggedInUser).setLoggedInUser(null);
        doReturn(logout.start(actionAsker))
                .when(logout)
                .newMenu(loggedInUser, borrowReturnList);
    }
}