import java.awt.*;

public class Tile {
    private int rank = 2;
    static int height, width;
    boolean canMerge;
    private Color color;
    public Tile(int r){
        rank = r;
    }

    public void setColor(Tile tile){
        color = (new Color(rank, rank, 0));
    }
}
