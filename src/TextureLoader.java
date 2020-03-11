import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;

public class TextureLoader {
	private static BufferedImage tileDark = null;
	private static BufferedImage tileLight = null;
	
	public static void loadTextures() {
		try {
			tileDark = ImageIO.read(new File("resources/ChessTileDark.png")); 
			tileLight = ImageIO.read(new File("resources/ChessTileLight.png")); 
		} catch (IOException e) { e.printStackTrace(); }
	}
	
	public static BufferedImage getDarkTile() {
		return tileDark;
	}
	
	public static BufferedImage getLightTile() {
		return tileLight;
	}
}
