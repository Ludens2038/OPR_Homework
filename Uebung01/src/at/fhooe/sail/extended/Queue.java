package at.fhooe.sail.extended;

public class Queue {
	private int[] queue;
	private int size;
	private int top;
	private int bottom;
	private int counter;

	/** Constructor initializes queue with a standard size. */
	public Queue() {
		this.size = 20;
		this.top = 0;
		this.bottom = 0;
		this.counter = 0;
		this.queue = new int[size];
	}

	/** Constructor initializes queue with the given size. */
	public Queue(int size) {
		this.size = size;
		this.top = 0;
		this.bottom = 0;
		this.counter = 0;
		this.queue = new int[size];
	}

	/**
	 * Copy constructor initializes queue with another queue. This constructor must
	 * COPY all elements of the other queue. The elements of the other queue must
	 * NOT be changed!
	 */
	public Queue(Queue other) {
		this.size = other.size;
		this.top = other.top;
		this.bottom = other.bottom;
		this.counter = other.counter;
		this.queue = new int[this.size];
		// fill content of new stack with content of given stack
		for (int i = 0; i < this.size; i++) {
			this.queue[i] = other.queue[i];
		}
	}

	/*
	 * Deinitializes the object. basically the garbage collector. Was used for
	 * cleanup before garbage-collector was introduced.
	 */
	protected void finalize() {
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

	/**
	 * Enqueues all elements from another queue onto this one. If another queue
	 * [4,5] is enqueued into this queue [1,2,3], the result is [1,2,3,4,5] and not
	 * [1,2,3,5,4]. The elements of the other queue must NOT be changed!
	 */
	public void enqueue(Queue other) {
		int totalSpace = this.counter + other.counter;

		if (this.size < totalSpace) {
			int[] newQueue = new int[totalSpace];
			for (int i = 0; i < this.counter; i++) {
				newQueue[i] = this.queue[(this.top + i) % this.size];
			}
			for (int i = 0; i < other.counter; i++) {
				newQueue[this.counter + i] = other.queue[(other.top + i) % other.size];
			}
			this.queue = newQueue;
			this.size = newQueue.length;
			this.top = 0;
			this.bottom = this.size - 1;
			this.counter = this.size;
		} else {
			for (int i = 0; i < other.counter; i++) {
				this.queue[this.bottom] = other.queue[((other.top + i) % other.size)];
				this.bottom = (this.bottom + 1) % this.size;
			}
			this.counter = this.counter + other.counter;
		}
	}

	/**
	 * Clones this Queue instance and returns an exact COPY.
	 */
	public Queue clone() {
		Queue clone = new Queue(this.size);
		clone.top = this.top;
		clone.bottom = this.bottom;
		clone.counter = this.counter;
		clone.queue = new int[this.size];
		for (int i = 0; i < this.size; i++) {
			clone.queue[i] = this.queue[i];
		}
		return clone;
	}

	/**
	 * Returns true if the other queue is equal to this one, false otherwise. The
	 * contents of the two queues must not be changed!
	 */
	public boolean equals(Queue other) {
		if (this.counter != other.counter) {
			return false;
		} else if (this.top != other.top) {
			return false;
		} else if (this.bottom != other.bottom) { //redundant check
			return false;
		} else if (this.size != other.size) {
			return false;
		} else {
			for (int i = 0; i < this.size; i++) {
				if (this.queue[i] != other.queue[i]) {
					return false; //do not understand why JUnit test skips this, bc it 
				}
			}
		}
		return true;
	}

	/** Dequeues the element at the front of the queue */
	public int dequeue() {
		if (counter == 0) {
			return Integer.MIN_VALUE;
		}
		int dequeued = queue[top];
		top = (top + 1) % queue.length;
		counter--;
		return dequeued;
	}

	/** Returns the front element of the queue without removing it */
	public int peek() {
		if (counter == 0) {
			return Integer.MIN_VALUE;
		}
		return queue[top];
	}

	/**
	 * Returns true if the element val exists in the stack, false otherwise.
	 */
	public boolean search(int val) {
		for (int i = 0; i < this.counter; i++) {
			if (this.queue[(top + i) % size] == val) {
				return true;
			}
		}
		return false;
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
			System.out.print(queue[(top + i) % size] + " ");
		}
		System.out.println();
	}

	/**
	 * Returns a string representation of the queue.
	 */
	public String toString() {
		StringBuilder builder = new StringBuilder();
		for (int i = 0; i < counter; i++) {
			builder.append("[" + (queue[(top + i) % size]) + "] ");
		}
		return builder.toString();
	}

}
