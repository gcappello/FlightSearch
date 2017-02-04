/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.lelecaps.flightsearch.data;

/**
 *
 * @author gabriele
 */
public class Flight {

    String origin;
    String destination;
    String airline;
    int price;

    public Flight(String o, String d, String a, int p) {
        origin = o;
        destination = d;
        airline = a;
        price = p;
    }
 
}
