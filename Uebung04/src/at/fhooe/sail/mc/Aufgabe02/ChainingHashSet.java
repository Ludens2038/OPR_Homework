package at.fhooe.sail.mc.Aufgabe02;

public class ChainingHashSet {
	/**
	 * Array which stores overflow lists that are indexed by the hash code of their
	 * elements.
	 */
	private RandomAccessDoubleLinkedList[] array;

	// helper method to get hashcode
	private int getHashcode(int val) {
		return val % this.array.length;
	}

	/**
	 * Initializes an empty hashtable with the given number of overflow lists.
	 */
	public ChainingHashSet(int indexSize) {
		array = new RandomAccessDoubleLinkedList[indexSize];
	}

	/**
	 * Inserts a new element val into the hashtable (hashcode = val % array.length),
	 * if it did not exist in the table before. Returns true if a new element was
	 * inserted, false if it already existed.
	 */
	public boolean insert(int val) {
		// calling contains method in RandomAccessDoubleLinkedList and returning false
		// if it is true
		if (this.contains(val)) {
			return false;
		} else {
			// calculating hashcode
			int hashcode = this.getHashcode(val);
			// checking if content of array is empty
			if (this.array[hashcode] == null) {
				// creating new RandomAccessDoubleLinkedList
				this.array[hashcode] = new RandomAccessDoubleLinkedList();
				// inserting value at index 0
				this.array[hashcode].insertAt(0, val);
				return true;
			} else {
				// if array is not empty, insert value at the end of the list
				this.array[hashcode].insertAt(this.array[hashcode].size(), val);
				return true;
			}
		}
	}

	/**
	 * Returns true if the given value is already stored in the hashtable, false
	 * otherwise.
	 */
	public boolean contains(int val) {
		if (this.array[this.getHashcode(val)] == null) {
			return false;
		}
		// call method of RandomAccessDoubleLinkedList to check if val is in the list
		if (this.array[this.getHashcode(val)].contains(val)) {
			return true;
		} else {
			return false;
		}
	}

	/**
	 * Removes the given element from the hashtable if it exists. Returns true if an
	 * element was removed, false if no such element existed.
	 */
	public boolean remove(int val) {
		// check if value is in the list
		if (this.contains(val)) {
			// call remove method of RandomAccessDoubleLinkedList
			return this.array[this.getHashcode(val)].removeAll(val);
		}
		return false;
	}

	/**
	 * Counts the amount of values, which are stored in the same overflow list
	 */
	public int getOverflowCount(int hashVal) {
		// check if hashVal is out of bounds
		if (hashVal < 0) {
			return Integer.MIN_VALUE;
		} else if (hashVal >= this.array.length) {
			return Integer.MIN_VALUE;
		// check if array is empty
		} else if (this.array[hashVal] == null) {
			return 0;
		} else {
			// return size of the list
			return this.array[hashVal].size();
		}
	}

	/**
	 * Counts the amount of elements in the hashtable by adding the amount of
	 * elements in each overflow list.
	 */
	public int elements() {
		int elements = 0;
		// iterate over array and add the size of each list
		for (int i = 0; i < array.length; i++) {
			elements += this.getOverflowCount(i);
		}
		return elements;
	}
}
