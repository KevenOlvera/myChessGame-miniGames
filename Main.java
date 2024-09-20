package byteblitz;
import java.util.Scanner;

import hangman.Hangman;

public class Main {

	public static void main(String[] args) {
		byte userSelect;
		Boolean isChoice = false;
		Scanner in = new Scanner(System.in);
		
		while (!isChoice) {
			//lists mini-game options for player and allows them to exit
			System.out.println("Welcome to Byte Blitz!");
			System.out.println("Please select a minigame from the options below.");
			System.out.println("[1] Chess");
			System.out.println("[2] What Movie Should I Watch?");
			System.out.println("[3] Uno");
			System.out.println("[4] Guess the Number");
			System.out.println("[5] Hangman");
			System.out.println("[6] Exit");
			
			//prevents exception errors from being thrown, allows user to select again
			//if incorrect selection was entered
			try {
				userSelect = in.nextByte();
			}
			catch (Exception e) {
				System.out.println("Please select a valid option.\n");
				in.next();
				continue;
			}
			
			//tests that user input is recognized
			switch (userSelect) {
				case 1 -> {
					//.println statements verify testing
					System.out.println("The user selected chess.");
					isChoice = true; //terminates while loop
				}
				case 2 -> {
					System.out.println("The user selected movie suggestions.");
					isChoice = true; //terminates while loop
				}
				case 3 -> {
					System.out.println("The user selected Uno.");
					UnoGame uno = new UnoGame();
					uno.play();
					isChoice = true; //terminates while loop
				}
				case 4 -> {
					System.out.println("The user selected number guessing.");
					isChoice = true; //terminates while loop
				}
				case 5 -> {
					boolean isCorrectDifficulty = false;
					int difficulty = 0;
					while (!isCorrectDifficulty) {
						System.out.println("Please select a difficulty:");
						System.out.println("[1] Easy");
						System.out.println("[2] Medium");
						System.out.println("[3] Hard");
						difficulty = in.nextInt();
						in.nextLine();
						
						switch (difficulty) {
						case 1 ->{
							isCorrectDifficulty = true;
						}
						
						case 2 ->{
							isCorrectDifficulty = true;
						}
						
						case 3 ->{
							isCorrectDifficulty = true;
						}
						
						default ->{
							System.out.println("Please select a valid difficulty.");
						}
						}
					}
					
					Hangman hangman = new Hangman(difficulty);
					hangman.selectWord();
					hangman.drawHangmanBoard();
					
					first:
					while (hangman.wrongCounter != 6) {
						System.out.println("Guess a letter.");
						System.out.println("If you're confident, you can guess the entire word.");
						String guess = in.nextLine();
						boolean isGuess = hangman.checkGuess(guess);
						if (isGuess && guess.length() > 1) {
							System.out.println("Here are your points:");
							//hangman.givePoints();
							break first;
						}
						else if (isGuess){
							hangman.drawHangmanBoard();
							if (hangman.checkCurrentGuess()) {
								System.out.println("You've guessed the word!");
								System.out.println("Here are your points:");
								//hangman.givePoints();
								break first;
							}
						}
						else {
							hangman.drawHangmanBoard();
						}
					}
					
					if (hangman.wrongCounter == 6) {
						hangman.drawHangmanBoard();
						System.out.println("You lose!");
					}
				}
				case 6 -> {
					System.exit(0);
				}
				default -> {
					System.out.println("Please select a valid option.\n");
				}
			}
		}
		
		in.close();
	}

}
