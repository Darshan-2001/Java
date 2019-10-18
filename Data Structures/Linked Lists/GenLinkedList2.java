//2/6/2018
public class GenLinkedList2 <T> {
	
	private class ListNode{
		
		private T data;
		private ListNode link;
		
		public ListNode() {
			data = null;
			link = null;
		}
		
		public ListNode(T aData, ListNode aLink) {
			data = aData;
			link = aLink;
		}
	}
	
	private ListNode head; //First Element
	private ListNode curr; //Used outside of the LL to access and modify info
	private ListNode prev;//One behind current
	
	public GenLinkedList2() {
		head = curr = prev = null;
	}
	
	//Inserts at the end of the list
	public void insert(T aData) {
		//Create an instance of Node
		ListNode newNode = new ListNode(aData, null) ;
		
		if(head == null) {//Empty List
			head = newNode;
			curr = null;
			return;
		}
		
		//The list isn't empty
		ListNode temp = head;  //**Get this concept** Don't do this for current
		while(temp.link != null) {
			temp = temp.link;
		}
		temp.link = newNode;
	}
	
	public void print() {
		
		ListNode temp = head;
		
		while(temp != null) {
			System.out.println(temp.data);
			temp = temp.link;
		}
		
	}
	
	//Kind of a getter
	public T getCurrent() {
		
		if( curr != null) {
			return curr.data;
		}
		else {
			return null;
		}
	}
	
	//Kind of a setter
	public void setCurrent(T aData) {
		if(curr != null) {
			curr.data = aData;
		}
	}
	
	public void moveCurrentForward() {
		if(curr == null) {
			return;
		}
		prev = curr;
		curr = curr.link;
	}
	
	public void resetCurrent() {
		curr = head;
		prev = null;
	}
	
	public boolean moreToIterate() {
		return curr != null;
	}
	
	public void insertAfterCurrent(T aData) {
		ListNode newNode = new ListNode(aData, null);
		if(curr != null) {
			newNode.link = curr.link;
			curr.link = newNode;
		}	
	}
	
	public void deleteCurrent() {
		if(curr != null && prev != null) {
			prev.link = curr.link;
			curr = curr.link;
		}
		else if(curr != null && prev == null) { //Current is the head
			head = head.link; //head = curr.link
			curr = head;
		}
	}
	

}
