import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

public class MenuTest {
    private Menu mockMenu = new Menu(new LoggedInUser());
    private MenuOption mockMenuOption = mock(MenuOption.class);

    @Before
    public void setUpMenu() {
        mockMenu.addMenuOption(mockMenuOption);
    }

    @Test
    public void printMenu() {
        Display display = mock(Display.class);
        when(mockMenuOption.getMenuOptionTitle()).thenReturn("Mock Option");
        mockMenu.printMenu(display);
        verify(display).println("1. Mock Option");
    }

    @Test
    public void removeMenuOption() {
        when(mockMenuOption.getMenuOptionTitle()).thenReturn("Mock Option");
        mockMenu.removeMenuOption("Mock Option");
        assertEquals(0, mockMenu.getList().size());
    }

}