package com.mycompany.ex02;

import java.util.ArrayList;

public class MainTest {

    public void testExecute() {
        ArrayList<Item2d> items = new ArrayList<>();
        items.add(new Item2d());
        items.add(new Item2d());
        items.add(new Item2d());

        Menu menu = Menu.getInstance();
        menu.addCommand(new ChangeItemCommand(items, 1, 1.5, 2.5));
        menu.executeCommand(0);

        Item2d changedItem = items.get(1);
        System.out.println("Changed item: X = " + changedItem.getX() + ", Y = " + changedItem.getY());
    }

    public void testChangeConsoleCommand() {
        ArrayList<Item2d> items = new ArrayList<>();
        items.add(new Item2d());
        items.add(new Item2d());
        items.add(new Item2d());

        ConsoleCommand changeCommand = new ChangeConsoleCommand(items, 1, 2.0, 3.0);
        System.out.println("Hotkey for ChangeConsoleCommand: " + changeCommand.getKey());
        changeCommand.execute();

        Item2d changedItem = items.get(1);
        System.out.println("Changed item: X = " + changedItem.getX() + ", Y = " + changedItem.getY());
    }

    public static void main(String[] args) {
        MainTest test = new MainTest();
        test.testExecute();
        test.testChangeConsoleCommand();
    }
}
