import javax.imageio.ImageIO;
import java.awt.*;
import java.io.IOException;
import java.sql.SQLOutput;

public class Tile {
    private int value;
    private int row, col;
    private int titleHeight = 100;
    public static final int height = 100, width = 100;
    boolean canMerge;
    private Color color;
    private Image image;
    public boolean hasAdded;

    public final static String PATH_PREFIX = "/images/";


    public Tile(int v, int r, int c){
        value = v;
        row = r;
        col = c;
        hasAdded = false; 
        getImage("tile"+v+"Image.jpg");
        //System.out.println("tile"+v+"Image.jpg");

    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
        getImage("tile"+value+"Image.jpg");
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
        g.drawImage(image, col*width, (row*height)+titleHeight, width,height, null);
    }

    public void drawLeg(Graphics g) {
        g.drawImage(image, col*width +800, (row*height)+titleHeight, width,height, null);
    }


    public int getRow() {
        return this.getRow();
    }
    public int getCol(){
        return this.getCol();
    }


    public void shiftUp(){
        if(this.value > 0 /**&& col > 0**/){
            this.row -= 1;

        }
    }

    public void shiftDown(){
        if(this.value > 0 /**&& col < 3**/){
            this.row +=1;
        }
    }

    public void shiftLeft(){
        if(this.value > 0 /**&& row < 0**/){
            this.col -=1;
        }
    }

    public void shiftRight(){
        if(this.value > 0 /**&& row > 3**/){
            this.col +=1;
        }
    }

}
