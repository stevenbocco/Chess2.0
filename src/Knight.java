import java.awt.Point;
import java.util.ArrayList;

public class Knight extends Piece {

	public Knight(ChessColor color, int x, int y) {
		super(color, x, y);


		this.pieceImage = color == ChessColor.WHITE ? TextureLoader.getKnightWhite() : TextureLoader.getKnightBlack();
	}

	

	@Override
	public void setValidMoves(Tile[][] gameboard) {
		
		this.validMoves.clear();
		
		//Upper
		knightMovement(gameboard, 1, 2);
		knightMovement(gameboard, -1, 2);
		
		//Lower
		knightMovement(gameboard, 1, -2);
		knightMovement(gameboard, -1, -2);
		
		//Right
		knightMovement(gameboard, 2, 1);
		knightMovement(gameboard, 2, -1);
		
		//Left
		knightMovement(gameboard, -2, 1);
		knightMovement(gameboard, -2, -1);
		
		checkMoveBounds();
		
	}
	
	private void knightMovement(Tile[][] gameboard, int x, int y) {
		try {
			if(gameboard[this.position.x + x][this.position.y + y].hasPiece()) {
				if(gameboard[this.position.x + x][this.position.y + y].getPiece().getColor() != getColor()) {
					this.validMoves.add(new Point(this.position.x + x, this.position.y + y));								
				}
			} else {
				this.validMoves.add(new Point(this.position.x + x, this.position.y + y));
			}
		} 
		catch (ArrayIndexOutOfBoundsException e) {}
		catch (NullPointerException e) {}
	}

}
