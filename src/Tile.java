import java.awt.*;

public class Tile {
    private int value = 2;
    private int row, col;
    static int height, width;
    boolean canMerge;
    private Color color;
    public Tile(int r, int c, int v){
        value = v;
        row = r;
        col = c;
    }

    public void setColor(Tile tile){
        color = (new Color(value, value, 0));
    }
}
