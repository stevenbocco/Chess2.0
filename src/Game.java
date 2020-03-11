import javax.swing.JFrame;

public class Game extends JFrame {
	
	private final int WINDOW_WIDTH = 800;
	private final int WINDOW_HEIGHT = 800;
	
	private GameBoard gameboard;
	
	
	public Game() {
		super("Chess Game");
		TextureLoader.loadTextures();
		
		
		gameboard = new GameBoard(WINDOW_WIDTH, WINDOW_HEIGHT);
		
		this.add(gameboard);
		this.setLayout(null);
		this.setSize(WINDOW_WIDTH, WINDOW_HEIGHT);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setVisible(true);
		
		gameboard.repaint();
	}
}
