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
//        Board board = new Board();
//        JFrame frame = new JFrame();
//        frame.add(board);
//        frame.setSize(810,900);
//        frame.setVisible(true);
//        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

    }

    public static BoardModel getBoard() {
        return boardModel;
    }
}
