import javax.swing.JFrame;

public class Game extends JFrame {
	
	private GameBoard gameboard;
	
	
	public Game() {
		super("Chess Game");
		
		gameboard = new GameBoard();
		
		this.add(gameboard);
		this.setLayout(null);
		this.setSize(1280, 900);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setVisible(true);
		
		gameboard.repaint();
	}
}
