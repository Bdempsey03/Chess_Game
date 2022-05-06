package Pieces;

public class Move {
    private String start = "null";
    private String end = "null";

    public void setStart(String start){
        this.start=start;
    }

    public String getStart() {
        return start;
    }

    public String getEnd() {
        return end;
    }

    public void setEnd(String end){
        this.end=end;
    }



    @Override
    public String toString(){
        return start+"-"+end;
    }
}
