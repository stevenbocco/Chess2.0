import java.util.ArrayList;

import javax.swing.JFrame;

public class Game extends JFrame {
	
	private final int WINDOW_WIDTH = 800;
	private final int WINDOW_HEIGHT = 800;
	
	private GameBoard gameboard;
	private ArrayList<Piece> whitePieces;
	private ArrayList<Piece> blackPieces;
	
	
	public Game() {
		super("Chess Game");
		TextureLoader.loadTextures();
		whitePieces = new ArrayList<Piece>(16);
		blackPieces = new ArrayList<Piece>(16);
		
		gameboard = new GameBoard(WINDOW_WIDTH, WINDOW_HEIGHT);
		this.getContentPane().add(gameboard);
		initializePieces();
		
		this.pack();
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setVisible(true);
	}
	
	private void initializePieces() {
		for(int i = 0; i < 8; i++) { // Create all black pawns
			Piece piece = new Pawn(ChessColor.BLACK, i, 1);
			blackPieces.add(piece);
			gameboard.getTile(i, 1).addPieceToTile(piece);
		}
		
		for(int i = 0; i < 8; i++) { //Create all white pawns
			Piece piece = new Pawn(ChessColor.WHITE, i, 6);
			whitePieces.add(piece);
			gameboard.getTile(i, 6).addPieceToTile(piece);
		}
	}
}
