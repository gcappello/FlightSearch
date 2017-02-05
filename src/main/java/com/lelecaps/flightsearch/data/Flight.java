package com.lelecaps.flightsearch.data;

/**
 *
 * @author gabriele
 */
public class Flight {

    String flightCode;
    int price;

    public Flight(String a, int p) {
        
        flightCode = a;
        price = p;
    }
    
    public String getAirline(){
        return flightCode;
    }
    
    public int getPrice(){
        return price;
    }
 
}
