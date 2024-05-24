package at.fhooe.sail.basic;

public class Stack {
	private int[] stack;
	private int top;
	private int size;
	
	/** Initializes the stack instance */
	public void initStack(int size) {
		this.size = size;
		this.top = 0;
		this.stack = new int [size];
	}
	
	/** Clears all elements from the stack */
	public void clear() {
		top = 0;
		
	}
	/** Pushes an element onto the stack */
	public void push(int val) {
		if(stack.length > top) {
			stack[top] = val;
			top++;
		}
	}
	
	/** Returns the top element of the stack and removes it */
	public int pop() {
		if(top > 0) {
			top = top -1;
			return stack[top];
		}
		return Integer.MIN_VALUE;
	}
	
	/** Returns the top element of the stack without removing it */
	public int peek() {
		if(top == 0) {
			return Integer.MIN_VALUE;
		}
		return stack[top - 1];
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
		for(int i = 0; i < top; i++) {
			System.out.print("[" + stack[i] + "] ");
		}
		System.out.println();
	}
}
