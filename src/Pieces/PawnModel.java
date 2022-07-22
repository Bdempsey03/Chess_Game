package Pieces;

import GameParts.Move;
import Graphics.BoardSquare;

import java.util.ArrayList;

public class PawnModel implements Piece{
    private final char colour;
    private boolean movedOnce;

    private static int count = 0;

    private int pawnID;

    public PawnModel(char colour){
    this.colour=colour;
    this.movedOnce=false;
    pawnID = count;
    count++;
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

        for(int i = 0; i<4; i++) {
            moves.add(new Move());
            moves.get(i).setStart(start.toString());
        }
        if(this.colour=='w') {
            if(secondIndex+1<7&&theBoard[firstIndex][secondIndex+1].getPieceOnSquare()==null)
                moves.get(0).setEnd(theBoard[firstIndex][secondIndex+1].toString());
            if(firstIndex+1<=7&&secondIndex+1<=7&&theBoard[firstIndex+1][secondIndex+1].getPieceOnSquare()!=null&&theBoard[firstIndex+1][secondIndex+1].getPieceOnSquare().getColor() == 'b')
                moves.get(1).setEnd(theBoard[firstIndex+1][secondIndex+1].toString());//taking diagonally
            if(firstIndex-1>=0&&secondIndex+1<=7&&theBoard[firstIndex-1][secondIndex+1].getPieceOnSquare()!=null&&theBoard[firstIndex-1][secondIndex+1].getPieceOnSquare().getColor() == 'b')
                moves.get(2).setEnd(theBoard[firstIndex-1][secondIndex+1].toString());//taking diagonally
            if(!this.movedOnce&&secondIndex+2<=7&&theBoard[firstIndex][secondIndex+2].getPieceOnSquare()==null) {
                moves.get(3).setEnd(theBoard[firstIndex][secondIndex + 2].toString());
                this.movedOnce = true;
            }
        }else{
            if(secondIndex-1>0&&theBoard[firstIndex][secondIndex-1].getPieceOnSquare()==null)
                moves.get(0).setEnd(theBoard[firstIndex][secondIndex-1].toString());
            if(firstIndex+1<=7&&secondIndex+1<=7&&theBoard[firstIndex+1][secondIndex-1].getPieceOnSquare()!=null&&theBoard[firstIndex+1][secondIndex-1].getPieceOnSquare().getColor() == 'w')
                moves.get(1).setEnd(theBoard[firstIndex+1][secondIndex-1].toString());//taking diagonally
            if(firstIndex-1>=0&&secondIndex+1<=7&&theBoard[firstIndex-1][secondIndex-1].getPieceOnSquare()!=null&&theBoard[firstIndex-1][secondIndex-1].getPieceOnSquare().getColor() == 'w')
                moves.get(2).setEnd(theBoard[firstIndex-1][secondIndex-1].toString());//taking diagonally
            if(!this.movedOnce&&secondIndex-2>=0&&theBoard[firstIndex][secondIndex-2].getPieceOnSquare()==null) {
                moves.get(1).setEnd(theBoard[firstIndex][secondIndex - 2].toString());
                this.movedOnce = true;

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
