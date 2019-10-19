/*
 * Written by Prashant Thirumal
 */
import java.util.*;
public class Tournament {
	public static final int INPUT = 10; //Max Number of players
	public static final int RUNS = 2; // No. of times each player must play another player


	public static void main(String[] args) {
		System.out.println("Welcome to the Rock Paper Scissors Tournament!");
		GenCircularLinkedList<Player> playerList = new GenCircularLinkedList<Player>();


		System.out.println("Adding 10 players to the game"); //Add 10 players to the game
		for(int i=0; i<INPUT; i++) {
			Player player = new Player();
			player.setName("Player " + i);
			playerList.insert(player);
		}


		//Logic to run the game
		for(int h =0; h<RUNS; h++) {
			for(int i = 0; i<INPUT; i++) {
				Player p1 = playerList.getDataAtCurrent();
				playerList.goToNext();

				for(int j=i+1; j<INPUT; j++) {

					System.out.println(p1.getName() + " vs " + playerList.getDataAtCurrent().getName());

					String p1Choice = p1.chooseGesture();
					String playerListChoice = playerList.getDataAtCurrent().chooseGesture();

					System.out.println(p1Choice + " vs " + playerListChoice);

					//Conditions for which player wins
					if(p1Choice.equals("rock") && playerListChoice.equals("paper")) {
						System.out.println(playerList.getDataAtCurrent().getName() + " WINS");
						p1.addLoss();
						playerList.getDataAtCurrent().addWin();
					}
					else if(p1Choice.equals("rock") && playerListChoice.equals("rock")) {
						System.out.println("TIE");
						p1.addTie();
						playerList.getDataAtCurrent().addTie();
					}
					else if(p1Choice.equals("rock") && playerListChoice.equals("scissors")) {
						System.out.println(p1.getName() + " WINS");
						p1.addWin();
						playerList.getDataAtCurrent().addLoss();
					}		
					else if(p1Choice.equals("paper") && playerListChoice.equals("scissors")) {
						System.out.println(playerList.getDataAtCurrent().getName() + " WINS");
						p1.addLoss();
						playerList.getDataAtCurrent().addWin();
					}
					else if(p1Choice.equals("paper") && playerListChoice.equals("paper")) {
						System.out.println("TIE");
						p1.addTie();
						playerList.getDataAtCurrent().addTie();
					}
					else if(p1Choice.equals("paper") && playerListChoice.equals("rock")) {
						System.out.println(p1.getName() + " WINS");
						p1.addWin();
						playerList.getDataAtCurrent().addLoss();
					}	
					else if(p1Choice.equals("scissors") && playerListChoice.equals("rock")) {
						System.out.println(playerList.getDataAtCurrent().getName() + " WINS");
						p1.addLoss();
						playerList.getDataAtCurrent().addWin();
					}
					else if(p1Choice.equals("scissors") && playerListChoice.equals("scissors")) {
						System.out.println("TIE");
						p1.addTie();
						playerList.getDataAtCurrent().addTie();
					}
					else if(p1Choice.equals("scissors") && playerListChoice.equals("paper")) {
						System.out.println(p1.getName() + " WINS");
						p1.addWin();
						playerList.getDataAtCurrent().addLoss();
					}

					playerList.goToNext();

				}
				for (int j = 0; j < i+1; j++) { //Dear Dr JJ, this is the for loop that I don't understand.
					playerList.goToNext();
				}

			}
		}

		playerList.showList();

	}

}

