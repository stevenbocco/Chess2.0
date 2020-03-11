
public class Bishop extends Piece {

	public Bishop(ChessColor color, int x, int y) {
		super(color, x, y);


		this.pieceImage = color == ChessColor.WHITE ? TextureLoader.getBishopWhite() : TextureLoader.getBishopBlack();
	}

	@Override
	public void movement() {
		// TODO Auto-generated method stub

	}

}
