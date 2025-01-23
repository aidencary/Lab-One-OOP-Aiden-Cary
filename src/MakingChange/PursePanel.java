package MakingChange;

import javax.swing.*;
import java.awt.*;

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
        g.drawString(purse.toString(), 10, 20); // Draw the purse contents as a string starting at (10, 20)
    }

}
