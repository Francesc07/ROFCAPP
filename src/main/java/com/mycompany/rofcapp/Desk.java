package com.mycompany.rofcapp;


import javax.swing.ImageIcon;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */


/**
 * A class representing a desk with properties like height, depth, width, and drawers.
 * 
 * @author USER Francis Okoye (C2680301)
 */
public class Desk extends Furniture {
    private static final String DESK_IMAGE_PATH = "C:\\Users\\USER\\OneDrive\\Documents\\NetBeansProjects\\ROFCAPP\\Images\\DeskImage\\Desk.png";
   private static final int HEIGHT = 85;
    private int depth;
    private int width;
    private int drawers;

    /**
     * Default constructor for a Desk.
     */
    public Desk() {
        super();
        this.depth = 0;
        this.width = 0;
        this.drawers = 0;
    }

    /**
     * Parameterized constructor for a Desk.
     *
     * @param ID       The ID of the desk.
     * @param woodType The type of wood used for the desk (OAK or WALNUT).
     * @param quantity The quantity of desks.
     * @param image    The ImageIcon representing the desk.
     * @param depth    The depth of the desk.
     * @param width    The width of the desk.
     * @param drawers  The number of drawers in the desk.
     */
    public Desk(String ID, WOOD_TYPE woodType, int quantity, ImageIcon image, int depth, int width, int drawers) {
        super(ID, woodType, quantity, image);
        this.depth = depth;
        this.width = width;
        this.drawers = drawers;
        this.image = new ImageIcon(DESK_IMAGE_PATH);
    }

    /**
     * Get the depth of the desk.
     *
     * @return The depth as an integer.
     */
    public int getDepth() {
        return depth;
    }
     /**
     * Set the depth of the desk.
     *
     * @param depth The depth to set.
     */
    public void setDepth(int depth){
        this.depth = depth;
    }

    /**
     * Get the width of the desk.
     *
     * @return The width as an integer.
     */
    public int getWidth() {
        return width;
    }
     /**
     * Set the width of the desk.
     *
     * @param width The width to set.
     */
    public void setWidth(int width){
        this.width = width ;
    }

    /**
     * Get the number of drawers in the desk.
     *
     * @return The number of drawers as an integer.
     */
    public int getDrawers() {
        return drawers ;
    }
    /**
     * Set the number of drawers in the desk.
     *
     * @param drawers The number of drawers to set.
     */
    public void setDrawers(int drawers){
         this.drawers = drawers;
    }
    
     /**
     * Set the ImageIcon representing the desk.
     *
     * @param image The ImageIcon to set.
     * @return 
     */
    @Override
    public ImageIcon setImageIcon(ImageIcon image) {
        
        return this.image = image;
    }
    
    /**
     * Calculate the price of the desk, considering its dimensions, wood type, and drawers.
     *
     * @return The calculated total price of the desk.
     */
    @Override
    public double calculatePrice() {
        double drawersPrice = drawers * 8.25;
        double unit = ((HEIGHT  + width + depth) + (width * depth) * getWoodType().getPrice());
        double totalPrice = unit + drawersPrice * getQuantity();
        return totalPrice;
    }

    

    /**
     * Get a string representation of the desk.
     *
     * @return A string containing the ID, wood type, quantity, price, dimensions, and number of drawers of the desk.
     */
    @Override
    public String toString() {
        return "Desk[ID=" + getID() + ", WoodType=" + getWoodType() + ", Quantity=" + getQuantity() +
               ", Height=" + HEIGHT  + ", Depth=" + depth + ", Width=" + width +
               ", Drawers=" + drawers +  ", Price=" + calculatePrice() + "]";
    }
     /**
     * Get the image representing the desk.
     *
     * @return The ImageIcon of the desk.
     */
    
    @Override
    public ImageIcon getImageIcon() {
        return this.image;
    }
}

