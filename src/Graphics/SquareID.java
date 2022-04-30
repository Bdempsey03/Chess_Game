package Graphics;

public class SquareID {
    private static int num = 1;
    private static char letter = 'A';

    private final int IDNumber;
    private final char IDLetter;

    public SquareID(){
        IDNumber=num;
        IDLetter=letter;
        switch (letter) {
            case ('A') -> letter = 'B';
            case ('B') -> letter = 'C';
            case ('C') -> letter = 'D';
            case ('D') -> letter = 'E';
            case ('E') -> letter = 'F';
            case ('F') -> letter = 'G';
            case ('G') -> letter = 'H';
            case ('H') -> {letter = 'A';
                num++;
            }
        }
        }
        @Override
    public String toString(){
        return ""+IDLetter+IDNumber;
        }
    }
