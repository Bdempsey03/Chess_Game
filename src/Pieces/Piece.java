package Pieces;

import java.util.ArrayList;

public interface Piece {
    char colour = 'x';
    char getColor();
    ArrayList<Move> listMoves();


}
