import java.util.ArrayList;
import java.util.Arrays;

public class MovieList extends ItemList {
    private ArrayList<Item> movieList;
    private LoggedInUser loggedInUser;
    private BorrowReturnList borrowReturnList;

    public MovieList(LoggedInUser loggedInUser, BorrowReturnList borrowReturnList) {
        super("Movie", loggedInUser, borrowReturnList);
        this.movieList = this.getItemList();
        this.borrowReturnList = this.getBorrowReturnList();
        this.loggedInUser = loggedInUser;
        initialise();
    }

    private void initialise() {
        ArrayList<String> titleList = new ArrayList<>(Arrays.asList("Zootopia", "Big Hero 6", "The Incredibles"));
        ArrayList<String> yearList = new ArrayList<>(Arrays.asList("2016", "2014", "2004"));
        ArrayList<String> directorList = new ArrayList<>(Arrays.asList("Byron Howard", "Don Hall", "Brad Bird"));
        ArrayList<MovieRating> ratingList = new ArrayList<>(Arrays.asList(MovieRating.EIGHT, MovieRating.UNRATED, MovieRating.NINE));
        for (int i = 0; i < titleList.size(); i++) {
            Movie movie = new Movie(titleList.get(i), yearList.get(i),directorList.get(i), ratingList.get(i));
            addItem(movie);
        }
    }

    private String printIfLibrarian(Movie movie) {
        String output = "";
        if (loggedInUser.getLoggedInUser() != null) {
            boolean isLibrarian = loggedInUser.getLoggedInUser().getRole().equals("librarian");
            boolean isItemUnavailable = !borrowReturnList.isItemAvailable(movie);
            if (isLibrarian && isItemUnavailable) {
                output += " (Borrowed by: " + borrowReturnList.getBorrower(movie).getName() + " - " + borrowReturnList.getBorrower(movie).getNumber() + ")";
            }
        }
        return output;
    }

    public void printList(Display display) {
        for (int i = 0; i < movieList.size(); i++) {
            String output = (i + 1) + ". ";
            Movie movie = (Movie) movieList.get(i);
            output += movie.getTitle();
            output += " (" + movie.getYear() + "), ";
            output += movie.getDirector() + ", ";
            output += movie.getRating() + ": ";
            output += borrowReturnList.isItemAvailable(movie) ? "Available" : "Not Available";
            output += printIfLibrarian(movie);

            display.println(output);
        }
    }
}
