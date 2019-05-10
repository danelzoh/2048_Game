import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.util.Scanner;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class GameRunner {
    private JPanel panel;
    private Timer timer;
    private static final int REFRESH_RATE = 10;
    private Grid grid;

    public static void main(String[] args) {
    	
    	
        new GameRunner().start();
    }

    public void start() {
        JFrame frame = new JFrame("Board");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        grid = new Grid();

        panel = new JPanel() {
            @Override
            public void paintComponent(Graphics g) {
                super.paintComponent(g);
        //        grid.draw(g);
            }
        };
        panel.setLayout(null);
        panel.setBackground(new Color(74, 232, 143));
        panel.setPreferredSize(new Dimension(1200, 800));
        frame.add(panel);
        frame.pack();
        frame.setVisible(true);
        System.out.println("test");
        panel.repaint();

        timer = new Timer(REFRESH_RATE, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent arg0) {
                //updateGame();
                panel.repaint();
            }
        });
        timer.start();
    }
}
