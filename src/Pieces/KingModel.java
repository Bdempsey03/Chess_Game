package Pieces;

import GameParts.Move;
import Graphics.BoardSquare;

import java.util.ArrayList;

public class KingModel implements Piece {
    private final char colour;

    public KingModel(char colour) {
        this.colour = colour;
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

        if(firstIndex+1<7)
            moves.get(0).setEnd(theBoard[firstIndex+1][secondIndex].toString());
        if(firstIndex+1<7&&secondIndex+1<7)
            moves.get(1).setEnd(theBoard[firstIndex+1][secondIndex+1].toString());
        if(secondIndex+1<7)
            moves.get(2).setEnd(theBoard[firstIndex][secondIndex+1].toString());
        if(firstIndex-1>0&&secondIndex+1<7)
            moves.get(3).setEnd(theBoard[firstIndex-1][secondIndex+1].toString());
        if(firstIndex-1>0)
            moves.get(4).setEnd(theBoard[firstIndex-1][secondIndex].toString());
        if(firstIndex-1>0&&secondIndex-1>0)
            moves.get(5).setEnd(theBoard[firstIndex-1][secondIndex-1].toString());
        if(secondIndex-1>0)
            moves.get(6).setEnd(theBoard[firstIndex][secondIndex-1].toString());
        if(firstIndex+1<7&&secondIndex-1>0)
            moves.get(7).setEnd(theBoard[firstIndex+1][secondIndex-1].toString());


        return moves;
    }

    public boolean checkCheck(BoardSquare[][] theBoard, BoardSquare start){
        int firstIndex = start.findBoardIndex(theBoard)[0];
        int secondIndex = start.findBoardIndex(theBoard)[1];
        char opponent;//opponent's colour
        if(start.getPieceOnSquare().getColor()=='w') {
            opponent = 'b';
        }else {
            opponent = 'w';
        }
        //In check from knight
        if(theBoard[firstIndex+1][secondIndex+2].getPieceOnSquare().toString().equals("N")&&theBoard[firstIndex+1][secondIndex+2].getPieceOnSquare().getColor()==opponent)
            return true;
        if(theBoard[firstIndex-1][secondIndex+2].getPieceOnSquare().toString().equals("N")&&theBoard[firstIndex-1][secondIndex+2].getPieceOnSquare().getColor()==opponent)
            return true;
        if(theBoard[firstIndex+1][secondIndex-2].getPieceOnSquare().toString().equals("N")&&theBoard[firstIndex+1][secondIndex-2].getPieceOnSquare().getColor()==opponent)
            return true;
        if(theBoard[firstIndex-1][secondIndex-2].getPieceOnSquare().toString().equals("N")&&theBoard[firstIndex-1][secondIndex-2].getPieceOnSquare().getColor()==opponent)
            return true;
        if(theBoard[firstIndex+2][secondIndex+1].getPieceOnSquare().toString().equals("N")&&theBoard[firstIndex+2][secondIndex+1].getPieceOnSquare().getColor()==opponent)
            return true;
        if(theBoard[firstIndex-2][secondIndex+1].getPieceOnSquare().toString().equals("N")&&theBoard[firstIndex-2][secondIndex+1].getPieceOnSquare().getColor()==opponent)
            return true;
        if(theBoard[firstIndex+2][secondIndex-1].getPieceOnSquare().toString().equals("N")&&theBoard[firstIndex+2][secondIndex-1].getPieceOnSquare().getColor()==opponent)
            return true;
        if(theBoard[firstIndex-2][secondIndex-1].getPieceOnSquare().toString().equals("N")&&theBoard[firstIndex-2][secondIndex-1].getPieceOnSquare().getColor()==opponent)
            return true;
        return false;
    }
    @Override
    public ArrayList<Move> listMoves() {
        return null;
    }

    public String toString() {
        return "K";
    }
}

