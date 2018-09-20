package com.twu.biblioteca;

import java.util.ArrayList;
import java.util.Arrays;

public class UserDB {
    private ArrayList<User> userList = new ArrayList<User>();

    public UserDB() {
        initialiseUserList();
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

    public ArrayList<User> getUserList() {
        return userList;
    }
}
