package Graphics;

import javax.swing.*;
import java.awt.*;

public class BoardSquare extends JComponent {
    private int x;
    private int y;
    private int z;
    private int w;

    public BoardSquare(int x, int y, int z, int w){
        this.x=x;
        this.y=y;
        this.z=z;
        this.w=w;

    }

    @Override
    protected void paintComponent(Graphics g){
        Graphics2D g2d = (Graphics2D)g;
        g2d.setColor(new Color(120, 75, 0));
        g2d.fillRect(x,y,z,w);
    }
}
