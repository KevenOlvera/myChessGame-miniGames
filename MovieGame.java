package BitBlitz;
import java.util.Scanner;
import java.util.ArrayList;
public class MovieAssessment 
{
	public void movieGame()
	{
		//ArrayList of movies from 2021 to 2023
		ArrayList<Movie> movies = new ArrayList<>();
		movies.add(new Movie("Migration 🦆", 2023, true, false, true, true, false, true, true));
		movies.add(new Movie("The Magician’s Elephant 🐘", 2023, true, false, false, true, false, true, false));
		movies.add(new Movie("Fast X 🚘", 2023, false, true, true, true, false, false, true));
		movies.add(new Movie("Aquaman 🌊", 2023, false, true, false, true, false, true, false));
		movies.add(new Movie("Barbie", 2023, false, true, true, false, false, true, false));
		movies.add(new Movie("Oppenheimer 💣", 2023, false, true, false, false, true, true, false));
		movies.add(new Movie("Shazam Fury of the Gods ⚡", 2023, false, true, true, true, false, false, true));
		movies.add(new Movie("Guardians of the Galaxy Vol. 3 🌌", 2023, false, true, true, true, false, false, true));
		movies.add(new Movie("Slumberland 💤", 2022, false, true, true, true, false, true, false));
		movies.add(new Movie("Luck 🍀", 2022, true, false, true, false, false, true, false));
		movies.add(new Movie("Jurassic World Dominion 🦕🦖", 2022, false, true, false, true, false, true, false));
		movies.add(new Movie("Sonic 2 🦔", 2022, false, true, true, true, false, true, false));
		movies.add(new Movie("Lyle Lyle Crocodile 🐊", 2022, false, true, true, false, false, true, false));
		movies.add(new Movie("The Bad Guys 🐺🕷️🐠🦈🐍🐈", 2022, true, false, true, true, false, false, true));
		movies.add(new Movie("Lightyear 🧑‍🚀🚀", 2022, true, false, false, true, false, true, false));
		movies.add(new Movie("Puss In Boots The Last Wish 😼👢🌠", 2022, true, false, true, true, false, true, false));
		movies.add(new Movie("Night at the Museum 🌃", 2022, true, false, true, true, false, false, true));
		movies.add(new Movie("Paws of Fury 🐾", 2022, true, false, true, true, false, true, false));
		movies.add(new Movie("Hotel Transylvania Transformania 🔫", 2022, true, false, true, true, false, false, true));
		movies.add(new Movie("Avatar The Way of Water 🌊", 2022, false, true, false, true, false, false, true));
		movies.add(new Movie("Godzilla vs. Kong 🦖🦍", 2021, false, true, false, true, false, false, true));
		movies.add(new Movie("The Tomorrow War ⌚", 2021, false, true, false, true, false, true, false));
		movies.add(new Movie("Boss Baby Family Business 🍼", 2021, true, false, true, false, false, false, true));
		movies.add(new Movie("Peter Rabbit 2 🐇", 2021, false, true, true, false, false, false, true));
		movies.add(new Movie("Spiderman No Way Home 🕸️", 2021, false, true, false, true, false, true, true));
		movies.add(new Movie("Venom Let There Be Carnage 🍫", 2021, false, true, true, true, false, true, true));
		movies.add(new Movie("Sing 2 🎤", 2021, true, false, true, true, false, false, true));
		movies.add(new Movie("Rumble 🤼🏟️", 2021, true, false, true, true, false, true, false));
		movies.add(new Movie("Space Jam A New Legacy 🏀", 2021, true, true, true, false, false, false, true));
		movies.add(new Movie("Ghostbusters Afterlife 👻", 2021, false, true, false, true, false, false, true));
		movies.add(new Movie("Vivo 🎷", 2021, true, false, true, true, false, true, false));
		movies.add(new Movie("Luca 🐟", 2021, true, false, true, true, false, true, false));
		movies.add(new Movie("Spirit Untamed 🐎", 2021, true, false, false, true, false, true, false));
		movies.add(new Movie("Riverdance 🦌", 2021, true, false, true, false, false, true, false));
		movies.add(new Movie("Raya The Last Dragon 🐉", 2021, true, false, true, true, false, true, false));
		movies.add(new Movie("Spider-Man: Across the Spider-Verse 🕷️", 2021, true, false, false, true, false, true, false));
		//a new ArrayList to store customized list of movies for the user
		//it initially starts as a duplicate copy of the original ArrayList
		ArrayList<Movie> recs = new ArrayList<>();
		recs.add(new Movie("Migration 🦆", 2023, true, false, true, true, false, true, true, true));
		recs.add(new Movie("The Magician’s Elephant 🐘", 2023, true, false, false, true, false, true, false, true));
		recs.add(new Movie("Fast X 🚘", 2023, false, true, true, true, false, false, true, true));
		recs.add(new Movie("Aquaman 🌊", 2023, false, true, false, true, false, true, false, true));
		recs.add(new Movie("Barbie", 2023, false, true, true, false, false, true, false, true));
		recs.add(new Movie("Oppenheimer 💣", 2023, false, true, false, false, true, true, false, true));
		recs.add(new Movie("Shazam Fury of the Gods ⚡", 2023, false, true, true, true, false, false, true, true));
		recs.add(new Movie("Guardians of the Galaxy Vol. 3 🌌", 2023, false, true, true, true, false, false, true, true));
		recs.add(new Movie("Slumberland 💤", 2022, false, true, true, true, false, true, false, true));
		recs.add(new Movie("Luck 🍀", 2022, true, false, true, false, false, true, false, true));
		recs.add(new Movie("Jurassic World Dominion 🦕🦖", 2022, false, true, false, true, false, true, false, true));
		recs.add(new Movie("Sonic 2 🦔", 2022, false, true, true, true, false, true, false, true));
		recs.add(new Movie("Lyle Lyle Crocodile 🐊", 2022, false, true, true, false, false, true, false, true));
		recs.add(new Movie("The Bad Guys 🐺🕷️🐠🦈🐍🐈", 2022, true, false, true, true, false, false, true, true));
		recs.add(new Movie("Lightyear 🧑‍🚀🚀", 2022, true, false, false, true, false, true, false, true));
		recs.add(new Movie("Puss In Boots The Last Wish 😼👢🌠", 2022, true, false, true, true, false, true, false, true));
		recs.add(new Movie("Night at the Museum 🌃", 2022, true, false, true, true, false, false, true, true));
		recs.add(new Movie("Paws of Fury 🐾", 2022, true, false, true, true, false, true, false, true));
		recs.add(new Movie("Hotel Transylvania Transformania 🔫", 2022, true, false, true, true, false, false, true, true));
		recs.add(new Movie("Avatar The Way of Water 🌊", 2022, false, true, false, true, false, false, true, true));
		recs.add(new Movie("Godzilla vs. Kong 🦖🦍", 2021, false, true, false, true, false, false, true, true));
		recs.add(new Movie("The Tomorrow War ⌚", 2021, false, true, false, true, false, true, false, true));
		recs.add(new Movie("Boss Baby Family Business 🍼", 2021, true, false, true, false, false, false, true, true));
		recs.add(new Movie("Peter Rabbit 2 🐇", 2021, false, true, true, false, false, false, true, true));
		recs.add(new Movie("Spiderman No Way Home 🕸️", 2021, false, true, false, true, false, true, true, true));
		recs.add(new Movie("Venom Let There Be Carnage 🍫", 2021, false, true, true, true, false, true, true, true));
		recs.add(new Movie("Sing 2 🎤", 2021, true, false, true, true, false, false, true, true));
		recs.add(new Movie("Rumble 🤼🏟️", 2021, true, false, true, true, false, true, false, true));
		recs.add(new Movie("Space Jam A New Legacy 🏀", 2021, true, true, true, false, false, false, true, true));
		recs.add(new Movie("Ghostbusters Afterlife 👻", 2021, false, true, false, true, false, false, true, true));
		recs.add(new Movie("Vivo 🎷", 2021, true, false, true, true, false, true, false, true));
		recs.add(new Movie("Luca 🐟", 2021, true, false, true, true, false, true, false, true));
		recs.add(new Movie("Spirit Untamed 🐎", 2021, true, false, false, true, false, true, false, true));
		recs.add(new Movie("Riverdance 🦌", 2021, true, false, true, false, false, true, false, true));
		recs.add(new Movie("Raya The Last Dragon 🐉", 2021, true, false, true, true, false, true, false, true));
		recs.add(new Movie("Spider-Man: Across the Spider-Verse 🕷️", 2021, true, false, false, true, false, true, false, true));
		//in case the user decides to choose invalid options
		ArrayList<Movie> alternative = new ArrayList<>();
		alternative.add(new Movie("Wall-E", 2008, true, false, true, false, false, true, false));
		alternative.add(new Movie("Big Hero 6", 2014, true, false, true, true, false, false, true));
		alternative.add(new Movie("Zootopia", 2016, true, false, true, true, false, true, false));
		Scanner in = new Scanner(System.in);
		boolean redo = true;
		boolean choseInvalidOption = false;
		//welcome statement
		System.out.println("WELCOME TO BIT BLITZ MOVIE ASSESSMENT!!!🥳");
		System.out.println("^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^");
		System.out.println("In this game, you will be asked questions to express your interests.");
		System.out.println("Based on your answers, you will receive a customized list of movie recommendations!");
		System.out.println("*Disclaimer* The movies in this game are post-covid only (from 2021 to 2024)");
		do
		{
			System.out.println("What would you like to do?");
			System.out.println("[1] Take the assessment to get movie suggestions");
			System.out.println("[2] View the movie directory");
			System.out.println("[3] Exit");
			System.out.println("Select an option (ex. enter \"1\" for the game):");
			int choice = in.nextInt();
			switch (choice)
			{
			case 1:
				System.out.println("Do you prefer animated or live-action movies?");
				System.out.println("[1] Animations");
				System.out.println("[2] Live actions");
				System.out.println("[3] I don't have a preference cuz I love both!");
				int styleChoice = in.nextInt();
				switch (styleChoice)
				{
				case 1:
					//remove visibility of non-animation movies
					for (Movie movie: recs)
					{
						if (movie.animation != true)
						{
							movie.setDisplay(false);
						}
					}
					break;
				case 2:
					//remove visibility of non-live-action movies
					for (Movie movie: recs)
					{
						if (movie.liveAction != true)
						{
							movie.setDisplay(false);
						}
					}
					break;
				case 3:
					break;
				default:
					choseInvalidOption = true;
					break;
				}
				System.out.println("Do you prefer action or comedy movies?");
				System.out.println("[1] Action");
				System.out.println("[2] Comedy");
				System.out.println("[3] I don't have a preference cuz I love both!");
				int genreChoice = in.nextInt();
				switch (genreChoice)
				{
				case 1:
					//remove visibility of non-action movies
					for (Movie movie: recs)
					{
						if (movie.action != true)
						{
							movie.setDisplay(false);
						}
					}
					break;
				case 2:
					//remove visibility of non-comedy movies
					for (Movie movie: recs)
					{
						if (movie.comedy != true)
						{
							movie.setDisplay(false);
						}
					}
					break;
				case 3:
					break;
				default:
					choseInvalidOption = true;
					break;
				}
				System.out.println("Are you open to watching movies with a historical connection?");
				System.out.println("[1] Yes");
				System.out.println("[2] No");
				System.out.println("[3] I don't have a preference");
				int historicalChoice = in.nextInt();
				switch (historicalChoice)
				{
				case 1:
					//make Oppenheimer visible
					recs.get(5).display = true;
					break;
				case 2:
					//make Oppenheimer invisible
					recs.get(5).display = false;
					break;
				case 3:
					break;
				default:
					choseInvalidOption = true;
					break;
				}
				//print movie recs
				if (choseInvalidOption == false)
				{
					for (Movie movie: recs)
					{
						if(movie.display == true)
						{
							System.out.print(movie.toString());
						}
					}
				}
				else
				{
					System.out.println("On this day. . .");
					System.out.println("You made the daring decision of choosing invalid option(s) in your answers");
					System.out.println("Therefore. . .");
					System.out.println("You must watch the following movies instead and extract some life lessons");
					for (Movie movie: alternative)
					{
						System.out.print(movie.toString());
					}
				}
				break;
			case 2:
				System.out.println(movies.toString());
				break;
			case 3:
			default:
				System.out.println(". . . and they lived happily ever after. The End.");
				System.out.println("[curtains close]");
				redo = false;
				break;
			}
		}
		while (redo == true);
		in.close();
	}
}
