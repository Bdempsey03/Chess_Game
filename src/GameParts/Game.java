package GameParts;
import Graphics.*;
import Pieces.KingModel;

//This is a comment

import static Pieces.KingModel.blackKing;
import static Pieces.KingModel.whiteKing;

public class Game {
    private static final Player white = new Player("white");
    private static final Player black = new Player("black");
    private static char playerTurn = 'w';
    private static boolean whiteCheck;
    private static boolean blackCheck;

    public static void go(){
        GUI.boardGridSetup();
        Board.boardSetup();
        Game.start();
    }
    public static void main(String[] args) {
        javax.swing.SwingUtilities.invokeLater(Game::go);
    }


    public static void start(){
        white.setTurn(true);//black.setTurn(true); isn't working for some reason
        blackKing = KingModel.locateKing(BoardSquare.theBoard, 'b');
        whiteKing = KingModel.locateKing(BoardSquare.theBoard, 'w');
        System.out.println(blackKing);
        System.out.println(whiteKing);
    }

    public static void toggleTurn(){
        if(white.getIsTurn()){
            playerTurn = 'b';
            white.setTurn(false);
            black.setTurn(true);
            blackCheck = KingModel.checkCheck(BoardSquare.theBoard, blackKing);//check to see if the black king is in check

        }else{

            playerTurn = 'w';
            white.setTurn(true);
            black.setTurn(false);
            whiteCheck = KingModel.checkCheck(BoardSquare.theBoard, whiteKing);//check to see if the white king is in check
        }
        System.out.println("BLACK CHECK: " + blackCheck + "\nWHITE CHECK: "+ whiteCheck);
//        if(whiteCheck || blackCheck)
//        System.exit(-8);
    }
    public static char getPlayerTurn(){
        return playerTurn;
    }

    public static boolean isWhiteCheck() {
        return whiteCheck;
    }

    public static boolean isBlackCheck() {
        return blackCheck;
    }
}
