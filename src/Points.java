import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import javax.swing.JFrame;
import javax.swing.JPanel;


public class Points {
    private int score = 0;
    private int titleHeight = 100;

    public void add(int v){
        score += v;
    }

    public void draw(Graphics g) {
        int fontSize = 50;

        g.setFont(new Font("Helvetica Bold", Font.BOLD, fontSize));
        g.setColor(Color.white);
        g.drawString("Score: "+score, (Tile.width*4)+20, 75+titleHeight);
    }
}

