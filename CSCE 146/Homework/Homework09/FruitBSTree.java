

public class FruitBSTree {
	//Every element has to be comparable in some way
	private class Node{
		private Fruit data;
		private Node leftChild;
		private Node rightChild;

		public Node(Fruit aFruit) {
			data = aFruit;
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
	public FruitBSTree() {
		root = null;
	}
	public void insert (Fruit aFruit) {
		if(root == null) {
			root = new Node(aFruit);
		}
		//TODO recursively add the element
		else {
			insert(root, aFruit);
		}
	}
	private Node insert(Node aNode, Fruit aFruit) {
		if(aNode == null) {
			aNode = new Node(aFruit);
		}
		else if(aFruit.getWeight() > aNode.data.getWeight()) {//Go Right
			aNode.rightChild = insert(aNode.rightChild, aFruit);
		}
		else if(aFruit.getWeight() < aNode.data.getWeight()) {//Go Left
			aNode.leftChild = insert(aNode.leftChild, aFruit);
		}
		return aNode;
	}
	public boolean search(Fruit aFruit) {
		return search(root,aFruit);
	}
	private boolean search(Node aNode, Fruit aFruit) {
		if(aNode == null) {//Wasn't in the tree
			return false;
		}
		if(aFruit.getWeight() == aNode.data.getWeight()) { //We found it
			return true;
		}
		else if(aFruit.getWeight() > aNode.data.getWeight()) { //Go left
			return search(aNode.rightChild, aFruit);
		}
		else { //Go Right
			return search(aNode.leftChild, aFruit);
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
		System.out.println(aNode.data);
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

	public void delete (Fruit aFruit) {
		root = deleting(root, aFruit);
	}
	private Node deleting(Node aNode, Fruit aFruit) {
		//Find the value
		if(aNode == null) { //the value (aData) is not found
			return null;
		}
		if(aFruit.getWeight() > aNode.data.getWeight()) { //Go Right
			aNode.rightChild = deleting(aNode.rightChild, aFruit);
		}
		else if(aFruit.getWeight() < aNode.data.getWeight()) { //Go Left
			aNode.leftChild = deleting(aNode.leftChild, aFruit);
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


}



