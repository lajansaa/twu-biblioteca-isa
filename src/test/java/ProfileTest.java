import org.junit.Test;
import org.mockito.Mock;

import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

public class ProfileTest {
    private User user = new User();
    private LoggedInUser loggedInUser = new LoggedInUser();
    private BorrowReturnList borrowReturnList = new BorrowReturnList();

    @Mock
    private Profile profile = spy( new Profile(user, loggedInUser, borrowReturnList));

    @Test
    public void startQuit() {
        ActionAsker actionAsker = mock(ActionAsker.class);
        when(actionAsker.ask("What would you like to do? (back/quit) ")).thenReturn("quit");
        assertEquals(null, profile.start(actionAsker));
    }

    @Test
    public void startBack() {
        ActionAsker actionAsker = mock(ActionAsker.class);
        when(actionAsker.ask("What would you like to do? (back/quit) ")).thenReturn("back");
        doReturn(profile.start(actionAsker))
                .when(profile)
                .newMenu(loggedInUser, borrowReturnList);

    }
}