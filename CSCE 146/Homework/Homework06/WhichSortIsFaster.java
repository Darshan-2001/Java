/*
 * Written By Prashant Thirumal
 */

import java.util.*;

public class WhichSortIsFaster {
	public static int[] algoChecks = {0,0,0,0}; //Array to check to number of times each algorithm has run
	public static final int SIZE = 1000;//Array size will be 1000
	public static int totalSelSort = 0;
	public static int totalBubSort = 0;
	public static int totalMerSort = 0;
	public static int totalQuiSort = 0;
	
	public static void main(String[] args) {
		
		for(int h=0;h<2;h++) { //Run Twice to get average
			
			//Reset counters
			algoChecks[0] = 0;
			algoChecks[1] = 0;
			algoChecks[2] = 0;
			algoChecks[3] = 0;
			
			Random rand = new Random();
			int[] selSort = new int[SIZE];
			int[] bubSort = new int[SIZE];
			int[] merSort = new int[SIZE];
			int[] quiSort = new int[SIZE];
			
			for(int i = 0; i < SIZE; i++) {//Populate the array
				int randomNums = rand.nextInt(1000);
				selSort[i] = randomNums;
				bubSort[i] = randomNums;
				merSort[i] = randomNums;
				quiSort[i] = randomNums;
			}


			//Selection sort checker
			System.out.println("Original array: ");
			printArray(selSort);
			System.out.println();
			System.out.println("Implementing Selection Sort");
			selectionSort(selSort);
			System.out.println("No of checks for Selection Sort: " + algoChecks[0]);
			totalSelSort +=  algoChecks[0];
			System.out.println("After Selection Sort: ");
			printArray(selSort);
			System.out.println();
			System.out.println("------------------------------------------------------");

			System.out.println("Original array: ");
			printArray(bubSort);
			System.out.println();
			System.out.println("Implementing Bubble Sort");
			bubbleSort(bubSort);
			System.out.println("No of checks for Bubble Sort: " + algoChecks[1]);
			totalBubSort += algoChecks[1];
			System.out.println("After Bubble Sort: ");
			printArray(bubSort);
			System.out.println();
			System.out.println("------------------------------------------------------");

			System.out.println("Original array: ");
			printArray(merSort);
			System.out.println();
			System.out.println("Implementing Merge Sort");
			mergeSort(merSort);
			System.out.println("No of checks for Merge Sort: " + algoChecks[2]);
			totalMerSort +=  algoChecks[2];
			System.out.println("After Merge Sort: ");
			printArray(merSort);
			System.out.println();
			System.out.println("------------------------------------------------------");

			System.out.println("Original array: ");
			printArray(quiSort);
			System.out.println();
			System.out.println("Implementing Quick Sort");
			quickSort(quiSort, 0, 999);
			System.out.println("No of checks for Quick Sort: " + algoChecks[3]);
			totalQuiSort +=  algoChecks[3];
			System.out.println("After Quick Sort: ");
			printArray(quiSort);
			System.out.println();
			System.out.println("------------------------------------------------------");

		}
		
		System.out.println("**************************************************************");
		System.out.println("Average number of Selection Sort Checks: " + (totalSelSort/2));
		System.out.println("Average number of Bubble Sort Checks: " + (totalBubSort/2));
		System.out.println("Average number of Merge Sort Checks: " + (totalMerSort/2));
		System.out.println("Average number of Quick Sort Checks: " + (totalQuiSort/2));


	}

	//Selection Sort Method
	public static void selectionSort(int[] a) {

		for(int i=0; i<a.length; i++) {
			int smallIndex = i;
			for(int j=i+1; j<a.length; j++) {
				algoChecks[0] = algoChecks[0] + 1;
				if(a[j] < a[smallIndex])//We found a smaller value
					smallIndex = j;
			}
			if(smallIndex != i) {//Swap because found a smaller value
				int temp = a[i];
				a[i] = a[smallIndex];
				a[smallIndex] = temp;
			}
		}

	}

	//Bubble Sort Method
	public static void bubbleSort(int[] a) {
		boolean hasSwapped = true;
		while(hasSwapped) {
			hasSwapped = false;
			for(int i=0; i<a.length-1; i++) {
				algoChecks[1] = algoChecks[1] + 1;
				if(a[i] > a[i+1]) {//Swap
					int temp = a[i];
					a[i] = a[i+1];
					a[i+1] = temp;
					hasSwapped = true;

				}

			}
		}

	}

	//Merge Sort Method
	public static void mergeSort(int[] a) {
		int size = a.length;
		if(size<2) {
			return;
		}
		int mid = size/2; // recall integer division
		int leftSize = mid;
		int rightSize = size - mid;
		int[] left = new int[leftSize];
		int[] right = new int[rightSize];

		for(int i=0; i<mid; i++) {//populate the left
			left[i] = a[i];
		}
		for(int i=mid; i<size;i++) {
			right[i-mid] = a[i]; //mid - mid = 0
		}
		mergeSort(left);
		mergeSort(right);
		//TODO merge
		merge(left, right, a);
	}

	private static void merge(int[] left, int[] right, int[] a) {
		int leftSize = left.length;
		int rightSize = right.length;
		int i = 0;// Left Array index
		int j = 0;// Right Array index
		int k = 0;// Sorted Array a index

		while(i<leftSize && j<rightSize) {
			algoChecks[2] = algoChecks[2] + 1;
			if(left[i] <= right[j]) {
				a[k] = left[i];
				i++;
				k++;
			}
			else {
				a[k] = right[j];
				j++;
				k++;
			}
		}

		//Both of the next two while loops cant run... One of them will return false if the while loop above did its job we;;
		while(i<leftSize) { //left overs in left side
			a[k] = left[i];
			i++; 
			k++;
		}

		while(j<rightSize) { //left overs in right side
			a[k] = right[j];
			j++;
			k++;
		}
	}

	//Quick Sort Method
	public static void quickSort(int[] a, int leftIndex, int rightIndex) {
		//partition
		int index = partition(a,leftIndex,rightIndex);

		if(leftIndex < index-1)
			quickSort(a,leftIndex,index-1);
		if(index < rightIndex)
			quickSort(a,index,rightIndex);

	}

	private static int partition(int[] a, int leftIndex, int rightIndex) {//Picks the pivot point
		int i = leftIndex;
		int j = rightIndex;

		int pivot = a[(leftIndex+rightIndex)/2];

		while(i<=j) {
			algoChecks[3] = algoChecks[3] + 1;
			while(a[i]<pivot) {//THis loop continually moves i forward until it finds a value less than i
				i++;
			}
			algoChecks[3] = algoChecks[3] + 1;
			while(a[j] > pivot) {
				j--;
			}
			if(i<=j) {//FOund values out of order so swap
				int temp = a[i];
				a[i] = a[j];
				a[j] = temp;
				i++;
				j--;
			}
		}
		return i;
	}

	public static void printArray(int[] a) {
		for(int i = 0; i < a.length; i++) {
			System.out.print(a[i]+", ");
		}
	}
}