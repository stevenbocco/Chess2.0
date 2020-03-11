
public class Pawn extends Piece {

	public Pawn(ChessColor color, int x, int y) {
		super(color, x, y);


		this.pieceImage = color == ChessColor.WHITE ? TextureLoader.getPawnWhite() : TextureLoader.getPawnBlack();
		
	}

	@Override
	public void movement() {
		// TODO Auto-generated method stub

	}

}
