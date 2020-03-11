import java.awt.Component;
import java.awt.Graphics;
import java.awt.image.BufferedImage;

public class Tile extends Component {
	
	private Piece piece = null;
	private BufferedImage tileImage = null;
	private int x,y;
	
	public Tile(Boolean isWhite, int x, int y) {
		super();
		this.tileImage = isWhite ? TextureLoader.getLightTile() : TextureLoader.getDarkTile();
		this.x = x;
		this.y = y;
	}
	
	@Override
	public void paint(Graphics g) {
		g.drawImage(tileImage, x, y, null);
		if(piece != null) {
			piece.paint(g);
		}
	}
}
