import java.awt.Component;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

public abstract class ChessPiece extends Component {
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
