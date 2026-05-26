import java.util.Random;
import java.util.Scanner;

public class blackjack {
    public static void main(String[] args) {
    int chips = 100;
    int bet = 10;
    Random random = new Random();
    Scanner scanner = new Scanner(System.in);

    System.out.println("Welcome to Blackjack! Starting with 100 chips.");

    while (chips > 0 && chips < 200) {
        System.out.println("You have " + chips + " chips. Betting 10 chips...");
        int playerCard = random.nextInt(11) + 1; // Card between 1 and 11
        int dealerCard = random.nextInt(11) + 1;

        System.out.println("Your card: " + playerCard);
        System.out.println("Dealer's card: " + dealerCard);

        if (playerCard > dealerCard) {
            chips += bet;
            System.out.println("You win this hand!");
        } else if (playerCard < dealerCard) {
            chips -= bet;
            System.out.println("You lose this hand.");
        } else {
            System.out.println("It's a tie. No chips exchanged.");
        }

        System.out.println("Press Enter to continue...");
        scanner.nextLine();
    }

    if (chips >= 200) {
        System.out.println("Congratulations! You reached 200 chips and won the game!");
    } else {
        System.out.println("Game over. You ran out of chips.");
    }

    scanner.close();
    }
}