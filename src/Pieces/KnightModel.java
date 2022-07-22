package Pieces;

import GameParts.Game;
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
        int firstIndex = start.findBoardIndex(theBoard)[0];
        int secondIndex = start.findBoardIndex(theBoard)[1];

        for(int i = 0; i<8; i++) {
            moves.add(new Move());
            moves.get(i).setStart(start.toString());
        }

        //All moves for a knight. (down 1, left 2...)
        if(firstIndex+1<=7&&secondIndex+2<=7)
        moves.get(0).setEnd(theBoard[firstIndex+1][secondIndex+2].toString());
        if(firstIndex-1>=0&&secondIndex+2<=7)
        moves.get(1).setEnd(theBoard[firstIndex-1][secondIndex+2].toString());
        if(firstIndex+1<=7&&secondIndex-2>=0)
        moves.get(2).setEnd(theBoard[firstIndex+1][secondIndex-2].toString());
        if(firstIndex-1>=0&&secondIndex-2>=0)
        moves.get(3).setEnd(theBoard[firstIndex-1][secondIndex-2].toString());
        if(firstIndex+2<=7&&secondIndex+1<=7)
        moves.get(4).setEnd(theBoard[firstIndex+2][secondIndex+1].toString());
        if(firstIndex+2<=7&&secondIndex-1>=0)
        moves.get(5).setEnd(theBoard[firstIndex+2][secondIndex-1].toString());
        if(firstIndex-2>=0&&secondIndex+1<=7)
        moves.get(6).setEnd(theBoard[firstIndex-2][secondIndex+1].toString());
        if(firstIndex-2>=0&&secondIndex-1>=0)
        moves.get(7).setEnd(theBoard[firstIndex-2][secondIndex-1].toString());

//        System.out.println(moves);
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