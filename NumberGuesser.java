package BitBlitz;
import java.util.Scanner;
public class NumberGuesser
{
	public void guessTheNumber()
	{
		Scanner in = new Scanner (System.in);
		//welcome screen
		System.out.println(Colors.PURPLE); //this program is embedded with color coding
		System.out.println("WELCOME TO GUESS THE NUMBER!!!🥳");
		System.out.println("################################");
		System.out.println("In this game, there are 3 different levels of difficulty:");
		boolean replay = false;
		//variable as option to replay the game by controlling the do-while loop
		do {
			//prints levels
			System.out.println(Colors.GREEN + "Easy 	- The range is from 1 to 100 with unlimited guesses");
			System.out.println(Colors.YELLOW  + "Medium 	- The range is from 1 to 700 with unlimited guesses");
			System.out.println(Colors.RED + "Hard 	- The range is from 1 to 200 with only 10 guesses available");
			//selection menu
			System.out.println(Colors.RESET + "Select a difficulty level (ex. enter \"1\" for easy):");
			System.out.println(Colors.GREEN + "[1] Easy");
			System.out.println(Colors.YELLOW  + "[2] Medium");
			System.out.println(Colors.RED + "[3] Hard");
			System.out.println(Colors.RESET);
			//user's difficulty level selection
			//variable that stores the user's choice of difficulty
			int difficultyChoice = 0;
			//makes sure user enters valid option
			boolean validChoice = false;
			//while loop that prevents user from continuing with an invalid selection
			while (validChoice == false)
			{
				difficultyChoice = in.nextInt();
				if((difficultyChoice == 1) ||(difficultyChoice == 2)||(difficultyChoice == 3))
				{
					validChoice = true;
				}
				else {
					validChoice = false;
					System.out.println(Colors.CYAN + "Invalid choice. Choose again.");
				}
			}
			//random numbers
			int easyRandomNumber = (int)(Math.random()*100+1); //1-100
			int mediumRandomNumber = (int)(Math.random()*700+1); //1-700
			int hardRandomNumber = (int)(Math.random()*200+1); //1-200
			//variable to store user's guess
			int guess = 0;
			//counter for the number of guesses made by the user
			int numberOfGuesses = 0; //resets to 0 each round
			//switch that directs the game based on the selected difficulty level
			switch(difficultyChoice)
			{
			case 1: //easy level
				System.out.println(Colors.GREEN);
				while (guess != easyRandomNumber)
			    {
			        System.out.println("Enter your guess: ");
			        guess = in.nextInt();
			        numberOfGuesses++;
			        //checks if guess is greater than or less than or equal to the generated random number
			        if (guess < easyRandomNumber)
			            {System.out.println("Too low");}
			        else if (guess > easyRandomNumber)
			            {System.out.println("Too high");}
			    } 
				//loop breaks when correct number is guessed
				System.out.println("Congratulations!");
				System.out.println("The number was " + easyRandomNumber + ".");
				System.out.println("Number of guesses: " + numberOfGuesses);
				break;
			case 2: //medium level
				System.out.println(Colors.YELLOW);
				while (guess != mediumRandomNumber)
			    {
			        System.out.println("Enter your guess: ");
			        guess = in.nextInt();
			        numberOfGuesses++;
			      //checks if guess is greater than or less than or equal to the generated random number
			        if (guess < mediumRandomNumber)
			            {System.out.println("Too low");}
			        else if (guess > mediumRandomNumber)
			            {System.out.println("Too high");}
			    }
				//loop breaks when correct number is guessed
				System.out.println("Congratulations!");
				System.out.println("The number was " + mediumRandomNumber + ".");
				System.out.println("Number of guesses: " + numberOfGuesses);
				break;
			case 3: //hard level
				System.out.println(Colors.RED);
				while (numberOfGuesses < 10)
				    {
				        System.out.println("Enter your guess: ");
				        guess = in.nextInt();
				        numberOfGuesses++;
				      //checks if guess is greater than or less than or equal to the generated random number
				        if (guess < hardRandomNumber)
				            {System.out.println("Too low");}
				        else if (guess > hardRandomNumber)
				            {System.out.println("Too high");}
				        else if (guess == hardRandomNumber)
				        {
				        	System.out.println("Congratulations!");
							System.out.println("The number was " + hardRandomNumber + ".");
							System.out.println("Number of guesses used: " + numberOfGuesses + "/10");
							break;
				        }
				    }
				//loop breaks if correct answer is guessed or if all 10 guesses are used up
				if (guess != hardRandomNumber)
				{
					System.out.println("You have used up all your guesses.");
					System.out.println("The number was " + hardRandomNumber + ".");
				}
			}
			
			String choice;
			boolean validDecision = false;
			//variable that prevents user from making an invalid choice
			//asks if user wants to replay the game
			while (validDecision == false)
			{
				System.out.println(Colors.PURPLE + "Would you like to play another round?: [Y]es or [N]o");
				choice = in.next();
				if (choice.equalsIgnoreCase("Y"))
				{
					replay = true;
					validDecision = true;
				}
				else if (choice.equalsIgnoreCase("N"))
				{
					System.out.println(Colors.BLUE);
					System.out.println("Thanks for playing!");
					System.out.println("Stay hydrated! 🥤");
					validDecision = true;
					replay = false;
				}
				else 
				{
					System.out.println(Colors.CYAN + "Invalid choice. Choose again. Enter \"y\" for yes or \"n\" for no");
				}
			}
			
		} while (replay == true);
		in.close();
	}
}
