import java.awt.Graphics;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JPanel;
public class Grid {

	private Tile[][] tiles = new Tile[4][4];

	public Grid() {
		for (int row = 0; row < tiles.length; row++) {
			for (int col = 0; col < tiles[0].length; col++) {
				tiles[row][col] = new Tile(0, row, col);
			}
		}

		randTile();
		randTile();
	}

	public void draw(Graphics g) {
		for (int r = 0; r < 4; r++) {
			for (int c = 0; c < 4; c++) {

				tiles[r][c].draw(g);
			}
		}
	}


	public void randTile() {
		//boolean done = false;
		for(int i = 0; i<1000; i++) {
			int row = (int) (Math.random() * 4);
			int col = (int) (Math.random() * 4);
			if (tiles[row][col].getValue() == 0) {
				tiles[row][col] = new Tile(2, row, col);
				break;
			}
			//System.out.println("inside randTile");
		}
	}

	public void resetTiles() {
		for(Tile[] tr : tiles) {
			for(Tile t : tr) {
				t.hasAdded = false;
			}
		}
	}

	private int moves = 0;

	public boolean canTileMoveUp(int r, int c) {
		if (r != 0 && tiles[r][c].getValue() != 0 && !tiles[r][c].hasAdded) {
			if (tiles[r - 1][c].getValue() == 0 || tiles[r][c].getValue() == tiles[r - 1][c].getValue()) {
				return true;
			}
		}
		return false;
	}

	/* depending on which direction the tiles are supposed to move,
	 *  we will need to loop through the array differently.
	 */
	public void moveUp(GameRunner gr) {
		//DOES NOT MAKE A NEW TILE ON AN INVALID MOVE
		//makes a game over dialogue box even when the game is not over
		for (int r = 1; r <= 3; r++) { //up to down
			for (int c = 0; c <= 3; c++) { //left to right
				int count = 0;
				while (canTileMoveUp(r - count, c)) {
					//tiles[r][c].shiftUp();
					Tile temp = new Tile(tiles[r - count][c].getValue() + tiles[r - 1 - count][c].getValue(), r - 1 - count, c); //adds current tile with tile above
					gr.getPoints().add(temp.getValue());
					if(tiles[r - 1 - count][c].getValue() != 0) {
						tiles[r - 1 - count][c].hasAdded = true;
					}
					tiles[r - 1 - count][c] = temp;
					tiles[r - count][c] = new Tile(0, r - count, c);
					System.out.println(r + " " + c);
					count++;
					moves++;
				}
			}
		}
		if (moves > 0){
			randTile();
		}
		moves = 0;
		if (youLost(tiles)) {
			System.out.println("game over");
			gr.gameOver();
		}
	}

	public boolean canTileMoveDown(int r, int c) {
		if (r != 3 && tiles[r][c].getValue() != 0 && !tiles[r][c].hasAdded) {
			if (tiles[r + 1][c].getValue() == 0 || tiles[r][c].getValue() == tiles[r + 1][c].getValue()) {
				return true;
			}
		}
		return false;
	}

	public void moveDown(GameRunner gr) {
		//makes a new tile even if an invalid move is made
		for (int r = 3; r >= 0; r--) { //down to up
			for (int c = 0; c <= 3; c++) { //left to right
				int count = 0;
				System.out.println(r - count + ", " + c);
				while (canTileMoveDown(r + count, c)) {
					//tiles[r][c].shiftUp();
					Tile temp = new Tile(tiles[r + count][c].getValue() + tiles[r + 1 + count][c].getValue(), r + 1 + count, c); //adds current tile with tile above
					gr.getPoints().add(temp.getValue());
					if(tiles[r + 1 + count][c].getValue() != 0) {
						tiles[r + 1 + count][c].hasAdded = true;
					}
					tiles[r + 1 + count][c] = temp;
					tiles[r + count][c] = new Tile(0, r + count, c);
					count++;
					moves++;
				}
			}
		}
		if (moves > 0){
			randTile();
		}
		moves = 0;
		if (youLost(tiles)) {
			System.out.println("game over");
			gr.gameOver();
		}
	}

	public boolean canTileMoveLeft(int r, int c) {
		if (c != 0 && tiles[r][c].getValue() != 0 && !tiles[r][c].hasAdded) {
			if (tiles[r][c - 1].getValue() == 0 || tiles[r][c].getValue() == tiles[r][c - 1].getValue()) {
				return true;
			}
		}
		return false;
	}

	public void moveLeft(GameRunner gr) {
		//makes a new tile even if an invalid move is made
		for (int r = 0; r <= 3; r++) { //top to bottom
			for (int c = 1; c <= 3; c++) { //left to right
				int count = 0;
				while (canTileMoveLeft(r, c - count)) {
					Tile temp = new Tile(tiles[r][c - count].getValue() + tiles[r][c - 1 - count].getValue(), r, c - 1 - count); //adds current tile with tile above
					gr.getPoints().add(temp.getValue());
					if(tiles[r][c - 1 - count].getValue() != 0) {
						tiles[r][c - 1 - count].hasAdded = true;
					}
					tiles[r][c - 1 - count] = temp;
					tiles[r][c - count] = new Tile(0, r, c - count);
					System.out.println(r + " " + c);
					count++;
					moves++;
				}
			}
		}
		if (moves > 0){
			randTile();
		}
		moves = 0;
		if (youLost(tiles)) {
			System.out.println("game over");
			gr.gameOver();
		}
	}

	public boolean canTileMoveRight(int r, int c) {
		if (c != 3 && tiles[r][c].getValue() != 0 && !tiles[r][c].hasAdded) {
			if (tiles[r][c + 1].getValue() == 0 || tiles[r][c].getValue() == tiles[r][c + 1].getValue()) {
				System.out.println("can move right");
				return true;
			}
		}
		return false;
	}

	public void moveRight(GameRunner gr) {
		//makes a new tile even if an invalid move is made
		for (int r = 0; r <= 3; r++) { //top to bottom
			for (int c = 2; c >= 0; c--) { //left to right
				int count = 0;
				System.out.println(r + (c + count));
				while (canTileMoveRight(r, c + count)) {
					Tile temp = new Tile(tiles[r][c + count].getValue() + tiles[r][c + 1 + count].getValue(), r, c + 1 + count); //adds current tile with tile above
					gr.getPoints().add(temp.getValue());
					if(tiles[r][c + 1 + count].getValue() != 0) {
						tiles[r][c + 1 + count].hasAdded = true;
					}
					tiles[r][c + 1 + count] = temp;
					tiles[r][c + count] = new Tile(0, r, c + count);
					count++;
					moves++;
				}
			}
		}
		if (moves > 0){
			randTile();
		}
		moves = 0;
		if (youLost(tiles)) {
			System.out.println("game over");
			gr.gameOver();
		}
	}

	public boolean youLost(Tile[][] tiles) {
		for(int r = 0; r<4; r++) {
			for(int c = 0; c<4; c++) {

				if(r == 0) { 			//top row of tiles
					if(tiles[r+1][c].getValue() == 0 && tiles[r+1][c].getValue()==tiles[r][c].getValue()) {
						return false;
					}
				}
				if(c == 0) {			//left row of tiles
					if(tiles[r][c+1].getValue() == 0 && tiles[r][c+1].getValue()==tiles[r][c].getValue()) {
						return false;
					}
				}
				if(c == 4) {			//left row of tiles
					return true;

				}
				if(r==4) {
					return true;
				}
				if(canTileMoveUp(r,c)) {
					return false;
				}
				if(canTileMoveRight(r,c)) {
					return false;
				}
				if(canTileMoveDown(r,c)) {
					return false;
				}

				if(canTileMoveLeft(r,c)) {
					return false;
				}

			}
		}
		return true;

	}
}
