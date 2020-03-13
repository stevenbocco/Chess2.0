import java.awt.Point;
import java.util.ArrayList;

public class Bishop extends Piece {

	public Bishop(ChessColor color, int x, int y) {
		super(color, x, y);


		this.pieceImage = color == ChessColor.WHITE ? TextureLoader.getBishopWhite() : TextureLoader.getBishopBlack();
	}

	

	@Override
	public void setValidMoves() {
		this.validMoves.clear();
		
		for(int i = 1; i < 8; i++) {
			this.validMoves.add(new Point(this.position.x -i, this.position.y -i));
			this.validMoves.add(new Point(this.position.x +i, this.position.y -i));
			this.validMoves.add(new Point(this.position.x -i, this.position.y +i));
			this.validMoves.add(new Point(this.position.x +i, this.position.y +i));
		}
		
		checkMoveBounds();
	}
}
