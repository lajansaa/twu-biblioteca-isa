import org.junit.Test;
import org.mockito.Mock;

import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

public class LoginTest {
//    private UserDB userDB = new UserDB();
//    private LoggedInUser loggedInUser = new LoggedInUser();
//    private BorrowReturnList borrowReturnList = new BorrowReturnList();
//
//    @Mock
//    private Login login = spy( new Login(userDB, loggedInUser, borrowReturnList));
//
//    @Test
//    public void startQuit() {
//        ActionAsker actionAsker = mock(ActionAsker.class);
//        when(actionAsker.ask("What would you like to do? ")).thenReturn("quit");
//        assertEquals(null, login.start(actionAsker));
//    }
//
//    @Test
//    public void startBack() {
//        ActionAsker actionAsker = mock(ActionAsker.class);
//        when(actionAsker.ask("What would you like to do? ")).thenReturn("back");
//        doReturn(login.start(actionAsker))
//                .when(login)
//                .newMenu(loggedInUser, borrowReturnList);
//
//    }
//
////    @Test
////    public void startLogin() {
////        ActionAsker actionAsker = mock(ActionAsker.class);
////        when(actionAsker.ask("What would you like to do? ")).thenReturn("login");
////        when(actionAsker.ask("Library Number (xxx-xxxx): ")).thenReturn("987-9876");
////        when(actionAsker.ask("Password: ")).thenReturn("librarian");
////
////        doReturn(login.start(actionAsker))
////                .when(login)
////                .newMenu(any(LoggedInUser.class), borrowReturnList);
////
////    }
}