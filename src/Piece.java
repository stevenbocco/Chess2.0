import java.awt.Component;
import java.awt.Graphics;
import java.awt.image.BufferedImage;

public class Piece extends Component {
	BufferedImage darkTile = null;
	BufferedImage LightTile = null;
	
	public Piece () {
		super();

		darkTile = TextureLoader.getDarkTile();
		LightTile = TextureLoader.getLightTile();
	}
	
	@Override
	public void paint(Graphics g) {
		
	}
}
