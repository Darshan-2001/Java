/**
 * 
 * @author Prashant
 * March 6 2018
 */

public class SortingAlgorithms {

	public static void main(String[] args) {
		
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
	
	public static void quickSort(int[] a, int leftIndex, int rightIndex) {
		//TODO partition
		int index = partition(a, leftIndex, rightIndex);
		if(leftIndex < index - 1) {
			quickSort(a, leftIndex, index-1);
		}
		if(index < rightIndex) {
			quickSort(a,index,rightIndex);
		}
		
	}
	private static int partition(int[] a, int leftIndex, int rightIndex) {
		int i = leftIndex;
		int j = rightIndex;
		int pivot = a[(leftIndex +rightIndex)/2];
		while(i<=j) {
			while(a[i] < pivot) {
				i++;
			}
			while(a[j] > pivot) {
				j--;
			}
			if(i<=j) {//Found values out of order so swap
				int temp = a[i];
				a[i] = a[j];
				a[j] = temp;
				i++;
				j--;
			}
		}
		return i;
	}
}
