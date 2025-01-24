package MakingChange;

import javax.swing.*;
import java.awt.*;
import java.util.Map;

public class PursePanel extends JPanel {
    private Purse purse = new Purse();

    public void setPurse(Purse purse) {
        this.purse = purse; // Sets the new purse to be displayed
        repaint(); // Repaints and updates the display
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g); // Call the superclass method to clear the panel
        int y = 20; // Start y position for drawing text and images


        for (Map.Entry<Denomination, Integer> entry : purse.cash.entrySet()) {
            Denomination denom = entry.getKey();
            int count = entry.getValue();

            // Draw the denomination name and count
            g.drawString(denom.name() + " x " + count, 20, y);

            // Load the image
            ImageIcon icon = new ImageIcon(denom.img());

            if (icon.getImage() != null) {
                for (int i = 0; i < count; i++) {
                    // Draw the image for each instance of the denomination
                    g.drawImage(icon.getImage(), 160 + (i * 60), y - 30, 60, 60, this);

                }
            } else {
                g.drawString("[Image not found: " + denom.img() + "]", 150, y); // Indicate missing image
            }

            y += 60; // Move down for the next denomination
        }
    }
}
