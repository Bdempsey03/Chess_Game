package Graphics;

import GameParts.Game;
import GameParts.Move;
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
    private boolean selected = false;
    private static ArrayList<Move> moves = new ArrayList<Move>();
    private static int j = 0;
    private static int i = 0;
    private static int k = 0;
    private boolean init = false;
    private boolean used = false;
    private static BoardSquare start;
    private static BoardSquare end;

    private final MouseListener AL= new MouseAdapter() {
        @Override
        public void mouseClicked(MouseEvent e) {
            clicked=true;
            selected=true;
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
        if(!init){
            moves.add(new Move());
            init=true;
        }
        Graphics2D g2d = (Graphics2D)g;
        setImages();
        if(c=='b')
        g2d.setColor(new Color(120, 75, 0));
        else
            g2d.setColor(new Color(210, 180, 140));
        g2d.fillRect(x,y,z,w);

        if(clicked) {
//            setPieceOnSquare(null);

            if (selected) {
                while(!used){
                if(moves.get(j).getStart().equals("null")){
                    moves.get(j).setStart(this+"");
                    start=this;
                    used=true;
                }else{
                    if(moves.get(j).getEnd().equals("null")){
                    moves.get(j).setEnd(this+"");
//                    if(validMove(moves.get(j))){
                        System.out.println("HI");
                        end=this;
                        movePieceOnSquare(start, end, moves.get(j));

//                    }

                    used=true;
                }else{
                        moves.add(new Move());
                        j++;
                }}}used=false;

                System.out.println(moves);
                g2d.setColor(Color.RED);
                g2d.drawRect(x, y, z, w);
                System.out.println(ID);
                clicked = false;
                System.out.println(piecesToString());
            }
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

    /**
     * Method for making moves
     * @return
     */
    public boolean validMove(BoardSquare[][] theBoard , Piece thePiece, Move theMove){
        return thePiece.validMove(theBoard, theMove);
    }

    /**
     * This is responsible for taking a starting and ending square and moving the image. !!NOT LOGIC!!
     * @param start starting square
     * @param end ending square
     * @param move the move to be made
     */
    public void movePieceOnSquare(BoardSquare start, BoardSquare end, Move move){

        if(start.pieceOnSquare!=null) {
            if (start.pieceOnSquare.getColor() == Game.getPlayerTurn()) {
                Piece piece = start.pieceOnSquare;
                start.setPieceOnSquare(null);

                for (int i = 0; i < 8; i++) {
                    for (int k = 0; k < 8; k++) {
                        if (theBoard[i][k].getID().equals(move.getEnd())) {
                            theBoard[i][k].setPieceOnSquare(piece);
                        }
                    }
                }
                start.repaint();
                System.out.println(start.pieceOnSquare);
                end.repaint();
                System.out.println(end.pieceOnSquare);
                Game.toggleTurn();
                System.out.println(Game.getPlayerTurn());
            }
        }
    }

    public String getID(){
        return ID.toString();
    }

    @Override
    public String toString(){
        return ID+"";
    }

    public static String boardToString(){
        StringBuilder str= new StringBuilder();
        for(int i = 0; i<8; i++){
            for(int k = 0; k<8; k++){
                str.append("[").append(theBoard[k][i]).append("]");
            }
            str.append("\n");
        }return str.toString();
    }


    public static String piecesToString(){
        StringBuilder str= new StringBuilder();
        for(int i = 0; i<8; i++){
            for(int k = 0; k<8; k++){
                if(theBoard[k][i].pieceOnSquare==null)
                    str.append("[X]");
                else
                str.append("[").append(theBoard[k][i].pieceOnSquare).append("]");
            }
            str.append("\n");
        }return str.toString();
    }
}
