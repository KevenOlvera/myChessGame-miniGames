import java.util.*;

public class UnoGame {
    private List<Card> deck;
    private List<Card> playerHand;
    private List<Card> computerHand;
    private String[] colors = {"\u001B[31m", "\u001B[32m", "\u001B[34m", "\u001B[33m"}; // Red, Green, Blue, Yellow
    private Card topCard;
    boolean playerTurn;
    boolean compPlayed;

    public UnoGame()
    {
        initializeDeck();
        shuffleDeck();
        dealCards();
        topCard = deck.remove(0);
    }

    private void initializeDeck()
    {
        deck = new ArrayList<>();
        for (int i = 0; i < 4; i++)
        {
            for (int j = 0; j <= 9; j++)
            {
                deck.add(new Card(colors[i], String.valueOf(j)));
            }
            if (i != 0)
            {
                deck.add(new Card(colors[i], "0"));
            }
            for (int k = 0; k < 2; k++)
            {
                deck.add(new Card(colors[i], "+2"));
                deck.add(new Card(colors[i], "SKIP"));
            }
        }
        deck.add(new Card("", "WILD"));
        deck.add(new Card("", "WILD"));
    }

    private void shuffleDeck()
    {
        Collections.shuffle(deck);
    }

    private void dealCards()
    {
        playerHand = new ArrayList<>();
        computerHand = new ArrayList<>();

        for (int i = 0; i < 7; i++)
        {
            playerHand.add(deck.remove(0));
            computerHand.add(deck.remove(0));
        }
    }

    public void play()
    {
        Scanner scanner = new Scanner(System.in);
        playerTurn = true;
        compPlayed = false;

        printUnoGameLogo();

        while (true)
        {
            if (playerHand.isEmpty())
            {
                System.out.println("You won!");
                break;
            }
            else if (computerHand.isEmpty())
            {
                System.out.println("Computer won!");
                break;
            }

            if (playerTurn)
            {
                System.out.println("Top card: " + topCard);

                if (topCard.getNumber().equals("+2"))
                {
                    drawTwo(true);
                }

                if (topCard.getNumber().equals("SKIP"))
                {
                    System.out.println("Oh no! Your turn is skipped");
                    playerTurn = true;
                }

                System.out.println("Your turn! Your hand: " + playerHand);

                System.out.println("Play a card (Enter the index, or -1 to draw a card): ");
                int cardIndex = scanner.nextInt();

                if (cardIndex == -1)
                {
                    playerHand.add(deck.remove(0));
                    System.out.println("You drew a card: " + playerHand.get(playerHand.size() - 1));
                }
                else
                {
                    if (cardIndex >= playerHand.size())
                    {
                    System.out.println("Card does not exist! Try again. (Enter the index, or -1 to draw a card): ");
                    cardIndex = scanner.nextInt();
                    }

                    Card playedCard = playerHand.get(cardIndex);
                    boolean correctMove = isValidMove(playedCard);

                    while (!correctMove)
                    {
                        System.out.println("Invalid Move! Try again. (Enter the index, or -1 to draw a card): ");
                        cardIndex = scanner.nextInt();
                        playedCard = playerHand.get(cardIndex);
                        correctMove = isValidMove(playedCard);
                    }

                    topCard = playerHand.remove(cardIndex);
                    System.out.println("You played: " + topCard);
                }
                playerTurn = false;
            }
            else
            {
                if (topCard.getNumber().equals("+2"))
                {
                    drawTwo(true);
                }

                if (topCard.getNumber().equals("WILD"))
                {
                    topCard = computerHand.remove(0);
                    System.out.println("Computer played: " + topCard);
                }

                if (topCard.getNumber().equals("SKIP"))
                {
                    System.out.println("Computer turn is skipped");
                    playerTurn = false;
                }
                else
                {
                    for (Card card : computerHand)
                    {
                        if (card.getColor().equals(topCard.getColor()) || card.getNumber().equals(topCard.getNumber()))
                        {
                            topCard = computerHand.remove(computerHand.indexOf(card));
                            System.out.println("Computer played: " + topCard);
                            compPlayed = true;
                            break;
                        }
                    }

                    if (!compPlayed)
                    {
                        computerHand.add(deck.remove(0));
                        computerHand.add(deck.remove(0));
                        System.out.println("Computer drew two cards");
                    }
                }
                playerTurn = true;
                compPlayed = false;
            }
        }
        scanner.close();
    }

    private boolean isValidMove(Card card)
    {
        return card.getNumber().equals("WILD") || card.getColor().equals(topCard.getColor()) || card.getNumber().equals(topCard.getNumber());
    }

    private void drawTwo(boolean plusTwoTrue)
    {
        if (playerTurn)
        {
            playerHand.add(deck.remove(0));
            playerHand.add(deck.remove(0));
            System.out.println("Oof! You have to draw two cards.");
        }
        else
        {
            computerHand.add(deck.remove(0));
            computerHand.add(deck.remove(0));
            System.out.println("Computer draws two cards.");
        }
    }

    private void printUnoGameLogo()
    {
        System.out.println("|        |  |\\       |     ------");
        System.out.println("|        |  | \\      |    /      \\");
        System.out.println("|        |  |  \\     |   /        \\");
        System.out.println("|        |  |   \\    |  /          \\");
        System.out.println("|        |  |    \\   |  \\          /");
        System.out.println("\\        /  |     \\  |   \\        /");
        System.out.println(" \\      /   |      \\ |    \\      /");
        System.out.println("  ------    |       \\|     ------");
        System.out.println("");
    }

//    public static void main(String[] args)
//    {
//        UnoGame uno = new UnoGame();
//        uno.play();
//    }
}
