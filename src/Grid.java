import java.awt.Graphics;
public class Grid {
	private Tile[][] tiles;
	
	public Grid() {
		//tiles = new Tile[row][col];
	}
	
	public void draw(Graphics g) {
		for (int r =0; r < 4; r++) {
			for (int c =0; c < 4; c++) {
				
				tiles[r][c].draw(g);
			}
		}
	}
	
}
