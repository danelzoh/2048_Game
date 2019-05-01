import java.awt.Image;
import java.io.IOException;

import javax.imageio.ImageIO;

public class tile32 extends Tile{
	static Image tile32Image;

	public tile32(int v, Image i, int r, int c) {
		super(32, getImage(), r, c);
		// TODO Auto-generated constructor stub
	}

	private static Image getImage() {
		if(tile32Image == null) {
			try {
				tile32Image = ImageIO.read(Tile.class.getClass().getResource("/tile32Image"));
				
				System.out.println("tile32 test");
				
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		// TODO Auto-generated method stub
		return tile32Image;
	}

}
