
public class AdjTester {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		AdjMatrixGraph m = new AdjMatrixGraph();
		System.out.println(" Adding edges");
		m.addEdge(0, 1, 1);
		m.addEdge(0, 3, 1);
		m.addEdge(1, 3, 1);
		m.addEdge(2, 0, 1);
		m.addEdge(2, 4, 1);
		m.addEdge(2, 5, 1);
		m.addEdge(3, 2, 1);
		m.addEdge(3, 4, 1);
		m.addEdge(4, 5, 1);
		m.addEdge(4, 6, 1);
		m.printAdjMatrix();
		System.out.println("DFS");
		m.printDFS();
		System.out.println("BFS");
		m.printBFS();

	}

}
