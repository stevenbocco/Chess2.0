
public class Rook extends Piece {

	

	public Rook(ChessColor color, int x, int y) {
		super(color, x, y);
		
		this.pieceImage = color == ChessColor.WHITE ? TextureLoader.getRookWhite() : TextureLoader.getRookBlack();
	}

	@Override
	public void movement() {
		// TODO Auto-generated method stub

	}

}
