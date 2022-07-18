package Pieces;

import GameParts.Move;
import Graphics.BoardSquare;

import java.util.ArrayList;

public class BishopModel implements Piece{
    private final char colour;
    private boolean hitDL = false;//collided with piece DOWN AND LEFT
    private boolean hitUL = false;//UP AND LEFT
    private boolean hitDR = false;//DOWN AND RIGHT
    private boolean hitUR = false;//UP AND RIGHT

    public BishopModel(char colour){
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
        int moveCtr = 0;
        int firstIndex = start.findBoardIndex(theBoard)[0];
        int secondIndex = start.findBoardIndex(theBoard)[1];


        for(int i = 0; i<28; i++) {
            moves.add(new Move());
            moves.get(i).setStart(start.toString());
        }

        int i = 0;
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
        return "B";
    }
}
