package Pieces;

import GameParts.Move;
import Graphics.BoardSquare;

import java.util.ArrayList;

public class KingModel implements Piece {
    private final char colour;
    public static BoardSquare blackKing;
    public static BoardSquare whiteKing;

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

    public static boolean checkCheck(BoardSquare[][] theBoard, BoardSquare start){
        char opponent;//opponent's colour
        ArrayList<Move> holderOfMoves;
        if(start.getPieceOnSquare().getColor()=='w') {
            opponent = 'b';
        }else {
            opponent = 'w';
        }
        /**
        Goes through all board squares until it find a piece. If the piece is the opponent's then it finds the legal moves and compares the
        end of the legal moves (target) with the current position of the king. If they match then the king is in check.
         */
        for(int i = 0; i < 64; i++){
            if(theBoard[i/8][i%8].getPieceOnSquare() != null)
                if(theBoard[i/8][i%8].getPieceOnSquare().getColor() == opponent) {
                    holderOfMoves = theBoard[i / 8][i % 8].getPieceOnSquare().validMove(theBoard, theBoard[i / 8][i % 8]);
                    for (int j = 0; j < holderOfMoves.size(); j++) {
                        if (holderOfMoves.get(j).getEnd().equals(start.toString()))
                            return true;
                    }
                }
        }
        return false;
    }
    @Override
    public ArrayList<Move> listMoves() {
        return null;
    }

    public String toString() {
        return "K";
    }

    public static BoardSquare locateKing(BoardSquare[][] theBoard, char colour){
        for(int i = 0; i<64; i++){
            if(theBoard[i/8][i%8].getPieceOnSquare() instanceof KingModel)
            if(theBoard[i/8][i%8].getPieceOnSquare().getColor() == colour)
            return theBoard[i/8][i%8];
        }
        return new BoardSquare(0, 0, 0, 0, '0', null, false);
    }
}

