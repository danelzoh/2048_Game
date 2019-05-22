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
	private Points points;

	public static void main(String[] args) {

		new GameRunner().start();
	}

	public void start() {
		JFrame frame = new JFrame("Board");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		grid = new Grid();
		points = new Points();
		panel = new JPanel() {
			@Override
			public void paintComponent(Graphics g) {
				super.paintComponent(g);
				grid.draw(g);
				points.draw(g);
			}
		};
		panel.setLayout(null);
		panel.setBackground(new Color(205, 192, 181));
		panel.setPreferredSize(new Dimension(1200, 800));
		frame.add(panel);
		frame.pack();
		frame.setVisible(true);

		if (panel.requestFocus(true))
		;

		panel.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
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
				panel.repaint();
			}
		});
		timer.start();
	}

	public void gameOver(){
		
		JOptionPane.showMessageDialog(null, "loser");
		//for some reason, the dialogue box will be shown on instances of moveUp() where none of the tiles move

	}

	public Points getPoints(){
		return points;
	}

	public void moveUp() {
		grid.moveUp(this);
	}

	private void moveDown() {
		grid.moveDown(this);
	}

	private void moveLeft() {
		grid.moveLeft(this);
	}
	private void moveRight() {
		grid.moveRight(this);
	}
	

}
