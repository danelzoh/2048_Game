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
				tiles[row][col] = new Tile(0, row, col);
			}
		}

		int tempRow = (int) (tiles.length * Math.random());
		int tempCol = (int) (tiles[0].length * Math.random());
		
		tiles[tempRow][tempCol].setValue(2);
		
		
//		tiles[(int) (tiles.length * Math.random())][(int) (tiles[0].length * Math.random())] 
//				
//				= new Tile (2, (int) (tiles.length * Math.random()), (int) (tiles[0].length * Math.random()));
	}
	
	public void draw(Graphics g) {
		for (int r =0; r < 4; r++) {
			for (int c =0; c < 4; c++) {
				
				tiles[r][c].draw(g);
			}
		}
	}
	
	public void randTile() {
		
	}
	
}