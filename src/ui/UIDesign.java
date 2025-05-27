package ui;

import javax.swing.*;
import java.awt.*;

public class UIDesign {

    // Frame dimensions and main background color
    public static final Dimension FRAME_SIZE = new Dimension(1050, 1050);
    public static final Color FRAME_BG_COLOR = new Color(230, 236, 245);

    // Main panel design
    public static final Dimension MAIN_PANEL_SIZE = new Dimension(850, 850);
    public static final Color MAIN_PANEL_BG_COLOR = Color.WHITE;
    public static final int MAIN_PANEL_ARC_WIDTH = 60;
    public static final int MAIN_PANEL_ARC_HEIGHT = 60;
    public static final Insets MAIN_PANEL_PADDING = new Insets(40, 40, 40, 40);

    // Title design
    public static final Font TITLE_FONT = new Font("SansSerif", Font.BOLD, 45);
    public static final Insets TITLE_PADDING = new Insets(30, 0, 50, 0);

    // Button design
    public static final Dimension BUTTON_SIZE = new Dimension(620, 110);
    public static final Font BUTTON_FONT = new Font("SansSerif", Font.BOLD, 30);

    // Rounded Button UI
    public static class RoundButton extends JButton {
        private static final int ARC_WIDTH = 40;
        private static final int ARC_HEIGHT = 40;

        public RoundButton(String text) {
            super(text);
            setPreferredSize(BUTTON_SIZE);
            setMaximumSize(BUTTON_SIZE);
            setFont(BUTTON_FONT);
            setForeground(Color.WHITE);
            setFocusPainted(false);
            setBorderPainted(false);
            setContentAreaFilled(false);
            setOpaque(false);
            setAlignmentX(Component.CENTER_ALIGNMENT);
        }

        @Override
        protected void paintComponent(Graphics g) {
            Graphics2D g2 = (Graphics2D) g.create();
            g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

            if (getModel().isPressed()) {
                g2.setColor(getBackground().darker());
            } else if (getModel().isRollover()) {
                g2.setColor(getBackground().brighter());
            } else {
                g2.setColor(getBackground());
            }

            g2.fillRoundRect(0, 0, getWidth(), getHeight(), ARC_WIDTH, ARC_HEIGHT);
            g2.dispose();

            super.paintComponent(g);
        }
    }

    // Utility: Create reusable round-styled button
    public static RoundButton createRoundButton(String text, Color bgColor) {
        RoundButton button = new RoundButton(text);
        button.setBackground(bgColor);
        return button;
    }

    // Utility: Create a reusable rounded main panel
    public static JPanel createRoundedMainPanel() {
        return new JPanel() {
            {
                setPreferredSize(MAIN_PANEL_SIZE);
                setOpaque(false);
                setBorder(BorderFactory.createEmptyBorder(
                        MAIN_PANEL_PADDING.top,
                        MAIN_PANEL_PADDING.left,
                        MAIN_PANEL_PADDING.bottom,
                        MAIN_PANEL_PADDING.right));
            }

            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                Graphics2D g2 = (Graphics2D) g;
                g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
                g2.setColor(MAIN_PANEL_BG_COLOR);
                g2.fillRoundRect(0, 0, getWidth(), getHeight(), MAIN_PANEL_ARC_WIDTH, MAIN_PANEL_ARC_HEIGHT);
            }
        };
    }
}
