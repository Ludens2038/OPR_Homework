package at.fhooe.sail.mc.Aufgabe01;

import java.util.ArrayList;

import at.fhooe.sail.mc.Aufgabe01Exceptions.*;

@SuppressWarnings("serial")
public class RandomAccessDoubleLinkedList extends ArrayList<Integer> {
	/** Initializes an empty list. */
	public RandomAccessDoubleLinkedList() {
		// calling existing method of superclass
		super();

	}

	/**
	 * Copy constructor which initializes the list with another list. This
	 * constructor must COPY all elements of the other list.
	 */
	public RandomAccessDoubleLinkedList(RandomAccessDoubleLinkedList other) {

		// calling existing method of superclass
		super(other);
	}

	/**
	 * Inserts a new element with value val at the given index. If the index is
	 * larger than the current size, the element is added at the last position in
	 * the list. Should index be < 0, then do nothing.
	 */
	public void insertAt(int index, int val) throws InvalidAccessException {
		if (index < 0) {
			helpThrowing();
		}
		if (index >= super.size()) {
			/*
			 * calling existing method in superclass, that adds the value at the end of the
			 * list
			 */
			super.add(val);
			/*
			 * calling existing method in superclass, in case given index exists
			 */
		} else {
			super.add(index, val);
		}

	}

	/**
	 * Returns true if an element with the given value exists, false otherwise.
	 * However, true is returned upon the first occurrence of val.
	 */
	public boolean contains(int val) {
		// call method of superclass
		return super.contains(val);
	}

	/**
	 * Removes the element at the given index. False if index > list’s size.
	 */
	public boolean removeAt(int index) throws InvalidAccessException {
		// check if index is out of bounds
		if (index < 0 || index >= super.size()) {
			helpThrowing();
		}
		/*
		 * calls existing method in superclass
		 */
		super.remove(index);
		return true;
	}

	/**
	 * Removes all elements with the given value. False if val was not found.
	 */
	public boolean removeAll(int val) {
		// boolean set for return
		boolean found = false;
		/*
		 * loop calls get method of superclass and compares it with val if found call
		 * remove from superclass set found to true afterwards return boolean
		 */
		for (int i = 0; i < this.size(); i++) {
			if (super.get(i).equals(val)) {
				super.remove(i);
				return found = true;
			}
		}
		return found;
	}

	/**
	 * Returns the integer value at the given index. If index > list’s size,
	 * Integer.MIN_VALUE is returned.
	 */
	public int elementAt(int index) throws InvalidAccessException {
		if (index >= super.size() || index < 0) {
			helpThrowing();
		}
		return super.get(index);
	}

	private void helpThrowing() throws InvalidAccessException {
		throw new InvalidAccessException("Invalid index");
	}

	/*
	 * Research why to use ArrayList instead of LinkedList
	 * 
	 * ArrayList is faster than LinkedList because it uses an array to store
	 * elements, LinkedList uses a doubly linked list to store elements. We build an
	 * ArrayList because we need to access elements by index and the HashSet for
	 * quick access to elements. Even though deleting or inserting elements is
	 * faster in a LinkedList, we don't need this functionality in our case. Because
	 * HashSet is used for quick access.
	 */
}
