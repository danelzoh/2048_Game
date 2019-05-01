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

    public static void main(String[] args) {
        new GameRunner().start();
        File file = new File("tile256Image.jpg");
		BufferedImage image = null;
		try {
			image = ImageIO.read(file);
		}catch(IOException e) {
			e.printStackTrace();
		}
        Tile t = new tile32(32,image,1,1);
        System.out.println("test2");
    }

    public void start() {
        JFrame frame = new JFrame("Space");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        panel = new JPanel() {
            @Override
            public void paintComponent(Graphics g) {
                super.paintComponent(g);
            }
        };
        panel.setLayout(null);
        panel.setBackground(new Color(74, 232, 143));
        panel.setPreferredSize(new Dimension(1200, 800));
        frame.add(panel);
        frame.pack();
        frame.setVisible(true);
        System.out.println("test");


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
