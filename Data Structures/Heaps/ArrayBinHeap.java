
public class ArrayBinHeap<T extends Comparable<T>> {
	private T[] heap;
	public static final int DEFAULT_SIZE = 120;
	private int lastIndex; //First null value
	
	public ArrayBinHeap() {
		init(DEFAULT_SIZE);
	}
	public ArrayBinHeap(int size) {
		init(size);
	}
	public void init(int size) {
		if(size > 0) {
			heap = (T[])(new Comparable[size]);
		lastIndex = 0;
		}
	}
	public void insert(T aData) {
		if(lastIndex >= heap.length)
			return;
		heap[lastIndex] = aData;
		
		lastIndex++;
	}
	private void bubbleUp() {
		//Keeps track of the index of the newly inserted item
		int currIndex = lastIndex;
		while(currIndex > 0 && heap[(currIndex - 1)/2].compareTo(heap[currIndex]) <0) {
			//Swap
			T temp = heap[(currIndex - 1)/2];
			heap[(currIndex - 1)/2] = heap[currIndex];
			heap[currIndex] = temp;
			currIndex = (currIndex - 1)/2;
		}
	}
	
	public T peek() {
		if(heap == null)
			return null;
		return heap[0];
	}
	
	public T remove() {
		if(heap == null)
			return null;
		T retVal = heap[0];
		heap[0] = heap[lastIndex - 1];
		heap[lastIndex - 1] = null;
		lastIndex --;
		//bubble down
		bubbleDown();
		return retVal;
	}
	private void bubbleDown() {
		int currIndex = 0;
		
		while(currIndex*2 + 1 < lastIndex) {
			int bigIndex = currIndex*2+1; //Assumes left child is the largest
			if(currIndex*2+2 < lastIndex && heap[currIndex*2+1].compareTo(heap[currIndex*2+2]) <0) {
				bigIndex = currIndex*2+2;
			}
			//Compare parents with largest child
			if(heap[currIndex].compareTo(heap[bigIndex])< 0) {
				//SWAP
				T temp = heap[currIndex];
				heap[currIndex] = heap[bigIndex];
				heap[bigIndex] = temp;
			}
			else //It was in the right position so stop
				break;
			currIndex = bigIndex;
		}
	}
	
	public void heapSort() {
		/*
		 * Do not do this:
		 * ArrayBinHeap heap2 = this;
		 * T[] heap2 = heap;
		 * It is a shallow copy that refers to the same memory address
		 * 
		 */
		T[] heap2 = heap.clone();
		for(int i=0; i<lastIndex; i++) {
			System.out.println(this.remove());
		}
		for(int i=0; i<heap2.length; i++) {
			heap[i] = heap2[i];
		}
	}
	
	
}
