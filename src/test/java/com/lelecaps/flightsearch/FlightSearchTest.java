/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.lelecaps.flightsearch;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.Ignore;

/**
 *
 * @author gabriele
 */
public class FlightSearchTest {
    
    public FlightSearchTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of forceExit method, of class FlightSearch.
     */
    @Ignore
    @Test
    public void testForceExit() {
        System.out.println("forceExit");
        String s = "";
        FlightSearch instance = null;
        instance.forceExit(s);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setup method, of class FlightSearch.
     */
    @Ignore
    @Test
    public void testSetup() {
        System.out.println("setup");
        FlightSearch instance = null;
        instance.setup();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of searchAirport method, of class FlightSearch.
     */
    @Ignore
    @Test
    public void testSearchAirport() {
        System.out.println("searchAirport");
        String a = "";
        FlightSearch instance = null;
        boolean expResult = false;
        boolean result = instance.searchAirport(a);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of searchRoute method, of class FlightSearch.
     */
    @Ignore
    @Test
    public void testSearchRoute() throws Exception {
        System.out.println("searchRoute");
        String o = "";
        String d = "";
        FlightSearch instance = null;
        instance.searchRoute(o, d);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
