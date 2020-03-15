import java.awt.Point;
import java.util.ArrayList;

public class Bishop extends Piece {

	public Bishop(ChessColor color, int x, int y) {
		super(color, x, y);


		this.pieceImage = color == ChessColor.WHITE ? TextureLoader.getBishopWhite() : TextureLoader.getBishopBlack();
	}

	

	@Override
	public void setValidMoves(Tile[][] gameboard) {
		this.validMoves.clear();
		
		setMovement(gameboard, -1, -1, 7);
		setMovement(gameboard, 1, -1, 7);
		setMovement(gameboard, -1, 1, 7);
		setMovement(gameboard, 1, 1, 7);
		
		checkMoveBounds();
	}
}
