package Pieces;

import GameParts.Move;
import Graphics.BoardSquare;

import java.util.ArrayList;

public class TestPieceWithEveryMove implements Piece {

    @Override
    public char getColor() {
        return 0;
    }

    @Override
    public ArrayList<Move> validMove(BoardSquare[][] theBoard, BoardSquare start) {
        ArrayList<Move> moves = new ArrayList<>();
        for(int i = 0; i<8; i++){
            for(int j = 0; j<8; j++){
                moves.add(new Move());
                moves.get(i*8+j).setStart(start.toString());
                moves.get(i*8+j).setEnd(BoardSquare.theBoard[i][j].getID());
            }
        }
        System.out.println("\u001B[35m" + moves + "\u001B[0m");
        return moves;
    }

    @Override
    public ArrayList<Move> listMoves() {
        return null;
    }
}
