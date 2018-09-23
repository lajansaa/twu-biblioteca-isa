import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class UserTest {

    private User mockUser = new User();

    @Before
    public void setUserAttributes() {
        mockUser.setName("Mock Name");
        mockUser.setEmail("Mock Email");
        mockUser.setNumber("98765432");
        mockUser.setRole("librarian");
        mockUser.setLibraryNumber("123-1234");
        mockUser.setPassword("password");
        mockUser.setLoginStatus(true);
    }

    @Test
    public void getName() {
        assertEquals("Mock Name", mockUser.getName());
    }

    @Test
    public void getEmail() {
        assertEquals("Mock Email", mockUser.getEmail());
    }

    @Test
    public void getNumber() {
        assertEquals("98765432", mockUser.getNumber());
    }

    @Test
    public void getRole() {
        assertEquals("librarian", mockUser.getRole());
    }

    @Test
    public void getLibraryNumber() {
        assertEquals("123-1234", mockUser.getLibraryNumber());
    }

    @Test
    public void getPassword() {
        assertEquals("password", mockUser.getPassword());
    }

    @Test
    public void getLoginStatus() {
        assertEquals(true, mockUser.getLoginStatus());
    }

}