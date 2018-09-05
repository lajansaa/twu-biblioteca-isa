package com.twu.biblioteca;

import java.util.ArrayList;

public class Menu {
    private ArrayList<MenuOption> list = new ArrayList<MenuOption>();

    public void addMenuOption(MenuOption option) {
        list.add(option);
    }

    public ArrayList<MenuOption> getList() {
        return list;
    }

    public void printMenu() {
        for (int i = 0; i < list.size(); i++) {
            System.out.println((i + 1) + ". " + list.get(i).getMenuOptionTitle());
        }
    }

    public void printDescription() {
        System.out.println("Menu");
        System.out.println("----");
        System.out.println("Type the number of an action you would like to take:");
        System.out.println(" ");
    }
}
