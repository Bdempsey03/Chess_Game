package Pieces;

import GameParts.Move;
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
    public ArrayList<Move> validMove(BoardSquare[][] theBoard, BoardSquare start) {
        int x = start.getX();
        ArrayList<Move> moves = new ArrayList<>();

        for(int i = 0; i<8; i++){
//            if(theBoard[)
        }



        return moves;
    }



    @Override
    public ArrayList<Move> listMoves() {
        return null;
    }

    public String toString(){
        return "R";
    }
}
//Hello. These are new changes