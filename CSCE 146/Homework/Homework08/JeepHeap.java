/*
 * Written By Prashant Thirumal
 */

public class JeepHeap<T extends Comparable<T>> {
	private T[] heap;
	private int lastIndex; //points to the first null element
	public static final int DEFAULT_SIZE = 128; //128 is a factor of 2

	public JeepHeap() {
		init(DEFAULT_SIZE);
	}
	public JeepHeap(int size) {
		init(size);
	}
	public void init(int size) {
		if(size > 0) {
			heap = (T[])(new Comparable[size]);
			lastIndex = 0;
		}
	}

	public void addJeep(T aData) { //Programming Question on Tests
		if(lastIndex >= heap.length)
			return; //Heap was full
		heap[lastIndex] = aData;
		DriveUp();
		lastIndex++;
	}
	private void DriveUp() {
		int currIndex = lastIndex;
		while(currIndex > 0 && heap[(currIndex-1)/2].compareTo(heap[currIndex]) < 0 ) {//If currIndex = 0 that means it is at the root
			//Swap
			int parentIndex = (currIndex-1)/2;
			T temp = heap[parentIndex];
			heap[parentIndex] = heap[currIndex];
			heap[currIndex] = temp;
			currIndex = parentIndex;
		}
	}

	public T peek() {
		if(heap == null)
			return null;
		return heap[0];
	}

	public T removeJeep() {
		T temp = peek();
		heap[0] = heap[lastIndex-1];
		heap[lastIndex-1] = null;
		lastIndex--;
		DriveDown();
		return temp;
	}
	private void DriveDown() {
		int currIndex = 0;
		while(currIndex*2+1 < lastIndex) {
			int bigIndex = currIndex*2+1; //Assumes the left is the largest
			if(currIndex*2+2 < lastIndex && heap[currIndex*2+1].compareTo(heap[currIndex*2+2]) < 0) 
				bigIndex = currIndex*2+2; //Actually right child was larger
			if(heap[currIndex].compareTo(heap[bigIndex]) < 0) {
				//Parent was less than larger child so swap
				T temp = heap[currIndex];
				heap[currIndex]=heap[bigIndex];
				heap[bigIndex] = temp;
			}
			else
				break; //No swap so stop
			currIndex = bigIndex;
		}
	}

	public void heapSort() {
		T[] heap2 = heap.clone();
		int currIndex = lastIndex;
		for(int i = 0; i < currIndex; i++)
			System.out.println(this.removeJeep());
		heap = heap2;
		lastIndex = currIndex;
	}

	public void JeepRollCall() {
		for(int i=0; i<heap.length; i++) {
			if(heap[i] != null)
				System.out.println(heap[i].toString());
			else
				continue;
		}
	}


}
