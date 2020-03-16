
public class Queen extends Piece {

	public Queen(ChessColor color, int x, int y) {
		super(color, x, y);

		this.pieceImage = color == ChessColor.WHITE ? TextureLoader.getQueenWhite() : TextureLoader.getQueenBlack();
	}

	@Override
	public void setValidMoves(Tile[][] gameboard) {
		this.validMoves.clear();
		
		//Horizontal and Vertical
		setMovement(gameboard, 0, 1, 7);
		setMovement(gameboard, 0, -1, 7);
		setMovement(gameboard, 1, 0, 7);
		setMovement(gameboard, -1, 0, 7);
		
		//Diagonal
		setMovement(gameboard, -1, -1, 7);
		setMovement(gameboard, 1, -1, 7);
		setMovement(gameboard, -1, 1, 7);
		setMovement(gameboard, 1, 1, 7);
	
		checkMoveBounds();
	}
}
