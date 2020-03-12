import java.awt.Component;
import java.awt.Graphics;
import java.awt.Point;
import java.awt.image.BufferedImage;
import java.util.ArrayList;

public abstract class Piece extends Component {
	
	protected BufferedImage pieceImage = null;
	protected ArrayList<Point> validMoves;
	protected Point position;
	private ChessColor color;
	
	public Piece (ChessColor color, int x, int y) {
		super();
		this.position = new Point(x, y);
		this.color = color;
		this.validMoves = new ArrayList<Point>();
	}

	@Override
	public void paint(Graphics g) {
		g.drawImage(pieceImage, this.position.x * 100, this.position.y * 100, null);
	}
	
	public ChessColor getColor() {
		return this.color;
	}
	
	public void updatePosition(int x, int y) {
		this.position.x = x;
		this.position.y = y;
	}
	
	public ArrayList<Point> getValidMoves(){
		return validMoves;
	}
	
	public abstract void setValidMoves();
	
}
