/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit5TestClass.java to edit this template
 */
package com.mycompany.rofcapp;

import javax.swing.ImageIcon;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 *
 * @author USER
 */
public class ChairTest {
    
    public ChairTest() {
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
     * Test of getImageIcon method, of class Chair.
     */
    @Test
    public void testGetImageIcon() {
        System.out.println("getImageIcon");
        Chair instance = new Chair();
        ImageIcon expResult = null;
        ImageIcon result = instance.getImageIcon();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setImageIcon method, of class Chair.
     */
    @Test
    public void testSetImageIcon() {
        System.out.println("setImageIcon");
        ImageIcon image = null;
        Chair instance = new Chair();
        ImageIcon expResult = null;
        ImageIcon result = instance.setImageIcon(image);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of calculatePrice method, of class Chair.
     */
    @Test
    public void testCalculatePrice() {
        System.out.println("calculatePrice");
        Chair instance = new Chair();
        double expResult = 0.0;
        double result = instance.calculatePrice();
        assertEquals(expResult, result, 0);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of toString method, of class Chair.
     */
    @Test
    public void testToString() {
        System.out.println("toString");
        Chair instance = new Chair();
        String expResult = "";
        String result = instance.toString();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
