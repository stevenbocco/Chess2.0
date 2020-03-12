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
		
		if(this.position.equals(this.originalPos)) {
			this.validMoves.add(new Point(this.position.x, this.position.y + (2 * checkedColor)));
		}
		if(this.position.x - 1 >= 0) {
			this.validMoves.add(new Point(this.position.x -1, this.position.y + (1 * checkedColor)));
		}
		if(this.position.x + 1 <= 7) {
			this.validMoves.add(new Point(this.position.x +1, this.position.y + (1 * checkedColor)));
		}
		this.validMoves.add(new Point(this.position.x, this.position.y + (1 * checkedColor)));
		
		/*
		for(int i = 0; i < this.validMoves.size(); i++) {
			System.out.println(this.validMoves.get(i).x + " <- x y -> " + this.validMoves.get(i).y);			
		}
		*/
		
	}
	
	private int checkColor() {
		return this.getColor() == ChessColor.WHITE ? -1 : 1;
	}
}
