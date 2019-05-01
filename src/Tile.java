import java.awt.*;

public class Tile {
    private int value;
    private int row, col;
    static int height, width;
    boolean canMerge;
    private Color color;
    private Image image;
    
    public Tile(int v, Image i, int r, int c){
        value = v;
        image = i;
        row = r;
        col = c;

    }

    public void setColor(Tile tile){
        color = (new Color(value, value, 0));
    }
    
    public void draw(Graphics g) {
    	
    }
}
