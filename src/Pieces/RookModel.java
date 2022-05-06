package Pieces;

import Graphics.Board;
import Graphics.BoardSquare;

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
    public boolean validMove(BoardSquare[][] theBoard, Move theMove) {
        BoardSquare boardSquare;
        for (int i = 0; i < 8; i++) {
            for (int k = 0; k < 8; k++) {
                if (theMove.getStart().equals(theBoard[i][k].toString())){
                    boardSquare=theBoard[i][k];
                }
            }


        }
        return true;
    }



    @Override
    public ArrayList<Move> listMoves() {
        return null;
    }

    public String toString(){
        return "R";
    }
}