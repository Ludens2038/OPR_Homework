package at.fhooe.sail.mc.Aufgabe01;

import at.fhooe.sail.mc.Aufgabe01Exceptions.InvalidAccessException;
import mc.opr.dll.MyDoubleLinkedList;

public class ListQueue extends MyDoubleLinkedList {
	/** Initializes an empty queue. */
	public ListQueue() {
		super();
	}

	/**
	 * Copy constructor which initializes the queue with another queue. This
	 * constructor must COPY all elements of the other queue.
	 */
	public ListQueue(ListQueue other) {
		int elements = other.elements();
		for (int i = 0; i < elements; i++) {
			this.enqueue(other.peekElementAt(i));
		}
	}

	/** Enqueues an element at the back of the queue. */
	public void enqueue(int val) {
		super.pushBack(val);
	}

	/** Dequeues the element at the front of the queue. */
	public int dequeue() throws InvalidAccessException {
		if (elements() == 0) {
			helpThrowing();
		}
		return super.popFront();
	}

	/** Returns the front element of the queue without removing it. */
	public int peek() throws InvalidAccessException {
		if(elements() == 0) {
			helpThrowing();
		}
		return super.peekFront();
	}
	
	private void helpThrowing() throws InvalidAccessException {
		throw new InvalidAccessException("Queue is empty");
	}
}
