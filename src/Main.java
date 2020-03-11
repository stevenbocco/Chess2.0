import java.awt.Canvas;
import java.awt.Color;
import java.awt.Component;
import java.awt.Graphics;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JFrame;

public class Main extends JFrame {

	
	private GameBoard gameboard;
	

	public Main() {
		super("Chess Game");
		
		gameboard = new GameBoard();
		
		this.add(gameboard);
		this.setLayout(null);
		this.setSize(1280, 900);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setVisible(true);
		gameboard.repaint();
	}
	
	
	public static void main(String[] args) {
		new Main();
	}

}


class GameBoard extends Canvas implements MouseListener{
	
	ChessPiece King;
	
	public GameBoard() {
		this.addMouseListener(this);
		setBackground (Color.BLACK);  
        setSize(1280, 900);
        King = new ChessPiece();
	}
	
	@Override
	public void paint(Graphics g) {
		System.out.println("paint function");
		King.paint(g);
	}
	
	@Override
	public void update(Graphics g) {
		System.out.println("update function");
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		int xPos = e.getX();
		int yPos = e.getY();
		
		if(xPos >= 10 && xPos <= 10 + 100) {
			System.out.println("Inside box");
		} else {
			System.out.println("Outside box");
		}
	}

	@Override
	public void mouseEntered(MouseEvent e) {}

	@Override
	public void mouseExited(MouseEvent e) {}

	@Override
	public void mousePressed(MouseEvent e) {}

	@Override
	public void mouseReleased(MouseEvent e) {}
}


class ChessPiece extends Component {
	BufferedImage img = null;
	BufferedImage img2 = null;
	
	public ChessPiece () {
		super();

		try {
		    img = ImageIO.read(new File("resources/meta.JPG")); 
		    img2 = ImageIO.read(new File("resources/peice.png")); 
		} catch (IOException e) {
		    e.printStackTrace();
		}
	}
	
	@Override
	public void paint(Graphics g) {
		System.out.println("Rendering king");
		
		
		g.drawImage(img, 0, 0, null);
		g.drawImage(img2, 20, 20, null);
	}
}
