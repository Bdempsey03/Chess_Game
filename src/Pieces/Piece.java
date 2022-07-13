package Pieces;

import GameParts.Move;
import Graphics.BoardSquare;

import java.util.ArrayList;

public interface Piece {
    char colour = 'x';
    char getColor();
    ArrayList<Move> validMove(BoardSquare[][] theBoard, BoardSquare start);
    ArrayList<Move> listMoves();
    public String toString();


}
