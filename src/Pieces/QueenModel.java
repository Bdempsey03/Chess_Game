package Pieces;

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
        int moveCtr = 0;
        int firstIndex = start.findBoardIndex(theBoard)[0];
        int secondIndex = start.findBoardIndex(theBoard)[1];


        for(int i = 0; i<56; i++) {
            moves.add(new Move());
            moves.get(i).setStart(start.toString());
        }

        int i = 0;
        while(!hitU&&secondIndex-i>=0){
            moves.get(moveCtr).setEnd(theBoard[firstIndex][secondIndex - i].toString());
            moveCtr++;
            i++;
        }
        i = 0;
        while(!hitD&&secondIndex+i<=7){
            moves.get(moveCtr).setEnd(theBoard[firstIndex][secondIndex + i].toString());
            moveCtr++;
            i++;
        }
        i = 0;
        while(!hitL && firstIndex-i>=0){
            moves.get(moveCtr).setEnd(theBoard[firstIndex - i][secondIndex].toString());
            moveCtr++;
            i++;
        }
        i = 0;
        while(!hitR && firstIndex+i<=7){
            moves.get(moveCtr).setEnd(theBoard[firstIndex + i][secondIndex].toString());
            moveCtr++;
            i++;
        }

        i = 0;
        while(!hitDR && firstIndex+i<=7 && secondIndex+i<=7){
            moves.get(moveCtr).setEnd(theBoard[firstIndex + i][secondIndex + i].toString());
            moveCtr++;
            i++;
        }
        i = 0;
        while(!hitDL && firstIndex-i>=0 && secondIndex+i<=7){
            moves.get(moveCtr).setEnd(theBoard[firstIndex - i][secondIndex + i].toString());
            moveCtr++;
            i++;
        }
        i = 0;
        while(!hitDR && firstIndex+i<=7 && secondIndex-i>=0){
            moves.get(moveCtr).setEnd(theBoard[firstIndex + i][secondIndex - i].toString());
            moveCtr++;
            i++;
        }
        i = 0;
        while(!hitDR && firstIndex-i>=0 && secondIndex-i>=0){
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