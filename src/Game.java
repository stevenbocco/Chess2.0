import java.awt.Point;
import java.util.ArrayList;

import javax.swing.JFrame;

public class Game extends JFrame {
	
	private final int WINDOW_WIDTH = 800;
	private final int WINDOW_HEIGHT = 800;
	
	private GameBoard gameboard;
	private ArrayList<Piece> whitePieces;
	private ArrayList<Piece> blackPieces;
	
	private Tile selectedTile = null;
	private Tile targetTile = null;
	
	private ChessColor currentPlayer = ChessColor.WHITE;
	
	public Game() {
		super("Chess Game");
		TextureLoader.loadTextures();
		whitePieces = new ArrayList<Piece>(16);
		blackPieces = new ArrayList<Piece>(16);
		
		gameboard = new GameBoard(WINDOW_WIDTH, WINDOW_HEIGHT, this);
		this.getContentPane().add(gameboard);
		initializePieces();
		
		this.pack();
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setVisible(true);
	}
	
	public void handleClick(Tile tile) {
		if(this.selectedTile == null && tile.hasPiece()) {
			if(validTile(tile)) {
				this.selectedTile = tile;
				this.selectedTile.getPiece().setValidMoves(gameboard.getBoard());
				System.out.println(this.selectedTile.getPiece().getValidMoves());
				
				System.out.println("you selected " + this.selectedTile.getTileCode());				
			}
			else { System.out.println("you selected an invalid tile"); }
		} 
		else if(this.selectedTile != null && tile.equals(selectedTile)) {
			this.selectedTile = null;
			System.out.println("you unselected the tile");
		}
		else if(this.selectedTile != null && !tile.equals(selectedTile)) {
			this.targetTile = tile;
			
			if(isValidMove(this.selectedTile.getPiece().getValidMoves(), this.targetTile.getBoardPosition())) {
				if(hasEnemyPiece()) {
					Piece targetPiece = this.targetTile.removePieceFromTile();
					removePieceFromBoard(targetPiece);
				}
				
				movePiece();
				
				gameboard.repaint();
				currentPlayer = currentPlayer == ChessColor.WHITE ? ChessColor.BLACK : ChessColor.WHITE;				
			} 
			else { System.out.println("INVALID MOVE TRY AGAIN!"); }
		}
	}
	
	private boolean validTile(Tile tile) {
		return currentPlayer == tile.getPiece().getColor() ? true : false;
	}
	
	private void movePiece() {
		Piece piece = this.selectedTile.removePieceFromTile();
		piece.updatePosition(this.targetTile.getPosition().x / 100, this.targetTile.getPosition().y / 100);
		
		this.targetTile.addPieceToTile(piece);
		this.selectedTile = null;
		this.targetTile = null;
	}
	
	private void removePieceFromBoard(Piece piece) {
		if(currentPlayer == ChessColor.WHITE) {
			blackPieces.remove(piece);
		} 
		else{
			whitePieces.remove(piece);
		}
	}
	
	private boolean isValidMove(ArrayList<Point> validMoves, Point targetPos) {
		for(int i = 0; i < validMoves.size(); i++) {
			if(validMoves.get(i).equals(targetPos)) {
				return true;
			}
		}
		return false;
	}
	
	private boolean hasEnemyPiece() {
		if(this.targetTile.hasPiece())
			if(this.targetTile.getPiece().getColor() != currentPlayer) 
				return true;				
		return false;
	}
	
	//Fixa till en finare funktion för att lägga till pieces
	private void initializePieces() {
		//Rooks
		Piece bRook = new Rook(ChessColor.BLACK, 0, 0);
		Piece bRook2 = new Rook(ChessColor.BLACK, 7, 0);
		Piece wRook = new Rook(ChessColor.WHITE, 0, 7);
		Piece wRook2 = new Rook(ChessColor.WHITE, 7, 7);
		blackPieces.add(bRook);
		blackPieces.add(bRook2);
		whitePieces.add(wRook);
		whitePieces.add(wRook2);
		gameboard.getTile(0, 0).addPieceToTile(bRook);
		gameboard.getTile(7, 0).addPieceToTile(bRook2);
		gameboard.getTile(0, 7).addPieceToTile(wRook);
		gameboard.getTile(7, 7).addPieceToTile(wRook2);
		
		//Knights
		Piece bKnight = new Knight(ChessColor.BLACK, 1, 0);
		Piece bKnight2 = new Knight(ChessColor.BLACK, 6, 0);
		Piece wKnight = new Knight(ChessColor.WHITE, 1, 7);
		Piece wKnight2 = new Knight(ChessColor.WHITE, 6, 7);
		blackPieces.add(bKnight);
		blackPieces.add(bKnight2);
		whitePieces.add(wKnight);
		whitePieces.add(wKnight2);
		gameboard.getTile(1, 0).addPieceToTile(bKnight);
		gameboard.getTile(6, 0).addPieceToTile(bKnight2);
		gameboard.getTile(1, 7).addPieceToTile(wKnight);
		gameboard.getTile(6, 7).addPieceToTile(wKnight2);
		
		//Bishops
		Piece bBishop = new Bishop(ChessColor.BLACK, 2, 0);
		Piece bBishop2 = new Bishop(ChessColor.BLACK, 5, 0);
		Piece wBishop = new Bishop(ChessColor.WHITE, 2, 7);
		Piece wBishop2 = new Bishop(ChessColor.WHITE, 5, 7);
		blackPieces.add(bBishop);
		blackPieces.add(bBishop2);
		whitePieces.add(wBishop);
		whitePieces.add(wBishop2);
		gameboard.getTile(2, 0).addPieceToTile(bBishop);
		gameboard.getTile(5, 0).addPieceToTile(bBishop2);
		gameboard.getTile(2, 7).addPieceToTile(wBishop);
		gameboard.getTile(5, 7).addPieceToTile(wBishop2);
		
		//Queens
		Piece bQueen = new Queen(ChessColor.BLACK, 3, 0);
		Piece wQueen = new Queen(ChessColor.WHITE, 3, 7);
		blackPieces.add(bQueen);
		whitePieces.add(wQueen);
		gameboard.getTile(3, 0).addPieceToTile(bQueen);
		gameboard.getTile(3, 7).addPieceToTile(wQueen);
		
		//Kings
		Piece bKing = new King(ChessColor.BLACK, 4, 0);
		Piece wKing = new King(ChessColor.WHITE, 4, 7);
		blackPieces.add(bKing);
		whitePieces.add(wKing);
		gameboard.getTile(4, 0).addPieceToTile(bKing);
		gameboard.getTile(4, 7).addPieceToTile(wKing);
		
		for(int i = 0; i < 8; i++) { // Create all black pawns
			Piece piece = new Pawn(ChessColor.BLACK, i, 1);
			Piece piece2 = new Pawn(ChessColor.WHITE, i, 6);
			blackPieces.add(piece);
			whitePieces.add(piece2);
			gameboard.getTile(i, 1).addPieceToTile(piece);
			gameboard.getTile(i, 6).addPieceToTile(piece2);
		}
	}
}
