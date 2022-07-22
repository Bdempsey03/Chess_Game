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

/*
The chess board is represented by this public member variable and is accessible by all classes. It is an 8x8 grid
of board squares.
 */

    public static BoardSquare[][] theBoard = new BoardSquare[8][8];


    private final SquareID ID;
    private Piece pieceOnSquare = null;
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
            if (selected) {
                while(!used){
                if(moves.get(j).getStart().equals("null")){
                    moves.get(j).setStart(this+"");
                    start=this;
                    used=true;
                }else{
                    if(moves.get(j).getEnd().equals("null")){
                    moves.get(j).setEnd(this+"");
                        end=this;
                        movePieceOnSquare(start, end, moves.get(j));

//                    }

                    used=true;
                }else{
                        moves.add(new Move());
                        j++;
                }}}used=false;

//                System.out.println(moves);
                g2d.setColor(Color.RED);
                g2d.drawRect(x, y, z-3, w-6);
//                System.out.println(ID);
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
     * This is responsible for taking a starting and ending square and moving the image. !!NOT LOGIC!!
     * @param start starting square
     * @param end ending square
     * @param move the move to be made
     */
    public void movePieceOnSquare(BoardSquare start, BoardSquare end, Move move){

        if(start.pieceOnSquare!=null) {
            if (start.pieceOnSquare.getColor() == Game.getPlayerTurn()) {
                Piece piece = start.pieceOnSquare;
                ArrayList<Move> moves = piece.validMove(theBoard, start);

                for (int i = 0; i < 8; i++) {
                    for (int k = 0; k < 8; k++) {
                        if (theBoard[i][k].getID().equals(move.getEnd())) {

                            for (int j = 0; j < moves.size(); j++) {
                                System.out.println("\u001B[47m" + move + " " + moves.get(j) + "\u001B[0m");
                                System.out.println(move.toString().equals(moves.get(j).toString()));
                                if (move.toString().equals(moves.get(j).toString()))
                                    if(theBoard[i][k].pieceOnSquare == null || theBoard[i][k].pieceOnSquare.getColor() != Game.getPlayerTurn()) {
                                    start.setPieceOnSquare(null);
                                    theBoard[i][k].setPieceOnSquare(piece);
                                    Game.toggleTurn();//IMPORTANT FOR TOGGLING TURN
                                    break;
                                }
                            }
                        }
                    }
                }
                //If the king was moved then it finds its new location
                if(piece instanceof KingModel)
                    if(piece.getColor() == 'w')
                        KingModel.whiteKing = KingModel.locateKing(theBoard, piece.getColor());
                if(piece.getColor() == 'b')
                    KingModel.blackKing = KingModel.locateKing(theBoard, piece.getColor());
//                System.out.println("WKING - BKING" + KingModel.whiteKing + " - " + KingModel.blackKing);

                start.repaint();
                end.repaint();
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

    /**
     * Prints out the chess board in console with white being on the top
     * @return board string
     */
    public static String piecesToString(){
        StringBuilder str= new StringBuilder();
        for(int i = 0; i<8; i++){
            for(int k = 0; k<8; k++){
                if((i+k)%2==1)
                    str.append("\u001B[40m");
                else
                    str.append("\u001B[47m" + "\u001B[30m");
                if(theBoard[k][i].pieceOnSquare==null)
                    str.append("   ");
                else
                str.append(" ").append(theBoard[k][i].pieceOnSquare).append(" ");
                str.append("\u001B[0m");
            }
            str.append("\n");
        }return str.toString();
    }

    public int[] findBoardIndex(BoardSquare[][] theBoard){
        for(int i = 0; i < 64; i++){
            if (this.toString().equals(theBoard[i/8][i%8].toString())){
                return new int[]{i/8, i%8};

            }
        }return new int[]{-1, -1};
    }

    public static BoardSquare matchIndexToBoard(String index, BoardSquare[][] theBoard) throws Exception {
        for(int i = 0; i<64; i++){
            if(theBoard[i/8][i%8].toString().equals(index))
            return theBoard[i/8][i%8];
        }
        throw(new Exception("Not a valid index"));
    }

    public Piece getPieceOnSquare() {
        return pieceOnSquare;
    }
}
