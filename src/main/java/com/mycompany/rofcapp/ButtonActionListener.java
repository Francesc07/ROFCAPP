/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 * This class, ButtonActionListener, implements the ActionListener interface
 * to handle various button actions in a Swing GUI application related to furniture ordering.
 */ 

package com.mycompany.rofcapp;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.swing.ImageIcon;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JSpinner;
import javax.swing.JTextArea;
import javax.swing.JTextField;

/**
 * The ButtonActionListener class handles actions triggered by buttons in the furniture ordering GUI.
 * It implements the ActionListener interface to respond to user interactions.
 *
 * @author USER Francis Okoye (C2680301)
 */
public class ButtonActionListener implements ActionListener {
    
    // GUI components and variables
    private ROFCGUI gui; 
    private Map<JLabel, Order> labelOrderMap;
    private JLabel[] imageLabels;
    private JTextField productIDTextField;
    private JTextField deskProductIDTextField;
    private JTextField tableProductIDTextField;
    private JComboBox<String> woodTypeDropdown;
    private JSpinner deskDrawer;
    private JComboBox<String> tableWoodTypeDropdown;
    private JComboBox<String> baseTypeDropdown;
    private JRadioButton yesRadioButton;
    private JRadioButton noRadioButton;
    private JTextField quantityTextField;
    private JTextField deskQuantityTextField;
    private JTextField tableQuantityTextField;
    private JTextField deskWidthTextField;
    private JTextField deskDepthTextField;
    private JTextField diameterTextField;
    private JPanel imagePanel;
    private JPanel orderPanel;
    private JLabel totalLabel;
    private final int MIN_DIAMETER = 50;
    private final int MAX_IMAGES = 9;
    private Order order;
    private List<Order> orders;
    private List<Furniture> furnitureList;
    private int imageCounter; 
      

     /**
     * Constructor for ButtonActionListener.
     * Initializes paths for images and references to GUI components.
     * @param gui The main GUI instance.
     */

    public ButtonActionListener(ROFCGUI gui) {
      
         // Initialize GUI components
        this.gui = gui;
        labelOrderMap = new HashMap<>();
        productIDTextField = gui.getProductIDTextField();
        deskProductIDTextField = gui.getDeskProductIDTextField();
        tableProductIDTextField = gui.getTableProductIDTextField();        
        quantityTextField = gui.getQuantityTextField();
        deskQuantityTextField = gui.getDeskQuantityTextField(); 
        tableQuantityTextField = gui.getTableQuantityTextField();        
        woodTypeDropdown = gui.getWoodTypeDropdown();
        deskDrawer = gui.getDrawers();
        tableWoodTypeDropdown = gui.getTableTypeDropdown();
        baseTypeDropdown = gui.getBaseTypeDropdown();
        yesRadioButton = gui.getYesRadioButton();
        noRadioButton = gui.getNoRadioButton();
        deskWidthTextField = gui.getDeskWidthTextField();
        deskDepthTextField = gui.getDeskDepthTextField();
        diameterTextField = gui.getDiameterTextField();
        imagePanel = gui.getImagePanel();
        imageLabels = gui.getImageLabels();
        orderPanel = gui.getOrderPanel();
        totalLabel = gui.getTotalLabel();
        order = new Order();
        orders = new ArrayList<>();
        furnitureList = order.getFurnitureList();
        
        
    }
    
   /**
     * Handles various button click events in the GUI.
     *
     * @param e The ActionEvent triggered by a button click.
     */
    @Override
    public void actionPerformed(ActionEvent e) {
        Object source = e.getSource();
         
        // Check the source of the action event
        if (source == gui.getAddChairButton()) {
             
            handleChairButtonClick();
        } else if (source == gui.getAddDeskButton()) {
             
            handleDeskButtonClick();
        } else if (source == gui.getAddTableButton()) {
             
            handleTableButtonClick();
        } else if (source == gui.getClearAllButton()) {
            handleClearButtonClick();
        } else if (source == gui.getPlaceOrderButton()) {
            handlePlaceOrderButtonClick();
        } else if (source == gui.getSummaryButton()) {
            handleSummaryButtonClick();
        } else if (source == gui.getReviewOrderButton()) {
            handleReviewOrderButtonClick();
        }
    }
    
     /**
     * Handles the button click for adding a chair to the order.
     * Extracts data from input fields and updates the order.
     */
    private void handleChairButtonClick(){
        
    // Extract data from input fields
    String productID = productIDTextField.getText();
    String quantityText = quantityTextField.getText();
    Boolean armRest;
    
    // Check if the input fields are empty
    if (productID.isEmpty()) {
       
         showError("Input the product ID");
        return; // Exit the action if there's missing input
    }
    if (quantityText.isEmpty()){
        
                showError("Input the quantity of item" );
        return; 
    }
  
    
    try {
        // Attempt to parse the quantity
            int quantity = Integer.parseInt(quantityText);
       
            WOOD_TYPE woodType = WOOD_TYPE.valueOf((String) woodTypeDropdown.getSelectedItem());
           
            // Check the selected radio button for armrest
            if (yesRadioButton.isSelected()) {
            armRest = true;
             } else if (noRadioButton.isSelected()) {
                armRest = false;
            } else {
        showError("Armrest selection is required");
        return;
            }
            
            
            // Create a chair object and add it to the order
            Chair chair = new Chair(productID, woodType,   null, quantity, armRest);
           
            orders.add(new Order());
            
            updateImagePanel(chair);
            order.addFurniture(chair);
            // Retrieve the JLabel for displaying the chair image. The JLabel is obtained from the 
            // imageLabels array using the current index value stored in imageCounter.
            JLabel chairLabel = imageLabels[imageCounter];

            // Associate the 'chair' object with the JLabel using putClientProperty. This allows 
            // storing a reference to the chair object within the JLabel, which is helpful for 
            // event handling, such as when a user clicks on this JLabel in the GUI.
            chairLabel.putClientProperty("furniture", chair);

            // Update the FurnitureMouseListener's labelOrderMap. This map maintains a relationship 
            // between each JLabel and its corresponding Order object. By adding the chairLabel and 
            // its associated order to this map, the application can identify which order to update 
            // or query when interacting with the chairLabel in the user interface.
            gui.getFurnitureMouseListener().getLabelOrderMap().put(chairLabel, order);
            orders.add(order);
            order.updateOrderDetails(orderPanel, totalLabel);
            updateTotalLabel(totalLabel,  orders);
            
           productIDTextField.setText("");
           quantityTextField.setText("");
            
               
    } catch (NumberFormatException ex) {
        // Handle the exception when quantity is not a valid integer
        showError( "Quantity must be a valid positive integer.");

    
    }
    }
    /**
     * Handles the button click for adding a desk to the order.
     * Extracts data from input fields and updates the order.
     */
    private void handleDeskButtonClick(){

    String productID = deskProductIDTextField.getText();
    String depthText = deskDepthTextField.getText();
    String widthText = deskWidthTextField.getText();
    String quantityText = deskQuantityTextField.getText();

    // Check if the input fields are empty
    if (productID.isEmpty()) {
        showError("Input the product ID");
        return;
    }

    if (depthText.isEmpty()) {
        showError("Input the desk depth");
    return;
    }

    if (widthText.isEmpty()) {
        showError("Input the desk width");
    return;
    }

    if (quantityText.isEmpty()) {
        showError("Input the quantity of item");
    return;
    }

    try {
    // Attempt to parse the input fields
    int depth = Integer.parseInt(depthText);
    int width = Integer.parseInt(widthText);
    int quantity = Integer.parseInt(quantityText);

    WOOD_TYPE woodType = WOOD_TYPE.valueOf((String) woodTypeDropdown.getSelectedItem());

    // Parse drawers
    int drawers;
    try {
    drawers = (int) deskDrawer.getValue();
        } catch (NumberFormatException e) {
        showError("Invalid value for drawers. Please select a valid number.");
    return;
        }

    // Create a desk object and add it to the order
    Desk desk = new Desk(productID, woodType, quantity, null, depth, width, drawers);

    // Load and set the desk image
    updateImagePanel(desk);

    order.addFurniture(desk);
    // Retrieve the JLabel corresponding to the current image counter.
    // This label will be used to display the desk image.
    JLabel deskLabel = imageLabels[imageCounter];

    // Associate the 'desk' object with the retrieved JLabel. This is done using the 
    // putClientProperty method, which allows storing a reference to the desk object
    // within the JLabel. This association is useful for event handling (e.g., when a 
    // mouse click on the JLabel needs to access the corresponding desk object).
    deskLabel.putClientProperty("furniture", desk);

    // Update the labelOrderMap in the FurnitureMouseListener. This map maintains the 
    // relationship between each JLabel and its corresponding Order object. Here, 
    // we are associating the current deskLabel with the current order. This is essential
    // for handling actions like identifying which order a clicked furniture item belongs to.
    gui.getFurnitureMouseListener().getLabelOrderMap().put(deskLabel, order);
    orders.add(order);

    // Update the order panel and total price label
    order.updateOrderDetails(orderPanel, totalLabel);
    updateTotalLabel(totalLabel, orders);

    deskProductIDTextField.setText("");
    deskDepthTextField.setText("");
    deskWidthTextField.setText("");
    deskQuantityTextField.setText("");

    } catch (NumberFormatException ex) {
    // Handle the exception when input fields are not valid integers
    showError("Fields must be valid positive integers.");
        }    } 
    
    /**
     * Handles the button click for adding a table to the order.
     * Extracts data from input fields and updates the order.
     */

    private void handleTableButtonClick() {
    String productID = tableProductIDTextField.getText();
    String diameterText = diameterTextField.getText();
    String quantityText = tableQuantityTextField.getText();

    // Check if the input fields are empty
    if (productID.isEmpty()) {
        showError("Input the product ID");
        return;
    }
    if (diameterText.isEmpty()) {
        showError("Input the desk diameter");
        return;
    }
    if (quantityText.isEmpty()) {
        showError("Input the quantity of item");
        return;
    }

    try {
        // Parse the input fields
        int diameter = Integer.parseInt(diameterText);
        int quantity = Integer.parseInt(quantityText);

        // Parse enums
        WOOD_TYPE woodType = WOOD_TYPE.valueOf((String) tableWoodTypeDropdown.getSelectedItem());
        BASE base = BASE.valueOf((String) baseTypeDropdown.getSelectedItem());
         
        if (diameter < MIN_DIAMETER) {
            showError("Diameter must be greater than 49");
            return;
        }
        // Create a table object and add it to the order
        Table table = new Table(productID, woodType, quantity, null, diameter, base);
       

        // Update the image panel (check if this method relies on order state)
        updateImagePanel(table);
      
        // Add the table to the order
        order.addFurniture(table);
        
        // Retrieve the JLabel from the imageLabels array at the current imageCounter index.
        // This JLabel is intended to display the image of the table in the user interface.
        JLabel tableLabel = imageLabels[imageCounter];

        // Associate the 'table' object with the retrieved JLabel. The putClientProperty method
        // is used here to store a reference to the table object inside the JLabel. This association
        // is particularly useful for event handling purposes, such as responding to mouse clicks on this JLabel.
        tableLabel.putClientProperty("furniture", table);

        // Update the FurnitureMouseListener's labelOrderMap to associate the tableLabel with the current order.
        // The labelOrderMap keeps track of which Order object is linked to each JLabel. This association is crucial
        // for correctly handling user interactions with the JLabel in the GUI, allowing the application to determine
        // which order is related to the clicked furniture item (in this case, the table).
        gui.getFurnitureMouseListener().getLabelOrderMap().put(tableLabel, order);

        // Add a new order instance to the orders list
        orders.add(new Order());

        // Update the order panel and total price label
        order.updateOrderDetails(orderPanel, totalLabel);
        updateTotalLabel(totalLabel, orders);

        // Clear input fields
        tableProductIDTextField.setText("");
        diameterTextField.setText("");
        tableQuantityTextField.setText("");

    } catch (NumberFormatException ex) {
        // Handle the exception when input fields are not valid integers
        showError("Field must be valid positive integers.");
    } 
}
    
    /**
     * Handles the button click for summary.
     */
    private void handleSummaryButtonClick(){
        
    if (orders.isEmpty()) {
                // Display an error message if there are no orders
               showError("No Order to Summarize");
            } else {
                // Build a summary text from the orders
                StringBuilder summaryText = new StringBuilder("Order Summary:\n");
              
                    summaryText.append(order.toString()).append("\n\n");
                    
           

                // Display the summary in a dialog
                JTextArea summaryTextArea = new JTextArea(20, 70);
                summaryTextArea.setEditable(false);
                summaryTextArea.setText(summaryText.toString());

                int choice = JOptionPane.showOptionDialog(
                    null,
                    new JScrollPane(summaryTextArea),
                    "Order Summary",
                    JOptionPane.YES_NO_OPTION,
                    JOptionPane.PLAIN_MESSAGE,
                    null,
                    new String[]{"Save", "Cancel"},
                    "Save"
                );

                if (choice == JOptionPane.YES_OPTION) {
                    // Implement the save operation here
                    OrderSerialization.saveOrder(order);
                    // For example, save the orders to a file or a database
                    
                      totalLabel.setText("Total Price:  £0.00");
                         order.updateOrderDetails(orderPanel, totalLabel);
                         imagePanel.removeAll();
                         orderPanel.removeAll();
                         

                // Add revalidate() and repaint() for immediate UI update
                        orderPanel.revalidate();
                        orderPanel.repaint();
                        imagePanel.revalidate();
                        imagePanel.repaint();
                        orders.add(order); // Add the current order to the list of orders
                        order = new Order();
                } else {
                    // User chose to cancel
                   showError("Order Cancelled");
                }
            }
             
    }
    
    /**
     * Handles the button click for clearing the current order details.
     * Resets UI components and creates a new order instance.
     */
    private void handleClearButtonClick() {
    

    // Clear the current order
    order.getFurnitureList().clear();

    // Remove all components from orderPanel and imagePanel
    orderPanel.removeAll();
    imagePanel.removeAll();
    
    // Reset imageCounter for a new order
    imageCounter = 0;

    // Reset the totalLabel
    totalLabel.setText("Total Price: £0.00");

    // Revalidate and repaint to reflect the changes
    orderPanel.revalidate();
    orderPanel.repaint();
    imagePanel.revalidate();
    imagePanel.repaint();

    // Create a new order instance
    order = new Order();
    orders.add(order);
    
}

     /**
     * Handles the button click for reviewing a saved order.
     * Prompts the user for an order ID and displays the saved order details.
     */
    
    private void handleReviewOrderButtonClick(){
        
    String orderId = JOptionPane.showInputDialog("OrderId");
    
    // Attempt to retrieve the saved order based on customer details
    Order savedOrder = OrderSerialization.loadOrder(orderId);

    // Check if the saved order exists
    if (savedOrder != null )  {
        // Display the saved order summary
        StringBuilder reviewText = new StringBuilder("Review of Saved Order:\n");
        reviewText.append(savedOrder.toString());

        JTextArea reviewTextArea = new JTextArea(20, 70);
        reviewTextArea.setEditable(false);
        reviewTextArea.setText(reviewText.toString());

        JOptionPane.showMessageDialog(null, new JScrollPane(reviewTextArea), "Review Order", JOptionPane.PLAIN_MESSAGE);
    } else {
        // Display a message indicating that no matching order was found
        JOptionPane.showMessageDialog(null, "No matching order found for the provided Order ID.", "No Matching Order", JOptionPane.INFORMATION_MESSAGE);
    }
    
    }
    
    /**
     * Handles the button click for placing the order.
     * Prompts the user for personal information and displays an order summary.
     */
    private void handlePlaceOrderButtonClick(){
        if (order.getFurnitureList().isEmpty()) {
        JOptionPane.showMessageDialog(null, "No orders to place.", "Error", JOptionPane.ERROR_MESSAGE);
        return; // Exit if there are no orders
    }
            // Prompt the user for personal information
            String name;
            String phoneNumber;
            String address;
            boolean inputsValid = false;
            
            // Validate inputs
    while (!inputsValid) {
        try {
            // Prompt the user for personal information
          
            name = JOptionPane.showInputDialog("Enter your name:");
            if (name == null || name.trim().isEmpty()) {
                showError("Please provide valid information for name.");
                return;
            }
           phoneNumber = JOptionPane.showInputDialog("Enter your phone number:");
            
            if (phoneNumber == null || phoneNumber.trim().isEmpty()) {
                showError("Please provide valid information for Phone Number.");
                return;
            }
             address = JOptionPane.showInputDialog("Enter your address:");
           
            if (address == null || address.trim().isEmpty()) {
                showError("Please provide valid information for address.");
               return;
            }

            inputsValid = true; // Set the flag to true if inputs are valid

             // Build the order summary text
            StringBuilder summaryText = new StringBuilder("Order Summary:\n\n");
            summaryText.append(order.toString()).append("\n\n");
            summaryText.append("Customer Information:\n");
            summaryText.append("Name: ").append(name).append("\n");
            summaryText.append("Phone Number: ").append(phoneNumber).append("\n");
            summaryText.append("Address: ").append(address).append("\n");

            // Display the summary in a dialog with Save and Cancel buttons
            JTextArea summaryTextArea = new JTextArea(20, 70);
            summaryTextArea.setEditable(false);
            summaryTextArea.setText(summaryText.toString());

            int choice = JOptionPane.showOptionDialog(
                    null,
                    new JScrollPane(summaryTextArea),
                    "Order Summary",
                    JOptionPane.YES_NO_OPTION,
                    JOptionPane.PLAIN_MESSAGE,
                    null,
                    new String[]{"Place Order", "Cancel"},
                    "Save"
            );
            
            if (choice == JOptionPane.YES_OPTION) {
              JOptionPane.showMessageDialog(null, "\t\t\t  Order Succesfully Placed \n " );                
                // Clear the order details after saving
                totalLabel.setText("Total Price:  £0.00");
                order.updateOrderDetails(orderPanel, totalLabel);
                imagePanel.removeAll();
                orderPanel.removeAll();
               
                // Add revalidate() and repaint() for immediate UI update
                orderPanel.revalidate();
                orderPanel.repaint();
                imagePanel.revalidate();
                imagePanel.repaint();
                
            } else {
                 if (choice == JOptionPane.NO_OPTION) {
                return; // Exit the place order process
            }
            }
        orders.add(order); // Add the current order to the list of orders
        order = new Order();

    } catch (Exception e) {
        showError("error");
    }
           
    }
}
    
     /**
     * Updates the total price label with the calculated total price of the current order.
     * @param totalLabel The label to display the total price.
     * @param orders The list of orders.
     */
    private void updateTotalLabel (JLabel totalLabel, List<Order> orders) {
        
    double total = order.calculateTotalPrice();
    totalLabel.setText("Total Price: £ " + String.format("%.2f", total));

   
     }
   
    /**
     * Updates the image panel with the specified image path.
     * @param imagePath The path of the image to display.
     */
    private void updateImagePanel(Furniture furniture) {
        
    if (imageCounter < MAX_IMAGES) {
    ImageIcon icon = furniture.getImageIcon();
    imageLabels[imageCounter].setIcon(icon);
    imageCounter++;
}
    imagePanel.revalidate();
    imagePanel.repaint();
    }
    
    
    /**
     * Displays an error message in a dialog.
     * @param message The error message to display.
     */
    private void showError(String message) {
        JOptionPane.showMessageDialog(null, message, "Error", JOptionPane.ERROR_MESSAGE);
    }
    
    
}