package at.fhooe.sail.basic;

public class Queue {
	private int[] queue;
	private int size;
	private int top;
	private int bottom;
	private int counter;

	/** Initializes the queue instance */
	public void initQueue(int size) {
		this.size = size;
		this.queue = new int[size];
		this.top = 0;
		this.bottom = 0;
		this.counter = 0;
	}

	/** Clears all elements from the queue */
	public void clear() {
		counter = 0;
		top = 0;
		bottom = 0;
	}

	/** Enqueues an element at the back of the queue */
	public void enqueue(int val) {
		if (counter != size) {
			if (bottom > (queue.length - 1)) {
				bottom = 0;
			}
			queue[bottom] = val;
			counter++;
			bottom++;
		}
	}

	/** Dequeues the element at the front of the queue */
	public int dequeue() {
		if (top < (queue.length - 1)) {
			top = top + 1;
			counter--;
			return queue[top - 1];
		} else {
			top = 0;
			counter--;
			return queue[queue.length - 1];
		}
	}

	/** Returns the front element of the queue without removing it */
	public int peek() {
		if (counter == 0) {
			return Integer.MIN_VALUE;
		}
		return queue[top];
	}

	/** Returns the number of elements in the queue */
	public int elements() {
		return counter;
	}

	/** Returns the maximum size of the queue */
	public int size() {
		return queue.length;
	}

	/** Prints all elements in the queue */
	public void print() {
		for (int i = 0; i < counter; i++) {
			System.out.print("[" + queue[(top + i) % size] + "] ");
		}
		System.out.println();
	}

}
