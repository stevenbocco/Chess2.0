import java.awt.Component;
import java.awt.Graphics;
import java.awt.image.BufferedImage;

public class ChessPiece extends Component {
	BufferedImage darkTile = null;
	BufferedImage LightTile = null;
	
	public ChessPiece () {
		super();

		darkTile = TextureLoader.getDarkTile();
		LightTile = TextureLoader.getLightTile();
	}
	
	@Override
	public void paint(Graphics g) {
		System.out.println("Rendering king");
		
		g.drawImage(darkTile, 0, 0, null);
		g.drawImage(LightTile, 100, 0, null);
	}
}
