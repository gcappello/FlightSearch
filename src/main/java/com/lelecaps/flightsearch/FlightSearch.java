/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.lelecaps.flightsearch;

import com.lelecaps.flightsearch.data.Airport;
import com.lelecaps.flightsearch.data.Airline;
import java.util.*;
import java.io.*;

/**
 *
 * @author gabriele
 */
public class FlightSearch {

    ArrayList<Airport> airports = new ArrayList<>();
    ArrayList<Airline> airlines = new ArrayList<>();

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        String origin, destination;
        int adult, child, infant;
        Date departure = new Date();

        FlightSearch fs = new FlightSearch();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        fs.setup();

        try {
            System.out.print("Insert your origin: ");
            origin = br.readLine();
            System.out.print("Insert your destination: ");
            destination = br.readLine();
            System.out.print("Insert the number of adults: ");
            //adult = br.readLine(); // convert to number
            System.out.print("Insert the number of children: ");
            //child = br.readLine();
            System.out.print("Insert the number of infants: ");
            //infant = br.readLine();

        } catch (IOException exc) {
            System.out.println("Error on input.");
        }
    }

    void setup() {
        // set airports informations
        airports.add(new Airport("MAD", "Madrid"));
        airports.add(new Airport("BCN", "Barcelona"));
        airports.add(new Airport("LHR", "London"));
        airports.add(new Airport("CDG", "Paris"));
        airports.add(new Airport("FRA", "Frakfurt"));
        airports.add(new Airport("IST", "Istanbul"));
        airports.add(new Airport("AMS", "Amsterdam"));
        airports.add(new Airport("FCO", "Rome"));
        airports.add(new Airport("CPH", "Copenhagen"));
        // set airlines informations with infant prices
        airlines.add(new Airline("IB", "Iberia", 10));
        airlines.add(new Airline("BA", "British Airways", 15));
        airlines.add(new Airline("LH", "Lufthansa", 7));
        airlines.add(new Airline("FR", "Ryanair", 20));
        airlines.add(new Airline("VY", "Vueling", 10));
        airlines.add(new Airline("TK", "Turkish Airlines", 5));
        airlines.add(new Airline("U2", "Easyjet", 19.90));
    }

}
