
public class Queen extends Piece {

	public Queen(ChessColor color, int x, int y) {
		super(color, x, y);


		this.pieceImage = color == ChessColor.WHITE ? TextureLoader.getQueenWhite() : TextureLoader.getQueenBlack();
	}

	@Override
	public void movement() {
		// TODO Auto-generated method stub

	}

}
