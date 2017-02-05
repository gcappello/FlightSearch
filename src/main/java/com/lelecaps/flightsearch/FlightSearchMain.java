/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.lelecaps.flightsearch;

import com.lelecaps.flightsearch.data.ResultFlight;
import java.io.FileNotFoundException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/**
 *
 * @author gabriele
 */
public class FlightSearchMain {

    public static void main(String[] args) throws FileNotFoundException, ParseException {
        DateFormat df = new SimpleDateFormat("dd/MM/yyyy");

        Calendar cal = Calendar.getInstance();
        cal.set(Calendar.HOUR_OF_DAY, 0);
        cal.set(Calendar.MINUTE, 0);
        cal.set(Calendar.SECOND, 0);
        cal.set(Calendar.MILLISECOND, 0);
        cal.add(Calendar.DAY_OF_MONTH, 2);

        String date = df.format(cal.getTime());

//        FlightSearch fs = new FlightSearch("BCN", "MAD", "07/02/2017", 1, 2, 0);
        FlightSearch fs = new FlightSearch("BCN", "MAD", date, 1, 2, 0);
        for (ResultFlight rf : fs.results) {
            System.out.println(rf.toString());
        }
        System.exit(0);
    }

}
