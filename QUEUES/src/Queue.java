// Reyes, Christian Joseph A.
// 2csa-25
// Lab Exercise 8
// Queues
//

public class Queue<T>
{
	private final int DEFAULT_CAPACITY = 100;
	private int front, rear, count;
	private T[] queue;

	public Queue()
	{
		front = rear = count = 0;
		queue = (T[]) (new Object[DEFAULT_CAPACITY]);
	}

	public void enqueue (T element)
	{
		if (size() == queue.length)
			throw new RuntimeException ("Queue Overflow");
		queue[rear] = element;
		rear = (rear+1) % queue.length;
		count++;
	}

	public T dequeue()
	{
		if (isEmpty())
			throw new RuntimeException ("Queue Underflow");
		T output = queue[front];
		queue[front] = null;
		front = (front+1) % queue.length;
		count--;
		return output;
	}
	
	public T first()
	{
		if (isEmpty())
			throw new RuntimeException ("Queue Underflow");
		return queue[front];
	}

	public boolean isEmpty()
	{
		return (count == 0);
	}

	public int size()
	{
		return count;
	}

	public String toString()
	{
		String output = "";
		int scan = front;
		
		while (scan < rear)
		{
			if (queue[scan]!=null)
			{
				output += queue[scan].toString()+" ";
			}
		scan++;
		}
		return output;
	}
}