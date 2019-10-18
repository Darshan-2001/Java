//Linked Lists and Generics
//2/1/2018


public class GenLinkedList <T> {
	
	private class ListNode{
		private T data;
		private ListNode link;
		
		public ListNode() { // default constructor
			data = null;
			link = null;
		}
		public ListNode(T aData, ListNode aLink) { // parameterised constructor
			data = aData;
			link = aLink;
		}
	}
	
	private ListNode head; //First Element in the list
	private ListNode curr; //Element of interested used externally
	private ListNode prev; //One node behind current
	
	public GenLinkedList() {
		head = prev = curr = null;
	}
	
	//insert at the end of the list
	public void insert(T aData) {
		
		//Create the node
		ListNode newNode = new ListNode(aData, null);
		if(head == null) {//empty list
			head = newNode;
			curr = head;
			return;
		}
		//List is not empty, traverse to the end of the list and then add Data
		ListNode temp = head;
		while(temp.link != null) {
			temp = temp.link;
		}
		temp.link = newNode; //Adds new node to the end of the list
	}
	
	//print method. Use to check your linked list
	public void print() {
		ListNode temp = head;
		while(temp != null) {
			System.out.println(temp.data);
			temp = temp.link;
		}
	}
	
	//Sort of like an Accessor?
	public T getCurrent() {
		
		if(curr != null) {
			return curr.data;
		}
		else {
			return null;
			
		}
	}
	
	//Sort of like a Mutator?
	public void setCurrent(T aData) {
		
		if(curr != null) {
			curr.data = aData;
		}
		
	}
	
	public void moveCurrentForward() {
		
		if(curr != null) {
			prev = curr;
			curr = curr.link;
		}
		
	}
	
	public void resetCurrent() {
		curr = head;
		prev = null;
	}
	
	public void insertAfterCurrent(T aData) {
		
		ListNode newNode = new ListNode(aData,null);
		if(curr != null) {
			newNode.link = curr.link;
			curr.link = newNode;
		}
		else if(head != null) {
			System.out.println("Current is outside of the list");
		}
		else {
			System.out.println("The list is empty");
		}
		
	}
	
	public void deleteCurrent() {
		
		if(curr != null && prev != null) { //Current is somewhere in the middle or end of the list
			prev.link = curr.link;
			curr = curr.link;
		}
		else if(curr != null && prev == null) {
			head = curr.link; // head = head.link
			curr = head;
		}
		else {
			System.out.println("Current was null...for some reason");
		}
		
	}
	
	public boolean moreToIterate() {
		return curr != null;
	}
	
	
	
}
