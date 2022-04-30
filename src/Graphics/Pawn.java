package Graphics;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import static Graphics.GUI.*;

public class Pawn extends JComponent {
    private char colour;

    public Pawn(char c){
        colour=c;
    }

    @Override
    protected void paintComponent(Graphics g){
        BufferedImage bPawn;
        BufferedImage wPawn;

        try {
            bPawn = ImageIO.read(new File("C:\\Users\\Ben\\IdeaProjects\\Chess\\src\\BlackPawn.png"));
            wPawn = ImageIO.read(new File("C:\\Users\\Ben\\IdeaProjects\\Chess\\src\\WhitePawn.png"));

            if (colour=='w'){
                g.drawImage(wPawn,0,0,null);
            }else{
                g.drawImage(bPawn,0,0,null);
            }

        } catch (IOException e) {
            System.out.println("No pawn image found");
        }


    }
}
