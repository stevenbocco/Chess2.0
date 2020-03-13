import java.awt.Point;
import java.util.ArrayList;

public class King extends Piece {

	public King(ChessColor color, int x, int y) {
		super(color, x, y);


		this.pieceImage = color == ChessColor.WHITE ? TextureLoader.getKingWhite() : TextureLoader.getKingBlack();
	}

	

	@Override
	public void setValidMoves() {
		this.validMoves.clear();
		
		//Up
		this.validMoves.add(new Point(this.position.x, this.position.y + 1));
		
		//UpRight
		this.validMoves.add(new Point(this.position.x + 1, this.position.y + 1));
		
		//Right
		this.validMoves.add(new Point(this.position.x + 1, this.position.y));
		
		//DownRight
		this.validMoves.add(new Point(this.position.x + 1, this.position.y - 1));
		
		//Down
		this.validMoves.add(new Point(this.position.x, this.position.y - 1));
		
		//DownLeft
		this.validMoves.add(new Point(this.position.x - 1, this.position.y - 1));
		
		//Left
		this.validMoves.add(new Point(this.position.x - 1, this.position.y));
		
		//UpLeft
		this.validMoves.add(new Point(this.position.x - 1, this.position.y + 1));
		
		ArrayList<Point> temp = new ArrayList<Point>();
		
		for(Point p : validMoves) {
			if(p.x <= 7 && p.x >= 0 && p.y <= 7 && p.y >= 0) {
				temp.add(p);
			}
		}
		this.validMoves = temp;
	}

}
