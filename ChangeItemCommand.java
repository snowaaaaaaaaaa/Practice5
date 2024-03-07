package com.mycompany.ex02;

import java.util.ArrayList;

public class ChangeItemCommand implements ConsoleCommand {
    private final ArrayList<Item2d> items;
    private final int index;
    private final double newX;
    private final double newY;
    private double oldX;
    private double oldY;

    public ChangeItemCommand(ArrayList<Item2d> items, int index, double newX, double newY) {
        this.items = items;
        this.index = index;
        this.newX = newX;
        this.newY = newY;
    }

    @Override
    public void execute() {
        if (index >= 0 && index < items.size()) {
            Item2d item = items.get(index);
            oldX = item.getX();
            oldY = item.getY();
            item.setXY(newX, newY);
        }
    }

    /**
     *
     */
    @Override
    public void undo() {
        if (index >= 0 && index < items.size()) {
            Item2d item = items.get(index);
            item.setXY(oldX, oldY);
        }
    }

    @Override
public char getKey() {

    return 'C';
}

}
