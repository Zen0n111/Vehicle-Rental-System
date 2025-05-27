package ui;

import system.RentalSystem;

import javax.swing.*;
import java.awt.*;

import static ui.UIDesign.*;

public class MainMenuUI extends JFrame {

    public MainMenuUI(RentalSystem rentalSystem) {
        setTitle("Vehicle Rental System");
        setSize(FRAME_SIZE);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setResizable(false);

        // Outer background and layout
        getContentPane().setBackground(FRAME_BG_COLOR);
        setLayout(new GridBagLayout()); // to center inner panel

        // Rounded panel
        JPanel mainPanel = new JPanel() {
            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                Graphics2D g2 = (Graphics2D) g;
                g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
                g2.setColor(MAIN_PANEL_BG_COLOR);
                g2.fillRoundRect(0, 0, getWidth(), getHeight(), MAIN_PANEL_ARC_WIDTH, MAIN_PANEL_ARC_HEIGHT);
            }
        };
        mainPanel.setLayout(new BoxLayout(mainPanel, BoxLayout.Y_AXIS));
        mainPanel.setPreferredSize(MAIN_PANEL_SIZE);
        mainPanel.setOpaque(false);
        mainPanel.setBorder(BorderFactory.createEmptyBorder(
                MAIN_PANEL_PADDING.top,
                MAIN_PANEL_PADDING.left,
                MAIN_PANEL_PADDING.bottom,
                MAIN_PANEL_PADDING.right));

        // Title
        JLabel title = new JLabel("Vehicle Rental System 🚗 ", SwingConstants.CENTER);
        title.setFont(TITLE_FONT);
        title.setAlignmentX(Component.CENTER_ALIGNMENT);
        title.setBorder(BorderFactory.createEmptyBorder(
                TITLE_PADDING.top,
                TITLE_PADDING.left,
                TITLE_PADDING.bottom,
                TITLE_PADDING.right));

        // Buttons
        RoundButton rentBtn = new RoundButton("🚙 Rent Vehicle");
        rentBtn.setBackground(new Color(112, 89, 199));
        RoundButton returnBtn = new RoundButton("🔄 Return Vehicle");
        returnBtn.setBackground(new Color(55, 200, 255));
        RoundButton viewBtn = new RoundButton("📋 View Available Vehicles");
        viewBtn.setBackground(new Color(90, 240, 180));
        RoundButton exitBtn = new RoundButton("🔚 Exit");
        exitBtn.setBackground(new Color(255, 100, 100));

        // Button Actions
        rentBtn.addActionListener(e -> new AvailableVehiclesUI(rentalSystem));
        returnBtn.addActionListener(e -> new ReturnFormUI(rentalSystem));
        viewBtn.addActionListener(e -> new AvailableVehiclesUI(rentalSystem));
        exitBtn.addActionListener(e -> System.exit(0));

        // Add to panel with spacing
        mainPanel.add(title);
        mainPanel.add(rentBtn);
        mainPanel.add(Box.createVerticalStrut(35));
        mainPanel.add(returnBtn);
        mainPanel.add(Box.createVerticalStrut(35));
        mainPanel.add(viewBtn);
        mainPanel.add(Box.createVerticalStrut(35));
        mainPanel.add(exitBtn);

        // Add to center of frame
        add(mainPanel);

        setVisible(true);
    }
}
