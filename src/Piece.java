import java.awt.Component;
import java.awt.Graphics;
import java.awt.image.BufferedImage;

public abstract class Piece extends Component {
	
	protected BufferedImage pieceImage = null;
	private ChessColor color;
	private int x,y;
	
	
	public Piece (ChessColor color, int x, int y) {
		super();
		this.x = x;
		this.y = y;
		this.color = color;
	}

	@Override
	public void paint(Graphics g) {
		g.drawImage(pieceImage, x, y, null);
	}
	
	public abstract void movement();
	
}
