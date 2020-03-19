import java.awt.Point;
import java.util.ArrayList;
import javax.swing.JFrame;

public class Game extends JFrame {
	
	private static Game gameInstance = null;
	
	private final int WINDOW_WIDTH = 800;
	private final int WINDOW_HEIGHT = 800;
	
	private GameBoard gameboard;
	private ArrayList<Piece> whitePieces;
	private ArrayList<Piece> blackPieces;
	
	private boolean gameOver;
	
	private Tile selectedTile = null;
	private Tile targetTile = null;
	
	private ChessColor currentPlayer = ChessColor.WHITE;
	
	//Make the constructor private so that the class can't be instantiated multiple times, Singleton class
	private Game() {
		super("Chess Game");
		TextureLoader.loadTextures();
		whitePieces = new ArrayList<Piece>(16);
		blackPieces = new ArrayList<Piece>(16);
		gameOver = false;
		
		gameboard = new GameBoard(WINDOW_WIDTH, WINDOW_HEIGHT, this);
		this.getContentPane().add(gameboard);
		initializePieces();
		
		this.setResizable(false);
		this.pack();
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setVisible(true);
	}
	
	//Returns a instance of Game and creates one if one doesn't exist
	public static Game getInstace() {
		if(gameInstance == null)
			gameInstance = new Game();
		
		return gameInstance;
	}
	
	//Handles all events that happens when you click on a piece and/or tile
	public void handleClick(Tile tile) {
		if(!gameOver) {
			if(this.selectedTile == null && tile.hasPiece()) {
				selectPiece(tile);
			} 
			else if(this.selectedTile != null && tile.equals(selectedTile)) {
				unselectPiece();
			}
			else if(this.selectedTile != null && !tile.equals(selectedTile)) {
				movePieceLogic(tile);
			}
		}
	}
	
	public boolean isGameOver() {
		return this.gameOver;
	}
	
	public ChessColor getWinner() {
		return currentPlayer == ChessColor.WHITE ? ChessColor.BLACK : ChessColor.WHITE;
	}
	
	private void selectPiece(Tile tile) {
		if(validTile(tile)) {
			this.selectedTile = tile;
			this.selectedTile.getPiece().setValidMoves(gameboard.getBoard());
			this.selectedTile.toggleHighlighted();
			toggleTiles(showValidMoves(this.selectedTile));
			
			gameboard.repaint();
			
			System.out.println("You selected " + this.selectedTile.getTileCode());				
		}
		else { System.out.println("You selected an invalid tile"); }
	}
	
	private void unselectPiece() {
		this.selectedTile.toggleHighlighted();
		toggleTiles(showValidMoves(this.selectedTile));
		this.selectedTile = null;
		gameboard.repaint();
		System.out.println("You unselected the tile");
	}
	
	private void movePieceLogic(Tile tile) {
		this.targetTile = tile;
		
		ArrayList<Point> validMoves = this.selectedTile.getPiece().getValidMoves();
		Point targetTilePos = this.targetTile.getBoardPosition();
		
		if(isValidMove(validMoves, targetTilePos) && validTheoreticalMove(this.selectedTile, this.targetTile)) {
			this.selectedTile.toggleHighlighted();
			toggleTiles(showValidMoves(this.selectedTile));
			
			if(hasEnemyPiece()) {
				Piece targetPiece = this.targetTile.movePieceFromTile();
				removePieceFromBoard(targetPiece);
			}
			
			movePiece();
			
			gameboard.repaint();
			currentPlayer = currentPlayer == ChessColor.WHITE ? ChessColor.BLACK : ChessColor.WHITE;	
			
			if(isInCheck(currentPlayer == ChessColor.WHITE ? blackPieces : whitePieces))
				if(isCheckMate()) {
					this.gameOver = true;
					gameboard.repaint();					
				}
				else 
					System.out.println("CHECK");
		} 
		else { System.out.println("INVALID MOVE TRY AGAIN!"); }
	}
	
	
	private boolean validTile(Tile tile) {
		return currentPlayer == tile.getPiece().getColor() ? true : false;
	}
	
	private boolean isInCheck(ArrayList<Piece> pieceList) {
		
		for(Piece p : pieceList) {
			p.setValidMoves(gameboard.getBoard());
			
			for(Point point : p.getValidMoves()) {
				if(gameboard.getBoard()[point.x][point.y].hasPiece()) {
					if(gameboard.getBoard()[point.x][point.y].getPiece().getClass().getName() == "King") {
						return true;
					}
				}
			}
		}
		return false;
	}
	
	//Checks if the move is valid before you move a piece, i.e. you can't move a piece so that your own king is in check.
	private boolean validTheoreticalMove(Tile originalTile, Tile targetTile) {
		
		ArrayList<Piece> temp = new ArrayList<Piece>();
		for(Piece p : currentPlayer == ChessColor.WHITE ? blackPieces : whitePieces) {
			temp.add(p);
		}
		
		Piece originalPiece = originalTile.movePieceFromTile();
		Piece origTargetPiece = null;
		
		if(targetTile.hasPiece()) {
			origTargetPiece = targetTile.movePieceFromTile();
			temp.remove(origTargetPiece);
		}
		
		originalPiece.updatePosition(targetTile.getPosition().x / 100, targetTile.getPosition().y / 100);
		targetTile.addPieceToTile(originalPiece);
		
		boolean inCheck = isInCheck(temp);
		
		originalPiece.updatePosition(originalTile.getPosition().x / 100, originalTile.getPosition().y / 100);
		targetTile.removePieceFromTile();
		originalTile.addPieceToTile(originalPiece);
		targetTile.addPieceToTile(origTargetPiece);
		
		return !inCheck;
	}
	
	//Checks if there is a valid move to get out of check, if there is not then it is checkmate.
	private boolean isCheckMate() {
		Tile[][] board = gameboard.getBoard();
		
		for(Piece p : currentPlayer == ChessColor.WHITE ? whitePieces : blackPieces) {
			
			Tile originalPieceTile = board[p.getPointPosition().x][p.getPointPosition().y]; 
			
			p.setValidMoves(board);
			
			for(Point pointMove : p.getValidMoves()) {
				Tile targetTile = board[pointMove.x][pointMove.y];
				if(validTheoreticalMove(originalPieceTile, targetTile))
					return false;
			}
		}
		return true;
	}
	
	
	private ArrayList<Point> showValidMoves(Tile selectedTile) {

        ArrayList<Point> validMoves = new ArrayList<Point>();
        
        Piece p = selectedTile.getPiece();
        
        for(Point point : p.getValidMoves()) {
            if(validTheoreticalMove(selectedTile, this.gameboard.getTile(point.x, point.y))) {
                validMoves.add(point);
            }
        }
        
        return validMoves;
    }
	
	private void toggleTiles(ArrayList<Point> points) {
		for(Point p : points) {
			gameboard.getTile(p.x, p.y).toggleHighlighted();
		}
	}
	
	
	private void movePiece() {
		Piece piece = this.selectedTile.movePieceFromTile();
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
	
	//Checks if the move you are trying to make is in the valid moves list of the piece
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
	
	private void addPieceToBoard(Piece piece) {
		ArrayList<Piece> pieceList = piece.getColor() == ChessColor.WHITE ? whitePieces : blackPieces;
		
		int xPos = piece.getPointPosition().x;
		int yPos = piece.getPointPosition().y;
		
		pieceList.add(piece);
		gameboard.getTile(xPos, yPos).addPieceToTile(piece);
	}
	
	private void initializePieces() {
		//Rooks
		Piece bRook = new Rook(ChessColor.BLACK, 0, 0);
		Piece bRook2 = new Rook(ChessColor.BLACK, 7, 0);
		Piece wRook = new Rook(ChessColor.WHITE, 0, 7);
		Piece wRook2 = new Rook(ChessColor.WHITE, 7, 7);
		
		addPieceToBoard(bRook);
		addPieceToBoard(bRook2);
		addPieceToBoard(wRook);
		addPieceToBoard(wRook2);
		
		//Knights
		Piece bKnight = new Knight(ChessColor.BLACK, 1, 0);
		Piece bKnight2 = new Knight(ChessColor.BLACK, 6, 0);
		Piece wKnight = new Knight(ChessColor.WHITE, 1, 7);
		Piece wKnight2 = new Knight(ChessColor.WHITE, 6, 7);
		
		addPieceToBoard(bKnight);
		addPieceToBoard(bKnight2);
		addPieceToBoard(wKnight);
		addPieceToBoard(wKnight2);
		
		//Bishops
		Piece bBishop = new Bishop(ChessColor.BLACK, 2, 0);
		Piece bBishop2 = new Bishop(ChessColor.BLACK, 5, 0);
		Piece wBishop = new Bishop(ChessColor.WHITE, 2, 7);
		Piece wBishop2 = new Bishop(ChessColor.WHITE, 5, 7);
		
		addPieceToBoard(bBishop);
		addPieceToBoard(bBishop2);
		addPieceToBoard(wBishop);
		addPieceToBoard(wBishop2);
		
		//Queens
		Piece bQueen = new Queen(ChessColor.BLACK, 3, 0);
		Piece wQueen = new Queen(ChessColor.WHITE, 3, 7);
		
		addPieceToBoard(bQueen);
		addPieceToBoard(wQueen);
		
		//Kings
		Piece bKing = new King(ChessColor.BLACK, 4, 0);
		Piece wKing = new King(ChessColor.WHITE, 4, 7);
		
		addPieceToBoard(bKing);
		addPieceToBoard(wKing);
		
		for(int i = 0; i < 8; i++) { // Create all black pawns
			Piece bPawn = new Pawn(ChessColor.BLACK, i, 1);
			Piece wPawn = new Pawn(ChessColor.WHITE, i, 6);
			
			addPieceToBoard(bPawn);
			addPieceToBoard(wPawn);
		}
	}
}
