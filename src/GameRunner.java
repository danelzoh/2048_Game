import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.util.Scanner;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
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
				grid.draw(g);
			}
		};
		panel.setLayout(null);
		panel.setBackground(new Color(74, 232, 143));
		panel.setPreferredSize(new Dimension(1200, 800));
		frame.add(panel);
		frame.pack();
		frame.setVisible(true);
		System.out.println("test");

		if (panel.requestFocus(true))
            System.out.println("true");
         ;
         
		panel.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				System.out.println("Key pressed");
				switch (e.getKeyCode()) {
				case KeyEvent.VK_UP:
					moveUp();
					break;
				case KeyEvent.VK_DOWN:
					moveDown();
					break;
				case KeyEvent.VK_LEFT:
					moveLeft();
					break;
				case KeyEvent.VK_RIGHT:
					moveRight();
					break;
				}
				panel.repaint();
			}
		});

				panel.repaint();

		        timer = new Timer(REFRESH_RATE, new ActionListener() {
			            @Override
		            public void actionPerformed(ActionEvent arg0) {
		                //updateGame();
			            //System.out.println("Action pressed");
		                panel.repaint();
		            }
		        });
		        timer.start();
	}

	public void moveUp() {
		grid.moveUp();
		System.out.println("moveUp");
	}

	private void moveDown() {
		grid.moveDown();
		System.out.println("moveDown");
	}

	private void moveLeft() {
		grid.moveLeft();
		System.out.println("moveLeft");
	}
	private void moveRight() {
		grid.moveRight();
		System.out.println("moveRight");
	}


}
