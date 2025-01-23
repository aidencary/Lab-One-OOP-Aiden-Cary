package MakingChange;

import javax.swing.*;
import java.awt.*;
import java.util.Map;

public class PursePanel extends JPanel {
    private Purse purse = new Purse();

    public void setPurse(Purse purse) {
        this.purse = purse; // Sets the new purse to be displayed
        repaint(); // Repaints and updates the display (had to Google this)
    }
// Will probably change everything below
    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g); // Call the superclass method to clear the panel
        int y = 20; // Start y position for drawing text and images
        for (Map.Entry<Denomination, Integer> entry : purse.cash.entrySet()) {
            Denomination denom = entry.getKey();
            int count = entry.getValue();

            // Draw the denomination name and count
            g.drawString(denom.name() + " x " + count, 10, y);

            // Load and draw the image if it exists
            ImageIcon icon = new ImageIcon((denom.img()));

            if (icon.getImage() != null) {
                g.drawImage(icon.getImage(), 150, y - 15, 30, 30, this); // Adjust image position and size
            }

            y += 40; // Move down for the next denomination


            /*
            String imagePath = denom.img(); // Directly use the provided image path
            java.net.URL imageUrl = getClass().getClassLoader().getResource(imagePath);
            ImageIcon icon = new ImageIcon((denom.img()));
            if (imageUrl != null) {
                //ImageIcon icon = new ImageIcon(imageUrl);
                for (int i = 0; i < count; i++) {
                    g.drawImage(icon.getImage(), 150 + (i * 35), y - 15, 30, 30, this); // Adjust image position and spacing
                }
            } else {
                g.drawString("[Image not found: " + denom.img() + "]", 150, y); // Indicate missing image
            }

            y += 40; // Move down for the next denomination

             */
        }
    }
}
