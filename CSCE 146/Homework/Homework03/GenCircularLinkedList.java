/*
 * Written By Prashant Thirumal
 */
public class GenCircularLinkedList<T> {
	
	private class ListNode{
		private T data;
		private ListNode link;
		
		public ListNode() {
			this.data = null;
			this.link = null;
		}
		public ListNode(T aData, ListNode aLink) {
			this.data = aData;
			this.link = aLink;
		}
	}
	
	private ListNode head; //First element in my Linked List
	private ListNode curr; //Current node of interest
	private ListNode prev; //One node behind the current
	private ListNode tail; //Last element in my Linked List

	public GenCircularLinkedList(){
		head = curr = prev = tail = null;
	}

	//Move current one node forward
	public void goToNext() {
		if(curr.link != null) {
			prev = curr;
			curr = curr.link;
		}
	}

	//Move current one node backward
	public void goToPrev() {
		if(prev == null) {
			return;
		}

		curr = prev;
		ListNode temp = head;
		while(temp.link != prev) {
			temp = temp.link;
		}
		prev = temp;
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
		else {
			return;
		}
	}
	

	public void insert(T aData) {
		ListNode newNode = new ListNode (aData,null);
		if(head == null) { //List is Empty
			head = newNode;
			curr = head;
			prev = head;
			tail = head;
			newNode.link = newNode;
		}
		else {
			newNode.link = tail.link;
			tail.link = newNode;
			tail = newNode;
		}
	}

	public void insertNodeAfterCurrent(T aData) {
		ListNode newNode = new ListNode(aData, null);
		if(head != null) {
			newNode.link = curr.link;
			curr.link = newNode;
		}
	}

	public void deleteCurrentNode() {
		if(head == null){//List is empty
			return;
		}
		prev.link = curr.link;

		if(curr == head){//Current is the head
			head = curr.link; 
		}
		if(curr == tail){//Current is the tail
			tail = prev; 
		}

		curr = curr.link;
	}
	
	public void resetCurrent() {
		curr = head;
		prev = null;
	}

	public void showList() {
		ListNode temp = head;
		while(temp != null){
			System.out.println(temp.data);
			if(temp == tail){
				break; 
			}
			temp = temp.link;
		}
	}

	public boolean inList(T aData) {
		ListNode temp = head;
		while(temp.link != null){
			if(temp.data == aData){
				return true; 
			}
			if(temp == tail){
				break; 
			}
			temp = temp.link;
		}
		return false;
	}


}
