import java.awt.Point;

public class Rook extends Piece {

	

	public Rook(ChessColor color, int x, int y) {
		super(color, x, y);
		
		this.pieceImage = color == ChessColor.WHITE ? TextureLoader.getRookWhite() : TextureLoader.getRookBlack();
	}

	

	@Override
	public void setValidMoves(Tile[][] gameboard) {
		this.validMoves.clear();
		
		setMovement(gameboard, 0, 1, 7);
		setMovement(gameboard, 0, -1, 7);
		setMovement(gameboard, 1, 0, 7);
		setMovement(gameboard, -1, 0, 7);
		
		checkMoveBounds();
	}
}
