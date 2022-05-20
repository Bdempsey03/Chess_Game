package GameParts;

public class Player {
    private final String colour;
    private boolean isTurn = false;

    public Player(String colour){
        this.colour = colour;
    }
    public void setTurn(boolean b){
        isTurn = b;
    }
    public boolean getIsTurn(){
        return isTurn;
    }
    public String toString(){
       return colour+" player";
    }
}
