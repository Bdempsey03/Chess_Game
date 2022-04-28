package Graphics;

import javax.swing.*;
import java.awt.*;

import static Graphics.GUI.*;

public class Board extends JComponent {
    private final int windowSize = getWindowSize();
    private final int dimension = getDimension();
    private final int offset = getOffset();
    private final String[] top= {"A","B","C","D","E","F","G", "H"};
    private final String[] side= {"1","2", "3", "4", "5", "6", "7", "8"};


    @Override
    protected void paintComponent(Graphics g){
        Graphics2D g2d = (Graphics2D)g;

        g2d.setColor(Color.BLACK);
        g2d.fillRect(0,0,windowSize,windowSize);//black border

        g2d.setColor(new Color(120, 75, 0));
        g2d.fillRect(offset,offset,(windowSize-(windowSize/8)),windowSize-(windowSize/8));//dark squares

        g2d.setColor(new Color(210,180,140));
        for (int i=0; i<8; i+=2){
            for (int k=0; k<8; k+=2){
                g2d.fillRect(offset+i*dimension, offset+k*dimension,dimension,dimension);
            }
        }
        for (int i=1; i<8; i+=2) {
            for (int k = 1; k < 8; k += 2) {
                g2d.fillRect(offset+i * dimension, offset+k * dimension, dimension, dimension);
            }//light squares
        }
        g2d.setColor(Color.WHITE);
        g2d.setFont(new Font("Times New Roman", Font.BOLD, 20));
        for (int i = 0; i<8; i++){
            g2d.drawString(top[i],dimension*(i+1),offset/2);
            g2d.drawString(top[i],dimension*(i+1),windowSize - offset/2);
        }
        for (int i = 0; i<8; i++){
            g2d.drawString(side[i],offset/2,dimension*(i+1));
            g2d.drawString(side[i],windowSize - offset/2,dimension*(i+1));
        }
    }
}
