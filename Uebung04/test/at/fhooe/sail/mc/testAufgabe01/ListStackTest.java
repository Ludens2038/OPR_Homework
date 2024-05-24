/**
 * 
 */
package at.fhooe.sail.mc.testAufgabe01;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import at.fhooe.sail.mc.Aufgabe01.ListStack;

class ListStackTest {
	
	private ListStack stack;

	@BeforeEach
	void setUp() {
		stack = new ListStack();
		stack.push(1);
		stack.push(2);
		stack.push(3);
		stack.push(4);
		stack.push(5);
	}
	
	@Test
	void testListStack() {
		ListStack other = new ListStack(stack);
		assertEquals(5, other.pop());
		assertEquals(4, other.pop());
    }
	
	@Test
	void testPush() {
		stack.push(6);
		assertEquals(6, stack.peek());
	}
	
	@Test
	void testPop() {
		assertEquals(5, stack.pop());
		assertEquals(4, stack.pop());
	}
	
	@Test
	void testPeek() {
		assertEquals(5, stack.peek());
		stack.pop();
		assertEquals(4, stack.peek());
	}

}
