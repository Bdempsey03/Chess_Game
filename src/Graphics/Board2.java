package Graphics;

import Pieces.*;

import static Graphics.BoardSquare.theBoard;

public class Board2{

    public static void boardSetup(){
        theBoard[0][0].setPieceOnSquare(new RookModel('w'));
        theBoard[7][0].setPieceOnSquare(new RookModel('w'));
        theBoard[1][0].setPieceOnSquare(new KnightModel('w'));
        theBoard[6][0].setPieceOnSquare(new KnightModel('w'));
        theBoard[2][0].setPieceOnSquare(new BishopModel('w'));
        theBoard[5][0].setPieceOnSquare(new BishopModel('w'));
    }
}
