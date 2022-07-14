package Pieces;

import GameParts.Move;
import Graphics.BoardSquare;

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
    public ArrayList<Move> validMove(BoardSquare[][] theBoard, BoardSquare start) {
        ArrayList<Move> moves = new ArrayList<>();
        String startTile = start.getID();


        return moves;
    }
    @Override
    public ArrayList<Move> listMoves() {
        return null;
    }

    public String toString(){
        return "N";
    }
}