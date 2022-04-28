package Graphics;

import javax.swing.*;

public class GUI {
    private static final int windowSize = 640;
    private static final int dimension = windowSize/8-(windowSize/64);
    private static final int offset = windowSize/16;

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
