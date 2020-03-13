import java.awt.Point;
import java.util.ArrayList;

public class Queen extends Piece {

	public Queen(ChessColor color, int x, int y) {
		super(color, x, y);


		this.pieceImage = color == ChessColor.WHITE ? TextureLoader.getQueenWhite() : TextureLoader.getQueenBlack();
	}

	

	@Override
	public void setValidMoves() {
		this.validMoves.clear();
		
		for(int i = 1; i < 8; i++) { //All Diagonal movement
			this.validMoves.add(new Point(this.position.x -i, this.position.y -i));
			this.validMoves.add(new Point(this.position.x +i, this.position.y -i));
			this.validMoves.add(new Point(this.position.x -i, this.position.y +i));
			this.validMoves.add(new Point(this.position.x +i, this.position.y +i));
		}
		
		for(int i = 0; i < 8; i++) { // All Horizontal and Vertical movement
			if(i != this.position.x) {
				this.validMoves.add(new Point(i, this.position.y));
			}
			if(i != this.position.y) {
				this.validMoves.add(new Point(this.position.x, i));
			}
		}
	
		checkMoveBounds();
	}
}
