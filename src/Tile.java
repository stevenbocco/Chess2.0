import java.awt.Component;
import java.awt.Graphics;
import java.awt.Point;
import java.awt.image.BufferedImage;

public class Tile extends Component {
	
	private Piece piece = null;
	private BufferedImage tileImage = null;
	private BufferedImage highlightedImage = null;
	private int x,y;
	private String tileCode;
	private boolean isHighlighted;
	
	public Tile(Boolean isWhite, int x, int y) {
		super();
		this.tileImage = isWhite ? TextureLoader.getLightTile() : TextureLoader.getDarkTile();
		this.highlightedImage = TextureLoader.getHighlightTile();
		this.x = x;
		this.y = y;
		this.tileCode = ChessTileCode.getChessTileCode(x/100, y/100);
		this.isHighlighted = false;
	}
	
	@Override
	public void paint(Graphics g) {
		g.drawImage(tileImage, x, y, null);
		
		if(isHighlighted)
			g.drawImage(highlightedImage, x, y, null);
		
		if(piece != null) 
			piece.paint(g);
	}
	
	public void addPieceToTile(Piece piece) {
		if(this.piece == null) {
			this.piece = piece;			
		}
	}
	
	public Piece movePieceFromTile() {
		Piece piece = this.piece;
		this.piece = null;
		return piece;
	}
	
	public void removePieceFromTile() {
		this.piece = null;
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
	
	public Point getBoardPosition() {
		return new Point(x/100, y/100);
	}
	
	public String getTileCode() {
		return this.tileCode;
	}
	
	public void toggleHighlighted() {
		this.isHighlighted = !this.isHighlighted;
	}
}
