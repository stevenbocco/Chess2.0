import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;

public class TextureLoader {
	private static BufferedImage tileDark = null;
	private static BufferedImage tileLight = null;
	private static BufferedImage pawnBlack = null;
	private static BufferedImage pawnWhite = null;
	private static BufferedImage rookBlack = null;
	private static BufferedImage rookWhite = null;
	private static BufferedImage knightBlack = null;
	private static BufferedImage knightWhite = null;
	private static BufferedImage bishopBlack = null;
	private static BufferedImage bishopWhite = null;
	private static BufferedImage queenBlack = null;
	private static BufferedImage queenWhite = null;
	private static BufferedImage kingBlack = null;
	private static BufferedImage kingWhite = null;
	
	public static void loadTextures() {
		try {
			tileDark = ImageIO.read(new File("resources/ChessTileDark.png")); 
			tileLight = ImageIO.read(new File("resources/ChessTileLight.png"));
			pawnBlack = ImageIO.read(new File("resources/PawnBlack.png"));
			pawnWhite = ImageIO.read(new File("resources/PawnWhite.png"));
			rookBlack = ImageIO.read(new File("resources/RookBlack.png"));
			rookWhite = ImageIO.read(new File("resources/RookWhite.png"));
			knightBlack = ImageIO.read(new File("resources/KnightBlack.png"));
			knightWhite = ImageIO.read(new File("resources/KnightWhite.png"));
			bishopBlack = ImageIO.read(new File("resources/BishopBlack.png"));
			bishopWhite = ImageIO.read(new File("resources/BishopWhite.png"));
			queenBlack = ImageIO.read(new File("resources/QueenBlack.png"));
			queenWhite = ImageIO.read(new File("resources/QueenWhite.png"));
			kingBlack = ImageIO.read(new File("resources/KingBlack.png"));
			kingWhite = ImageIO.read(new File("resources/KingWhite.png"));
		} catch (IOException e) { e.printStackTrace(); }
	}
	
	public static BufferedImage getDarkTile() {
		return tileDark;
	}
	
	public static BufferedImage getLightTile() {
		return tileLight;
	}
	
	public static BufferedImage getPawnBlack() {
		return pawnBlack;
	}
	
	public static BufferedImage getPawnWhite() {
		return pawnWhite;
	}
	
	public static BufferedImage getRookBlack() {
		return rookBlack;
	}
	
	public static BufferedImage getRookWhite() {
		return rookWhite;
	}
	
	public static BufferedImage getKnightBlack() {
		return knightBlack;
	}
	
	public static BufferedImage getKnightWhite() {
		return knightWhite;
	}
	
	public static BufferedImage getBishopBlack() {
		return bishopBlack;
	}
	
	public static BufferedImage getBishopWhite() {
		return bishopWhite;
	}
	
	public static BufferedImage getQueenBlack() {
		return queenBlack;
	}
	
	public static BufferedImage getQueenWhite() {
		return queenWhite;
	}
	
	public static BufferedImage getKingBlack() {
		return kingBlack;
	}
	
	public static BufferedImage getKingWhite() {
		return kingWhite;
	}
}