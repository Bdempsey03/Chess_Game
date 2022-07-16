package Pieces;

import GameParts.Move;
import Graphics.BoardSquare;

import java.util.ArrayList;

public class PawnModel implements Piece{
    private final char colour;
    private boolean movedOnce = false;

    public PawnModel(char colour){
    this.colour=colour;
    }

    @Override
    public char getColor() {
        return colour;
    }

    @Override
    public ArrayList<Move> validMove(BoardSquare[][] theBoard, BoardSquare start) {
        ArrayList<Move> moves = new ArrayList<>();
        int firstIndex = start.findBoardIndex(theBoard)[0];
        int secondIndex = start.findBoardIndex(theBoard)[1];

        for(int i = 0; i<3; i++) {
            moves.add(new Move());
            moves.get(i).setStart(start.toString());
        }
        if(this.colour=='w') {
            if(secondIndex+1<7)
            moves.get(0).setEnd(theBoard[firstIndex][secondIndex+1].toString());
            if(!this.movedOnce&&secondIndex+2<=7) {
                moves.get(1).setEnd(theBoard[firstIndex][secondIndex + 2].toString());
                movedOnce = true;
            }
        }else{
            if(secondIndex-1>0)
                moves.get(0).setEnd(theBoard[firstIndex][secondIndex-1].toString());
            if(!this.movedOnce&&secondIndex-2>=0) {
                moves.get(1).setEnd(theBoard[firstIndex][secondIndex - 2].toString());
                movedOnce = true;
            }
        }
        return moves;
    }
    @Override
    public ArrayList<Move> listMoves() {
        return null;
    }

    public String toString(){
        return "P";
    }
}
