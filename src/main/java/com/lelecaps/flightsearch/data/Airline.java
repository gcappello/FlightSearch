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
public class Airline {
    // test
    String code;
    String name;
    double infant_price;

    public Airline(String pcode, String pname, double pinfant_price) {
        code = pcode;
        name = pname;
        infant_price = pinfant_price;
    }
}
