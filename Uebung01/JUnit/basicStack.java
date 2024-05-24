import static org.junit.Assert.assertEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import at.fhooe.sail.basic.Stack;

class basicStack {
	
	public Stack t;
	
	@BeforeEach
	void setUp() {
		t = new Stack();
		t.initStack(5);
	}
	
	@Test
	void testClear() {
		assertEquals(Integer.MIN_VALUE, t.peek());
		assertEquals(0, t.elements());
		t.push(12);
		t.push(2);
		assertEquals(2, t.peek());
		assertEquals(2, t.elements());
		t.clear();
		assertEquals(Integer.MIN_VALUE, t.peek());
		assertEquals(0, t.elements());
	}

	@Test
	void testPush() {
		assertEquals(Integer.MIN_VALUE, t.peek());
		t.push(7);
		t.push(3);
		t.push(2);
		assertEquals(2, t.peek());
		assertEquals(3, t.elements());
		t.push(1);
		t.push(1);
		t.push(1);
		assertEquals(5, t.elements());
	}
	
	@Test
	void testPop() {
		assertEquals(Integer.MIN_VALUE, t.pop());
		t.push(1);
		t.push(2);
		t.push(4);
		t.push(44);
		t.push(73);
		assertEquals(5, t.elements());
		assertEquals(73, t.peek());
		t.pop();
		assertEquals(4, t.elements());
		assertEquals(44, t.peek());
	}
	
	@Test
	void testPeek() {
		assertEquals(Integer.MIN_VALUE, t.peek());
		t.push(3);
		assertEquals(3, t.peek());
	}
	
	@Test
	void testElements() {
		assertEquals(0, t.elements());
		t.push(3);
		t.push(6);
		t.push(4);
		assertEquals(3, t.elements());
	}
	
	@Test
	void testSize() {
		assertEquals(5, t.size());
		Stack u = new Stack();
		u.initStack(3);
		assertEquals(3, u.size());
	}
}