/*
 * Written by Prashant Thirumal
 */
import java.util.*;
public class Player {
	private String name;
	private int NumWins;
	private int NumLoss;
	private int NumTies;

	public String gesture;

	public Player() { //Constructor
		this.name = "No Name yet";
		this.NumWins = this.NumLoss = this.NumTies = 0;
	}

	public Player(String aName, int Wins, int Loss, int Ties) { //Parameterized constructor
		this.name = aName;
		this.NumWins = Wins;
		this.NumLoss = Loss;
	}

	//Accessors and Mutators 
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getNumWins() {
		return NumWins;
	}

	public void setNumWins(int numWins) {
		if(numWins >=0) {
			NumWins = numWins;
		}
	}

	public int getNumLoss() {
		return NumLoss;
	}

	public void setNumLoss(int numLoss) {
		if(numLoss >= 0) {
			NumLoss = numLoss;
		}
	}

	public int getNumTies() {
		return NumTies;
	}

	public void setNumTies(int numTies) {
		if(numTies >= 0) {
			NumTies = numTies;
		}
	}

	//ToString method
	public String toString() {
		return ("Player " + this.name 
				+ " Wins " + this.NumWins + 
				" Loss " + this.NumLoss + 
				" Ties " + this.NumTies);
	}

	//Player randomly chooses rock, paper, scissors
	public String chooseGesture() {
		Random rand = new Random();
		int selection = rand.nextInt(3)+1;
		if(selection == 1){
			return "rock";
		}
		else if(selection == 2){
			return "paper";
		}
		else if(selection == 3){
			return "scissors";
		}
		else {
			return "";
		}
	}
	
	//method to count each player number of wins, losses and ties
	int winCounter = 0;
	int lossCounter = 0;
	int tieCounter = 0;
	
	public void addWin() {
		winCounter ++;
		setNumWins(winCounter);
	}
	
	public void addLoss() {
		lossCounter ++;
		setNumLoss(lossCounter);
	}
	
	public void addTie() {
		tieCounter ++;
		setNumTies(tieCounter);
	}



}
