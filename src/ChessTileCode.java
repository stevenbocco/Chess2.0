public abstract class ChessTileCode {

	private static Character[] chessLetters = {'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H'};
	private static Integer[] chessNumbers = {8, 7, 6, 5, 4, 3, 2, 1};
	
	public static String getChessTileCode(int letter, int number) {
		return chessLetters[letter] + chessNumbers[number].toString();
	}
}
