import javax.imageio.ImageIO;
import java.awt.*;
import java.io.IOException;

public class Tile {
    private int value;
    private int row, col;
    static int height = 100, width = 100;
    boolean canMerge;
    private Color color;
    private Image image;

    public final static String PATH_PREFIX = "/images/";


    public Tile(int v, int r, int c){
        value = v;
        row = r;
        col = c;
        image = getImage("tile"+v+"Image.jpg");
    }

    public void setColor(Tile tile){
        color = (new Color(value, value, 0));
    }

    protected  Image getImage(String name) {
        Image img = null;
        name = PATH_PREFIX+name;
        try {
            image = ImageIO.read(getClass().getResource(name));
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return img;
    }
    
    public void draw(Graphics g) {
    	g.drawImage(image, 0, 0, null);
    	
    }
}
