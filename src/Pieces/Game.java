package Pieces;
import Graphics.*;

import javax.swing.*;

public class Game {
    private static BoardModel boardModel;

    public static void main(String[] args) {
        boardModel = new BoardModel();
        boardModel.boardSetup();
        Board board = new Board();
        JFrame frame = new JFrame();
        frame.add(board);
        frame.setSize(810,900);
        frame.setVisible(true);
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

    }

    public static BoardModel getBoard() {
        return boardModel;
    }
}
