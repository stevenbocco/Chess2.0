import java.awt.BasicStroke;
import java.awt.Canvas;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
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
		for(int i = 0; i < 8; i++) {
			for(int j = 0; j < 8; j++) {
				board[i][j].paint(g);
			}
		}
		
		if(game.isGameOver()) 
			drawGameOver(g);		
	}
	
	@Override
	public void update(Graphics g) {
		super.update(g);	
	}
	
	public Tile[][] getBoard(){
		return this.board;
	}
	
	public Tile getTile(int i, int j) {
		return board[i][j];
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
	
	private void drawGameOver(Graphics g) {
		ChessColor winner = game.getWinner();
		
		g.setFont(new Font("Arial", Font.BOLD, 100));
		g.setColor(new Color(255, 255, 255));
		g.drawString("CHECKMATE", 85, 425);	
		
		g.setFont(new Font("Arial", Font.BOLD, 75));
		g.drawString(winner.toString() + " WINS!", 150, 500);
		
	}
}
