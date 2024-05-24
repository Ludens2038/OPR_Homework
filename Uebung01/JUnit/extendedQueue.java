import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import at.fhooe.sail.extended.Queue;

public class extendedQueue {
	private Queue q, r, s, t;

	@BeforeEach
	void setUp() {
		q = new Queue(5);
		q.enqueue(1);
		q.enqueue(2);
		q.enqueue(3);
		q.enqueue(4);

		r = new Queue(4);
		r.enqueue(11);
		r.enqueue(12);
		r.enqueue(13);

		s = new Queue(q.clone());
		
		t = new Queue();
	}
	
	@Test
	void testClear() {
		q.clear();
		assertEquals(0, q.elements());
	}
	
	@Test
	void testEnqueue() {
		q.enqueue(5);
		assertEquals(5, q.elements());
		assertEquals(1, q.peek());
		q.enqueue(6);
		assertEquals(5, q.elements());
		assertEquals(1, q.peek());
		q.dequeue();
		q.enqueue(6);
		assertEquals(2, q.peek());
		assertEquals(5, q.elements());
	}
	
	@Test
	void testEnqueueOther() {
		q.enqueue(r);
		assertEquals(7, q.elements());
		t.enqueue(s);
		assertEquals(4, t.elements());
	}
	
	@Test
	void testClone() {
		t = r.clone();
		assertTrue(r.equals(r));
	}
	
	@Test
	void testEquals() {
		Queue u = new Queue(3);
		u.enqueue(1);
		u.enqueue(2);
		u.enqueue(3);
		Queue v = new Queue(3);
		v.enqueue(4);
		v.enqueue(5);
		v.enqueue(6);
		assertFalse(u.equals(v));
		assertFalse(s.equals(u));
		assertTrue(s.equals(q));
		assertFalse(s.equals(r));
		r.enqueue(73);
		assertFalse(s.equals(r));
		s.dequeue();
		s.enqueue(73);
		assertFalse(s.equals(q));
	}
	
	@Test
	void testDequeue() {
		s.clear();
		assertEquals(Integer.MIN_VALUE, s.dequeue());
		assertEquals(11, r.dequeue());
	}
	
	@Test
	void testPeek() {
		assertEquals(11, r.peek());
		r.clear();
		assertEquals(Integer.MIN_VALUE, r.peek());
	}
	
	@Test
	void testSearch() {
		assertTrue(r.search(11));
		assertFalse(r.search(73));
		r.clear();
		assertFalse(r.search(11));
	}
	
	@Test
	void testSize() {
		assertEquals(5, q.size());
		q.clear();
		assertEquals(5, q.size());
	}
	
	@Test
	void testToString() {
		String expected = new String("[1] [2] [3] [4] ");
		assertEquals(expected, s.toString());
		
		String expected2 = new String("[1] [2] [3] [4] [11] [12] [13] ");
		q.enqueue(r);
		assertEquals(expected2, q.toString());
	}

}






