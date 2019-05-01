import java.awt.Graphics;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
public class Grid {

	private Tile[][] tiles = new Tile[4][4];
	
	public Grid() {
		for(int row =0; row < tiles.length; row++) {
			for(int col = 0; col < tiles[0].length; col++) {
				File file = new File("tile256Image.jpg");
				BufferedImage image = null;
				try {
					image = ImageIO.read(file);
				}catch(IOException e) {
					e.printStackTrace();
				}
				tiles[row][col] = new Tile(256, image, row, col);
			}
		}
		//new Tile[row][col];
	}
	
	public void draw(Graphics g) {
		for (int r =0; r < 4; r++) {
			for (int c =0; c < 4; c++) {
				
				tiles[r][c].draw(g);
			}
		}
	}
	
}
