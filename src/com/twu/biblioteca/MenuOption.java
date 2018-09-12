package com.twu.biblioteca;

public interface MenuOption {
    abstract String getMenuOptionTitle();
    abstract void printDescription();
    abstract boolean start();
    abstract boolean checkUserInput(String userInput);
}
