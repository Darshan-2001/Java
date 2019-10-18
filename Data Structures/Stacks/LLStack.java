
public class LLStack<T> implements StackInterface<T> {
	
	private class ListNode {
		private T data;
		private ListNode link;
		
		public ListNode(T aData, ListNode aLink) {
			data = aData;
			link = aLink;
		}
		
	}
	
	private ListNode head;//First Element so last one pushed in 
	
	public LLStack() {
		head = null;
	}
	
	public void push(T aData) {
		ListNode newNode = new ListNode(aData, head);
		head = newNode;
	}
	
	public T pop() {
		if(head == null) {
			return null;
		}
		T ret = head.data;
		head = head.link;
		return ret;
	}
	
	public T peek() {
		if (head == null) {
			return null;
		}
		return head.data;
	}
	
	public void print() {
		ListNode temp = head;
		while(temp != null) {
			System.out.println(temp.data);
			temp = temp.link;
		}
	}

}
