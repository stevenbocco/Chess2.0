import java.awt.Canvas;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class GameBoard extends Canvas implements MouseListener {
	
	private Tile[][] board;
	private Game game;
	
	public GameBoard(int CANVAS_WIDTH, int CANVAS_HEIGHT, Game game) {
		setBackground (Color.BLACK);  
		setPreferredSize(new Dimension(CANVAS_WIDTH, CANVAS_HEIGHT));
		
		this.game = game;
        this.addMouseListener(this);
        this.board = new Tile[8][8];
        
        initializeBoard();
	}
	
	@Override
	public void paint(Graphics g) {
		System.out.println("paint function");
		for(int i = 0; i < 8; i++) {
			for(int j = 0; j < 8; j++) {
				board[i][j].paint(g);
			}
		}
	}
	
	@Override
	public void update(Graphics g) {
		super.update(g);
		System.out.println("update function");	
	}
	
	@Override
	public void mouseClicked(MouseEvent e) {
		int xPos = e.getX();
		int yPos = e.getY();
		
		Tile tile = findTile(xPos, yPos);
		game.handleClick(tile);
	}

	@Override
	public void mouseEntered(MouseEvent e) {}

	@Override
	public void mouseExited(MouseEvent e) {}

	@Override
	public void mousePressed(MouseEvent e) {}

	@Override
	public void mouseReleased(MouseEvent e) {}
	
	private void initializeBoard() {
		for(int i = 0; i < 8; i++) {
			for(int j = 0; j < 8; j++) {
				int x = i * 100;
				int y = j * 100;
				
				board[i][j] = new Tile(isWhite(i,j), x, y);
			}
		}
	}
	
	private boolean isWhite(int i, int j) {
		if((i + j) % 2 == 0) {
			return true;
		}
		return false;
	}
	
	private Tile findTile(int xPos, int yPos) {
		int i = (xPos/100);
		int j = (yPos/100);
		
		return board[i][j];
	}
	
	public Tile getTile(int i, int j) {
		return board[i][j];
	}
}
