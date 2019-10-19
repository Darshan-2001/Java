import java.io.*;
import java.util.*;

public class ReversePolishCalculator {

	static ArrayStack<Integer> arrayStack = new ArrayStack<Integer>();
	public static final String DELIM = " "; 

	public static void main(String[]args) {

		Scanner kb = new Scanner(System.in);

		System.out.println("Welcome to the reverse Polish Calculator!");
		System.out.println("Enter in the name of the file");
		String filename = kb.nextLine();

		try {
			String fileLine;
			Scanner inStream = new Scanner(new File(filename));
			String[] splitLine;

			while (inStream.hasNextLine()) {	
				fileLine = inStream.nextLine();
				splitLine = fileLine.split(DELIM);

				for(int i=0; i<splitLine.length; i++) {
					while(splitLine[i] != null) {
						System.out.println("Calculating " + fileLine);
						
						try {
							arrayStack.push(Integer.parseInt(splitLine[i]));
						}

						catch(Exception a) {

							if(splitLine[i].equals("+")) {
								int aNum = arrayStack.pop() + arrayStack.pop();
								arrayStack.push(aNum);
								System.out.println("Result is "); 
				 				arrayStack.print();
								
							}
							else if(splitLine[i].equals("-")) {
								int aNum = arrayStack.pop() - arrayStack.pop();
								arrayStack.push(aNum);
								System.out.println("Result is "); 
								arrayStack.print();
							}
							else if(splitLine[i].equals("*")) {
								int aNum = arrayStack.pop() * arrayStack.pop();
								arrayStack.push(aNum);
								System.out.println("Result is "); 
								arrayStack.print();
							}
							else if(splitLine[i].equals("/")) {
								int aNum = arrayStack.pop() / arrayStack.pop();
								arrayStack.push(aNum);
								System.out.println("Result is "); 
								arrayStack.print();
							}
							else {
								System.out.println(a);
							}
							//end of catch
						}
						fileLine = inStream.nextLine();
						//end of for loop
					}
				}
				//end of while loop				
			}
			inStream.close();
		} 

		catch (Exception e) {
			System.out.println(e);
		}
	}

}


