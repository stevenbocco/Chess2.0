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
	
	protected void checkMoveBounds() {
		ArrayList<Point> temp = new ArrayList<Point>();
		
		for(Point p : validMoves) {
			if(p.x <= 7 && p.x >= 0 && p.y <= 7 && p.y >= 0) {
				temp.add(p);
			}
		}
		this.validMoves = temp;
	}
	
	protected void DiagonalMovement(Tile[][] gameboard, int x, int y, int maxMoves) {
		for(int i = 1; i <= maxMoves; i++) {
			try {
				if(gameboard[position.x + (i * x)][position.y + (i * y)].hasPiece())
					if(gameboard[position.x + (i * x)][position.y + (i * y)].getPiece().getColor() != this.color) {
						validMoves.add(new Point(position.x + (i * x), position.y + (i * y)));
						break;
					} else { break; }
				
				validMoves.add(new Point(position.x + (i * x), position.y + (i * y)));
				
			} catch (ArrayIndexOutOfBoundsException e) {}
		}
	}
	
	public abstract void setValidMoves(Tile[][] gameboard);
	
}
