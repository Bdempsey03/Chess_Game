package Graphics;

import GameParts.Game;
import Pieces.*;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import static Graphics.GUI.*;

public class Board extends JComponent {
    BufferedImage bPawn;
    BufferedImage bRook;
    BufferedImage bBishop;
    BufferedImage bKnight;
    BufferedImage bKing;
    BufferedImage bQueen;

    BufferedImage wPawn;
    BufferedImage wRook;
    BufferedImage wBishop;
    BufferedImage wKnight;
    BufferedImage wKing;
    BufferedImage wQueen;




    private final int windowSize = getWindowSize();
    private final int dimension = getDimension();
    private final int offset = getOffset();
    private final String[] top= {"A","B","C","D","E","F","G", "H"};
    private final String[] side= {"1","2", "3", "4", "5", "6", "7", "8"};


    @Override
    protected void paintComponent(Graphics g) {
        BoardModel boardModel = Game.getBoard();
        Graphics2D g2d = (Graphics2D) g;

        setImages();

        g2d.setColor(Color.BLACK);
        g2d.fillRect(0, 0, windowSize, windowSize);//black border

        g2d.setColor(new Color(120, 75, 0));
        g2d.fillRect(offset, offset, (windowSize - (windowSize / 8)), windowSize - (windowSize / 8));//dark squares

        g2d.setColor(new Color(210, 180, 140));
        for (int i = 0; i < 8; i += 2) {
            for (int k = 0; k < 8; k += 2) {
                g2d.fillRect(offset + i * dimension, offset + k * dimension, dimension, dimension);
            }
        }
        for (int i = 1; i < 8; i += 2) {
            for (int k = 1; k < 8; k += 2) {
                g2d.fillRect(offset + i * dimension, offset + k * dimension, dimension, dimension);
            }//light squares
        }
        g2d.setColor(Color.WHITE);
        g2d.setFont(new Font("Times New Roman", Font.BOLD, 20));
        for (int i = 0; i < 8; i++) {
            g2d.drawString(top[i], dimension * (i + 1), offset / 2);
            g2d.drawString(top[i], dimension * (i + 1), windowSize - offset / 2);
        }
        for (int i = 0; i < 8; i++) {
            g2d.drawString(side[i], offset / 2, dimension * (i + 1));
            g2d.drawString(side[i], windowSize - offset / 2, dimension * (i + 1));
        }

        /*
         * This is where all the pieces are drawn on the board
         */

//        double scale =(((double)dimension/100));
//        int newDimension = ((100/dimension));

//        g2d.scale(scale, scale);

//        g2d.scale(0.86,0.86);
        for (int i = 0; i < 8; i++) {
            for (int k = 0; k < 8; k++) {
                if (boardModel.getBoardArr()[i][k] != null) {
                    if (boardModel.getBoardArr()[i][k] instanceof PawnModel) {
                        if (boardModel.getBoardArr()[i][k].getColor() == 'w') {
                            g2d.drawImage(wPawn, ((offset + k * dimension)), (offset + i * dimension), null);
                        } else {
                            g2d.drawImage(bPawn, ((offset + k * dimension)), (offset + i * dimension), null);
                        }
                    }
                    if (boardModel.getBoardArr()[i][k] instanceof RookModel) {
                        if (boardModel.getBoardArr()[i][k].getColor() == 'w') {
                            g2d.drawImage(wRook, ((offset + k * dimension)), (offset + i * dimension), null);
                        } else {
                            g2d.drawImage(bRook, ((offset + k * dimension)), (offset + i * dimension), null);
                        }
                    }
                    if (boardModel.getBoardArr()[i][k] instanceof KnightModel) {
                        if (boardModel.getBoardArr()[i][k].getColor() == 'w') {
                            g2d.drawImage(wKnight, ((offset + k * dimension)), (offset + i * dimension), null);
                        } else {
                            g2d.drawImage(bKnight, ((offset + k * dimension)), (offset + i * dimension), null);
                        }
                    }
                    if (boardModel.getBoardArr()[i][k] instanceof BishopModel) {
                        if (boardModel.getBoardArr()[i][k].getColor() == 'w') {
                            g2d.drawImage(wBishop, ((offset + k * dimension)), (offset + i * dimension), null);
                        } else {
                            g2d.drawImage(bBishop, ((offset + k * dimension)), (offset + i * dimension), null);
                        }
                    }
                    if (boardModel.getBoardArr()[i][k] instanceof KingModel) {
                        if (boardModel.getBoardArr()[i][k].getColor() == 'w') {
                            g2d.drawImage(wKing, ((offset + k * dimension)), (offset + i * dimension), null);
                        } else {
                            g2d.drawImage(bKing, ((offset + k * dimension)), (offset + i * dimension), null);
                        }
                    }
                    if (boardModel.getBoardArr()[i][k] instanceof QueenModel) {
                        if (boardModel.getBoardArr()[i][k].getColor() == 'w') {
                            g2d.drawImage(wQueen, ((offset + k * dimension)), (offset + i * dimension), null);
                        } else {
                            g2d.drawImage(bQueen, ((offset + k * dimension)), (offset + i * dimension), null);
                        }
                    }
                }
            }

        }
    }

    private void setImages(){
        try {
            bPawn = ImageIO.read(new File("C:\\Users\\Ben\\IdeaProjects\\Chess\\src\\BlackPawn.png"));
            bRook = ImageIO.read(new File("C:\\Users\\Ben\\IdeaProjects\\Chess\\src\\BlackRook.png"));
            bKnight = ImageIO.read(new File("C:\\Users\\Ben\\IdeaProjects\\Chess\\src\\BlackKnight.png"));
            bBishop = ImageIO.read(new File("C:\\Users\\Ben\\IdeaProjects\\Chess\\src\\BlackBishop.png"));
            bKing = ImageIO.read(new File("C:\\Users\\Ben\\IdeaProjects\\Chess\\src\\BlackKing.png"));
            bQueen = ImageIO.read(new File("C:\\Users\\Ben\\IdeaProjects\\Chess\\src\\BlackQueen.png"));

            wPawn = ImageIO.read(new File("C:\\Users\\Ben\\IdeaProjects\\Chess\\src\\WhitePawn.png"));
            wRook = ImageIO.read(new File("C:\\Users\\Ben\\IdeaProjects\\Chess\\src\\WhiteRook.png"));
            wKnight = ImageIO.read(new File("C:\\Users\\Ben\\IdeaProjects\\Chess\\src\\WhiteKnight.png"));
            wBishop = ImageIO.read(new File("C:\\Users\\Ben\\IdeaProjects\\Chess\\src\\WhiteBishop.png"));
            wKing = ImageIO.read(new File("C:\\Users\\Ben\\IdeaProjects\\Chess\\src\\WhiteKing.png"));
            wQueen = ImageIO.read(new File("C:\\Users\\Ben\\IdeaProjects\\Chess\\src\\WhiteQueen.png"));


        } catch (IOException e) {
            System.out.println("Missing one or more images");
        }
    }
}

