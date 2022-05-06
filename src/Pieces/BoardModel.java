package Pieces;

//not used
public class BoardModel {
    private Piece[][] board = new Piece[8][8];




    public void boardSetup(){
        //pawns
        for(int i=0; i<8; i++){
            board[1][i]= new PawnModel('w');
            board[6][i]= new PawnModel('b');
        }
        board[0][0] = new RookModel('w');
        board[0][7] = new RookModel('w');
        board[0][1] = new KnightModel('w');
        board[0][6] = new KnightModel('w');
        board[0][2] = new BishopModel('w');
        board[0][5] = new BishopModel('w');
        board[0][4] = new QueenModel('w');
        board[0][3] = new KingModel('w');

        board[7][0] = new RookModel('b');
        board[7][7] = new RookModel('b');
        board[7][1] = new KnightModel('b');
        board[7][6] = new KnightModel('b');
        board[7][2] = new BishopModel('b');
        board[7][5] = new BishopModel('b');
        board[7][4] = new QueenModel('b');
        board[7][3] = new KingModel('b');
    }
    public Piece[][] getBoardArr(){
        return board;
    }
}
