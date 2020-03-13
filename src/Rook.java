import java.awt.Point;

public class Rook extends Piece {

	

	public Rook(ChessColor color, int x, int y) {
		super(color, x, y);
		
		this.pieceImage = color == ChessColor.WHITE ? TextureLoader.getRookWhite() : TextureLoader.getRookBlack();
	}

	

	@Override
	public void setValidMoves(Tile[][] gameboard) {
		this.validMoves.clear();
		
		for(int i = 0; i < 8; i++) {
			if(i != this.position.x) {
				this.validMoves.add(new Point(i, this.position.y));
			}
			if(i != this.position.y) {
				this.validMoves.add(new Point(this.position.x, i));
			}
		}
	}
}
