/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.rofcapp;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.HashMap;
import java.util.Map;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

/**
 * The `FurnitureMouseListener` class handles mouse events for JLabels associated
 * with furniture images in the ROFC (Real Office Furniture Configurator) application.
 * It provides functionality for left, middle, and right mouse clicks on the furniture images.
 */
public class FurnitureMouseListener extends MouseAdapter {

   private final ROFCGUI rofcgui;
    private final Order order;
    private JLabel source;
    private Map<JLabel, Order> labelOrderMap;

    public FurnitureMouseListener(ROFCGUI rofcgui) {
        this.rofcgui = rofcgui;
        this.order = new Order();
        this.source = null;
        labelOrderMap = new HashMap<>();
    }

    /**
     * Handles mouse-click events on the furniture images.
     *
     * @param e The MouseEvent associated with the click.
     */
     @Override
    public void mouseClicked(MouseEvent e) {
        source = (JLabel) e.getSource();

        switch (e.getButton()) {
            case MouseEvent.BUTTON1:
                handleLeftClick();
                break;
            case MouseEvent.BUTTON2:
                handleMiddleClick();
                break;
            case MouseEvent.BUTTON3:
                handleRightClick();
                break;
            default:
                // Optionally handle other mouse buttons if needed
                break;
        }
    }

    
        private void handleLeftClick() {
        if (source != null) {
            // Use labelOrderMap to find the correct Order associated with the clicked label
            Order associatedOrder = labelOrderMap.get(source);
            if (associatedOrder != null) {
                Furniture furniture = getFurnitureByLabel(source, associatedOrder);
                if (furniture != null) {
                    String orderInfo = furniture.toString();
                    displayMessage("Order Details: " + orderInfo);
                } else {
                    displayMessage("No furniture associated with this label.");
                }
            } else {
                displayMessage("No order associated with this label.");
            }
        }
         }
        
    /**
     * Handles actions for a middle mouse click on a furniture image.
     *
     */
    private void handleMiddleClick() {
        if (source != null) {
        
        if (source.getIcon() == null) {
                 displayMessage("Clicked on an empty order.");
                     
                } else {
                    displayMessage("its working");
    }
        
        }
    }

    /**
     * Handles actions for a right mouse click on a furniture image.
     *
     */
     private void handleRightClick() {
        if (source != null && source.getIcon() != null) {
            int confirm = JOptionPane.showConfirmDialog(
                null,
                "Are you sure you want to remove this item from the order?",
                "Confirmation",
                JOptionPane.YES_NO_OPTION
            );

            if (confirm == JOptionPane.YES_OPTION) {
                Order associatedOrder = labelOrderMap.get(source);
                if (associatedOrder != null) {
                    Furniture furnitureToRemove = getFurnitureByLabel(source, associatedOrder);
                    if (furnitureToRemove != null) {
                        associatedOrder.removeFurniture(furnitureToRemove);
                        labelOrderMap.remove(source);
                        source.setIcon(null);
                        rofcgui.updateOrderDisplay();
                    } else {
                        displayMessage("Furniture not found in the order.");
                    }
                } else {
                    displayMessage("No associated order found for this item.");
                }
            }
        } else {
            displayMessage("No Order to remove.");
        }
    }
     
   public Furniture getFurnitureByLabel(JLabel label, Order order) {
    Furniture furniture = (Furniture) label.getClientProperty("furniture");
    return order.getFurnitureList().contains(furniture) ? furniture : null;
        }
      
      public JLabel findLabelForFurniture(Furniture furniture) {
        for (JLabel label : rofcgui.getImageLabels()) {
            if (label != null && label.getClientProperty("furniture") == furniture) {
                return label;
            }
        }
        return null;  // Return null if no matching label is found
    }
      
    public Map<JLabel, Order> getLabelOrderMap() {
    return labelOrderMap;
        }
    
    public void addFurnitureItem(Furniture furniture, JLabel label) {
    order.addFurniture(furniture);
    getLabelOrderMap().put(label, order);
    // Other UI updates...
}

    /**
     * Displays a message (for demonstration purposes).
     *
     * @param message The message to display.
     */
    private void displayMessage(String message) {
        // Implement how you want to display messages
        JOptionPane.showMessageDialog(null,message);
    }

   
}
