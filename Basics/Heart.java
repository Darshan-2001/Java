/**
 * This class draws a simple heart based on the user input
 */

package tester;
import java.util.*;
public class Heart {

	// Java program to print heart star pattern
	public static void main(String[] args) {
		Scanner kb = new Scanner(System.in);

		System.out.println("Enter a number");
		int N = kb.nextInt();
		

		for (int i = 0; i < N; i++) {
			for (int j = 0; j <= 4 * N; j++) {
				double d1 = Math.sqrt(Math.pow(i - N, 2)
						+ Math.pow(j - N, 2));

				double d2 = Math.sqrt(Math.pow(i - N, 2)
						+ Math.pow(j - 3 * N, 2));

				if (d1 < N + 0.5 || d2 < N + 0.5) {
					System.out.print('*');
				} else {
					System.out.print(' ');
				}
			}
			System.out.print(System.lineSeparator());
		}

		for (int i = 1; i < 2 * N; i++) {
			for (int j = 0; j < i; j++) {
				System.out.print(' ');
			}

			for (int j = 0; j < 4 * N + 1 - 2 * i; j++) {
				System.out.print('*');
			}

			System.out.print(System.lineSeparator());
		}
		
		kb.close();

	}


}

