package Graphics;

import javax.swing.*;
import java.awt.*;

public class GUI {
    private static final int windowSize = 640;
    private static final int dimension = windowSize/8-(windowSize/64);
    private static final int offset = windowSize/16;

    public static void boardGridSetup(){
        JFrame frame = new JFrame();
        frame.setSize(640, 640);
        frame.setLayout(new GridLayout(8,8));
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        int ctr=0;

        while(ctr<8) {
            if (ctr % 2 == 0) {
                for (int i = 0; i < 4; i++) {
                    frame.add(new BoardSquare(0, 0, 80, 80, 'w', null));
                    frame.add(new BoardSquare(0, 0, 80, 80, 'b', null));
                }
            } else {
                for (int i = 0; i < 4; i++) {
                    frame.add(new BoardSquare(0, 0, 80, 80, 'b', null));
                    frame.add(new BoardSquare(0, 0, 80, 80, 'w', null));
                }
            }ctr++;
        }
        frame.setVisible(true);
    }
    public static int getWindowSize(){
        return windowSize;
    }

    public static int getDimension() {
        return dimension;
    }

    public static int getOffset() {
        return offset;
    }
}
