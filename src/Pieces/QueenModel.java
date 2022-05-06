package Pieces;

import Graphics.Board;
import Graphics.BoardSquare;

import java.util.ArrayList;

public class QueenModel implements Piece{
    private final char colour;

    public QueenModel(char colour){
        this.colour=colour;
    }

    @Override
    public char getColor() {
        return colour;
    }

    @Override
    public boolean validMove(BoardSquare[][] theBoard, Move theMove) {
        return false;//HOLDER
    }

    @Override
    public ArrayList<Move> listMoves() {
        return null;
    }

    public String toString(){
        return "Q";
    }
}