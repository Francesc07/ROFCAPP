/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.rofcapp;

import java.io.Serializable;
import javax.swing.ImageIcon;

/**
 * A class representing a chair, extending the Furniture class and providing additional features like armrests.
 * @author USER Francis Okoye (C2680301)
 */
public class Chair extends Furniture implements Serializable {
    protected boolean armRest;
    
    private static final String CHAIR_IMAGE_PATH = "C:\\Users\\USER\\OneDrive\\Documents\\NetBeansProjects\\ROFCAPP\\Images\\ChairImage\\chair.png";
    // Constants for wood units
    private int WOOD_UNIT_WITH_ARMREST = 1500;
    private int WOOD_UNIT_WITHOUT_ARMREST = 1250;
    
    /**
     * Default constructor for a Chair.
     */
    public Chair() {
        super();
       
    }

    /**
     * Parameterized constructor for a Chair.
     *
     * @param ID      The ID of the chair.
     * @param woodType The type of wood used for the chair (OAK or WALNUT).
     * @param quantity The quantity of chairs.
     * @param image   The ImageIcon representing the chair.
     * @param armRest A Boolean indicating the presence of armrests (true if armrests are present, false otherwise).
     */
    public Chair(String ID, WOOD_TYPE woodType, ImageIcon image,int quantity, boolean armRest) {
        super(ID, woodType, quantity, image);
        this.armRest = armRest;
        this.image = new ImageIcon(CHAIR_IMAGE_PATH);
    }
    
     /**
     * Get the image representing the chair.
     *
     * @return The ImageIcon of the chair.
     */
    
    @Override
    public ImageIcon getImageIcon(){
         return this.image;
    }
    
    /**
     * Set the ImageIcon representing the chair.
     *
     * @param image The ImageIcon to set.
     * @return 
     */
    
    @Override
    public ImageIcon setImageIcon(ImageIcon image) {
     return this.image = image;
    }

    /**
     * Calculate the total price of the chairs, considering wood type, armrests, and quantity.
     *
     * @return The calculated total price of the chairs.
     */
    @Override
    public double calculatePrice() {
        double woodTypePrice = getWoodType().getPrice();
        int woodUnit = (armRest ? WOOD_UNIT_WITH_ARMREST : WOOD_UNIT_WITHOUT_ARMREST);
        double totalPrice = woodTypePrice * woodUnit * getQuantity();
        return totalPrice;
    }

    /**
     * Get a string representation of the chair.
     *
     * @return A string containing the ID, wood type, quantity, price, and armrest presence of the chair.
     */
    @Override
    public String toString() {
        return "Chair[ID=" + getID() + ", WoodType=" + getWoodType() + ", Quantity=" + getQuantity() +
                ", ArmRest=" + armRest + ", Price=" + calculatePrice() + "]";
    }

   
}
