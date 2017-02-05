package com.lelecaps.flightsearch.data;

/**
 *
 * @author gabriele
 */
public class Airport {

    String code;
    String city;

    public Airport(String pcode, String pcity) {
        code = pcode;
        city = pcity;
    }
    
    public String getCode(){
        return code;
    }
}
