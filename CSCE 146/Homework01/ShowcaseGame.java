/*
 * Written By Prashant Thirumal
 */

import java.io.*;
import java.util.*;

public class ShowcaseGame {

	public static void main(String[] args) {
		Scanner kb = new Scanner(System.in);
		String choice = "yes";

		Showcase showcases = new Showcase();
		showcases.readFromFile("prizeList.txt");

		System.out.println("Welcome to the showcase show down!");

		//While loop to repeat the game
		while (choice.toLowerCase().equals("yes")) {

			System.out.println("Your prizes are: ");
			showcases.randomiser();
			System.out.println("You must guess the total cost of all without going over");
			System.out.println("Enter your guess");
			double UserGuess = kb.nextDouble();

			//if statements to check the user guess and the actual cost
			if (UserGuess - showcases.GameCost < 2000 && showcases.GameCost - UserGuess < 2000) {
				System.out.println("You guessed " + UserGuess + " the acutual price is " + showcases.GameCost);
				System.out.println("Your guess was under, you win!!");
			}

			else if (UserGuess == showcases.GameCost) {
				System.out.println("You guessed " + UserGuess + " the acutual price is " + showcases.GameCost);
				System.out.println("You are either a GENIUS or a CHEATER");
			}

			else {
				System.out.println("You guessed " + UserGuess + " the acutual price is " + showcases.GameCost);
				System.out.println("I'm sorry but that guess was bad.  You lose for being bad.");
			}
			
			System.out.println("Would you like to play again? Enter \"no\" to quit or \"yes\" to continue");
			choice = kb.next();

		}
		
		System.out.println("GoodBye");
	}

}
