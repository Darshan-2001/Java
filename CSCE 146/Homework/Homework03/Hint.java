/*
public class Hint {
	package edu.sc.csce146.s18.hw03;

	//public class RPSGame {
		public static void main(String[] args) {
			CircularLinkedList<Player> players = new CircularLinkedList<>();
			
			for (int i = 0; i < 5; i++) { //TODO: 10 players
				players.insert(new Player());
			}
			
			for (int i = 0; i < 5; i++) { // TODO: 10 players
				Player p1 = players.getDataAtCurrent();
				
				players.goToNext();
				
				for (int j = i + 1; j < 5; j++) {// TODO: from (i + 1) to the 9th
					/*
					 * Replace below two System.out.println() with the logic of doing the comparison and statistics
					 
					//TODO: put your codes here
					// ------------ BEGIN ----------
					System.out.println(p1.getName() + " vs " + players.getDataAtCurrent().getName());
					System.out.println(p1.getHand() + " >>> <<< " + players.getDataAtCurrent().getHand());
					
					//------------- END -------------
					players.goToNext();
				}
//				System.out.println(">>> " + players.getDataAtCurrent());
				
				// move to the next of p1
				for (int j = 0; j < i + 1; j++) {
					players.goToNext();
				}
				
//				System.out.println(">>>>>>" + players.getDataAtCurrent());
			}
			
		}
	}

}
*/
