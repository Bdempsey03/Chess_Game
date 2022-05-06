package Pieces;
import Graphics.*;

import javax.swing.*;

public class Game {
    private static BoardModel boardModel;

    public static void main(String[] args) {

        GUI.boardGridSetup();
        Board2.boardSetup();
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
}
