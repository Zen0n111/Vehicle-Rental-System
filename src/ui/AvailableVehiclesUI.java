package ui;

import models.Vehicle;
import system.DataStore;
import system.RentalSystem;
import static ui.UIDesign.*;

import javax.swing.*;
import java.awt.*;
import java.util.List;

/**
 * UI screen that displays a list of currently available vehicles.
 * Users can select a vehicle to proceed to the rental form.
 */
public class AvailableVehiclesUI extends JFrame {

    public AvailableVehiclesUI(RentalSystem rentalSystem) {
        setTitle("Select Available Vehicle");
        getContentPane().setBackground(FRAME_BG_COLOR);
        setSize(FRAME_SIZE.width, FRAME_SIZE.height);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);
        setResizable(false);
        setLayout(new GridBagLayout());

        // Main rounded panel containing the entire UI content
        JPanel mainPanel = UIDesign.createRoundedMainPanel();
        mainPanel.setLayout(new BorderLayout(20, 20));

        // Heading label
        JLabel title = new JLabel("Choose a Vehicle to Rent", SwingConstants.CENTER);
        title.setFont(TITLE_FONT);
        title.setBorder(BorderFactory.createEmptyBorder(20, 0, 20, 0));
        mainPanel.add(title, BorderLayout.NORTH);

        // Panel that will hold all available vehicle buttons
        JPanel vehicleListPanel = new JPanel();
        vehicleListPanel.setLayout(new BoxLayout(vehicleListPanel, BoxLayout.Y_AXIS));
        vehicleListPanel.setOpaque(false);

        // Retrieve available vehicles (quantity > 0)
        List<Vehicle> availableVehicles = DataStore.getAvailableVehicles();

        if (availableVehicles.isEmpty()) {
            // Display message if no vehicles are available
            JLabel noVehicle = new JLabel("No vehicles available!", SwingConstants.CENTER);
            noVehicle.setFont(new Font("SansSerif", Font.PLAIN, 24));
            noVehicle.setAlignmentX(Component.CENTER_ALIGNMENT);
            vehicleListPanel.add(noVehicle);
        } else {
            // For each available vehicle, create a button to select it
            for (Vehicle v : availableVehicles) {
                JButton vehicleButton = UIDesign.createRoundButton(v.toString(), new Color(70, 130, 180));
                vehicleButton.setAlignmentX(Component.CENTER_ALIGNMENT);

                // Open rental form with selected vehicle
                vehicleButton.addActionListener(e -> {
                    new RentalFormUI(rentalSystem, v);
                    dispose(); // Close current screen
                });

                vehicleListPanel.add(vehicleButton);
                vehicleListPanel.add(Box.createVerticalStrut(20));
            }
        }

        // Scroll pane to accommodate long vehicle lists
        JScrollPane scrollPane = new JScrollPane(vehicleListPanel);
        scrollPane.setOpaque(false);
        scrollPane.getViewport().setOpaque(false);
        scrollPane.setBorder(null);
        scrollPane.setPreferredSize(new Dimension(800, 600));

        mainPanel.add(scrollPane, BorderLayout.CENTER);
        add(mainPanel);
        setVisible(true);
    }
}
