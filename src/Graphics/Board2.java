package Graphics;

import Pieces.RookModel;

import static Graphics.BoardSquare.theBoard;

public class Board2{

    public static void boardSetup(){
        theBoard[0][0].setPieceOnSquare(new RookModel('w'));
    }
}
