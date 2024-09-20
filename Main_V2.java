package byteblitz;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

import hangman.Hangman;

public class Main {

	public static void main(String[] args) {
		byte userSelect;
		Boolean isChoice = false;
		Scanner in = new Scanner(System.in);
		String playerName;
		boolean userDoesExist = false;
		
		System.out.println("Please enter your name:");
		playerName = in.nextLine();
		
		Player p1 = new Player(playerName);
		
		try {
			String path = "C:\\Users\\slona\\Documents\\College\\Spring 2024\\CSE 1325\\Final_Project\\ByteBlitz\\src\\byteblitz\\users.txt";
			StringBuffer buffer = new StringBuffer();
			Scanner sc = new Scanner(new File(path));
			
			FileWriter w = new FileWriter(path, true);
			BufferedWriter writer = new BufferedWriter(w);
			
			while (sc.hasNextLine()) {
				buffer.append(sc.nextLine() + System.lineSeparator());
			}
			
			String fileContents = buffer.toString();
			sc.close();
			
			if (fileContents == null) {
				writer.append(playerName + ">0");
			}
			else {
				String entries[] = fileContents.split(">\n");
				for (int i = 0; i < entries.length; i += 2) {
					String e = entries[i];
					if (e.equals(playerName)) {
						p1.setName(playerName);
						p1.setScore(Integer.parseInt(entries[i + 1]));
						userDoesExist = true;
						break;
					}
					else {
						continue;
					}
				}
			}
		}catch (IOException e) {
			System.err.println("User info retrieval error.");
		}
		
		while (!isChoice) {
			//lists mini-game options for player and allows them to exit
			System.out.println("Welcome to Byte Blitz!");
			System.out.println("Please select a minigame from the options below.");
			System.out.println("[1] Chess");
			System.out.println("[2] What Movie Should I Watch?");
			System.out.println("[3] Uno");
			System.out.println("[4] Guess the Number");
			System.out.println("[5] Hangman");
			System.out.println("[6] View leaderboard");
			System.out.println("[7] Exit");
			
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
					/*UnoGame uno = new UnoGame();
					uno.play();
					isChoice = true; //terminates while loop
					*/
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
							p1.addPoints(hangman.givePoints());
							System.out.println("+" + (difficulty * 100));
							break first;
						}
						else if (isGuess){
							hangman.drawHangmanBoard();
							if (hangman.checkCurrentGuess()) {
								System.out.println("You've guessed the word!");
								System.out.println("Here are your points:");
								p1.addPoints(hangman.givePoints());
								System.out.println("+" + (difficulty * 100));
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
					ArrayList<Player> players = new ArrayList<>();
					
					try {
						FileReader r = new FileReader("C:\\Users\\slona\\Documents\\College\\Spring 2024\\CSE 1325\\Final_Project\\ByteBlitz\\src\\byteblitz\\users.txt");
						BufferedReader reader = new BufferedReader(r);
						
						if (reader.readLine() == null) {
							System.out.println("The leaderboard is empty! Start playing!");
						}
						else {
							int i = 0;
							while (reader.readLine() != null) {
								String e = reader.readLine();
								String entry[] = e.split(">");
							
								players.add(new Player(entry[0]));
								players.get(i).setScore(Integer.parseInt(entry[1]));
								i++;
							}
						}
						
						reader.close();
					}catch (IOException e) {
						System.err.println("Leaderboard error.");
					}
					
					for (int i = 0; i < players.size(); i++) {
						int min = i;
						for (int j = i + 1; j < players.size(); j++) {
							if(players.get(j).getScore() < players.get(min).getScore()) {
								min = j;
							}
						}
						
						Player temp = players.get(min);
						players.set(min, players.get(i));
						players.set(i, temp);
					}
					
					for (int i = players.size() - 1; i >= 0; i--) {
						System.out.println(players.get(i).toString());
					}
				}
				case 7 ->{
					userDoesExist = false;
					
					try{
						String path = "C:\\Users\\slona\\Documents\\College\\Spring 2024\\CSE 1325\\Final_Project\\ByteBlitz\\src\\byteblitz\\users.txt";
						StringBuffer buffer = new StringBuffer();
						Scanner sc = new Scanner(new File(path));
						
						while (sc.hasNextLine()) {
							buffer.append(sc.nextLine()+System.lineSeparator());
						}
						
						String fileContents = buffer.toString();
						sc.close();
						
						FileReader r = new FileReader(path);
						BufferedReader reader = new BufferedReader(r);
						FileWriter w = new FileWriter(path);
						BufferedWriter writer = new BufferedWriter(w);
						
						String line = reader.readLine();
						if (line == null) {
							writer.write(p1.getName() + ">" + p1.getScore());
							reader.close();
							writer.close();
							System.out.println("Game saved!");
							System.exit(0);
						}
						else {
							while (line != null) {
								String entry[] = line.split(">");
								if (entry[0].equals(p1.getName())) {
									String oldLine = line;
									String newLine = p1.getName() + ">" + p1.getScore();
									fileContents = fileContents.replaceAll(oldLine, newLine);
									
									writer.write(fileContents);
									writer.flush();
									userDoesExist = true;
								}
								else {
									line = reader.readLine();
									continue;
								}
							}
						}
						
						if (!userDoesExist) {
							writer.write(fileContents + "\n" + p1.getName() + ">" + p1.getScore());
						}
						
						reader.close();
						writer.close();
					}catch (IOException e) {
						System.err.println("Save error.");
					}
					
					System.out.println("Game saved!");
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
	}

}
