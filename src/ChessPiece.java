import java.awt.Component;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

public class ChessPiece extends Component {
	BufferedImage tile1 = null;
	BufferedImage tile2 = null;
	
	public ChessPiece () {
		super();

		try {
		    tile1 = ImageIO.read(new File("resources/ChessTileDark.png")); 
		    tile2 = ImageIO.read(new File("resources/ChessTileLight.png")); 
		} catch (IOException e) {
		    e.printStackTrace();
		}
	}
	
	@Override
	public void paint(Graphics g) {
		System.out.println("Rendering king");
		
		
		g.drawImage(tile1, 0, 0, null);
		g.drawImage(tile2, 100, 0, null);
	}
}
