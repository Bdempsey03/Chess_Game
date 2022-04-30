package Pieces;

import java.util.ArrayList;

public class KnightModel implements Piece{
    private final char colour;

    public KnightModel(char colour){
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