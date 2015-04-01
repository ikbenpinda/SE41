package com.example.etienne.pizzapp.pizzapp;

import com.example.etienne.pizzapp.pizzapp.Order;
import java.util.ArrayList;

/**
 * Container class for previously ordered pizzas.
 * Created by Etienne on 1-4-2015.
 */
public class History {

    public ArrayList<Order> Orders;

    public History(boolean withfakedata) {
        Orders = withfakedata ? createFakeData() : new ArrayList<Order>();
    }

    public static ArrayList<Order> createFakeData(){
        ArrayList<Order> orders = new ArrayList<>();

        for (int i = 0; i < 3; i++) {
            orders.add(Order.randomize());
        }

        return orders;
    }
}
