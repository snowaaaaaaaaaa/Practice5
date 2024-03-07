package com.mycompany.ex02;

import java.io.*;
import java.util.ArrayList;
import java.util.Random;

public class ViewResult implements View, Serializable {
    private static final long serialVersionUID = 1L;
    private static final String FNAME = "items.bin";
    private ArrayList<Item2d> items = new ArrayList<>();

    public ViewResult() {
        this(DEFAULT_NUM);
    }

    public ViewResult(int n) {
        Random random = new Random();
        for(int ctr = 0; ctr < n; ctr++) {
            double x = random.nextDouble();
            double y = Math.sin(x * Math.PI / 180);
            Item2d item = new Item2d();
            item.setXY(x, y);
            items.add(item);
        }
    }

    public ArrayList<Item2d> getItems() {
        return items;
    }

    private double calc(double x) {
        return Math.sin(x * Math.PI / 180);
    }

    public void init(double stepX) {
        double x = 0.0;
        for(Item2d item : items) {
            item.setXY(x, calc(x));
            x += stepX;
        }
    }

    @Override
    public void viewInit() {
    }

    public void viewSave() throws IOException {
        try (ObjectOutputStream os = new ObjectOutputStream(new FileOutputStream(FNAME))) {
            os.writeObject(items);
            os.flush();
        }
    }

    @SuppressWarnings("unchecked")
    public void viewRestore() throws Exception {
        try (ObjectInputStream is = new ObjectInputStream(new FileInputStream(FNAME))) {
            items = (ArrayList<Item2d>) is.readObject();
        }
    }

    @Override
    public void viewShow() {
        viewHeader();
        viewBody();
        viewFooter();
    }

    public void viewHeader() {
        System.out.println("Results:");
        System.out.println("   X   |   Y   ");
        System.out.println("----------------");
    }

    public void viewBody() {
        for(Item2d item : items) {
            System.out.printf("%5.2f  |  %5.2f%n", item.getX(), item.getY());
        }
    }

    public void viewFooter() {
        System.out.println("End.");
    }
}
