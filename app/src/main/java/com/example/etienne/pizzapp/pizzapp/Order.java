package com.example.etienne.pizzapp.pizzapp;

import java.util.*;

/**
 * Created by Etienne on 23-3-2015.
 */
public class Order {

    private List<Pizza> pizzas;
    private Date timestamp;
    private double total;

    public Order(ArrayList<Pizza> pizzas) {
        this.pizzas = new ArrayList<>();
        this.timestamp = new Date();
    }

    public List<Pizza> getPizzas() {
        return pizzas;
    }

    public void setPizzas(List<Pizza> pizzas) {
        this.pizzas = pizzas;
        calculatePrice();
    }

    public void addPizza(Pizza pizza){
        pizzas.add(pizza);
        calculatePrice();
    }

    private double calculatePrice() {
        for (Pizza p : pizzas){
            total += p.getPrice();
        }

        return total;
    }

    /**
     * Gets a receipt.
     * @return a String with all pizzas, the timestamp and the total price.
     */
    @Override
    public String toString() {
        String receipt =  "Order of " + timestamp.toString();

        for(Pizza p : pizzas){
            receipt += p.toString() + "\n";
        }

        receipt += "\n, total: €" + total + ",-";

        return receipt;
    }

    public static Order randomize() {
        ArrayList<Pizza> pizzas;

        for (int i = 0; i < 5; i++) {
            Pizza pizza = Pizza.randomize();
            //pizzas.add(pizza);
        }

        return null;//new Order(pizzas);
    }
}
