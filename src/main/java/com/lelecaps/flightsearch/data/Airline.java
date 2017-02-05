package com.lelecaps.flightsearch.data;

/**
 *
 * @author gabriele
 */
public class Airline {
    
    String code;
    String name;
    double infant_price;

    public Airline(String pcode, String pname, double pinfant_price) {
        code = pcode;
        name = pname;
        infant_price = pinfant_price;
    }
    
    public String getCode(){
        return code;
    }
    
    public double getInfantPrice(){
        return infant_price;
    }
}
