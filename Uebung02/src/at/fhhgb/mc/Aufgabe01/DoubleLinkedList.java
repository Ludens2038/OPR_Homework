package at.fhhgb.mc.Aufgabe01;

public class DoubleLinkedList {

	/** Pointer to the first and last element of the list */
	private DLNode head, tail;

	private int indexList = -1;

	/** Constructor initializes an empty list. */
	public DoubleLinkedList() {
		head = null;
		tail = null;
	}

	/** Clears all elements from the linked list */
	public void clear() {
		head = null;
		tail = null;
		indexList = -1; // if object is added index starts wit zero
	}

	/** Adds an element at the front of the linked list. */
	public void prepend(int val) {
		DLNode n = new DLNode();
		n.val = val;

		// in case list is empty
		if (head == null) {
			head = n;
			tail = n;
			indexList++;

			// in case list is not empty
		} else {
			head.prev = n;
			head.prev.next = head;
			head = n;
			indexList++;
		}
	}

	/** Adds an element at the back of the linked list. */
	public void append(int val) {
		DLNode n = new DLNode();
		n.val = val;

		// in case list is empty
		if (head == null) {
			head = n;
			tail = n;
			indexList++;

			// in case list is not empty
		} else {
			tail.next = n;
			tail.next.prev = tail;
			tail = n;
			indexList++;
		}
	}

	/**
	 * Returns the element at position ‘index’. Returns Integer.MIN_VALUE if ‘index’
	 * is invalid.
	 */
	public int get(int index) {
		// in case list is empty
		if (head == null) {
			return Integer.MIN_VALUE;

			// in case given index is invalid
		} else if (index < 0 || index > indexList) {
			return Integer.MIN_VALUE;

			// in case list is not empty and index is valid
		} else {
			DLNode getIndex = head;
			for (int i = 0; i < index; i++) {
				getIndex = getIndex.next;
			}
			return getIndex.val;
		}
	}

	/**
	 * Removes and returns the front element of the linked list. Returns
	 * Integer.MIN_VALUE if empty
	 */
	public int popFront() {

		// in case list is empty
		if (head == null) {
			return Integer.MIN_VALUE;

			// in case only one object in the list
		} else if (head == tail) {
			DLNode n = head;
			head = null;
			tail = null;
			indexList--;
			return n.val;

			// in case list contains more than one object
		} else {
			DLNode n = head;
			head = head.next;
			head.prev = null;
			indexList--;
			return n.val;
		}
	}

	/**
	 * Returns the front element of the list without removing it. Returns
	 * Integer.MIN_VALUE if empty
	 */
	public int peekFront() {

		// in case list is empty
		if (head == null) {
			return Integer.MIN_VALUE;

			// in case list contains objects
		} else {
			return head.val;
		}
	}

	/**
	 * Removes and returns the element from the back of the linked list. Returns
	 * Integer.MIN_VALUE if empty
	 */
	public int popBack() {

		// in case list is empty
		if (tail == null) {
			return Integer.MIN_VALUE;

			// in case only one object is in list
		} else if (tail == head) {
			DLNode n = tail;
			head = null;
			tail = null;
			indexList--;
			return n.val;

			// in case list contains more than one object
		} else {
			DLNode n = tail;
			tail = tail.prev;
			tail.next = null;
			indexList--;
			return n.val;
		}
	}

	/**
	 * Returns the element at the back of the list without removing it. Returns
	 * Integer.MIN_VALUE if empty
	 */
	public int peekBack() {

		// in case list is empty
		if (tail == null) {
			return Integer.MIN_VALUE;

			// in case list contains objects
		} else {
			return tail.val;
		}
	}

	/** Returns the number of elements in the double linked list */
	public int size() {
		// result of addition equals size of list
		return indexList + 1;
	}

	/**
	 * Reverses the order of all elements in the list. “He who is first, shall be
	 * last!”
	 */
	public void reverse() {
		// return if either head is null or head == tail
		if (head == null || head == tail) {
			return;
		}
		// run through list and inverse pointer
		DLNode curr = head;
		DLNode prev = null;
		while (curr != null) {
			prev = curr.prev;
			curr.prev = curr.next;
			curr.next = prev;
			curr = curr.prev;
		}
		// rearrange head and tail
		prev = head;
		head = tail;
		tail = prev;
	}

	///////////////////////////////////////////
	///////////////////////////////////////////
	/// 									///
	/// Part 2 of submission starts here! 	///
	/// 									///
	///////////////////////////////////////////
	///////////////////////////////////////////

	/**
	 * Copy constructor initializes list with another list. This constructor must
	 * COPY all elements of the other list. The elements of the other list must NOT
	 * be changed!
	 */
	public DoubleLinkedList(DoubleLinkedList other) {
		// in case list is empty
		if (other.head == null) {
			head = null;
			tail = null;
			// in case list contains content
		} else {
			DLNode temp = other.head; // runner
			while (temp != null) {
				/**
				 * append object that temp is pointing at, with its value existing method is
				 * used
				 */
				this.append(temp.val);
				temp = temp.next;
			}
		}

	}

	/**
	 * Deinitializes the object; think about it and comment what to do here.
	 * 
	 * before garbage collector was introduced you had to implement one by yourself.
	 * nowadays it is not common to use finalize method bc its kinda faulty and can
	 * lead to unpredictable failures.
	 */
	protected void finalize() {

	}

	/**
	 * Adds all elements from another list at the front of this linked list.
	 */
	public void prepend(DoubleLinkedList other) {
		// check if other list contains anything
		if (other.head == null) {
			return;
		}
		/**
		 * check if this list contains anything. if not, rearrange this head and tail to
		 * other head an tail
		 */
		if (this.head == null) {
			this.head = other.head;
			this.tail = other.tail;
			/**
			 * if this contains objects, rearrange pointer between this head and other tail.
			 * at the end move this head to new position
			 */
		} else {
			this.head.prev = other.tail;
			other.tail.next = this.head;
			this.head = other.head;
		}
		// update indexList by adding other size
		this.indexList = this.indexList + other.size();
	}

	/**
	 * Adds all elements from another list at the back of this linked list.
	 */
	public void append(DoubleLinkedList other) {
		// check if other list contains anything
		if (other.head == null) {
			return;
		}
		/**
		 * check if this list contains anything. if not, rearrange this head and tail to
		 * other head an tail
		 */
		if (this.head == null) {
			this.head = other.head;
			this.tail = other.tail;
			/**
			 * if this contains objects, rearrange pointer between this tail and other head.
			 * at the end move this tail to new position
			 */
		} else {
			this.tail.next = other.head;
			other.head.prev = this.tail;
			this.tail = other.tail;
		}
		// update indexList by adding other size
		this.indexList = this.indexList + other.size();
	}

	/** Clones this DoubleLinkedList instance and returns an exact COPY. */
	public DoubleLinkedList clone() {
		DoubleLinkedList clone = new DoubleLinkedList();
		if (head == null) {
			clone.head = null;
			clone.tail = null;
			// in case list contains content
		} else {
			DLNode temp = head; // runner
			while (temp != null) {
				/**
				 * append object that temp is pointing at, with its value existing method is
				 * used
				 */
				clone.append(temp.val);
				temp = temp.next;
			}
		}
		return clone;
	}

	/**
	 * Returns true if the other list is equal to this one, false otherwise. The
	 * contents of the two lists must not be changed!
	 */
	public boolean equals(DoubleLinkedList other) {
		// compare index
		if(this.indexList != other.indexList) {
			return false;
		// if both lists are empty return true
		} else if (this.head == null && other.head == null) {
			return true;
		// compare element-wise
		} else {
			DLNode a = this.head;
			DLNode b = other.head;
			// run through both lists and compare values
			while (a != null) {
				if (a.val != b.val) {
					return false;
				}
				a = a.next;
				b = b.next;
			}
		}
		return true;
	}

	/**
	 * Returns a string representation of the list. Example: List of size 5: 1 -> 2
	 * -> 3 -> 4 -> 5
	 */
	public String toString() {
		if (head == null) {
			return "empty";
		} else {
			DLNode temp = head;
			StringBuilder b = new StringBuilder("List of size " + (indexList + 1) + ": ");
			while (temp != null) {
				b.append("[" + temp.val + "] ");
				temp = temp.next;
			}
			return b.toString();
		}

	}

	/** Returns true if the element val exists in the list, false otherwise. */
	public boolean search(int val) {
		// in case list is empty return false
		if (head == null) {
			return false;
		}
		DLNode temp = head;
		// run through list an compare object-values with given value
		while (temp != null) {
			if (temp.val == val) {
				return true;
			}
			temp = temp.next;
		}
		return false;
	}

}
