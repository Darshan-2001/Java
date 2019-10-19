
public class ArrBinHeap<T extends Comparable<T>> {
	private T[] heap;
	private int lastIndex; //points to the first null element
	public static final int DEFAULT_SIZE = 128; //128 is a factor of 2

	public ArrBinHeap() {
		init(DEFAULT_SIZE);
	}
	public ArrBinHeap(int size) {
		init(size);
	}
	public void init(int size) {
		if(size > 0) {
			heap = (T[])(new Comparable[size]);
			lastIndex = 0;
		}
	}

	public void insert(T aData) { //Programming Question on Tests
		if(lastIndex >= heap.length)
			return; //Heap was full
		heap[lastIndex] = aData;
		bubbleUp();
		lastIndex++;
	}
	private void bubbleUp() {
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

	public T remove() {
		T temp = peek();
		heap[0] = heap[lastIndex-1];
		heap[lastIndex-1] = null;
		lastIndex--;
		bubbleDown();
		return temp;
	}
	private void bubbleDown() {
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
		int currIndex = lastIndex;
		for(int i=0; i<lastIndex; i++) {
			System.out.println(this.remove());
		}
	}
	
	/*
	 * public void heapSort(){
	 * T[] heap2 = heap.clone;
	 * int currIndex = lastIndex;
	 * for(int i=0; i<currIndex; i++)
	 *  System.out.println(this.remove());
	 * heap = heap2;
	 * lastIndex = currIndex
	 */

}
