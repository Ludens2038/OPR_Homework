package at.fhooe.sail.mc.TestAufgabe01;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import at.fhooe.sail.mc.Aufgabe01.ListStack;
import at.fhooe.sail.mc.Aufgabe01.RandomAccessDoubleLinkedList;
import at.fhooe.sail.mc.Aufgabe01Exceptions.InvalidAccessException;

class RandomAccessDoubleLinkedListTest {

	private RandomAccessDoubleLinkedList list;

	@BeforeEach
	void setUp() {
		list = new RandomAccessDoubleLinkedList();
		try {
		list.insertAt(0, 1);
		list.insertAt(1, 2);
		list.insertAt(2, 3);
		}catch(InvalidAccessException e) {
			System.out.println(e.toString());
		}
	}

	@Test
	void testInsertAt() {
		try {
		list.insertAt(3, 4);
		assertEquals(4, list.size());
		list.insertAt(2, 6);
		assertEquals(5, list.size());
		}catch(InvalidAccessException e) {
			System.out.println(e.toString());
		}
	}
	
	@Test
	void testRandomDoubleLinkedList() {
		RandomAccessDoubleLinkedList list2 = new RandomAccessDoubleLinkedList(list);
		assertEquals(3, list2.size());
	}
	
	@Test
	void testContains() {
		assertTrue(list.contains(2));
		assertFalse(list.contains(4));
	}
	
	@Test
	void testRemoveAt() {
		try {
		assertTrue(list.removeAt(1));
		}catch(InvalidAccessException e) {
			System.out.println(e.toString());
		}
		assertEquals(2, list.size());
	}
	
	@Test
	void testRemoveAll() {
		assertTrue(list.removeAll(2));
		assertFalse(list.removeAll(4));
	}
	
	@Test
	void testElementAt() {
		try {
		assertEquals(2, list.elementAt(1));
		}catch(InvalidAccessException e) {
			System.out.println(e.toString());
		}
	}
	
	@Test
	public void testExpectExceptionInsertAt() {
		assertThrows(InvalidAccessException.class, () -> {
			list.insertAt(-1, 90);
		});
		assertThrows(InvalidAccessException.class, () -> {
			list.insertAt(3, 90);
		});
	}
	
	@Test
	public void testExpectExceptionRemoveAt() {
		assertThrows(InvalidAccessException.class, () -> {
			list.removeAt(-1);
		});
		assertThrows(InvalidAccessException.class, () -> {
			list.removeAt(1);
		});
	}
	
	@Test
	public void testExpectExceptionElementAt() {
		assertThrows(InvalidAccessException.class, () -> {
			list.elementAt(-1);
		});
		assertThrows(InvalidAccessException.class, () -> {
			list.elementAt(1);
		});
	}
}
