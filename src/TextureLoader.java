import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;

import javax.imageio.ImageIO;

public class TextureLoader {
	private static BufferedImage tileDark = null;
	private static BufferedImage tileLight = null;
	
	private static BufferedImage tileHighlight = null;
	private static BufferedImage tileHighlightRed = null;
	
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
	
	//load all textures
	public static void loadTextures() {
		try {
			tileDark = ImageIO.read(load("ChessTileDark.png")); 
			tileLight = ImageIO.read(load("ChessTileLight.png"));
			tileHighlight = ImageIO.read(load("ChessTileHighlight.png"));
			tileHighlightRed = ImageIO.read(load("ChessTileHighlightRed.png"));
			pawnBlack = ImageIO.read(load("PawnBlack.png"));
			pawnWhite = ImageIO.read(load("PawnWhite.png"));
			rookBlack = ImageIO.read(load("RookBlack.png"));
			rookWhite = ImageIO.read(load("RookWhite.png"));
			knightBlack = ImageIO.read(load("KnightBlack.png"));
			knightWhite = ImageIO.read(load("KnightWhite.png"));
			bishopBlack = ImageIO.read(load("BishopBlack.png"));
			bishopWhite = ImageIO.read(load("BishopWhite.png"));
			queenBlack = ImageIO.read(load("QueenBlack.png"));
			queenWhite = ImageIO.read(load("QueenWhite.png"));
			kingBlack = ImageIO.read(load("KingBlack.png"));
			kingWhite = ImageIO.read(load("KingWhite.png"));
		} catch (IOException e) { e.printStackTrace(); }
	}
	
	//get texture path
	private static InputStream load(String path) {
		InputStream stream = TextureLoader.class.getResourceAsStream(path);
		if(stream == null)
			stream = TextureLoader.class.getResourceAsStream("/" + path);
		
		return stream;
	}
	
	public static BufferedImage getDarkTile() {
		return tileDark;
	}
	
	public static BufferedImage getLightTile() {
		return tileLight;
	}
	
	public static BufferedImage getHighlightTile() {
		return tileHighlight;
	}
	
	public static BufferedImage getHighlightTileRed() {
		return tileHighlightRed;
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