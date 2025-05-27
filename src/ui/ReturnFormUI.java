package ui;

import models.Customer;
import models.Vehicle;
import system.RentalSystem;

import javax.swing.*;
import java.awt.*;

import static ui.UIDesign.*;

/**
 * ReturnFormUI - UI form for customers to return a previously rented vehicle.
 * This class uses UIDesign for consistent styling and handles rental ID input and validation.
 */
public class ReturnFormUI extends JFrame {

    /**
     * Constructor for ReturnFormUI
     * @param rentalSystem The main RentalSystem instance to handle rental logic.
     */
    public ReturnFormUI(RentalSystem rentalSystem) {
        // Frame properties
        setTitle("Return Vehicle");
        setSize(FRAME_SIZE);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);
        setResizable(false);
        getContentPane().setBackground(FRAME_BG_COLOR);
        setLayout(new GridBagLayout());

        // =====================
        // Main Panel with Rounded Background
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
                MAIN_PANEL_PADDING.right));

        // =====================
        // Title Label
        // =====================
        JLabel titleLabel = new JLabel("Return Rented Vehicle", SwingConstants.CENTER);
        titleLabel.setFont(TITLE_FONT);
        titleLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
        titleLabel.setBorder(BorderFactory.createEmptyBorder(
                TITLE_PADDING.top,
                TITLE_PADDING.left,
                TITLE_PADDING.bottom,
                TITLE_PADDING.right));

        // =====================
        // Rental ID Input Field
        // =====================
        JTextField idField = new JTextField();
        idField.setMaximumSize(new Dimension(700, 100));
        idField.setFont(new Font("SansSerif", Font.PLAIN, 28));
        idField.setBorder(BorderFactory.createTitledBorder(
                BorderFactory.createLineBorder(Color.GRAY, 1),
                "Enter Your Rental ID",
                0, 0, new Font("SansSerif", Font.BOLD, 25)));

        // =====================
        // Return Button
        // =====================
        RoundButton returnButton = new RoundButton("Return Vehicle");
        returnButton.setBackground(new Color(220, 80, 60));
        returnButton.addActionListener(e -> {
            String rentalIdText = idField.getText().trim();

            // Styling for JOptionPane dialogs
            UIManager.put("OptionPane.messageFont", new Font("SansSerif", Font.PLAIN, 60));
            UIManager.put("OptionPane.buttonFont", new Font("SansSerif", Font.BOLD, 60));

            // =====================
            // Input Validation
            // =====================
            if (rentalIdText.isEmpty()) {
                JOptionPane.showMessageDialog(this,
                        "Please enter your Rental ID.",
                        "Error", JOptionPane.ERROR_MESSAGE);
                return;
            }

            // Check format: should start with RC / RM + number (e.g., RC3, RM5)
            if (rentalIdText.length() < 3 ||
                    Character.toUpperCase(rentalIdText.charAt(0)) != 'R' ||
                    (Character.toUpperCase(rentalIdText.charAt(1)) != 'C' &&
                            Character.toUpperCase(rentalIdText.charAt(1)) != 'M')) {

                JOptionPane.showMessageDialog(this,
                        "Rental ID must be like RC3 or RM5.",
                        "Invalid Input", JOptionPane.ERROR_MESSAGE);
                return;
            }

            try {
                // Extract numeric part from rental ID string
                int rentalId = Integer.parseInt(rentalIdText.substring(2)); // Remove "RC" or "RM"

                // Retrieve customer based on rental ID (adjusted for 0-based index)
                Customer customer = rentalSystem.getCustomerById(rentalId - 1);

                if (customer == null) {
                    JOptionPane.showMessageDialog(this,
                            "Rental ID not found!",
                            "Error", JOptionPane.ERROR_MESSAGE);
                    return;
                }

                // Retrieve and update vehicle
                Vehicle rentedVehicle = customer.getRentedVehicle();
                if (rentedVehicle != null) {
                    rentedVehicle.setQuantity(rentedVehicle.getQuantity() + 1); // Increase vehicle availability

                    JOptionPane.showMessageDialog(this,
                            "✅ Vehicle returned successfully!\nThank you!",
                            "Return Successful", JOptionPane.INFORMATION_MESSAGE);
                    dispose(); // Close the window
                } else {
                    JOptionPane.showMessageDialog(this,
                            "This rental does not have a valid vehicle linked.",
                            "Return Error", JOptionPane.ERROR_MESSAGE);
                }

            } catch (NumberFormatException ex) {
                // Rental ID part was not a number
                JOptionPane.showMessageDialog(this,
                        "Rental ID must be in the format RC3 or RM5.",
                        "Invalid Input", JOptionPane.ERROR_MESSAGE);
            }
        });

        // =====================
        // Add Components to Panel
        // =====================
        formPanel.add(titleLabel);
        formPanel.add(Box.createVerticalStrut(40));
        formPanel.add(idField);
        formPanel.add(Box.createVerticalStrut(50));
        formPanel.add(returnButton);

        // Add panel to frame
        add(formPanel);
        setVisible(true);
    }
}
