import java.io.*;
import java.util.*;

public class FruitMain {
	public static final String delim = "\t";
	public static final int Format = 1;
	public static FruitBSTree FBS = new FruitBSTree();
	public static final String filename = "fruits.txt";

	public static void main (String[] args) {

		try {
			File aFile = new File(filename);
			Scanner inStream = new Scanner(aFile);

			int FruitCount = 0;
			String fileLine;
			while (inStream.hasNextLine()) {
				FruitCount++;
				inStream.nextLine();
			}
			if (FruitCount <= 0) {
				System.out.println("Something went wrong");
			} 
			inStream = new Scanner(new File(filename));
			String[] splitLine;
			while (inStream.hasNextLine()) {
				fileLine = inStream.nextLine();
				splitLine = fileLine.split(delim);
				FBS.insert(new Fruit(splitLine[0], Double.parseDouble(splitLine[1])));

			}
			inStream.close();
		} 
		catch (Exception e) {
			System.out.println(e);
		}

		System.out.println("Printing the In-Order Traversal");
		FBS.printInOrder();
		
		System.out.println("\nPrinting the Pre-Order Traversal");
		FBS.printPreOrder();
		
		System.out.println("\nPrinting the Post-Order Traversal");
		FBS.printPostOrder();
		
		System.out.println("\nDeleting Apple 0.4859853412170728");
		Fruit deleteFruit = new Fruit("Apple", 0.4859853412170728 );
		FBS.delete(deleteFruit);
		System.out.println("\nPrinting the In-Order Traversal");
		FBS.printInOrder();
	}
}

