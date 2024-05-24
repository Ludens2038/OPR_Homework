package at.fhooe.sail.extended;

//defines stack class
public class Stack {
	private int[] stack;
	private int top;
	private int size;

	// constructor creates stack with default size
	public Stack() {
		this.size = 20;
		this.top = 0;
		this.stack = new int[this.size];
	}

	// constructor creates stack with given size
	public Stack(int size) {
		this.size = size;
		this.top = 0;
		this.stack = new int[size];
	}

	// initialize new stack with given stack
	public Stack(Stack other) {
		this.size = other.size;
		this.top = other.top;
		this.stack = new int[this.size];

		// fill content of new stack with content of given stack
		for (int i = 0; i < this.size; i++) {
			this.stack[i] = other.stack[i];
		}
	}

	/*
	 * Deinitializes the object. basically the garbage collector. Was used
	 * for cleanup before garbage-collector was introduced. 
	 */
	protected void finalize() {

	}

	/** Clears all elements from the stack */
	public void clear() {
		top = 0;

	}

	/** Pushes an element onto the stack */
	public void push(int val) {
		if (stack.length > top) {
			stack[top] = val;
			top++;
		}
	}

	/**
	 * Pushes all elements from another stack onto this one. If another stack [4,5]
	 * is pushed onto this stack [1,2,3], the result is [1,2,3,4,5] and not
	 * [1,2,3,5,4]. The elements of the other stack must NOT be changed!
	 */
	public void push(Stack other) {
		//calculates total elements of merged stacks
		int totalSpace = this.top + other.top;
		
		/*
		 * checks if merged stack exceeds "this" stack. if so a new stack in form
		 * of an array is created and content of both arrays is copied. if not, first array
		 * is filled with content of second array.
		 */
		if (this.size < totalSpace) {
			int[] newStack = new int[totalSpace];
			//moves first elements in new array
			for (int i = 0; i < this.top; i++) {
				newStack[i] = this.stack[i];
			}
			//continues filling new array with second stack
			for (int i = 0; i < other.top; i++) {
				newStack[this.top + i] = other.stack[i];
			}
			//sets new values for object-fields
			this.stack = newStack;
			this.size = newStack.length;
			this.top = newStack.length;
		} else {
			for (int i = 0; i < other.top; i++) {
				this.stack[this.top] = other.stack[i];
				this.top++;
			}
		}
	}

	/**
	 * Clones this Stack instance and returns an exact COPY.
	 */
	public Stack clone() {
		Stack s = new Stack(this.size);
		s.size = this.size;
		s.top = this.top;
		s.stack = new int[s.size];
		for (int i = 0; i < s.size; i++) {
			s.stack[i] = this.stack[i];
		}
		return s;
	}

	/**
	 * Returns true if the other stack is equal to this one, false otherwise. The
	 * contents of the two stacks must not be changed!
	 */
	public boolean equals(Stack other) {
		
		//check pointer position
		if (this.top != other.top) {
			return false;
		} else if(this.size != other.size) {
			return false;
		} else {
			for (int i = 0; i < this.top; i++) {
				if (this.stack[i] != other.stack[i]) {
					return false;
				}
			}
		}
		return true;
	}

	/** Returns the top element of the stack and removes it */
	public int pop() {
		if (top > 0) {
			top = top - 1;
			return stack[top];
		}
		return Integer.MIN_VALUE;
	}

	/** Returns the top element of the stack without removing it */
	public int peek() {
		if (top == 0) {
			return Integer.MIN_VALUE;
		}
		return stack[top - 1];
	}

	/**
	 * Returns true if the element val exists in the stack, false otherwise.
	 */
	public boolean search(int val) {
	    for (int i = 0; i < this.top; i++) {
	        if (this.stack[i] == val) {
	            return true;
	        }
	    }
	    return false;
	}


	/** Returns the number of elements in the stack */
	public int elements() {
		return top;
	}

	/** Returns the maximum size of the stack */
	public int size() {
		return stack.length;
	}

	/** Prints all elements in the stack */
	public void print() {
		for (int i = 0; i < top; i++) {
			System.out.print("[" + stack[i] + "] ");
		}
		System.out.println();
	}

	/**
	 * Returns a string representation of the stack.
	 * creates a new string builder and appends content of array.
	 */
	public String toString() {
		StringBuilder builder = new StringBuilder();
		for (int i = 0; i < top; i++) {
			builder.append("[" + (stack[i]) + "] ");
		}

		return builder.toString();
	}
}
