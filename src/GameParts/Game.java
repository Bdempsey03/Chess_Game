package GameParts;
import Graphics.*;

public class Game {
    private static final Player white = new Player("white");
    private static final Player black = new Player("black");
    private static char playerTurn = 'w';

    public static void main(String[] args) {

        GUI.boardGridSetup();
        Board.boardSetup();
        Game.start();


    }


    public static void start(){
        white.setTurn(true);//black.setTurn(true); isnt working for some reason
    }

    public static void toggleTurn(){
        if(white.getIsTurn()){
            playerTurn = 'b';
            white.setTurn(false);
            black.setTurn(true);
        }else{
            playerTurn = 'w';
            white.setTurn(true);
            black.setTurn(false);
        }
    }
    public static char getPlayerTurn(){
        return playerTurn;
    }
}
