
public class King extends Piece {

	public King(ChessColor color, int x, int y) {
		super(color, x, y);


		this.pieceImage = color == ChessColor.WHITE ? TextureLoader.getKingWhite() : TextureLoader.getKingBlack();
	}

	

	@Override
	public void setValidMoves() {
		// TODO Auto-generated method stub
		
	}

}
