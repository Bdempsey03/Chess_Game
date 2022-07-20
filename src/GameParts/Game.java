package GameParts;
import Graphics.*;
import Pieces.KingModel;

public class Game {
    private static final Player white = new Player("white");
    private static final Player black = new Player("black");
    private static char playerTurn = 'w';
    private static boolean whiteCheck;
    private static boolean blackCheck;

    public static void main(String[] args) {

        GUI.boardGridSetup();
        Board.boardSetup();
        Game.start();


    }


    public static void start(){
        white.setTurn(true);//black.setTurn(true); isnt working for some reason
        KingModel.blackKing = KingModel.locateKing(BoardSquare.theBoard, 'b');
        KingModel.whiteKing = KingModel.locateKing(BoardSquare.theBoard, 'w');
        System.out.println(KingModel.blackKing);
        System.out.println(KingModel.whiteKing);
    }

    public static void toggleTurn(){
        if(white.getIsTurn()){
            playerTurn = 'b';
            white.setTurn(false);
            black.setTurn(true);
        }else{
            playerTurn = 'w';
            white.setTurn(true);
            black.setTurn(false);
        }
    }
    public static char getPlayerTurn(){
        return playerTurn;
    }
}
