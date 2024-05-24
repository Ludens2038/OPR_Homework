/**
 * 
 */
package at.fhooe.sail.mc.TestAufgabe01;

import static org.junit.Assert.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import at.fhooe.sail.mc.Aufgabe01.ListQueue;
import at.fhooe.sail.mc.Aufgabe01.ListStack;
import at.fhooe.sail.mc.Aufgabe01Exceptions.InvalidAccessException;

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
		try {
		assertEquals(5, other.pop());
		assertEquals(4, other.pop());
		}catch(InvalidAccessException e) {
			System.out.println(e.toString());
		}
    }
	
	@Test
	void testPush() {
		stack.push(6);
		try {
		assertEquals(6, stack.peek());
		}catch(InvalidAccessException e) {
			System.out.println(e.toString());
		}
	}
	
	@Test
	void testPop() {
		try {
		assertEquals(5, stack.pop());
		assertEquals(4, stack.pop());
		}catch(InvalidAccessException e) {
			System.out.println(e.toString());
		}
	}
	
	@Test
	void testPeek() {
		try {
		assertEquals(5, stack.peek());
		stack.pop();
		assertEquals(4, stack.peek());
		}catch(InvalidAccessException e) {
			System.out.println(e.toString());
		}
	}
	
	@Test
	public void testExpectExceptionPop() {
    	ListStack test = new ListStack();
		assertThrows(InvalidAccessException.class, () -> {
			test.pop();
		});
		assertThrows(InvalidAccessException.class, () -> {
			stack.pop();
		});
	}
	
	@Test
	public void testExpectExceptionPeek() {
		ListStack test = new ListStack();
		assertThrows(InvalidAccessException.class, () -> {
			test.peek();
		});
		assertThrows(InvalidAccessException.class, () -> {
			stack.peek();
		});
	}
}
