import java.awt.Component;
import java.awt.Graphics;
import java.awt.Point;
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
	
	public void addPieceToTile(Piece piece) {
		if(this.piece == null) {
			this.piece = piece;			
		}
	}
	
	public Piece removePieceFromTile() {
		Piece piece = this.piece;
		this.piece = null;
		return piece;
	}
	
	public boolean hasPiece() {
		return piece != null ? true : false; 
	}
	
	public Piece getPiece() throws NullPointerException{
		return this.piece;
	}
	
	public Point getPosition() {
		return new Point(x, y);
	}
}
