package com.example.etienne.pizzapp.pizzapp;

import java.util.ArrayList;

/**
 * Singleton object keeping track of userdata.
 * Perhaps not technically a 'state'.
 * Created by Etienne on 1-4-2015.
 */
public class State {

    private History history;

    private static State instance;

    private State() {this.history = new History(true);}

    public static State getInstance(){
        if (instance == null)
            instance = new State();
        return instance;
    }

    public History getHistory() {
        return history;
    }
}
