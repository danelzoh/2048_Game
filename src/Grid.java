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


		int tempRow2 = (int) (tiles.length * Math.random());
		int tempCol2 = (int) (tiles[0].length * Math.random());
		
		while (tempRow == tempRow2) {
			tempRow2 = (int) (tiles.length * Math.random());
		}
		while (tempCol == tempCol2) {
			tempRow2 = (int) (tiles[0].length * Math.random());
		}
		


		tiles[tempRow][tempCol].setValue(2);
		tiles[tempRow2][tempCol2].setValue(2);
		
		
		//tiles[tempRow2][tempCol2].setValue(2);


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
	
	/* depending on which direction the tiles are supposed to move,
	*  we will need to loop through the array differently.
	*/
	public void moveUp(){
		for(int r = 1; r<= 3; r++){
			for(int c=0; c<=3; c++){
				tiles[r][c].shiftUp();
			}
		}
	}

	public void moveDown(){
		for(int r = 0; r<= 2; r++){
			for(int c=0; c<=3; c++){
				tiles[r][c].shiftDown();
			}
		}
	}

	public void moveLeft(){
		for(int r = 0; r<= 3; r++){
			for(int c=1; c<=3; c++){
				tiles[r][c].shiftLeft();
			}
		}
	}

	public void moveRight(){
		for(int r = 0; r<= 3; r++){
			for(int c=0; c<=2; c++){
				tiles[r][c].shiftRight();
			}
		}
	}

}