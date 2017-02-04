/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.lelecaps.flightsearch;

import com.lelecaps.flightsearch.data.Airport;
import com.lelecaps.flightsearch.data.Airline;
import com.lelecaps.flightsearch.data.Flight;
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
    public static void main(String[] args) throws FileNotFoundException {
        // TODO code application logic here
        String origin, destination;
        int adult, child, infant;
        Date departure = new Date();
        Date today = new Date();
        FlightSearch fs = new FlightSearch();
        ArrayList<Flight> flights = new ArrayList<>();
        
        fs.setup();
        
        try (Scanner scan = new Scanner(System.in)) {
            // reading request
            System.out.println("Insert airport of origin: ");
            origin = scan.nextLine();
            System.out.println("Insert airport of destination: ");
            destination = scan.nextLine();
            System.out.println("Insert date of departure: ");
            departure = scan.next();
            System.out.println("Insert number of adults: ");
            adult = scan.nextInt();
            System.out.println("Insert number of children: ");
            child = scan.nextInt();
            System.out.println("Insert number of infants: ");
            infant = scan.nextInt();
            
            scan.close();
        }
        flights = (searchRoute(origin, destination));
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

    public ArrayList<Flight> searchRoute(String o, String d) throws FileNotFoundException {
        Scanner scanner = new Scanner(new File("resources/flights.csv"));
        scanner.useDelimiter(",");
        ArrayList<Flight> flights = new ArrayList<>();

        while (scanner.hasNextLine()) {
            if (o == scanner.next()) {
                if (d == scanner.next()) {
                    flights.add(new Flight(o, d, scanner.next(), scanner.nextInt()));
                }
            }
            scanner.nextLine();
        }
        return flights;

    }

}
