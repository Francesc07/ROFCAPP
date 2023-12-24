/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.rofcapp;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.Insets;
import javax.swing.BorderFactory;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JSpinner;
import javax.swing.JTabbedPane;
import javax.swing.JTextField;
import javax.swing.SpinnerNumberModel;


/**
 * This class extends JFrame and provides a user interface
 * for managing furniture orders.
 * @author USER Francis Okoye (C2680301)
 */

public class ROFCGUI extends JFrame {
    private FurnitureMouseListener furnitureMouseListener;
    GridBagConstraints constraints;   
    private JLabel totalLabel;
    private JLabel[] imageLabels;
    private JTextField productIDTextField, deskProductIDTextField, tableProductIDTextField;
    private JComboBox<String> woodTypeDropdown,deskWoodTypeDropdown, tableWoodTypeDropdown,baseTypeDropdown;
    private JRadioButton yesRadioButton,noRadioButton;
    private JTextField quantityTextField, deskQuantityTextField,tableQuantityTextField;
    private JTextField deskWidthTextField,deskDepthTextField, diameterTextField;
    private JPanel imagePanel, buttonPanel ;
    private JPanel panelRight,panelLeft;
    private JSpinner deskDrawer;
    private JPanel  orderPanel;
    Order order;
    Order[] orders; 
   
     
   
    int MAX_IMAGES = 9;
    
    private JButton chairButton, deskButton, tableButton;
    private JButton clearAllButton, summaryButton, placeOrderButton, reviewOrderButton;
    private JTabbedPane tabbedPane;  // Declare tabbedPane as a class field
    

   
     /**
     * Constructs a new ROFCGUI instance.
     * Initializes the user interface and attaches action listeners.
     */
    public ROFCGUI() {
        super("ROFC");

        initializeUI();
        initialiseOrder();
        attachActionListeners();
        this.furnitureMouseListener = new FurnitureMouseListener(this);
        
    }

    
     /**
     * Initializes the main user interface.
     * Sets up the layout and adds left, center, and right panels.
     */
    private void initializeUI() {
        setLayout(new BorderLayout());
        add(createLeftPanel(), BorderLayout.WEST);
        add(createCenterPanel(), BorderLayout.CENTER);
        add(createRightPanel(), BorderLayout.EAST);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        pack();
        setLocationRelativeTo(null);
        setVisible(true);
    }
    public FurnitureMouseListener getFurnitureMouseListener() {
    return this.furnitureMouseListener;
}
    
     /**
     * Creates the left panel containing tabs for managing chairs, desks, and tables.
     * @return The left panel.
     */
    private JPanel createLeftPanel() {
        panelLeft = new JPanel(new FlowLayout(FlowLayout.LEFT));
        panelLeft.setBackground(Color.LIGHT_GRAY);

        tabbedPane = new JTabbedPane();
        tabbedPane.addTab("Chairs", null, createChairPanel(), "Chairs");
        tabbedPane.addTab("Desk", null, createDeskPanel(), "Desk");
        tabbedPane.addTab("Table", null, createTablePanel(), "Table");

        panelLeft.add(tabbedPane);

        return panelLeft;
    }
    
    /**
     * Creates the panel for managing chair-related information.
     * @return The panel for managing chairs.
     */
    private JPanel createChairPanel() {
              


        // Create a panel for the "Chairs" tab
        JPanel chairPanel = new JPanel(new GridBagLayout());

        constraints = new GridBagConstraints();
        constraints.anchor = GridBagConstraints.WEST;
        constraints.insets = new Insets(25, 15, 25, 15);

        // Add label "Product ID" and text field on the same row
        JLabel productIDLabel = new JLabel("Product ID:");
        productIDTextField = new JTextField(15);
        constraints.gridx = 0;
        constraints.gridy = 0;
        chairPanel.add(productIDLabel, constraints);
        constraints.gridx = 1;
        chairPanel.add(productIDTextField, constraints);

        // Add a dropdown displaying the type of wood on the second row
        JLabel woodTypeLabel = new JLabel("Wood Type:");
        String[] woodTypes = {"OAK", "WALNUT"};
        woodTypeDropdown = new JComboBox<>(woodTypes);
        constraints.gridx = 0;
        constraints.gridy = 1;
        chairPanel.add(woodTypeLabel, constraints);
        constraints.gridx = 1;
        chairPanel.add(woodTypeDropdown, constraints);

        // Add label "Armrest" and a button (Yes/No) on the third row
        JLabel armrestLabel = new JLabel("Armrest:");
        yesRadioButton = new JRadioButton("Yes");
        noRadioButton = new JRadioButton("No");
        ButtonGroup armrestButtonGroup = new ButtonGroup();
        armrestButtonGroup.add(yesRadioButton);
        armrestButtonGroup.add(noRadioButton);
        constraints.gridx = 0;
        constraints.gridy = 2;
        chairPanel.add(armrestLabel, constraints);
        constraints.gridx = 1;
        chairPanel.add(yesRadioButton, constraints);
        constraints.gridx = 2;
        chairPanel.add(noRadioButton, constraints);

        // Add label "Quantity" and text field on the fourth row
        JLabel quantityLabel = new JLabel("Quantity:");
        quantityTextField = new JTextField(5);
        constraints.gridx = 0;
        constraints.gridy = 3;
        chairPanel.add(quantityLabel, constraints);
        constraints.gridx = 1;
        chairPanel.add(quantityTextField, constraints);
        
        // Create a button for the "Chairs" tab
        chairButton = new JButton("ADD CHAIR");
        constraints.gridx = 1;
        constraints.gridy = 4;
        constraints.gridwidth = 2;
        chairPanel.add(chairButton, constraints);
        
        return chairPanel;
    }
    
    /**
     * Creates the panel for managing desk-related information.
     * @return The panel for managing desks.
     */
    
    private JPanel createDeskPanel() {
        JPanel deskPanel = new JPanel(new GridBagLayout());
       
        // Add label "Product ID" and text field on the first row
        JLabel deskProductIDLabel = new JLabel("Product ID:");
        deskProductIDTextField = new JTextField(10);
        constraints.gridx = 0;
        constraints.gridy = 1;
        deskPanel.add(deskProductIDLabel, constraints);
        constraints.gridx = 2;
        constraints.gridwidth = 2;
        deskPanel.add(deskProductIDTextField, constraints);

        // Add a dropdown displaying the type of wood on the second row
        JLabel deskWoodTypeLabel = new JLabel("Wood Type:");
        String[] deskWoodTypes = {"OAK", "WALNUT"};
        deskWoodTypeDropdown = new JComboBox<>(deskWoodTypes);
        constraints.gridx = 1;
        constraints.gridy = 2;
        deskPanel.add(deskWoodTypeLabel, constraints);
        constraints.gridx = 2;
        deskPanel.add(deskWoodTypeDropdown, constraints);

        // Add label "Width" and text field on the fourth row
        JLabel deskWidthLabel = new JLabel("Width:");
        deskWidthTextField = new JTextField(5);
        constraints.gridx = 1;
        constraints.gridy = 4;
        deskPanel.add(deskWidthLabel, constraints);
        constraints.gridx = 2;
        deskPanel.add(deskWidthTextField, constraints);

        // Add dropdown displaying the number of drawers on the fifth row
        JLabel deskDrawersLabel = new JLabel("No. of Drawers:");
        deskDrawer= new JSpinner(new SpinnerNumberModel(1, 1, 4, 1));
        
       // String[] deskDrawerNumbers = {"1", "2", "3", "4"};
        //deskDrawersDropdown = new JComboBox<>(deskDrawerNumbers);
        constraints.gridx = 1;
        constraints.gridy = 3;
        deskPanel.add(deskDrawersLabel, constraints);
        constraints.gridx = 2;
        deskPanel.add(deskDrawer, constraints);

        // Add label "Depth" and text field on the sixth row
        JLabel deskDepthLabel = new JLabel("Depth:");
        deskDepthTextField = new JTextField(5);
        constraints.gridx = 1;
        constraints.gridy = 5;
        deskPanel.add(deskDepthLabel, constraints);
        constraints.gridx = 2;
        deskPanel.add(deskDepthTextField, constraints);

        // Add label "Quantity" and text field on the seventh row
        JLabel deskQuantityLabel = new JLabel("Quantity:");
        deskQuantityTextField = new JTextField(5);
        constraints.gridx = 1;
        constraints.gridy = 6;
        deskPanel.add(deskQuantityLabel, constraints);
        constraints.gridx = 2;
        deskPanel.add(deskQuantityTextField, constraints);

        // Create a button for the "Table" tab
        deskButton = new JButton("ADD DESK");
        constraints.gridx = 1;
        constraints.gridy = 7;
        constraints.gridwidth = 1;
        deskPanel.add(deskButton, constraints);
        
        
        
        
        return deskPanel;
    }
     /**
     * Creates the panel for managing table-related information.
     * @return The panel for managing tables.
     */
    private JPanel createTablePanel() {
        JPanel tablePanel = new JPanel(new GridBagLayout());

        // Add label "Product ID" and text field on the first row
        JLabel tableProductIDLabel = new JLabel("Product ID:");
        tableProductIDTextField = new JTextField(15);
        constraints.gridx = 0;
        constraints.gridy = 0;
        tablePanel.add(tableProductIDLabel, constraints);
        constraints.gridx = 1;
        tablePanel.add(tableProductIDTextField, constraints);

        // Add a dropdown displaying the type of wood on the second row
        JLabel tableWoodTypeLabel = new JLabel("Wood Type:");
        String[] tableWoodTypes = {"OAK", "WALNUT"};
        tableWoodTypeDropdown = new JComboBox<>(tableWoodTypes);
        constraints.gridx = 0;
        constraints.gridy = 1;
        tablePanel.add(tableWoodTypeLabel, constraints);
        constraints.gridx = 1;
        tablePanel.add(tableWoodTypeDropdown, constraints);

        // Add a dropdown of Base type on the third row
        JLabel baseTypeLabel = new JLabel("Base Type:");
        String[] baseTypes = {"WOOD", "CHROME"};
        baseTypeDropdown = new JComboBox<>(baseTypes);
        constraints.gridx = 0;
        constraints.gridy = 2;
        tablePanel.add(baseTypeLabel, constraints);
        constraints.gridx = 1;
        tablePanel.add(baseTypeDropdown, constraints);

        // Add label "Diameter" and text field on the fourth row
        JLabel diameterLabel = new JLabel("Diameter:");
        diameterTextField = new JTextField(5);
        constraints.gridx = 0;
        constraints.gridy = 3;
        tablePanel.add(diameterLabel, constraints);
        constraints.gridx = 1;
        tablePanel.add(diameterTextField, constraints);

        // Add label "Quantity" and text field on the fifth row
        JLabel tableQuantityLabel = new JLabel("Quantity:");
        tableQuantityTextField = new JTextField(5);
        constraints.gridx = 0;
        constraints.gridy = 4;
        tablePanel.add(tableQuantityLabel, constraints);
        constraints.gridx = 1;
        tablePanel.add(tableQuantityTextField, constraints);

        // Create a button for the "Desk" tab
        tableButton = new JButton("ADD TABLE");
        constraints.gridx = 1;
        constraints.gridy = 5;
        constraints.gridwidth = 2;
        tablePanel.add(tableButton, constraints);
       
        return tablePanel;
    }
    
     /**
     * Creates the central panel containing images and buttons.
     * @return The central panel.
     */
    
    private JPanel createCenterPanel() {
    JPanel centerPanel = new JPanel(new BorderLayout());
    centerPanel.setPreferredSize(new Dimension(450, 500));
    centerPanel.setBackground(Color.LIGHT_GRAY);
    // Add components to the centerPanel
    centerPanel.add(createImagePanel(), BorderLayout.CENTER);
    centerPanel.add(createButtonPanel(), BorderLayout.SOUTH);

    return centerPanel;
}
    
     /**
     * Creates the panel containing furniture images.
     * @return The panel with furniture images.
     */
    private JPanel createImagePanel() {
    // Create a new JPanel with a 3x3 grid layout
    imagePanel = new JPanel(new GridLayout(3, 3,10,10));

    // Set the background color of the imagePanel to gray
    imagePanel.setBackground(Color.GRAY);

    // Add a border to the imagePanel with a black line
    imagePanel.setBorder(BorderFactory.createLineBorder(Color.BLACK));

    // Create an array of JLabels to store the images
    imageLabels = new JLabel[MAX_IMAGES];

    // Loop to create JLabels for each image slot
    for (int imageCounter = 0; imageCounter < MAX_IMAGES; imageCounter++) {
        // Create a new JLabel for the current image slot
        imageLabels[imageCounter] = new JLabel();

        // Set the background color of the image label to white
        imageLabels[imageCounter].setBackground(Color.WHITE);

        // Add a border to the image label with a black line
        imageLabels[imageCounter].setBorder(BorderFactory.createLineBorder(Color.BLACK));

        // Make the image label opaque (to show the background color)
        imageLabels[imageCounter].setOpaque(true);
        
        // Set a minimum size for each image label
        Dimension minSize = new Dimension(50, 50);
        imageLabels[imageCounter].setMinimumSize(minSize);

        // Add the image label to the imagePanel
        imagePanel.add(imageLabels[imageCounter]);

        // Make the imagePanel opaque (to show its background color)
        imagePanel.setOpaque(true);
        
        imagePanel.revalidate();
        imagePanel.repaint();
       
        
    }

    // Return the initialized imagePanel
    return imagePanel;
}
    
    public void updateOrderDisplay() {
    orderPanel.removeAll();
    order.updateOrderDetails(orderPanel, totalLabel);
    orderPanel.revalidate();
    orderPanel.repaint();
    imagePanel.revalidate();
    imagePanel.repaint();
}
    
    /**
     * Creates the panel containing action buttons.
     * @return The panel with action buttons.
     */
    private JPanel createButtonPanel() {
    buttonPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
    buttonPanel.setBackground(Color.DARK_GRAY);

    // Initialize buttons
    clearAllButton = new JButton("Clear All");
    placeOrderButton = new JButton("Place Order");
    summaryButton = new JButton("Summary");
    reviewOrderButton = new JButton("Review Order");

    // Add buttons to the panel
    buttonPanel.add(clearAllButton);
    buttonPanel.add(placeOrderButton);
    buttonPanel.add(summaryButton);
    buttonPanel.add(reviewOrderButton);

    return buttonPanel;
}
    
    /**
     * Creates the right panel for displaying order details.
     * @return The right panel.
     */
    private JPanel createRightPanel() {
    panelRight = new JPanel(new FlowLayout(FlowLayout.RIGHT));
    panelRight.setBackground(Color.CYAN);
    totalLabel = new JLabel("Total: ");  // Initialize totalLabel
    panelRight.add(createOrderPanel());
    panelRight.add(totalLabel);

    return panelRight;
}
    
     /**
     * Creates the panel for displaying order details.
     * @return The panel with order details.
     */
    private JPanel createOrderPanel() {
        orderPanel = new JPanel(new GridLayout(0, 4));
        orderPanel.add(new JLabel("Product ID"));
        orderPanel.add(new JLabel("Item Type"));
        orderPanel.add(new JLabel("Quantity"));
        orderPanel.add(new JLabel("Price"));

        return orderPanel;
    }
    
    
    /**
     * Attaches action listeners to the relevant buttons.
     */
    private void attachActionListeners() {
        ButtonActionListener actionListener = new ButtonActionListener(this);
       chairButton.addActionListener(actionListener);
       deskButton.addActionListener(actionListener);
       tableButton.addActionListener(actionListener);
       clearAllButton.addActionListener(actionListener);
       placeOrderButton.addActionListener(actionListener);
       summaryButton.addActionListener(actionListener);
       reviewOrderButton.addActionListener(actionListener);
    }
    
     /**
     * Initializes order-related components.
     */
    private void initialiseOrder() {
        orders = new Order[MAX_IMAGES];
       
        for (JLabel label : imageLabels) {
         label.addMouseListener(new FurnitureMouseListener(this));
        }
    }
    
   
     /**
     * Gets the button for adding chairs.
     * @return The button for adding chairs.
     */
    public JButton getAddChairButton(){
        return chairButton;
    }

    /**
     * Gets the button for adding tables.
     * @return The button for adding tables.
     */
    public JButton getAddTableButton(){
        return tableButton;
    }

    /**
     * Gets the button for adding desks.
     * @return The button for adding desks.
     */
    public JButton getAddDeskButton(){
        return deskButton;
    }

    /**
     * Gets the button for clearing all inputs.
     * @return The button for clearing all inputs.
     */
    public JButton getClearAllButton() {
        return clearAllButton;
    }

    /**
     * Gets the button for placing an order.
     * @return The button for placing an order.
     */
    public JButton getPlaceOrderButton() {
        return placeOrderButton;
    }

    /**
     * Gets the button for viewing a summary.
     * @return The button for viewing a summary.
     */
    public JButton getSummaryButton() {
        return summaryButton;
    }

    /**
     * Gets the button for reviewing an order.
     * @return The button for reviewing an order.
     */
    public JButton getReviewOrderButton() {
        return reviewOrderButton;
    }

    /**
     * Gets the text field for chair product ID.
     * @return The text field for chair product ID.
     */
    public JTextField getProductIDTextField(){
        return productIDTextField;
    }

    /**
     * Gets the text field for desk product ID.
     * @return The text field for desk product ID.
     */
    public JTextField getDeskProductIDTextField() {
        return deskProductIDTextField;
    }

    /**
     * Gets the text field for table product ID.
     * @return The text field for table product ID.
     */
    public JTextField getTableProductIDTextField(){
        return tableProductIDTextField;
    }

    /**
     * Gets the text field for chair quantity.
     * @return The text field for chair quantity.
     */
    public JTextField getQuantityTextField(){
        return quantityTextField;
    }

    /**
     * Gets the text field for desk quantity.
     * @return The text field for desk quantity.
     */
    public JTextField getDeskQuantityTextField(){
        return deskQuantityTextField;
    }

    /**
     * Gets the text field for table quantity.
     * @return The text field for table quantity.
     */
    public JTextField getTableQuantityTextField(){
        return tableQuantityTextField;
    }

    /**
     * Gets the combo box for chair wood type.
     * @return The combo box for chair wood type.
     */
    public JComboBox<String> getWoodTypeDropdown(){
        return woodTypeDropdown;
    }

    /**
     * Gets the combo box for table wood type.
     * @return The combo box for table wood type.
     */
    public JComboBox<String> getTableTypeDropdown(){
        return tableWoodTypeDropdown;
    }

    /**
     * Gets the combo box for desk wood type.
     * @return The combo box for desk wood type.
     */
    public JComboBox<String> getDeskTypeDropdown(){
        return deskWoodTypeDropdown;
    }

    /**
     * Gets the combo box for desk drawers type.
     * @return The combo box for desk drawers type.
     */
    public JSpinner getDrawers(){
        return deskDrawer;
    }

    /**
     * Gets the combo box for table base type.
     * @return The combo box for table base type.
     */
    public JComboBox<String> getBaseTypeDropdown(){
        return baseTypeDropdown;
    }

    /**
     * Gets the radio button for chair armrest (Yes).
     * @return The radio button for chair armrest (Yes).
     */
    public JRadioButton getYesRadioButton(){
        return yesRadioButton;
    }

    /**
     * Gets the radio button for chair armrest (No).
     * @return The radio button for chair armrest (No).
     */
    public JRadioButton getNoRadioButton(){
        return noRadioButton;
    }

    /**
     * Gets the text field for desk width.
     * @return The text field for desk width.
     */
    public JTextField getDeskWidthTextField(){
        return deskWidthTextField;
    }

    /**
     * Gets the text field for desk depth.
     * @return The text field for desk depth.
     */
    public JTextField getDeskDepthTextField(){
        return deskDepthTextField;
    }

    /**
     * Gets the text field for table diameter.
     * @return The text field for table diameter.
     */
    public JTextField getDiameterTextField(){
        return diameterTextField;
    }

    /**
     * Gets the array of labels for furniture images.
     * @return The array of labels for furniture images.
     */
    public JLabel[] getImageLabels(){
        return imageLabels;
    }

    /**
     * Gets the panel containing furniture images.
     * @return The panel containing furniture images.
     */
    public JPanel getImagePanel() {
        return imagePanel;
    }

    /**
     * Gets the panel containing order details.
     * @return The panel containing order details.
     */
    public JPanel getOrderPanel(){
        return orderPanel;
    }

    /**
     * Gets the label displaying the total.
     * @return The label displaying the total.
     */
    public JLabel getTotalLabel(){
        return totalLabel;
    }
    
   
   
}