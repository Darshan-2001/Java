
public class ArrayQueue<T> implements QueueInterface{
	private T[] queue;
	private int tailIndex;//Is not actually the last element-it's one after the last element i.e FIrst null
	public static final int DEFAULT_SIZE = 100;
	
	public ArrayQueue()
	{
		this.init(DEFAULT_SIZE);
	}
	
	public ArrayQueue(int size)
	{
		this.init(size);
	}
	
	public void init(int size)
	{
		if(size <= 0) 
			return;
		//queue = new T[size] //This won't work
		queue = (T[])(new Object[size]);//Typecast
		tailIndex = 0;
	}
	
	public void enqueue(Object aData)
	{
		if(tailIndex >= queue.length)//Queue is full
			return;
		queue[tailIndex] = (T)aData;
		tailIndex++;
	}
	
	public T dequeue() 
	{
		T ret = queue[0];
		for(int i = 0; i<tailIndex; i++)
		{
			queue[i] = queue[i+1];
		}
		tailIndex--;
		return ret;
	}
	
	public T peek()
	{
		return queue[0];
	}
	
	public void print()
	{
		for(T elem:queue)
		{
			System.out.println(elem);
		}
	}
	
	
		
	
}









