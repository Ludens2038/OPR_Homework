import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import at.fhooe.sail.basic.Queue;

public class basicQueue {

	public Queue t;
	
	@BeforeEach
	void setUp() {
		t = new Queue();
		t.initQueue(5);
		t.enqueue(10);
		t.enqueue(20);
		t.enqueue(30);
		t.enqueue(40);
	}
	
	@Test
	void testClear() {
		t.clear();
		assertEquals(0, t.elements());
		assertEquals(Integer.MIN_VALUE, t.peek());
	}
	
	@Test
	void testEnqueue() {
		t.enqueue(50);
		assertEquals(10, t.peek());
		assertEquals(5, t.elements());
		t.enqueue(60);
		assertEquals(10, t.peek());
		assertEquals(5, t.elements());
		t.dequeue();
		t.enqueue(70);
		
		}
	
	@Test
	void testDequeue() {
		t.dequeue();
		assertEquals(20, t.peek());
		assertEquals(3, t.elements());
		t.dequeue();
		t.dequeue();
		t.dequeue();
		t.dequeue();
		t.dequeue();
		
	}
	
	@Test
	void testPeek() {
		assertEquals(10, t.peek());
		t.dequeue();
		assertEquals(20, t.peek());
	}
	
	@Test
	void testElements() {
		assertEquals(4, t.elements());
		t.dequeue();
		assertEquals(3, t.elements());
		t.enqueue(23);
		assertEquals(4, t.elements());
	}
	
	@Test
	void testSize() {
		assertEquals(5, t.size());
	}
}







