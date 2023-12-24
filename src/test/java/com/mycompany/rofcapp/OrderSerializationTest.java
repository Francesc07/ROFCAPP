/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit5TestClass.java to edit this template
 */
package com.mycompany.rofcapp;

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
public class OrderSerializationTest {
    
    public OrderSerializationTest() {
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
     * Test of saveOrder method, of class OrderSerialization.
     */
    @Test
    public void testSaveOrder() {
        System.out.println("saveOrder");
        Order order = null;
        OrderSerialization.saveOrder(order);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of loadOrder method, of class OrderSerialization.
     */
    @Test
    public void testLoadOrder() {
        System.out.println("loadOrder");
        String orderId = "";
        Order expResult = null;
        Order result = OrderSerialization.loadOrder(orderId);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of generateSavedOrderId method, of class OrderSerialization.
     */
    @Test
    public void testGenerateSavedOrderId() {
        System.out.println("generateSavedOrderId");
        String expResult = "";
        String result = OrderSerialization.generateSavedOrderId();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
