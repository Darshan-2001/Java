

/*
 * Written By Prashant Thirumal
 */
public class GenDoubleLinkedList <T> {
	
	private class ListNode {
		private T data;
		private ListNode nextLink;
		private ListNode prevLink;
		
		public ListNode() { // default constructor
			data = null;
			nextLink = null;
			prevLink = null;
		}
		public ListNode(T aData, ListNode aLink, ListNode bLink) { // Parameterized constructor
			data = aData;
			nextLink = aLink;
			prevLink = bLink;
		}
		
	}
	
	private ListNode head; //First Element in the list
	private ListNode curr; //Element of interested used externally
	private ListNode prev; //One node behind current
	private ListNode next; //One node after current
	
	public GenDoubleLinkedList() {
		head = prev = curr = null;
	}
	
	public void insert(T aData) {
		ListNode newNode = new ListNode(aData, null, null);
		// Create the node
		if (head == null) {
			head = newNode;
			curr = head;
			return;
		}
		// List is not empty, go to the end of the list and add the Data
		ListNode temp = head;
		while (temp.nextLink != null) {// keeps going while the next node is not empty
			temp = temp.nextLink;
		}
		temp.nextLink = newNode;
		newNode.prevLink = temp;
	}
	
	public void goToNext() {
		if(curr.nextLink != null) {
			prev = curr;
			curr = curr.nextLink;
		}		
	}
	
	public void goToPrev() {
		if(curr.prevLink != null) {
			next = curr; //Continuously repeat
			curr = curr.prevLink;
		}
	}
	
	public T getDataAtCurrent() {
		if(curr != null) {
			return curr.data;
		}
		else {
			return null;
		}
	}
	
	public void setDataAtCurrent(T aData) {
		if(curr != null) {
			curr.data = aData;
		}
	}
	
	public void insertNodeAfterCurrent(T aData) {
		ListNode newNode = new ListNode(aData,null,null);
		if(curr != null) {
			newNode.nextLink = curr.nextLink;
			curr.nextLink.prevLink = newNode;
			curr.nextLink = newNode;
			newNode.prevLink = curr;
		}
		else if(head != null) {
			System.out.println("Current is outside of the list");
		}
		else {
			System.out.println("The list is empty");
		}
	}
	
	public void deleteCurrentNode() {
		if(curr != null && curr.nextLink != null && curr.prevLink != null) { //Current is somewhere in the middle of the list
			curr.prevLink.nextLink = curr.nextLink;
			curr.nextLink.prevLink = curr.prevLink;
		}
		else if(curr != null && curr.nextLink != null && curr.prevLink == null) { //Delete the head
			head = curr.nextLink; //Current becomes the new head
			curr = head;
			head.prevLink = null; //Removes the link before the node
		}
		else if(curr != null && curr.nextLink == null && curr.prevLink != null) { // Current is the tail 
			curr.prevLink.nextLink = null;
		}
		else if(curr != null && curr.nextLink == null && curr.prevLink == null) { // Current is the only node in the list
			curr = null;
		}
		else {
			System.out.println("Current was null...for some reason");
		}
	}
	
	public void showList() {
		ListNode temp = head;
		while(temp != null) {// list is not empty
			System.out.println(temp.data);
			temp = temp.nextLink;
		}
	}
	
	public boolean inList(T aData) {
		boolean checker = false;
		ListNode temp = head;
		while(temp != null) {//the list isn't empty
			if(aData.equals(temp.data)) {
				checker = true;
			}
			temp = temp.nextLink;
			}
		return checker;
		}


}
