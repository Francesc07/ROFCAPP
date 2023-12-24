/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit5TestClass.java to edit this template
 */
package com.mycompany.rofcapp;

import java.util.List;
import javax.swing.JLabel;
import javax.swing.JPanel;
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
public class OrderTest {
    
    public OrderTest() {
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
     * Test of addFurniture method, of class Order.
     */
    @Test
    public void testAddFurniture() {
        System.out.println("addFurniture");
        Furniture furniture = null;
        Order instance = new Order();
        instance.addFurniture(furniture);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getFurnitureList method, of class Order.
     */
    @Test
    public void testGetFurnitureList() {
        System.out.println("getFurnitureList");
        Order instance = new Order();
        List<Furniture> expResult = null;
        List<Furniture> result = instance.getFurnitureList();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setFurnitureList method, of class Order.
     */
    @Test
    public void testSetFurnitureList() {
        System.out.println("setFurnitureList");
        List<Furniture> furnitureList = null;
        Order instance = new Order();
        instance.setFurnitureList(furnitureList);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of removeFurniture method, of class Order.
     */
    @Test
    public void testRemoveFurniture() {
        System.out.println("removeFurniture");
        Furniture furniture = null;
        Order instance = new Order();
        instance.removeFurniture(furniture);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of clearOrder method, of class Order.
     */
    @Test
    public void testClearOrder() {
        System.out.println("clearOrder");
        Order instance = new Order();
        instance.clearOrder();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of calculateTotalPrice method, of class Order.
     */
    @Test
    public void testCalculateTotalPrice() {
        System.out.println("calculateTotalPrice");
        Order instance = new Order();
        double expResult = 0.0;
        double result = instance.calculateTotalPrice();
        assertEquals(expResult, result, 0);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of toString method, of class Order.
     */
    @Test
    public void testToString() {
        System.out.println("toString");
        Order instance = new Order();
        String expResult = "";
        String result = instance.toString();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of updateOrderDetails method, of class Order.
     */
    @Test
    public void testUpdateOrderDetails() {
        System.out.println("updateOrderDetails");
        JPanel orderPanel = null;
        JLabel totalLabel = null;
        Order instance = new Order();
        instance.updateOrderDetails(orderPanel, totalLabel);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
