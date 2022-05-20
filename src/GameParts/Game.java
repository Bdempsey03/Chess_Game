package GameParts;
import Graphics.*;
import Pieces.BoardModel;

public class Game {
    private static BoardModel boardModel;
    private static Player white = new Player("white");
    private static Player black = new Player("black");

    public static void main(String[] args) {

        GUI.boardGridSetup();
        Board2.boardSetup();
        Game.start();
        for(int j=0; j<BoardSquare.theBoard.length;j++)
            for(int p=0; p<BoardSquare.theBoard.length;p++)
                System.out.println(BoardSquare.theBoard[j][p]);


        boardModel = new BoardModel();
        boardModel.boardSetup();
        System.out.println(BoardSquare.boardToString());
        System.out.println(BoardSquare.piecesToString());

    }

    public static BoardModel getBoard() {
        return boardModel;
    }
    public static void start(){
        white.setTurn(true);
        //needs more stuff
    }
    public static void toggleTurn(){
        if(white.getIsTurn()){
            white.setTurn(false);
            black.setTurn(true);
        }else{
            white.setTurn(true);
            black.setTurn(false);
        }
    }
}