import java.awt.Canvas;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class GameBoard extends Canvas implements MouseListener{
	
	public GameBoard(int CANVAS_WIDTH, int CANVAS_HEIGHT) {
		this.addMouseListener(this);
		setBackground (Color.BLACK);  
        setSize(CANVAS_WIDTH, CANVAS_HEIGHT);
	}
	
	@Override
	public void paint(Graphics g) {
		System.out.println("paint function");
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
