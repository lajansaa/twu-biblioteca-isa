package com.twu.biblioteca;

import java.util.ArrayList;
import java.util.Arrays;

public class BookList extends ItemList {
    private ArrayList<Item> bookList;

    public BookList(Biblioteca bib) {
        super("Book", bib);
        this.bookList = getItemList();
        initialiseBookList();
    }

    public void initialiseBookList() {
        ArrayList<String> titleList = new ArrayList<>(Arrays.asList("Murder on Orient Expressway", "The ABC Murders", "Crooked House"));
        ArrayList<String> yearList = new ArrayList<>(Arrays.asList("1934", "1936", "1949"));
        for (int i = 0; i < titleList.size(); i++) {
            Book book = new Book(titleList.get(i), yearList.get(i));
            addItem(book);
        }
    }
}
