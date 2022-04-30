package Pieces;

import java.util.ArrayList;

public class KingModel implements Piece{
    private final char colour;

    public KingModel(char colour){
        this.colour=colour;
    }

    @Override
    public char getColor() {
        return colour;
    }

    @Override
    public ArrayList<Move> listMoves() {
        return null;
    }
}
