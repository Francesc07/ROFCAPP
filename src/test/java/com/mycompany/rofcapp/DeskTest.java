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
public class DeskTest {
    
    public DeskTest() {
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
     * Test of getDepth method, of class Desk.
     */
    @Test
    public void testGetDepth() {
        System.out.println("getDepth");
        Desk instance = new Desk();
        int expResult = 0;
        int result = instance.getDepth();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setDepth method, of class Desk.
     */
    @Test
    public void testSetDepth() {
        System.out.println("setDepth");
        int depth = 0;
        Desk instance = new Desk();
        instance.setDepth(depth);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getWidth method, of class Desk.
     */
    @Test
    public void testGetWidth() {
        System.out.println("getWidth");
        Desk instance = new Desk();
        int expResult = 0;
        int result = instance.getWidth();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setWidth method, of class Desk.
     */
    @Test
    public void testSetWidth() {
        System.out.println("setWidth");
        int width = 0;
        Desk instance = new Desk();
        instance.setWidth(width);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getDrawers method, of class Desk.
     */
    @Test
    public void testGetDrawers() {
        System.out.println("getDrawers");
        Desk instance = new Desk();
        int expResult = 0;
        int result = instance.getDrawers();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setDrawers method, of class Desk.
     */
    @Test
    public void testSetDrawers() {
        System.out.println("setDrawers");
        int drawers = 0;
        Desk instance = new Desk();
        instance.setDrawers(drawers);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setImageIcon method, of class Desk.
     */
    @Test
    public void testSetImageIcon() {
        System.out.println("setImageIcon");
        ImageIcon image = null;
        Desk instance = new Desk();
        ImageIcon expResult = null;
        ImageIcon result = instance.setImageIcon(image);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of calculatePrice method, of class Desk.
     */
    @Test
    public void testCalculatePrice() {
        System.out.println("calculatePrice");
        Desk instance = new Desk();
        double expResult = 0.0;
        double result = instance.calculatePrice();
        assertEquals(expResult, result, 0);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of toString method, of class Desk.
     */
    @Test
    public void testToString() {
        System.out.println("toString");
        Desk instance = new Desk();
        String expResult = "";
        String result = instance.toString();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getImageIcon method, of class Desk.
     */
    @Test
    public void testGetImageIcon() {
        System.out.println("getImageIcon");
        Desk instance = new Desk();
        ImageIcon expResult = null;
        ImageIcon result = instance.getImageIcon();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
