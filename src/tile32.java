import java.awt.Image;

import javax.imageio.ImageIO;

public class tile32 extends Tile{
	static Image tile32Image;

	public tile32(int v, Image i, int r, int c) {
		super(32, getImage(), r, c);
		// TODO Auto-generated constructor stub
	}

	private static Image getImage() {
		if(tile32Image == null) {
		//	tile32Image = ImageIO.read(tile32Image);
		}
		// TODO Auto-generated method stub
		return tile32Image;
	}

}
