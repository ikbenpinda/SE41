package com.example.etienne.pizzapp.pizzapp;

import android.content.Context;

import com.example.etienne.pizzapp.R;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Etienne on 23-3-2015.
 */
public class Pizza {

    private String name;
    private ArrayList<String> ingredients;
    private double price;
    private double size;

    public Pizza(String name, ArrayList<String> ingredients, double price, double size) {
        this.name = name;
        this.ingredients = ingredients;
        this.price = price;
        this.size = size;
    }

    public ArrayList<String> getIngredients() {
        return ingredients;
    }

    public void setIngredients(ArrayList<String> ingredients) {
        this.ingredients = ingredients;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public double getSize() {
        return size;
    }
    @Override
    public String toString() {
        return name;
    }

    public static Pizza randomize() {
        double price = Math.random() * 10;
        ArrayList<String> ingredients = new ArrayList<>();
        String[] ings = new String[]{
                "Tuna",
                "Pineapple",
                "Ham",
                "Chicken"
        };
        for (int i = 0; i < 5; i++) {
            int random = (int) Math.abs(Math.random() * 10);
                //ingredients.add();
        }

        return null;//Pizza(ingredients, price);
    }
}
