import java.util.ArrayList;
import java.util.Arrays;

public class BookList extends ItemList {

    public BookList(LoggedInUser loggedInUser, BorrowReturnList borrowReturnList) {
        super("Book", loggedInUser, borrowReturnList);
        initialise();
    }

    private void initialise() {
        ArrayList<String> titleList = new ArrayList<>(Arrays.asList("Murder on Orient Expressway", "The ABC Murders", "Crooked House"));
        ArrayList<String> yearList = new ArrayList<>(Arrays.asList("1934", "1936", "1949"));
        for (int i = 0; i < titleList.size(); i++) {
            Book book = new Book(titleList.get(i), yearList.get(i));
            addItem(book);
        }
    }
}
