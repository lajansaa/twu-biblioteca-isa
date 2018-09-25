import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

//@RunWith(Parameterized.class)
public class CheckUserInputTest {
//    private String input;
//    private boolean expected;
//
//    public CheckUserInputTest(String input, boolean expected) {
//        this.input = input;
//        this.expected = expected;
//    }
//
//    @Parameterized.Parameters
//    public static Collection<Object[]> data() {
//        return Arrays.asList(new Object[][] {
//                {"quit", false},
//                {"back", true},
//                {"borrow 1", true},
//        });
//    }

    @Test
    public void checkQuit() {
        CheckUserInput checkUserInput = new CheckUserInput();
        MenuOriginal mockMenu = mock(MenuOriginal.class);
        Display display = mock(Display.class);
        assertEquals(false, checkUserInput.check("quit", mockMenu, display));
    }

    @Test
    public void checkBack() {
        CheckUserInput checkUserInput = new CheckUserInput();
        MenuOriginal mockMenu = mock(MenuOriginal.class);
        Display display = mock(Display.class);
        checkUserInput.check("back", mockMenu, display);
        verify(display).println("This is the home page. Please select a valid menu option!");
    }

    @Test
    public void checkMenuOption() {
        CheckUserInput checkUserInput = new CheckUserInput();
        MenuOriginal mockMenu = mock(MenuOriginal.class);
        MenuOption mockMenuOption = mock(MenuOption.class);

        ArrayList<MenuOption> mockList = new ArrayList<>();
        mockList.add(mockMenuOption);

        Display display = mock(Display.class);

        when(mockMenu.getList()).thenReturn(mockList);

//        assertEquals(1, mockMenu.getList().size());
        checkUserInput.check("1", mockMenu, display);
        verify(mockMenuOption).start();
//        verify(display).println("Please select a valid option!");
    }
}