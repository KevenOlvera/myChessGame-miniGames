package hangman;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.BufferedReader;
import java.util.ArrayList;
import java.util.List;

/**
 * The Hangman class represents the game hangman. All instances of this class represent a single game
 * of hangman. The Hangman class provides methods to create properly functioning game of Hangman,
 * including a method that draws the hangman, checking the user's guess, checking to see if the user
 * has guessed the entire word, giving points to the player, and a method to select a word that the
 * user will attempt to guess.
 * 
 * @version	1.3
 */
public class Hangman {
	int difficulty;    // stores difficulty selected by player
	String word;       // stores word selected from text files
	public int wrongCounter;    // counts # of incorrect guesses
	List<String> wrongBank = new ArrayList<String>();    // stores user's incorrect guesses
	String [] currentGuess;    // stores the current guess of the user, whether partial or complete
	
	public Hangman(int d) {
		difficulty = d;
	}
	
	/**
	* Draws and displays the gallows for the game.
	* Prints a picture of the gallows based on the number of incorrect guesses made by the user.
	* 
	* @version	1.3
	*/
	public void drawGallows() {
		String [] emptyGallows = {"   __________________",    // stores an empty version of the gallows
					  			  "  |                  |",
		                          "  |                  |",
		                          "  |                  |",
                                  "  |                  |",
		                          "  |                  |",
		                          "                     |",
		                          "                     |",
		                          "                     |",
		                          "                     |",
		                          "                     |",
		                          "                     |",
		                          "                     |",
		                          "                     |",
		                          "                     |",
		                          "                     |",
		                          "                     |",
		                          "                     |",
		                          "           --------------------"};
		String [] gallowsWithMan = {"   __________________",    // stores final version of the gallows
		                            "  |                  |",
		                            "  |                  |",
		                            "  |                  |",
		                            "  |                  |",
		                            "  |                  |",
		                            " ---                 |",
		                            "|   |                |",
		                            " ---                 |",
		                            "\\ | /                |",
		                            " \\|/                 |",
		                            "  |                  |",
		                            "  |                  |",
		                            " / \\                 |",
		                            "/   \\                |",
		                            "                     |",
		                            "                     |",
		                            "                     |",
		                            "           --------------------"};
		
		if (wrongCounter == 0) {
			for (String l : emptyGallows) {
				System.out.println(l);
			}
		}
		else if (wrongCounter == 6) {
			for (String l : gallowsWithMan) {
				System.out.println(l);
			}
		}
		else {
			for (int i = 0; i < 6; i++) {
				System.out.println(emptyGallows[i]);
			}
		
			for (int i = 6; i < 9; i++) {
				System.out.println(gallowsWithMan[i]);
			}
			
			switch (wrongCounter) {    // the program will print out a different version of the gallows based on # of incorrect guesses
			case 1 ->{
				for (int i = 9; i < emptyGallows.length; i++) {
					System.out.println(emptyGallows[i]);
				}
			}
			case 2 ->{
		    	System.out.println("  |                  |");
		    	System.out.println("  |                  |");
		    	System.out.println("  |                  |");
		    	System.out.println("  |                  |");
		    	System.out.println("  |                  |");
			
		    	for (int i = 13; i < emptyGallows.length; i++) {
		    		System.out.println(emptyGallows[i]);
		    	}
			}
			case 3 ->{
		    	System.out.println("\\ |                  |");
		    	System.out.println(" \\|                  |");
		    	System.out.println("  |                  |");
		    	System.out.println("  |                  |");
		    	System.out.println("  |                  |");
			
		    	for (int i = 13; i < emptyGallows.length; i++) {
		    		System.out.println(emptyGallows[i]);
		    	}
			}
			case 4 ->{
				System.out.println("\\ | /                |");
		    	System.out.println(" \\|/                 |");
		    	System.out.println("  |                  |");
		    	System.out.println("  |                  |");
		    	System.out.println("  |                  |");
			
		    	for (int i = 13; i < emptyGallows.length; i++) {
		    		System.out.println(emptyGallows[i]);
		    	}
			}
			case 5 ->{
				System.out.println("\\ | /                |");
				System.out.println(" \\|/                 |");
				System.out.println("  |                  |");
		   		System.out.println("  |                  |");
		   		System.out.println("  |                  |");
		   		System.out.println(" /                   |");
		   		System.out.println("/                    |");
			
		   		for (int i = 15; i < emptyGallows.length; i++) {
		   			System.out.println(emptyGallows[i]);
		   		}
			}
			default ->{    //error message for debugging purposes
				System.out.println("Gallows print error.");
			}
			}
		}
	}
	
	/**
	* Draws and displays a box with the user's incorrect guesses inside. Uses a for-each loop to print
	* out each incorrect guess stored in wrongBank.
	* 
	* @version	1.2
	*/
	public void drawWrongBank() {
		System.out.println("Wrong Guesses");
		if(wrongCounter == 0) {    // if the user has not guessed incorrectly, then draw an empty box
			System.out.println(" --------------");
			System.out.println("|              |");
			System.out.println(" --------------");
		}
		else {
			System.out.println(" --------------");
			System.out.print("| ");
			for(String l : wrongBank) {
				System.out.print(l + " ");
			}
			System.out.println("|");
			System.out.println(" --------------");
		}
	}
	
	/**
	* Draws and displays the state of the user's current guess.
	* For example, if the word is "banana", and the user has only guessed "a", then the screen
	* should show "_ a _ a _ a". Uses a for-each loop to print out each character stored in currentGuess.
	* 
	* @version	1.2
	*/
	public void drawCurrentGuess() {
		for (String l : currentGuess) {
			System.out.print(l + " ");
		}
		System.out.println();
	}
	
	/**
	* Draws and prints a complete, comprehensive hangman board.
 	* Uses drawGallows(), drawWrongBank(), and drawCurrentGuess() to display board.
 	* 
 	* @version 1.3
	*/
	public void drawHangmanBoard() {
		drawGallows();
		System.out.println();
		drawWrongBank();
		System.out.println();
		drawCurrentGuess();
		System.out.println();
	}
	
	/**
	* Selects a word that the user will guess. The word is selected randomly from a text file that is
	* associated with the difficulty selected by the user. This method also sets currentGuess to a
	* default array filled with blanks.
	* 
	* @version	1.3
	*/
	public void selectWord() {
		int randomNumber;
		switch (difficulty) {    // program will select a word from one of three files, depending on the difficulty the user selected
		case 1 -> {
			try {
				FileReader file = new FileReader("C:\\Users\\slona\\Documents\\College\\Spring 2024\\CSE 1325\\Final_Project\\ByteBlitz\\src\\hangman\\easyWords.txt.txt");
				BufferedReader easyRead = new BufferedReader(file);
				randomNumber = (int)((Math.random() * 19) + 0);    // program randomly selects a word within the file out of 20 words
				for (int i = 0; i < randomNumber - 1; i++) {
					try {
						easyRead.readLine();
					} catch (IOException e) {
						e.printStackTrace();
					}
				}
				try {
					word = easyRead.readLine().toUpperCase();    // sets word to selected word from text file, changed to uppercase for comparison purposes
					currentGuess = new String[word.length()];    // sets currentGuess to a default array containing only blanks
					for (int i = 0; i < word.length(); i++) {
						currentGuess[i] = "_";
					}
				} catch (IOException e) {
					e.printStackTrace();
				}
				try {
					easyRead.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			} catch (FileNotFoundException e) {
				System.err.println("File was not found.");
			}
		}
		case 2 -> {
			try {
				FileReader file = new FileReader("C:\\Users\\slona\\Documents\\College\\Spring 2024\\CSE 1325\\Final_Project\\ByteBlitz\\src\\hangman\\mediumWords.txt.txt");
				BufferedReader mediumRead = new BufferedReader(file);
				randomNumber = (int)((Math.random() * 19) + 0);
				for (int i = 0; i < randomNumber - 1; i++) {
					try {
						mediumRead.readLine();
					} catch (IOException e) {
						e.printStackTrace();
					}
				}
				try {
					word = mediumRead.readLine().toUpperCase();
					currentGuess = new String[word.length()];
					for (int i = 0; i < word.length(); i++) {
						currentGuess[i] = "_";
					}
				} catch (IOException e) {
					e.printStackTrace();
				}
				try {
					mediumRead.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			} catch (FileNotFoundException e) {
				System.err.println("File was not found.");
			}
		}
		case 3 -> {
			try {
				FileReader file = new FileReader("C:\\Users\\slona\\Documents\\College\\Spring 2024\\CSE 1325\\Final_Project\\ByteBlitz\\src\\hangman\\hardWords.txt.txt");
				BufferedReader hardRead = new BufferedReader(file);
				randomNumber = (int)((Math.random() * 19) + 0);
				for (int i = 0; i < randomNumber - 1; i++) {
					try {
						hardRead.readLine();
					} catch (IOException e) {
						e.printStackTrace();
					}
				}
				try {
					word = hardRead.readLine().toUpperCase();
					currentGuess = new String[word.length()];
					for (int i = 0; i < word.length(); i++) {
						currentGuess[i] = "_";
					}
				} catch (IOException e) {
					e.printStackTrace();
				}
				try {
					hardRead.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			} catch (FileNotFoundException e) {
				System.err.println("File was not found.");
			}
		}
		default -> {
			System.err.println("Word select error.");
		}
		}
	}
	
	/**
	* Checks if user's guess is correct or not, whether its the entire word or a single letter.
	* 
 	* @return	whether the user entered a correct guess or not
 	* @version	1.2
	*/
	public boolean checkGuess(String guess) {
		if (guess.length() > 1) {    // if user tries to guess entire word
			if (word.equalsIgnoreCase(guess)) {
				System.out.println("That's correct!");
				return true;
			}
			else {
				System.out.println("That's incorrect.");
				wrongCounter++;    // counts user's incorrect guess
				return false;
			}
		}
		else {
			if (word.contains(guess.toUpperCase())) {    // changed user guess to uppercase for comparison purposes
				int index = word.indexOf(guess.toUpperCase());
				currentGuess[index] = guess.toUpperCase();
				String tempWord = word.substring(index + 1);
				while (tempWord.contains(guess.toUpperCase())) {    // uses while loop to check word for all instances of user's guess
					index = tempWord.indexOf(guess.toUpperCase());
					currentGuess[index] = guess.toUpperCase();    // because currentGuess and word have the same length, indices should line up
					tempWord = word.substring(index + 1);
				}
				
				return true;
			}
			else {
				System.out.println("Wrong guess!");
				wrongBank.add(guess);    // stores user's incorrect guess to be displayed in wrong bank
				wrongCounter++;
				return false;
			}
		}
	}

	/**
	* Gives points to the player.
	* 
 	* @return	points awarded
 	* @version	1.1
	*/
	public int givePoints() {
		switch (difficulty) {    // program awards points based on the difficulty the user chooses
		case 1 ->{
			return 100;
		}
		
		case 2 ->{
			return 200;
		}
		
		case 3 ->{
			return 300;
		}
		
		default ->{
			System.out.println("Points error.");
		}
		}
		
		return 0;
	}

	/**
	* Checks to see if user has guessed entire word. If currentGuess has any blanks in it, then the
	* user must not have guessed the entire word.
	* 
 	* @return	whether user has guessed entire word or not
 	* @version	1.1
	*/
	public boolean checkCurrentGuess() {
		for (int i = 0; i < currentGuess.length; i++) {    // if the currentGuess has a blank in it, then the user has not guessed the entire word
			if (currentGuess[i].equals("_")) {
				return false;
			}
		}
		
		return true;
	}
}
		return true;
	}
}
