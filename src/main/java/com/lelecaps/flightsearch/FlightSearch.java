/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.lelecaps.flightsearch;

import com.lelecaps.flightsearch.data.*;
import java.util.*;
import java.io.*;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;

/**
 *
 * @author gabriele
 */
public class FlightSearch {

    ArrayList<Airport> airports = new ArrayList<>();
    ArrayList<Airline> airlines = new ArrayList<>();
    ArrayList<Flight> flights = new ArrayList<>();

    /**
     * @param args the command line arguments
     * @throws java.io.FileNotFoundException
     * @throws java.text.ParseException
     */
    public static void main(String[] args) throws FileNotFoundException, ParseException {
        String origin, destination;
        int adult, child, infant;
        Date departure = new Date();
        
        DateFormat df = new SimpleDateFormat("dd/MM/yyyy"); 
        String date;
        Date today = new Date();
        FlightSearch fs = new FlightSearch();
        
        fs.setup();
        
        try (Scanner scan = new Scanner(System.in)) {
            // reading request
            System.out.println("Insert airport of origin: ");
            origin = scan.nextLine();
            System.out.println("Insert airport of destination: ");
            destination = scan.nextLine();
            System.out.println("Insert date of departure: ");
            date = scan.nextLine();
            departure = df.parse(date);
            System.out.println("Insert number of adults: ");
            adult = scan.nextInt();
            System.out.println("Insert number of children: ");
            child = scan.nextInt();
            System.out.println("Insert number of infants: ");
            infant = scan.nextInt();
            
            scan.close();
        }
        fs.searchRoute(origin, destination);
        System.out.println("Sono stati trovati i seguenti voli.");
        System.out.println(fs.flights.toString());
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

    void searchRoute(String o, String d) throws FileNotFoundException {
        try (Scanner scanner = new Scanner(new File("src/main/resources/flights.csv"))) {
//            scanner.useDelimiter(",");
            flights = new ArrayList<>();
            scanner.nextLine(); // exclude first row
            while (scanner.hasNextLine()) {
                String[] row = scanner.nextLine().split(",");
                String origine = row[0];
                if (o.equals(origine)) {
                    String destinazione = row[1];
                    if (d.equals(destinazione)) {
                        String volo = row[2];
                        int prezzo = Integer.parseInt(row[3]);
                        flights.add(new Flight(origine, destinazione, volo, prezzo));
                        System.out.println("O: " +origine+", D: "+destinazione+", V: "+volo+", P: "+prezzo);
                    }
                }
//                scanner.nextLine();
            }
            scanner.close();
        }
    }
}
