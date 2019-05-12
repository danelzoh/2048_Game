import javax.imageio.ImageIO;
import java.awt.*;
import java.io.IOException;
import java.sql.SQLOutput;

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
        getImage("tile"+v+"Image.jpg");
        System.out.println("tile"+v+"Image.jpg");
        //add code which is used for empty cell with a value of '0'
    }

    public void setColor(Tile tile){
        color = (new Color(value, value, 0));
    }

    protected void getImage(String name) {
        name = PATH_PREFIX+name;
        try {
            image = ImageIO.read(getClass().getResource(name));
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
    
    public void draw(Graphics g) {
    	g.drawImage(image, row*width, col*width, width,height, null);
    }
}
