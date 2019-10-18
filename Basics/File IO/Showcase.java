/*
 * Written by Prashant Thirumal
 */
import java.io.*;
import java.util.Scanner;
import java.util.Random;

public class Showcase {
	private Prize[] prizes;
	public static final String delim = "\t";
	public static final int MAX_PRICES = 50;
	public static final int Format = 2;
	public static final int RANDOM = 5;
	public double GameCost = 0;

	public Showcase() {
		prizes = new Prize[MAX_PRICES];
	}

	public Showcase(int size) {
		if (size > 0) {
			prizes = new Prize[size];
		}
	}

	public Prize[] getPrizes() {
		return prizes;
	}

	public void addPrize(Prize aPrize) {
		if (prizes[prizes.length - 1] != null) {
			return;
		}
		for (int i = 0; i < prizes.length; i++) {
			if (prizes[i] == null) {
				prizes[i] = aPrize;
				return;
			}
		}
	}

	public void readFromFile(String filename) {
		if (filename == null) {
			System.out.println("Your file does not exist");
		}
		try {
			Scanner inStream = new Scanner(new File(filename));
			int prizeCount = 0;
			String fileLine;
			while (inStream.hasNextLine()) {
				prizeCount++;
				inStream.nextLine();
			}
			if (prizeCount <= 0) {
				System.out.println("Something went wrong");
			} else {
				prizes = new Prize[prizeCount];
			}
			inStream = new Scanner(new File(filename));
			String[] splitLine;
			while (inStream.hasNextLine()) {
				fileLine = inStream.nextLine();
				splitLine = fileLine.split(delim);
				if (splitLine.length == Format) {
					this.addPrize(new Prize(splitLine[0], Double.parseDouble(splitLine[1])));
				}
			}
			inStream.close();
		} catch (Exception e) {
			System.out.println("Something went wrong");
		}
	}

	public void randomiser() {
		Random rand = new Random();

		for (int i = 0; i < RANDOM; i++) {
			int random = rand.nextInt(50) - 1;
			System.out.println(prizes[random].getName());
			GameCost += prizes[random].getPrizeCost();

		}
	}
}
