import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import javax.swing.JFrame;
import javax.swing.JPanel;


public class Title {
    private int score = 0;

    public void add(int v){
        score += v;
    }

    public void draw(Graphics g) {
        int fontSize = 76;

        g.setFont(new Font("Helvetica Bold", Font.BOLD, fontSize));
        g.setColor(Color.white);
        g.drawString("Fruitful Quadrilaterals", 0, fontSize);
    }
}

