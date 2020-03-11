
public class Knight extends Piece {

	public Knight(ChessColor color, int x, int y) {
		super(color, x, y);


		this.pieceImage = color == ChessColor.WHITE ? TextureLoader.getKnightWhite() : TextureLoader.getKnightBlack();
	}

	@Override
	public void movement() {
		// TODO Auto-generated method stub

	}

}
