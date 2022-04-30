package Pieces;

import java.util.ArrayList;

public class RookModel implements Piece{
    private final char colour;

    public RookModel(char colour){
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