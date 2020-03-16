import java.awt.Point;

public class Pawn extends Piece {

	private Point originalPos;
	
	public Pawn(ChessColor color, int x, int y) {
		super(color, x, y);
		this.originalPos = new Point(x,y);
		this.pieceImage = color == ChessColor.WHITE ? TextureLoader.getPawnWhite() : TextureLoader.getPawnBlack();
		
	}

	@Override
	public void setValidMoves(Tile[][] gameboard) {
		int checkedColor = checkColor();
		
		this.validMoves.clear();
		
		if(this.position.equals(this.originalPos)) {
			try {
				if(!gameboard[this.position.x][this.position.y + (2 * checkedColor)].hasPiece())
					this.validMoves.add(new Point(this.position.x, this.position.y + (2 * checkedColor)));
			} catch (ArrayIndexOutOfBoundsException e) {}
		}
		
		try {
			if(!gameboard[this.position.x][this.position.y + (1 * checkedColor)].hasPiece())
				this.validMoves.add(new Point(this.position.x, this.position.y + (1 * checkedColor)));	
		} catch (ArrayIndexOutOfBoundsException e) {}
		
		if(this.position.x - 1 >= 0) //Checking if the diagonal tile has a piece and if that piece is the opposite color
			if(gameboard[position.x -1][position.y + (1 * checkedColor)].hasPiece()) 
				if(gameboard[position.x -1][position.y + (1 * checkedColor)].getPiece().getColor() != getColor())
					this.validMoves.add(new Point(this.position.x -1, this.position.y + (1 * checkedColor)));				
		
		if(this.position.x + 1 <= 7) //Checking if the diagonal tile has a piece and if that piece is the opposite color
			if(gameboard[position.x + 1][position.y + (1 * checkedColor)].hasPiece()) 
				if(gameboard[position.x + 1][position.y + (1 * checkedColor)].getPiece().getColor() != getColor())
					this.validMoves.add(new Point(this.position.x + 1, this.position.y + (1 * checkedColor)));
	}
	
	private int checkColor() {
		return this.getColor() == ChessColor.WHITE ? -1 : 1;
	}
}
