import java.util.*;

public class AdjMatrixGraph {
	private double[][] adjMatrix;
	public static final int DEFAULT_VERT_AMT = 10;
	private ArrayList<Integer> markedList;
	private Queue<Integer> vQ;
	
	public AdjMatrixGraph() {
		init(DEFAULT_VERT_AMT);
	}
	public AdjMatrixGraph(int size) {
		init(size);
	}
	private void init(int size) {
		if(size <= 0) {
			return;
		}
		adjMatrix = new double[size][size];
		markedList = new ArrayList<Integer>(); //Construct this if not a null pointer exception
		vQ = new LinkedList<Integer>();
	}
	
	public void addEdge(int fromVert, int toVert, double weight) {
		if(!isValidIndex(fromVert) || !isValidIndex(toVert))
			return;
		adjMatrix[fromVert][toVert] = weight;
	}
	private boolean isValidIndex(int index) {
		return index >= 0 && index <adjMatrix.length;
	}
	
	public void printAdjMatrix() {
		for(int i=0; i<adjMatrix.length;i++) {
			for(int j=0; j<adjMatrix[i].length; j++) {
				System.out.print(adjMatrix[i][j]  + "|");
			}
			System.out.println();
		}
	}
	
	public void printDFS() {
		markedList.clear();
		printDFS(0);
	}
	private void printDFS(int index) {
		System.out.println(index);
		markedList.add(index);
		for(int i=0; i<adjMatrix[index].length; i++) {
			if(adjMatrix[index][i] != 0 && !markedList.contains(i))
				printDFS(i);
		}
	}
	
	public void printBFS() {
		markedList.clear();
		vQ.clear();
		markedList.add(0);
		vQ.add(0);
		System.out.println(0);
		printBFS(0); 
	}
	private void printBFS(int index) {
		while(!vQ.isEmpty()) {
			int currI = vQ.remove();
			markedList.add(currI);
			for(int i=0; i<adjMatrix[index].length; i++) {
				if(!markedList.contains(i) && !vQ.contains(i) && adjMatrix[currI][i] !=0 ) {
					System.out.println(i);
					vQ.add(i);
				}
			}
		}
	}
		

}
