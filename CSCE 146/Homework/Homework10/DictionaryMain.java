import java.util.*;
import java.io.*;
public class DictionaryMain {
	public static final String filename = "dictionary2.txt";
	public static final int MAX_WORDS = 25144;
	public static final char[][] board = { 
			{'R', 'A', 'H', 'J', 'M' },
			{'Y', 'U', 'W', 'W', 'K' },
			{'R', 'X', 'N', 'F', 'M' },
			{'E', 'O', 'A', 'P', 'E' },
	};
	public static String[] foundWords;
	public static String[] validWords = new String[MAX_WORDS];
	public static ArrayList<String> wordsFound = new ArrayList<String>();

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try {
			File aFile = new File(filename);
			//System.out.println(aFile.getAbsolutePath());
			Scanner inStream = new Scanner(aFile);

			int lineCount = 0;
			String fileLine;

			while(inStream.hasNextLine()) {
				lineCount ++;
				inStream.nextLine();
			}
			if(lineCount <= 0)
				System.out.println("Something went wrong");

			inStream = new Scanner(new File(filename));
			while(inStream.hasNextLine()) {

				for(int i=0; i<validWords.length; i++) {
					fileLine = inStream.nextLine();
					validWords[i] = fileLine;
				}
			}

			findWords(board);
			for(int i=0; i<wordsFound.size(); i++) {
				System.out.println(wordsFound.get(i));
			}
			inStream.close();

		}
		catch(Exception e) {
			System.out.println(e);
		}

	}

	//Boolean to check if word formed is in the dictionary
	public static boolean isWord(String aWord) {
		for(int i=0; i<validWords.length; i++) {
			if(aWord.equalsIgnoreCase(validWords[i])) {
				return true;
			}
		}
		return false;
	}

	//recursive function to find all possible words
	public static void findWords(char board[][]) {
		//Mark all characters as not visited
		boolean visited[][] = {{false}};

		//initialize current string
		String word = "";

		// Consider every character and look for all words
		// starting with this character
		for (int i=0; i<board.length; i++) {
			for (int j=0; j<board[i].length; j++) {
				findWords(board, visited, i, j, word);
			}
		}
	}
	public static void findWords(char board[][], boolean visited[][], int i, int j, String word ) {
		//Mark current cell as visited
		visited[i][j] = true;
		word += board[i][j];

		if(isWord(word)) {
			wordsFound.add(word);
		}

		//Traverse adjacent cells of board
		for (int row=i; row<=i+1 && row<board.length; row++) {
			for (int col=j; col<=j+1 && col<board[i].length; col++) {
				if (row>=0 && col>=0 && !visited[row][col])
					findWords(board,visited, row, col, word);
			}
		}
	}





}