/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.rofcapp;

import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;

/**
 * A class for testing the furniture ordering system.
 * @author Francis Okoye (C2680301)
 */
public class FurnitureTest {
    private static final Logger LOGGER = Logger.getLogger(FurnitureTest.class.getName());
    private static final String CHAIR_IMAGE_PATH = "C:\\Users\\USER\\OneDrive\\Documents\\NetBeansProjects\\Furniture Image\\Chair\\With Armrest\\chair.png";
    private static final String DESK_IMAGE_PATH = "C:\\Users\\USER\\OneDrive\\Documents\\NetBeansProjects\\Furniture Image\\Desk\\Desk.png";
    private static final String TABLE_IMAGE_PATH = "C:\\Users\\USER\\OneDrive\\Documents\\NetBeansProjects\\Furniture Image\\Table\\Wood Base\\Table.png";

    /**
     * Main method to test the furniture ordering system.
     * @param args Command line arguments (not used).
     */
    public static void main(String[] args) {
        // Create some furniture items
        Table table1;
        Table table2;
        Desk desk1;
        Desk desk2;
        Chair chair1;
        Chair chair2;

        chair2 = loadChair("C2", WOOD_TYPE.OAK, 2, false);
        chair1 = loadChair("C1", WOOD_TYPE.WALNUT, 4, true);

        table1 = loadTable("T1", WOOD_TYPE.OAK, 2, 90, BASE.CHROME);
        table2 = loadTable("T2", WOOD_TYPE.WALNUT, 4, 50, BASE.WOOD);

        desk1 = loadDesk("D1", WOOD_TYPE.OAK, 1, 90, 120, 4);
        desk2 = loadDesk("D2", WOOD_TYPE.WALNUT, 3, 60, 90, 3);

        // Create an order and add the furniture items to it
        Order order = new Order();
        order.addFurniture(chair1);
        order.addFurniture(chair2);
        order.addFurniture(table1);
        order.addFurniture(table2);
        order.addFurniture(desk1);
        order.addFurniture(desk2);

        // Print the order details
        System.out.println(order.toString());
    }
    /**
     * Load a chair with the given parameters.
     * @param id The ID of the chair.
     * @param woodType The wood type of the chair.
     * @param quantity The quantity of the chair.
     * @param withArmrest Whether the chair has armrests.
     * @return The loaded Chair object.
     * @throws an Exception If loading the chair image fails.
     */
    private static Chair loadChair(String id, WOOD_TYPE woodType, int quantity, boolean withArmrest) {
        try {
            return new Chair(id, woodType,  new ImageIcon(CHAIR_IMAGE_PATH),quantity, withArmrest);
        } catch (Exception  e) {
            LOGGER.log(Level.SEVERE, "Unable to load chair image", e);
            return null;
        }
    }
    /**
     * Load a table with the given parameters.
     * @param id The ID of the table.
     * @param woodType The wood type of the table.
     * @param quantity The quantity of the table.
     * @param diameter The diameter of the table.
     * @param base The base of the table.
     * @return The loaded Table object.
     * @throws an Exception If loading the table image fails.
     */
    private static Table loadTable(String id, WOOD_TYPE  woodType, int quantity, int diameter, BASE base) {
        try {
            return new Table(id, woodType, quantity, new ImageIcon(TABLE_IMAGE_PATH), diameter, base);
        } catch (Exception e) {
            LOGGER.log(Level.SEVERE, "Unable to load table image", e);
            return null;
        }
    }
     /**
     * Load a desk with the given parameters.
     * @param id The ID of the desk.
     * @param woodType The wood type of the desk.
     * @param quantity The quantity of the desk.
     * @param width The width of the desk.
     * @param length The length of the desk.
     * @param drawers The number of drawers in the desk.
     * @return The loaded Desk object.
     * @throws an Exception If loading the desk image fails.
     */
    private static Desk loadDesk(String id, WOOD_TYPE  woodType, int quantity, int width, int length, int drawers) {
        try {
            return new Desk(id, woodType, quantity, new ImageIcon(DESK_IMAGE_PATH), width, length, drawers);
        } catch (Exception e) {
            LOGGER.log(Level.SEVERE, "Unable to load desk image", e);
            return null;
        }
    }
}

