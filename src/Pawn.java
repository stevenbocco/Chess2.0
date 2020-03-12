import java.awt.Point;

public class Pawn extends Piece {

	private Point originalPos;
	
	public Pawn(ChessColor color, int x, int y) {
		super(color, x, y);
		this.originalPos = new Point(x,y);
		this.pieceImage = color == ChessColor.WHITE ? TextureLoader.getPawnWhite() : TextureLoader.getPawnBlack();
		
	}

	

	@Override
	public void setValidMoves() {
		int checkedColor = checkColor();
		
		if(this.position == this.originalPos) {
			this.validMoves.add(new Point(this.position.x, this.position.y + (2 * checkedColor)));
		}
		
	}
	
	private int checkColor() {
		return this.getColor() == ChessColor.WHITE ? -1 : 1;
	}
}
