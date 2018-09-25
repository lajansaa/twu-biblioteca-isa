import org.junit.Before;
import org.junit.Test;

import static org.mockito.Mockito.*;

public class LoginTest {
    private UserDB userDB;
    private User user;
    private LoggedInUser loggedInUser;
    private BorrowReturnList borrowReturnList;
    private ActionAsker actionAsker;
    private Login login;

    @Before
    public void setUp() {
        userDB = new UserDB();
        user = userDB.getUserList().get(0);
        borrowReturnList = new BorrowReturnList();

        loggedInUser = mock(LoggedInUser.class);
        login = spy( new Login(userDB, loggedInUser, borrowReturnList));
        actionAsker = mock(ActionAsker.class);
    }

    @Test
    public void startBack() {
        when(actionAsker.ask("What would you like to do? (login/back/quit) ")).thenReturn("back");

        doReturn(login.start(actionAsker))
                .when(login)
                .newMenu(loggedInUser, borrowReturnList);
    }

    @Test
    public void startLogin() {
        when(actionAsker.ask("What would you like to do? (login/back/quit) ")).thenReturn("login");
        when(actionAsker.ask("Library Number (xxx-xxxx): ")).thenReturn("987-9876");
        when(actionAsker.ask("Password: ")).thenReturn("librarian");

        login.start(actionAsker);

        verify(loggedInUser).setLoggedInUser(user);
        doReturn(login.start(actionAsker))
                .when(login)
                .newMenu(loggedInUser, borrowReturnList);
    }
}