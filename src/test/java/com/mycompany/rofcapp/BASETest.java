/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit5TestClass.java to edit this template
 */
package com.mycompany.rofcapp;

import static com.mycompany.rofcapp.BASE.CHROME;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 *
 * @author USER FRANCIS OKOYE (C2680301)
 */
public class BASETest {
    
    public BASETest() {
    }
    
    @BeforeAll
    public static void setUpClass() {
    }
    
    @AfterAll
    public static void tearDownClass() {
    }
    
    @BeforeEach
    public void setUp() {
    }
    
    @AfterEach
    public void tearDown() {
    }

    /**
     * Test of values method, of class BASE.
     */
    @Test
    public void testValues() {
        System.out.println("values");
        BASE[] expResult = null;
        BASE[] result = BASE.values();
        assertArrayEquals(expResult, result);
       
    }

    /**
     * Test of valueOf method, of class BASE.
     */
    @Test
    public void testValueOf() {
        System.out.println("valueOf");
        String name = "CHROME";
        BASE expResult = CHROME;
        BASE result = BASE.valueOf(name);
        assertEquals(expResult, result);
        
    }

    /**
     * Test of getPrice method, of class BASE.
     */
    @Test
    public void testGetPrice() {
        System.out.println("getPrice");
        BASE instance = BASE.WOOD;
        double expResult = 40;
        double result = instance.getPrice();
        assertEquals(expResult, result, 0);
        
    }
    
}
