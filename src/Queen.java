import java.awt.Point;
import java.util.ArrayList;

public class Queen extends Piece {

	public Queen(ChessColor color, int x, int y) {
		super(color, x, y);


		this.pieceImage = color == ChessColor.WHITE ? TextureLoader.getQueenWhite() : TextureLoader.getQueenBlack();
	}

	

	@Override
	public void setValidMoves(Tile[][] gameboard) {
		this.validMoves.clear();
		
		//Horizontal and Vertical
		DiagonalMovement(gameboard, 0, 1, 7);
		DiagonalMovement(gameboard, 0, -1, 7);
		DiagonalMovement(gameboard, 1, 0, 7);
		DiagonalMovement(gameboard, -1, 0, 7);
		
		//Diagonal
		DiagonalMovement(gameboard, -1, -1, 7);
		DiagonalMovement(gameboard, 1, -1, 7);
		DiagonalMovement(gameboard, -1, 1, 7);
		DiagonalMovement(gameboard, 1, 1, 7);
	
		checkMoveBounds();
	}
}
