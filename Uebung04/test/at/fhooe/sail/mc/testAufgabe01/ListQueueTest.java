package at.fhooe.sail.mc.testAufgabe01;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import at.fhooe.sail.mc.Aufgabe01.ListQueue;

class ListQueueTest {
	private ListQueue queue;

	@BeforeEach
	void setUp() {
		queue = new ListQueue();
		queue.enqueue(1);
		queue.enqueue(2);
		queue.enqueue(3);
		queue.enqueue(4);
		queue.enqueue(5);
		
	}

	@Test
	void testEnqueue() {
        queue.enqueue(6);
    }
	
	@Test
	void testDequeue() {
		assertEquals(1, queue.dequeue());
		assertEquals(2, queue.dequeue());
		assertEquals(3, queue.peek());
	}
	
    @Test
	void testPeek() {
		assertEquals(1, queue.peek());
		queue.dequeue();
		assertEquals(2, queue.peek());
	}
    
    @Test
	void testListQueue() {
		ListQueue other = new ListQueue(queue);
		assertEquals(1, other.dequeue());
		assertEquals(2, other.dequeue());
	}
}
