
public class LinkedBSTree {
	//Every element has to be comparable in some way
	private class Node{
		private Shape data;
		private Node leftChild;
		private Node rightChild;

		public Node(Shape aShape) {
			data = aShape;
			leftChild = rightChild = null;
		}

		public Node getLeft() {
			return leftChild;
		}
		public Node getRight() {
			return rightChild;
		}
	}
	private Node root; //First element of our tree
	public LinkedBSTree() {
		root = null;
	}
	public void insert (Shape aShape) {
		if(root == null) {
			root = new Node(aShape);
		}
		//TODO recursively add the element
		else {
			insert(root, aShape);
		}
	}
	private Node insert(Node aNode, Shape aShape) {
		if(aNode == null) {
			aNode = new Node(aShape);
		}
		else if(aShape.getArea() > aNode.data.getArea()) {//Go Left
			aNode.leftChild = insert(aNode.leftChild, aShape);
		}
		else if(aShape.getArea() < aNode.data.getArea()) {//Go Right
			aNode.rightChild = insert(aNode.rightChild, aShape);
		}
		return aNode;
	}
	public boolean search(Shape aShape) {
		return search(root,aShape);
	}
	private boolean search(Node aNode, Shape aShape) {
		if(aNode == null) {//Wasn't in the tree
			return false;
		}
		if(aShape.getArea() == aNode.data.getArea()) { //We found it
			return true;
		}
		else if(aShape.getArea() > aNode.data.getArea()) { //Go left
			return search(aNode.leftChild, aShape);
		}
		else { //Go Right
			return search(aNode.rightChild, aShape);
		}
	}

	public void printPreOrder() {
		printPreOrder(root);
	}
	private void printPreOrder(Node aNode) {
		if(aNode == null) {//Hit A Leaf
			return;
		}
		System.out.println(aNode.data);//Access the node
		printPreOrder(aNode.leftChild);//Go Left
		printPreOrder(aNode.rightChild);//Go Right
	}

	public void printInOrder() {
		printInOrder(root);
	}
	private void printInOrder(Node aNode) {
		if(aNode == null)
			return;
		printInOrder(aNode.leftChild);
		System.out.print(aNode.data);
		printInOrder(aNode.rightChild);
	}

	public void printPostOrder() {
		printPostOrder(root);
	}
	private void printPostOrder(Node aNode) {
		if(aNode == null)
			return;
		printPostOrder(aNode.leftChild);
		printPostOrder(aNode.rightChild);
		System.out.println(aNode.data);
	}

	public void delete (Shape aShape) {
		root = delete(root, aShape);
	}
	private Node delete(Node aNode, Shape aShape) {
		//Find the value
		if(aNode == null) { //the value (aData) is not found
			return null;
		}
		if(aShape.getArea() > aNode.data.getArea()) { //Go Left
			aNode.leftChild = delete(aNode.leftChild, aShape);
		}
		else if(aShape.getArea() < aNode.data.getArea()) { //Go Right
			aNode.rightChild = delete(aNode.rightChild, aShape);
		}
		else { //We Found it!! Kill it!!

			//We may or may not have a left child so whatever just return it
			if(aNode.rightChild == null) {
				return aNode.leftChild;
			}
			//We do have a right child but do not have a left
			if(aNode.leftChild == null) {
				return aNode.rightChild;
			}
			//Crap we have two kids
			Node temp = aNode; //Temp points to the node we are deleting
			// point aNode to the smallest value in the right subtree
			aNode = findMinInTree(aNode.rightChild);
			// delete smallest element from right subtree
			aNode.rightChild = deleteMinFromTree(temp.rightChild);
			aNode.leftChild = temp.leftChild; 
		}
		return aNode;
	}
	private Node findMinInTree(Node aNode) {
		if(aNode == null) {
			return null;
		}
		if(aNode.leftChild == null) { //This node is the smallest value
			return aNode;
		}
		else {
			return findMinInTree(aNode.leftChild);
		}
	}
	private Node deleteMinFromTree(Node aNode) {
		if(aNode == null) {
			return null;
		}
		if(aNode.leftChild == null) {
			return aNode.rightChild;
		}
		aNode.leftChild = deleteMinFromTree(aNode.leftChild);
		return aNode;
	}

	public int countNodes(){
		return countNodes(root);
	}

	//countNodes function by passing the root

	private int countNodes(Node aNode){
		if (aNode == null)
			return 0;
		else{
			int count = 1;
			count += countNodes(aNode.getLeft());
			count+= countNodes(aNode.getRight());
			return count;

		}

	}



}



