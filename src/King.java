
public class King extends Piece {

	public King(ChessColor color, int x, int y) {
		super(color, x, y);

		this.pieceImage = color == ChessColor.WHITE ? TextureLoader.getKingWhite() : TextureLoader.getKingBlack();
	}
		
	@Override
	public void setValidMoves(Tile[][] gameboard) {
		this.validMoves.clear();
		
		//Horizontal and Vertical
		setMovement(gameboard, 0, 1, 1);
		setMovement(gameboard, 0, -1, 1);
		setMovement(gameboard, 1, 0, 1);
		setMovement(gameboard, -1, 0, 1);
		
		//Diagonal
		setMovement(gameboard, -1, -1, 1);
		setMovement(gameboard, 1, -1, 1);
		setMovement(gameboard, -1, 1, 1);
		setMovement(gameboard, 1, 1, 1);
		
		checkMoveBounds();
	}

}
