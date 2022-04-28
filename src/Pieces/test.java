package Pieces;
import Graphics.*;

import javax.swing.*;

public class test {
    public static void main(String[] args) {
        Board board = new Board();
        JFrame frame = new JFrame();
        frame.add(board);
        board.add(new Pawn());
        frame.setSize(810,900);
        frame.setVisible(true);
    }
}
