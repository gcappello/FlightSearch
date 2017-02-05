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
import java.text.DecimalFormat;
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
        // input data
        String origin, destination;
        int adult, child, infant;
        Date departure;

        DateFormat df = new SimpleDateFormat("dd/MM/yyyy");
        DecimalFormat decf = new DecimalFormat("#.##");
        String date;
        Date today = df.parse(df.format(Calendar.getInstance().getTime()));
        int period;
        FlightSearch fs = new FlightSearch();

        fs.setup();

        try (Scanner scan = new Scanner(System.in)) {
            // reading request
            System.out.println("Insert airport of origin: ");
            origin = scan.nextLine();
            if (!fs.searchAirport(origin)) {
                fs.forceExit("airport");
            }
            System.out.println("Insert airport of destination: ");
            destination = scan.nextLine();
            if (!fs.searchAirport(destination)) {
                fs.forceExit("airport");
            }
            System.out.println("Insert date of departure (dd/MM/yyyy): ");
            date = scan.nextLine();
            departure = df.parse(date);
            period = (int) ((departure.getTime() - today.getTime()) / (24 * 60 * 60 * 1000));
//            System.out.println("today is " + today + ", depart " + departure +", period " + period);
            if (period <= 0) {
                fs.forceExit("date");
            }
            System.out.println("Insert number of adults: ");
            adult = scan.nextInt();
            if (adult <= 0) {
                fs.forceExit("adult");
            }
            System.out.println("Insert number of children: ");
            child = scan.nextInt();
            if (child < 0) {
                fs.forceExit("");
            }
            System.out.println("Insert number of infants: ");
            infant = scan.nextInt();
            if (infant < 0) {
                fs.forceExit("");
            }
            System.out.println();
            scan.close();
        }

        fs.searchRoute(origin, destination);

        if (fs.flights.isEmpty()) {
            System.out.println("no flights available");
        } else {
            int percentage;
            if (period >= 31) {
                // 80% of the base price
                percentage = 80;
            } else if (period >= 16) {
                // 100% of the base price
                percentage = 100;
            } else if (period >= 3) {
                // 120% of the base price
                percentage = 120;
            } else {
                // 150% of the base price
                percentage = 150;
            }

            for (int i = 0; i < fs.flights.size(); i++) {
                double full_price = (double) Math.round(fs.flights.get(i).getPrice() * percentage) / 100;
                double tot_price = 0;
                String adultString = "", childString = "", infantString = "";
                
                if (adult == 1 && child == 0 && infant == 0) {
                    tot_price = full_price;
                } else {
                    // adults
                    String fullPriceString = " (" + percentage + "% of " + fs.flights.get(i).getPrice() + ")";
                    adultString = " (" + adult + " *" + fullPriceString;
                    tot_price = full_price * adult;
                    if (child > 0) { 
                        // 33% discount of the full price
                        tot_price += full_price * child * 0.67;
                        childString = (child > 1 ? child + " *" : "") + " + 67% of" + fullPriceString;
                    }
                    if (infant > 0) {
                        String airlineCode = fs.flights.get(i).getAirline().substring(0, 2);

                        double infant_price = 0;
                        if (infant > 0) {
                            for (Airline a : fs.airlines) {
                                if (a.getCode().contains(airlineCode)) {
                                    infant_price = a.getInfantPrice();
                                    break;
                                }
                            }
                            tot_price += infant_price * infant;
                            infantString = " + " + (infant > 1 ? infant + " * " : "") +  decf.format(infant_price);
//                            infantString = " + " + (infant > 1 ? infant + " * " : "") +  (double) Math.round(infant_price * 100) / 100;
                        }
                    }
                }
//                String outputString = fs.flights.get(i).getAirline() + ", " + (double) Math.round(tot_price * 100) / 100 + " €" + adultString + childString + infantString;
                String outputString = fs.flights.get(i).getAirline() + ", " + decf.format(tot_price) + " €" + adultString + childString + infantString;
                if(adult+child+infant > 1){
                    outputString += ")";
                }
                System.out.println(outputString);
            }
        }
    }

    void forceExit(String s) {
        switch (s) {
            case "airport":
                System.out.println("Airport code not found");
                break;
            case "date":
                System.out.println("Date of departure cannot be earlier than tomorrow");
                break;
            case "adult":
                System.out.println("Insert minimum 1 adult passanger");
                break;
            default:
                System.out.println("Wrong input");
                break;
        }
        System.exit(1);
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

    boolean searchAirport(String a) {
        for (Airport ap : airports) {
            if (ap.getCode().equals(a)) {
                return true;
            }
        }
        return false;
    }

    void searchRoute(String o, String d) throws FileNotFoundException {
        try (Scanner scanner = new Scanner(new File("src/main/resources/flights.csv"))) {
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
                        flights.add(new Flight(volo, prezzo));
//                        System.out.println(origine + "," + destinazione + "," + volo + "," + prezzo);
                    }
                }
            }
            scanner.close();
        }
    }
}
