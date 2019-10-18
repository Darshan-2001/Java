/**
* Linked List Queue
**/
public class LLQueue<T> implements QueueInterface
{
	private class ListNode
	{
		T data;
		ListNode Link;
		
		public ListNode(T aData, ListNode aLink)
		{
			data = aData;
			Link = aLink;
		}
	}
	
	ListNode head;
	ListNode tail;
	
	public LLQueue()
	{
		head = tail = null;
	}
	
	public void enqueue(Object aData)
	{
		ListNode newNode = new ListNode((T)aData,null);
		if(head == null)
		{
			head = newNode;
			tail = head;
			return;
		}
		tail.Link = newNode;
		tail = tail.Link;		
	}
	
	public T dequeue()
	{
		if(head == null)
			return null;
		ListNode ret = head;
		head = head.Link;
		return ret.data;
	}
	
	public T peek()
	{
		if(head == null)
			return null;
		return head.data;
	}
	
	public void print() 
	{
		ListNode temp = head;
		while(temp != null)
		{
			System.out.println(temp.data);
			temp = temp.Link;
		}
	}
	
	
}

