package Graphics;

import javax.swing.*;
import java.awt.*;

import static Graphics.GUI.*;

public class Pawn extends JComponent {
    private final int windowSize = getWindowSize();
    private final int dimension = getDimension();
    private final int offset = getOffset();

    @Override
    protected void paintComponent(Graphics g){
        Graphics2D g2d = (Graphics2D)g;
        g2d.setColor(Color.RED);
        g2d.fillOval(0,0, dimension, dimension);

    }
}
