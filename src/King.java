import java.awt.Point;
import java.util.ArrayList;

public class King extends Piece {

	public King(ChessColor color, int x, int y) {
		super(color, x, y);


		this.pieceImage = color == ChessColor.WHITE ? TextureLoader.getKingWhite() : TextureLoader.getKingBlack();
	}

	

	@Override
	public void setValidMoves(Tile[][] gameboard) {
		this.validMoves.clear();
		
		//Horizontal and Vertical
		DiagonalMovement(gameboard, 0, 1, 1);
		DiagonalMovement(gameboard, 0, -1, 1);
		DiagonalMovement(gameboard, 1, 0, 1);
		DiagonalMovement(gameboard, -1, 0, 1);
		
		//Diagonal
		DiagonalMovement(gameboard, -1, -1, 1);
		DiagonalMovement(gameboard, 1, -1, 1);
		DiagonalMovement(gameboard, -1, 1, 1);
		DiagonalMovement(gameboard, 1, 1, 1);
		
		checkMoveBounds();
	}

}
