import java.awt.Component;
import java.awt.Graphics;
import java.awt.Point;
import java.awt.image.BufferedImage;

public class Tile extends Component {
	
	private Piece piece = null;
	private BufferedImage tileImage = null;
	private BufferedImage highlightedImage = null;
	private BufferedImage highlightedImageRed = null;
	private int x,y;
	private boolean isHighlighted;
	private boolean isHighlightedRed;
	
	public Tile(Boolean isWhite, int x, int y) {
		super();
		this.tileImage = isWhite ? TextureLoader.getLightTile() : TextureLoader.getDarkTile();
		this.highlightedImage = TextureLoader.getHighlightTile();
		this.highlightedImageRed = TextureLoader.getHighlightTileRed();
		this.x = x;
		this.y = y;
		this.isHighlighted = false;
		this.isHighlightedRed = false;
	}
	
	@Override
	public void paint(Graphics g) {
		g.drawImage(tileImage, x, y, null);
		
		if(isHighlightedRed)
			g.drawImage(highlightedImageRed, x, y, null);
		
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
	
	public void toggleHighlighted() {
		this.isHighlighted = !this.isHighlighted;
	}
	
	public void toggleHighlightedRed() {
		this.isHighlightedRed = !this.isHighlightedRed;
	}
}
