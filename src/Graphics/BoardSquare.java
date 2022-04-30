package Graphics;

import Pieces.*;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

public class BoardSquare extends JComponent {

    BufferedImage bPawn;BufferedImage bRook;BufferedImage bBishop;BufferedImage bKnight;BufferedImage bKing;BufferedImage bQueen;

    BufferedImage wPawn;BufferedImage wRook;BufferedImage wBishop;BufferedImage wKnight;BufferedImage wKing;BufferedImage wQueen;



    public static BoardSquare[][] theBoard = new BoardSquare[8][8];

    private final SquareID ID;
    private Piece pieceOnSquare;
    private final int x;
    private final int y;
    private final int z;
    private final int w;
    private final char c;
    private boolean clicked = false;

    private static int i = 0;
    private static int k = 0;

    private final MouseListener AL= new MouseAdapter() {
        @Override
        public void mouseClicked(MouseEvent e) {
            clicked=true;
            repaint();
        }
    };

    public BoardSquare(int x, int y, int z, int w, char c, Piece piece) {
        pieceOnSquare = piece;
        this.x = x;
        this.y = y;
        this.z = z;
        this.w = w;
        this.c = c;
        this.addMouseListener(AL);
        ID = new SquareID();
        theBoard[i][k] = this;
        if (i < 7) {
            i++;
        } else {
            i=0;
            k++;
        }
    }

    @Override
    protected void paintComponent(Graphics g){
        Graphics2D g2d = (Graphics2D)g;
        setImages();
        if(c=='b')
        g2d.setColor(new Color(120, 75, 0));
        else
            g2d.setColor(new Color(210, 180, 140));
        g2d.fillRect(x,y,z,w);
        if(clicked){
            g2d.setColor(Color.RED);
            g2d.drawRect(x,y,z,w);
            System.out.println(ID);
            clicked=false;
        }

        if(pieceOnSquare !=null) {
            if (pieceOnSquare instanceof PawnModel) {
                if (pieceOnSquare.getColor() == 'w')
                    g2d.drawImage(wPawn, 0, 0, null);
                else {
                    g2d.drawImage(bPawn, 0, 0, null);
                }
            }
            if (pieceOnSquare instanceof RookModel) {
                if (pieceOnSquare.getColor() == 'w')
                    g2d.drawImage(wRook, 0, 0, null);
                else {
                    g2d.drawImage(bRook, 0, 0, null);
                }
            }if (pieceOnSquare instanceof KnightModel) {
                if (pieceOnSquare.getColor() == 'w')
                    g2d.drawImage(wKnight, 0, 0, null);
                else {
                    g2d.drawImage(bKnight, 0, 0, null);
                }
            }if (pieceOnSquare instanceof BishopModel) {
                if (pieceOnSquare.getColor() == 'w')
                    g2d.drawImage(wBishop, 0, 0, null);
                else {
                    g2d.drawImage(bBishop, 0, 0, null);
                }
            }if (pieceOnSquare instanceof KingModel) {
                if (pieceOnSquare.getColor() == 'w')
                    g2d.drawImage(wKing, 0, 0, null);
                else {
                    g2d.drawImage(bKing, 0, 0, null);
                }
            }if (pieceOnSquare instanceof QueenModel) {
                if (pieceOnSquare.getColor() == 'w')
                    g2d.drawImage(wQueen, 0, 0, null);
                else {
                    g2d.drawImage(bQueen, 0, 0, null);
                }
            }
        }


    }
    public void setPieceOnSquare(Piece p){
        pieceOnSquare=p;
        repaint();
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
    @Override
    public String toString(){
        return ID+"";
    }
}
