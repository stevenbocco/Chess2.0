import java.awt.Point;
import java.util.ArrayList;

public class Knight extends Piece {

	public Knight(ChessColor color, int x, int y) {
		super(color, x, y);


		this.pieceImage = color == ChessColor.WHITE ? TextureLoader.getKnightWhite() : TextureLoader.getKnightBlack();
	}

	

	@Override
	public void setValidMoves() {
		
		this.validMoves.clear();
		
		//Upper
		this.validMoves.add(new Point(this.position.x + 1, this.position.y + 2));
		this.validMoves.add(new Point(this.position.x - 1, this.position.y + 2));
		
		//Lower
		this.validMoves.add(new Point(this.position.x + 1, this.position.y - 2));
		this.validMoves.add(new Point(this.position.x - 1, this.position.y - 2));
		
		//Right
		this.validMoves.add(new Point(this.position.x + 2, this.position.y + 1));
		this.validMoves.add(new Point(this.position.x + 2, this.position.y - 1));
		
		//Left
		this.validMoves.add(new Point(this.position.x - 2, this.position.y + 1));
		this.validMoves.add(new Point(this.position.x - 2, this.position.y - 1));
		
		ArrayList<Point> temp = new ArrayList<Point>();
		
		for(Point p : validMoves) {
			if(p.x <= 7 && p.x >= 0 && p.y <= 7 && p.y >= 0) {
				temp.add(p);
			}
		}
		this.validMoves = temp;
		
	}

}
