package com.twu.biblioteca;
import java.util.*;

public class Biblioteca {
    private Menu menu = new Menu();
    private BookList bookList = new BookList(this);
    private MovieList movieList = new MovieList(this);
    private ArrayList<User> userList = new ArrayList<User>();
    private User loggedInUser = null;
    private Login login = new Login(this);
    private boolean running = true;

    public Biblioteca () {
        initialiseBookList();
        initialiseMovieList();
        initialiseUserList();
        initialiseMenu();
    }

    public void initialiseBookList() {
        ArrayList<String> titleList = new ArrayList<String>(Arrays.asList("Murder on Orient Expressway", "The ABC Murders", "Crooked House"));
        ArrayList<String> yearList = new ArrayList<String>(Arrays.asList("1934", "1936", "1949"));
        for (int i = 0; i < titleList.size(); i++) {
            Book book = new Book(titleList.get(i), yearList.get(i));
            bookList.addItem(book);
        }
    }

   public void initialiseMovieList() {
        ArrayList<String> titleList = new ArrayList<String>(Arrays.asList("Zootopia", "Big Hero 6", "The Incredibles"));
        ArrayList<String> yearList = new ArrayList<String>(Arrays.asList("2016", "2014", "2004"));
       ArrayList<String> directorList = new ArrayList<String>(Arrays.asList("Byron Howard", "Don Hall", "Brad Bird"));
       ArrayList<String> ratingList = new ArrayList<String>(Arrays.asList("8", "7", "8"));
        for (int i = 0; i < titleList.size(); i++) {
            Movie movie = new Movie(titleList.get(i), yearList.get(i),directorList.get(i), ratingList.get(i));
            movieList.addItem(movie);
        }
    }

    public void initialiseUserList() {
        ArrayList<String> nameList = new ArrayList<String>(Arrays.asList("Isa", "Jason"));
        ArrayList<String> emailList = new ArrayList<String>(Arrays.asList("isa@mail.com", "jason@mail.com"));
        ArrayList<String> numberList = new ArrayList<String>(Arrays.asList("98765432", "91234567"));
        ArrayList<String> roleList = new ArrayList<String>(Arrays.asList("librarian", "customer"));
        ArrayList<String> libraryNumberList = new ArrayList<String>(Arrays.asList("987-9876", "123-1234"));
        ArrayList<String> passwordList = new ArrayList<String>(Arrays.asList("librarian", "customer"));
        for (int i = 0; i < nameList.size(); i++) {
            User user = new User();
            user.setName(nameList.get(i));
            user.setEmail(emailList.get(i));
            user.setNumber(numberList.get(i));
            user.setRole(roleList.get(i));
            user.setLibraryNumber(libraryNumberList.get(i));
            user.setPassword(passwordList.get(i));
            user.setLoginStatus(false);
            userList.add(user);
        }
    }

    public void initialiseMenu() {
        menu.addMenuOption(bookList);
        menu.addMenuOption(movieList);
        menu.addMenuOption(login);
    }

    public void printWelcomeMessage() {
        System.out.println(" ");
        System.out.println("Welcome to Biblioteca!");
        System.out.println("----------------------");
        System.out.println("There's much you can do here!");
        System.out.println("At any point in time of your session with us, feel free to type back to go to a previous page or type quit to leave.");
    }

    public ArrayList<User> getUserList() {
        return userList;
    }

    public User getLoggedInUser() {
        return loggedInUser;
    }

    public void setLoggedInUser(User loggedInUser) {
        this.loggedInUser = loggedInUser;
    }

    public Menu getMenu() {
        return menu;
    }

    public void startBiblioteca() {
        printWelcomeMessage();
        menu.start();
        System.out.println("See you again soon!");
    }
}
