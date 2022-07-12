package Graphics;

import Pieces.*;

import static Graphics.BoardSquare.theBoard;

public class Board {

    public static void boardSetup(){
        theBoard[0][0].setPieceOnSquare(new RookModel('w'));
        theBoard[7][0].setPieceOnSquare(new RookModel('w'));
        theBoard[1][0].setPieceOnSquare(new KnightModel('w'));
        theBoard[6][0].setPieceOnSquare(new KnightModel('w'));
        theBoard[2][0].setPieceOnSquare(new BishopModel('w'));
        theBoard[5][0].setPieceOnSquare(new BishopModel('w'));
        theBoard[4][0].setPieceOnSquare(new QueenModel('w'));
        theBoard[3][0].setPieceOnSquare(new KingModel('w'));

        theBoard[0][7].setPieceOnSquare(new RookModel('b'));
        theBoard[7][7].setPieceOnSquare(new RookModel('b'));
        theBoard[1][7].setPieceOnSquare(new KnightModel('b'));
        theBoard[6][7].setPieceOnSquare(new KnightModel('b'));
        theBoard[2][7].setPieceOnSquare(new BishopModel('b'));
        theBoard[5][7].setPieceOnSquare(new BishopModel('b'));
        theBoard[4][7].setPieceOnSquare(new QueenModel('b'));
        theBoard[3][7].setPieceOnSquare(new KingModel('b'));

        for(int i=0; i<8; i++){
            theBoard[i][1].setPieceOnSquare(new PawnModel('w'));
            theBoard[i][6].setPieceOnSquare(new PawnModel('b'));
        }
    }
}
