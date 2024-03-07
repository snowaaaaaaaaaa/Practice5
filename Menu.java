package com.mycompany.ex02;

import java.util.ArrayList;


public class Menu {
    private final ArrayList<ConsoleCommand> commands;

    private static Menu instance;

    private Menu() {
        commands = new ArrayList<>();
    }

    public static Menu getInstance() {
        if (instance == null) {
            instance = new Menu();
        }
        return instance;
    }

    public void addCommand(ConsoleCommand command) {
        commands.add(command);
    }

    public void executeCommand(int choice) {
        boolean commandFound = false;
        for (ConsoleCommand command : commands) {
            if (command.getKey() == choice) {
                command.execute();
                commandFound = true;
                break;
            }
        }
        if (!commandFound) {
            System.out.println("Invalid command.");
        }
    }

    public void displayMenu() {
        System.out.println("Choose an action:");
        System.out.println(" 'v'iew, 'g'enerate, 's'ave, 'r'estore, 'c'hange, 'q'uit");
    }
}
