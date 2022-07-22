package Pieces;

import GameParts.Game;
import GameParts.Move;
import Graphics.BoardSquare;

import java.util.ArrayList;

public class QueenModel implements Piece{
    private final char colour;
    private boolean hitU = false;//hit a piece UP
    private boolean hitD = false;;//down
    private boolean hitL = false;;//left
    private boolean hitR = false;;//right
    private boolean hitUL = false;;//up left
    private boolean hitUR = false;;//up right
    private boolean hitDL = false;;//down left
    private boolean hitDR = false;;//down right


    public QueenModel(char colour){
        this.colour=colour;
    }

    @Override
    public char getColor() {
        return colour;
    }

    @Override
    public ArrayList<Move> validMove(BoardSquare[][] theBoard, BoardSquare start) {



        ArrayList<Move> moves = new ArrayList<>();
        hitDR = false;
        hitDL = false;
        hitUR = false;
        hitUL = false;
        hitD = false;
        hitL = false;
        hitR = false;
        hitU = false;
        int moveCtr = 0;
        int firstIndex = start.findBoardIndex(theBoard)[0];
        int secondIndex = start.findBoardIndex(theBoard)[1];


        for(int i = 0; i<56; i++) {
            moves.add(new Move());
            moves.get(i).setStart(start.toString());
        }

        int i = 0;
        while(!hitU&&secondIndex-i>=0){
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

        i = 0;
        while(!hitDR && firstIndex+i<=7 && secondIndex+i<=7){
            if(firstIndex+(i+1)<=7&&secondIndex+(i+1)<=7)
                if(theBoard[firstIndex+(i+1)][secondIndex+(i+1)].getPieceOnSquare() != null){
                    hitDR = true;
                    moves.get(moveCtr).setEnd(theBoard[firstIndex+(i+1)][secondIndex+i+1].toString());
                    moveCtr++;
                }
            moves.get(moveCtr).setEnd(theBoard[firstIndex + i][secondIndex + i].toString());
            moveCtr++;
            i++;
        }
        i = 0;
        while(!hitDL && firstIndex-i>=0 && secondIndex+i<=7){
            if(firstIndex-(i+1)>=0&&secondIndex+(i+1)<=7)
                if(theBoard[firstIndex-(i+1)][secondIndex+(i+1)].getPieceOnSquare() != null){
                    hitDL = true;
                    moves.get(moveCtr).setEnd(theBoard[firstIndex-(i+1)][secondIndex+i+1].toString());
                    moveCtr++;
                }
            moves.get(moveCtr).setEnd(theBoard[firstIndex - i][secondIndex + i].toString());
            moveCtr++;
            i++;
        }
        i = 0;
        while(!hitUR && firstIndex+i<=7 && secondIndex-i>=0){
            if(firstIndex+(i+1)<=7&&secondIndex-(i+1)>=0)
                if(theBoard[firstIndex+(i+1)][secondIndex-(i+1)].getPieceOnSquare() != null){
                    hitUR = true;
                    moves.get(moveCtr).setEnd(theBoard[firstIndex+(i+1)][secondIndex-(i+1)].toString());
                    moveCtr++;
                }
            moves.get(moveCtr).setEnd(theBoard[firstIndex + i][secondIndex - i].toString());
            moveCtr++;
            i++;
        }
        i = 0;
        while(!hitUL && firstIndex-i>=0 && secondIndex-i>=0){
            if(firstIndex-(i+1)>=0&&secondIndex-(i+1)>=0)
                if(theBoard[firstIndex-(i+1)][secondIndex-(i+1)].getPieceOnSquare() != null){
                    hitUL = true;
                    moves.get(moveCtr).setEnd(theBoard[firstIndex-(i+1)][secondIndex-(i+1)].toString());
                    moveCtr++;
                }
            moves.get(moveCtr).setEnd(theBoard[firstIndex - i][secondIndex - i].toString());
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
        return "Q";
    }
}