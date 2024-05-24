package at.fhooe.sail.mc.Aufgabe01;

import at.fhooe.sail.mc.Aufgabe01Exceptions.InvalidAccessException;
import mc.opr.dll.MyDoubleLinkedList;

public class ListStack extends MyDoubleLinkedList {
    /** Initializes an empty stack. */
    public ListStack() {
        super();
    }

    /** Copy constructor which initializes the stack with another stack.
     This constructor must COPY all elements of the other stack. */
    public ListStack(ListStack other) {
        int elements = other.elements();
        for(int i = 0; i < elements; i++){
            this.push(other.peekElementAt(i));
        }
    }

    /** Pushes an element onto the stack. */
    public void push(int val) {
        super.pushBack(val);
    }

    /** Returns the top element of the stack and removes it. */
    public int pop() throws InvalidAccessException {
    	if (elements() == 0) {
    		helpThrowing();
    	}
        return super.popBack();
    }

    /** Returns the top element of the stack without removing it. */
    public int peek() throws InvalidAccessException {
    	if (elements() == 0) {
    		helpThrowing();
    	}
        return super.peekBack();
    }
    
    private void helpThrowing() throws InvalidAccessException{
    	throw new InvalidAccessException("Stack is empty");
    }
}
