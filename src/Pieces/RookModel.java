package Pieces;

import GameParts.Game;
import GameParts.Move;
import Graphics.BoardSquare;

import java.util.ArrayList;

public class RookModel implements Piece{
    private final char colour;
    private boolean hitU;//Hit a piece UP
    private boolean hitD;//down
    private boolean hitL;//left
    private boolean hitR;//right

    public RookModel(char colour){
        this.colour=colour;
    }

    @Override
    public char getColor() {
        return colour;
    }

    @Override
    public ArrayList<Move> validMove(BoardSquare[][] theBoard, BoardSquare start) {



        ArrayList<Move> moves = new ArrayList<>();
        hitD = false;
        hitL = false;
        hitU = false;
        hitR = false;
        int moveCtr = 0;
        int firstIndex = start.findBoardIndex(theBoard)[0];
        int secondIndex = start.findBoardIndex(theBoard)[1];


        for(int i = 0; i<28; i++) {//28 is the maximum number of valid moves
            moves.add(new Move());
            moves.get(i).setStart(start.toString());
        }

        int i = 0;
        while(!hitU&&secondIndex-i>=0){//continues adding vertical upwards moves to the list until it hits a piece. It includes the move that captures the piece
//            if(i>0)
            if(secondIndex-(i+1)>=0)
            if(theBoard[firstIndex][secondIndex-(i+1)].getPieceOnSquare() != null) {
                hitU = true;
                moves.get(moveCtr).setEnd(theBoard[firstIndex][secondIndex - (i + 1)].toString());//the move that would hit the piece
                moveCtr++;

            }

            moves.get(moveCtr).setEnd(theBoard[firstIndex][secondIndex - i].toString());
            moveCtr++;
            i++;
        }
        i = 0;
        while(!hitD&&secondIndex+i<=7){
//            if(i>0)
            if(secondIndex+(i+1)<=7&&secondIndex+(i+1)>=0)
            if(theBoard[firstIndex][secondIndex+(i+1)].getPieceOnSquare() != null) {
                hitD = true;
                moves.get(moveCtr).setEnd(theBoard[firstIndex][secondIndex + (i + 1)].toString());
                moveCtr++;
            }

            moves.get(moveCtr).setEnd(theBoard[firstIndex][secondIndex + i].toString());
            moveCtr++;
            i++;
        }
        i = 0;
        while(!hitL && firstIndex-i>=0){
//            if(i>0)
            if(firstIndex-(i+1)>=0)
                if(theBoard[firstIndex-(i+1)][secondIndex].getPieceOnSquare() != null) {
                    hitL = true;
                    moves.get(moveCtr).setEnd(theBoard[firstIndex-(i+1)][secondIndex].toString());
                    moveCtr++;
                }

            moves.get(moveCtr).setEnd(theBoard[firstIndex - i][secondIndex].toString());
            moveCtr++;
            i++;
        }
        i = 0;
        while(!hitR && firstIndex+i<=7){
//            if(i>0)
            if(firstIndex+(i+1)<=7&&firstIndex+(i+1)>=0)
            if(theBoard[firstIndex+(i+1)][secondIndex].getPieceOnSquare() != null) {
                hitR = true;
                moves.get(moveCtr).setEnd(theBoard[firstIndex+(i+1)][secondIndex].toString());
                moveCtr++;
            }

            moves.get(moveCtr).setEnd(theBoard[firstIndex + i][secondIndex].toString());
            moveCtr++;
            i++;
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