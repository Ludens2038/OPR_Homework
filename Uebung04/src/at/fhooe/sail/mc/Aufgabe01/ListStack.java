package at.fhooe.sail.mc.Aufgabe01;

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
    public int pop() {
        return super.popBack();
    }

    /** Returns the top element of the stack without removing it. */
    public int peek() {
        return super.peekBack();
    }
}
