package exercise1;

import java.util.Random;
import java.util.Scanner;

/**
 * A class that fills a hand of 7 cards with random Card Objects and then asks the user to pick a card.
 * It then searches the array of cards for the match to the user's card.
 * To be used as starting code in Exercise
 *
 * @author dancye
 * @author Paul Bonenfant Jan 25, 2022
 */
public class CardTrick {

    public static void main(String[] args) {

        Card[] hand = new Card[7];

        // Generate random cards for the hand
        Random random = new Random();
        for (int i = 0; i < hand.length; i++) {
            Card card = new Card();
            card.setValue(random.nextInt(13) + 1);
            card.setSuit(Card.SUITS[random.nextInt(4)]);
            hand[i] = card;
        }

        // Ask the user for Card value and suit
        Scanner scanner = new Scanner(System.in);
        System.out.println("Pick a card! Enter value (1-13): ");
        int userValue = scanner.nextInt();
        System.out.println("Enter suit (Hearts=1, Diamonds=2, Spades=3, Clubs=4): ");
        int userSuit = scanner.nextInt();

        // Create user's card
        Card userCard = new Card();
        userCard.setValue(userValue);
        userCard.setSuit(Card.SUITS[userSuit - 1]); // Adjust for 0-based array

        // Search the hand for the user's card
        boolean found = false;
        for (Card card : hand) {
            if (card.getValue() == userCard.getValue() && card.getSuit().equals(userCard.getSuit())) {
                found = true;
                break;
            }
        }

        // Report whether the user's card is in the hand
        if (found) {
            printInfo();
        } else {
            System.out.println("Sorry, your card is not in the hand.");
        }

        scanner.close();
    }

    // I'm Done !
    
    /**
     * A simple method to print out personal information.
     * Follow the instructions to replace this information with your own.
     * @author Paul Bonenfant Jan 2022
     */
    private static void printInfo() {
        System.out.println("Congratulations, you guessed right!");
        System.out.println();
        System.out.println("My name is Hunny");
        System.out.println();
        System.out.println("My career ambitions:");
        System.out.println("-- Be a Software Developer");
        System.out.println("-- Have a Good GPA in this semester!");
        System.out.println();
        System.out.println("My hobbies:");
        System.out.println("-- Playing Cards");
        System.out.println("-- Watching Movies");
        System.out.println("-- Listening Songs");
        System.out.println("-- Outdoor Activity");
        System.out.println();
    }
}
