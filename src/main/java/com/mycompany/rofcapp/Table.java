/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.rofcapp;

import java.io.Serializable;
import javax.swing.ImageIcon;

/**
 * A class representing a table with properties like diameter, wood type, base, and price.
 * 
 * @author Francis Okoye (C2680301)
 */
public class Table extends Furniture implements Serializable {
    /** The diameter of the table. */
    private int diameter;
     /** The type of base used for the table. */
    private BASE base;
    
    private static final String TABLE_IMAGE_PATH = "C:\\Users\\USER\\OneDrive\\Documents\\NetBeansProjects\\ROFCAPP\\Images\\TableImage\\table.png";
    
    

    /**
     * Default constructor for a Table.
     * Initializes instance variables to default values.
     */
    public Table() {
        super();
        this.diameter = diameter;
        this.base = null;
    }

    /**
     * Parameterized constructor for a Table.
     *
     * @param ID       The ID of the table.
     * @param woodType The type of wood used for the table (OAK or WALNUT).
     * @param quantity The quantity of tables.
     * @param image    The ImageIcon representing the table.
     * @param diameter The diameter of the table.
     * @param base     The base type of the table (e.g., CHROME).
     */
    public Table(String ID, WOOD_TYPE woodType, int quantity, ImageIcon image, int diameter, BASE base) {
        super(ID, woodType, quantity, image);
        this.diameter = diameter;
        this.base = base;
        this.image = new ImageIcon(TABLE_IMAGE_PATH);
    }

    /**
     * Set the diameter of the table.
     *
     * @param diameter
     */
    public void setDiameter(int diameter) {
        this.diameter = diameter;
        
    }
     /**
     * Get the diameter of the table.
     *
     * @return The diameter of the table.
     */
    public int getdiameter(){
        return diameter;
    }

    /**
     * Get the base type of the table.
     *
     * @return The base type of the table (e.g., CHROME).
     */
    public BASE getBase() {
        return base;
    }
    /**
     * Set the base type of the table.
     *
     * @param base The base type of the table.
     */
    public void setBase(BASE base){
        this.base = base;
            }
    
    /**
     * Set the ImageIcon representing the table.
     *
     * @param image The ImageIcon to set.
     * @return 
     */
    public ImageIcon setImageIcon(ImageIcon image) {
        return this.image = image;
    }
    
    
    @Override
    public double calculatePrice() {
        double basePrice = getBase().getPrice();
        double totalWoodPrice = diameter * diameter * getWoodType().getPrice() + basePrice;
        double totalPrice = totalWoodPrice * getQuantity();
        return totalPrice;
    }

    @Override
    public String toString() {
        return "Table[ID=" + getID() + ", WoodType=" + getWoodType() + ", Quantity=" + getQuantity() +
                ", Diameter=" + diameter + ", Base=" + base + ", Price=" + calculatePrice() + "]";
    }
    
    /**
     * Get the image representing the table.
     *
     * @return The ImageIcon of the table.
     */
    
    @Override
    public ImageIcon getImageIcon() {
       return this.image;
    }

   
}
    

