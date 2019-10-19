import java.util.Random;

public class WhichSortIsFastest {
	public static int[] algoChecks = {0,0,0,0}; //Array to check to number of times each algorithm has run
	public static final int SIZE = 1000; //Array size will be 1000
	public static final int RUN = 5; //I will have each sort run 5 times
	public static int SSchecks;
	public static int BSchecks;
	public static int MSchecks;
	public static int QSchecks;
	
	public static void main(String[] args) {
		Random rand = new Random();
		int[] selSort = new int[SIZE];
		int[] bubSort = new int[SIZE];
		int[] merSort = new int[SIZE];
		int[] quiSort = new int[SIZE];
		
		int SSavg = 0;
		int BSavg = 0;
		int MSavg = 0;
		int QSavg = 0;
		
		for(int i = 0; i < RUN; i++) {
			for(int j = 0; j < SIZE; j++) { //Populate the array
				int randomNums = rand.nextInt(1000);
				selSort[j] = randomNums;
				bubSort[j] = randomNums;
				merSort[j] = randomNums;
				quiSort[j] = randomNums;
			}


			//Selection sort checker

			selectionSort(selSort);
			System.out.println("No of checks for Selection Sort: " + algoChecks[0]); 
			SSchecks+= algoChecks[0];
			
			bubbleSort(bubSort);
			System.out.println("No of checks for Bubble Sort: " + algoChecks[1]);
			BSchecks += algoChecks[1];
			
			mergeSort(merSort);
			System.out.println("No of checks for Merge Sort: " + algoChecks[2]);
			MSchecks += algoChecks[2];
			
			quickSort(quiSort, 0, 999);
			System.out.println("No of checks for Quick Sort: " + algoChecks[3]);
			QSchecks += algoChecks[3];
		}
		
		SSavg = (SSchecks/RUN);
		BSavg = (BSchecks/RUN);
		MSavg = (MSchecks/RUN);
		QSavg = (QSchecks/RUN);
		
		System.out.println("Average number of Selection Sort checks: "+SSavg+
				"\nAverage number of Bubble sort checks: "+BSavg+
				"\nAverage number of Merge Sort checks: "+MSavg+
				"\nAverage number of Quick Sort checks: "+QSavg);
	}



	public static void selectionSort(int[] a) {

		for(int i=0; i<a.length; i++) {
			int smallIndex = i;
			for(int j=i+1; j<a.length; j++) {
				algoChecks[0] = algoChecks[0] +1;
				if(a[j] < a[smallIndex])//We found a smaller value
					smallIndex = j;
			}
			if(smallIndex != i) {//Swap because found a smaller value
				int temp = a[i];
				a[i] = a[smallIndex];
				a[smallIndex] = temp;
			}
		}


		SSchecks = algoChecks[0];
	}

	public static void bubbleSort(int[] a) {
		boolean hasSwapped = true;
		while(hasSwapped) {
			hasSwapped = false;
			for(int i=0; i<a.length-1; i++) {
				algoChecks[1] = algoChecks[1] +1;
				if(a[i] > a[i+1]) {//Swap
					int temp = a[i];
					a[i] = a[i+1];
					a[i+1] = temp;
					hasSwapped = true;

				}

			}
		}

		BSchecks = algoChecks[1];
	}

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
		//merge
		merge(left, right, a);
	}

	private static void merge(int[] left, int[] right, int[] a) {
		int leftSize = left.length;
		int rightSize = right.length;
		int i = 0;// Left Array index
		int j = 0;// Right Array index
		int k = 0;// Sorted Array a index

		while(i<leftSize && j<rightSize) {
			algoChecks[2] = algoChecks[2]+1;
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
		MSchecks = algoChecks[2];
	}

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
		QSchecks = algoChecks[3];
		return i;
	}

	public static void printArray(int[] a) {
		for(int i = 0; i < a.length; i++) {
			System.out.print(a[i]+" ");
		}
	}
}