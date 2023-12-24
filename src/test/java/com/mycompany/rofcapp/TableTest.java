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
public class TableTest {
    
    public TableTest() {
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
     * Test of setDiameter method, of class Table.
     */
    @Test
    public void testSetDiameter() {
        System.out.println("setDiameter");
        int diameter = 0;
        Table instance = new Table();
        instance.setDiameter(diameter);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getdiameter method, of class Table.
     */
    @Test
    public void testGetdiameter() {
        System.out.println("getdiameter");
        Table instance = new Table();
        int expResult = 0;
        int result = instance.getdiameter();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getBase method, of class Table.
     */
    @Test
    public void testGetBase() {
        System.out.println("getBase");
        Table instance = new Table();
        BASE expResult = null;
        BASE result = instance.getBase();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setBase method, of class Table.
     */
    @Test
    public void testSetBase() {
        System.out.println("setBase");
        BASE base = null;
        Table instance = new Table();
        instance.setBase(base);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setImageIcon method, of class Table.
     */
    @Test
    public void testSetImageIcon() {
        System.out.println("setImageIcon");
        ImageIcon image = null;
        Table instance = new Table();
        ImageIcon expResult = null;
        ImageIcon result = instance.setImageIcon(image);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of calculatePrice method, of class Table.
     */
    @Test
    public void testCalculatePrice() {
        System.out.println("calculatePrice");
        Table instance = new Table();
        double expResult = 0.0;
        double result = instance.calculatePrice();
        assertEquals(expResult, result, 0);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of toString method, of class Table.
     */
    @Test
    public void testToString() {
        System.out.println("toString");
        Table instance = new Table();
        String expResult = "";
        String result = instance.toString();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getImageIcon method, of class Table.
     */
    @Test
    public void testGetImageIcon() {
        System.out.println("getImageIcon");
        Table instance = new Table();
        ImageIcon expResult = null;
        ImageIcon result = instance.getImageIcon();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
