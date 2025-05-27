package ui;

import models.Customer;
import models.Vehicle;
import system.RentalSystem;

import javax.swing.*;
import java.awt.*;

import static ui.UIDesign.*;

/**
 * RentalFormUI - A form for customers to enter their details and confirm a vehicle rental.
 * This form uses consistent styling from the UIDesign class and handles input validation and rental submission.
 */
public class RentalFormUI extends JFrame {

    /**
     * Constructor for RentalFormUI
     * @param rentalSystem - The main RentalSystem instance handling the business logic.
     * @param selectedVehicle - The vehicle selected by the customer to rent.
     */
    public RentalFormUI(RentalSystem rentalSystem, Vehicle selectedVehicle) {
        // Set up the JFrame
        setTitle("Rent Vehicle Form");
        setSize(FRAME_SIZE);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);
        setResizable(false);
        getContentPane().setBackground(FRAME_BG_COLOR);
        setLayout(new GridBagLayout());

        // =====================
        // Main Panel Setup
        // =====================
        JPanel formPanel = new JPanel() {
            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                Graphics2D g2 = (Graphics2D) g;
                g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
                g2.setColor(MAIN_PANEL_BG_COLOR);
                g2.fillRoundRect(0, 0, getWidth(), getHeight(), MAIN_PANEL_ARC_WIDTH, MAIN_PANEL_ARC_HEIGHT);
            }
        };
        formPanel.setLayout(new BoxLayout(formPanel, BoxLayout.Y_AXIS));
        formPanel.setPreferredSize(MAIN_PANEL_SIZE);
        formPanel.setOpaque(false);
        formPanel.setBorder(BorderFactory.createEmptyBorder(
                MAIN_PANEL_PADDING.top,
                MAIN_PANEL_PADDING.left,
                MAIN_PANEL_PADDING.bottom,
                MAIN_PANEL_PADDING.right
        ));

        // =====================
        // Title Label
        // =====================
        JLabel titleLabel = new JLabel("Enter Your Details", SwingConstants.CENTER);
        titleLabel.setFont(TITLE_FONT);
        titleLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
        titleLabel.setBorder(BorderFactory.createEmptyBorder(
                TITLE_PADDING.top,
                TITLE_PADDING.left,
                TITLE_PADDING.bottom,
                TITLE_PADDING.right
        ));

        // =====================
        // Selected Vehicle Display
        // =====================
        JTextArea vehicleDetails = new JTextArea(selectedVehicle.toString());
        vehicleDetails.setEditable(false);
        vehicleDetails.setFont(new Font("Monospaced", Font.PLAIN, 20));
        vehicleDetails.setBackground(new Color(240, 240, 240));
        vehicleDetails.setBorder(BorderFactory.createTitledBorder(
                BorderFactory.createLineBorder(Color.GRAY, 1),
                "Selected Vehicle",
                0, 0, new Font("SansSerif", Font.BOLD, 25)
        ));
        vehicleDetails.setMaximumSize(new Dimension(700, 100));

        // =====================
        // Customer Input Fields
        // =====================
        Font fieldFont = new Font("SansSerif", Font.PLAIN, 28);

        JTextField nameField = new JTextField();
        nameField.setMaximumSize(new Dimension(700, 100));
        nameField.setFont(fieldFont);
        nameField.setBorder(BorderFactory.createTitledBorder(
                BorderFactory.createLineBorder(Color.GRAY, 1),
                "Full Name",
                0, 0, new Font("SansSerif", Font.BOLD, 25)
        ));

        JTextField contactField = new JTextField();
        contactField.setMaximumSize(new Dimension(700, 100));
        contactField.setFont(fieldFont);
        contactField.setBorder(BorderFactory.createTitledBorder(
                BorderFactory.createLineBorder(Color.GRAY, 1),
                "Contact Number",
                0, 0, new Font("SansSerif", Font.BOLD, 25)
        ));

        // =====================
        // Submit Button
        // =====================
        RoundButton submitButton = new RoundButton("Confirm Rental");
        submitButton.setBackground(new Color(0, 160, 100));
        submitButton.addActionListener(e -> {
            String name = nameField.getText().trim();
            String contactNumber = contactField.getText().trim();

            // Set font for JOptionPane dialogs
            UIManager.put("OptionPane.messageFont", new Font("SansSerif", Font.PLAIN, 60));
            UIManager.put("OptionPane.buttonFont", new Font("SansSerif", Font.BOLD, 60));

            // =====================
            // Input Validation
            // =====================
            if (name.isEmpty() || contactNumber.isEmpty()) {
                JOptionPane.showMessageDialog(this,
                        "Please fill all fields!\n",
                        "Alert",
                        JOptionPane.ERROR_MESSAGE);
                return;
            }

            if (!contactNumber.matches("\\d+")) {
                JOptionPane.showMessageDialog(this,
                        "Please enter a valid contact number.",
                        "Alert",
                        JOptionPane.ERROR_MESSAGE);
                return;
            }

            // =====================
            // Process Rental
            // =====================
            Customer customer = new Customer(name, contactNumber, selectedVehicle);
            int rId = rentalSystem.addRental(customer);
            char rChar = selectedVehicle.getType().charAt(0); // Prefix rental ID with vehicle type
            JOptionPane.showMessageDialog(this,
                    "Rental confirmed! \nRemember your Rental Id : R" + rChar + rId + "\nThank You");

            dispose(); // Close the form after submission
        });

        // =====================
        // Add Components to Main Panel
        // =====================
        formPanel.add(titleLabel);
        formPanel.add(Box.createVerticalStrut(20));
        formPanel.add(vehicleDetails);
        formPanel.add(Box.createVerticalStrut(30));
        formPanel.add(nameField);
        formPanel.add(Box.createVerticalStrut(20));
        formPanel.add(contactField);
        formPanel.add(Box.createVerticalStrut(40));
        formPanel.add(submitButton);

        // Add main panel to the frame
        add(formPanel);
        setVisible(true);
    }
}
