package com.mycompany.ex02;

import java.util.ArrayList;

public class ChangeConsoleCommand implements ConsoleCommand {
    private final ArrayList<Item2d> items;
    private final int index;
    private final double newX;
    private final double newY;

    public ChangeConsoleCommand(ArrayList<Item2d> items, int index, double newX, double newY) {
        this.items = items;
        this.index = index;
        this.newX = newX;
        this.newY = newY;
    }

    @Override
    public void execute() {
        if (index >= 0 && index < items.size()) {
            Item2d item = items.get(index);
            item.setXY(newX, newY);
        }
    }

    @Override
    public char getKey() {
        return 'C';
    }
}
