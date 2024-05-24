package at.fhooe.sail.mc.TestAufgabe01;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import at.fhooe.sail.mc.Aufgabe01.ListQueue;
import at.fhooe.sail.mc.Aufgabe01Exceptions.InvalidAccessException;
import at.fhooe.sail.mc.Aufgabe01Exceptions.ValueException;

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
		try {
		assertEquals(1, queue.dequeue());
		assertEquals(2, queue.dequeue());
		assertEquals(3, queue.peek());
		}catch(InvalidAccessException e) {
			System.out.print(e.toString());
		}
	}
	
    @Test
	void testPeek() {
    	try {
		assertEquals(1, queue.peek());
		queue.dequeue();
		assertEquals(2, queue.peek());
    	} catch(InvalidAccessException e) {
    		System.out.print(e.toString());
    	}
	}
    
    @Test
	void testListQueue() {
		ListQueue other = new ListQueue(queue);
		try {
		assertEquals(1, other.dequeue());
		assertEquals(2, other.dequeue());
		}catch(InvalidAccessException e) {
			System.out.print(e.toString());
		}
	}
    
    @Test
	public void testExpectExceptionDequeue() {
    	ListQueue test = new ListQueue();
		assertThrows(InvalidAccessException.class, () -> {
			test.dequeue();
		});
		assertThrows(InvalidAccessException.class, () -> {
			queue.dequeue();
		});
	}
    
    @Test
        public void testExpectExceptionPeek() {
    	ListQueue test = new ListQueue();
    	assertThrows(InvalidAccessException.class, () -> {
			test.peek();
		});
		assertThrows(InvalidAccessException.class, () -> {
			queue.peek();
		});
    }
}
