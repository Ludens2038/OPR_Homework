package at.fhooe.sail.mc.testAufgabe02;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import at.fhooe.sail.mc.Aufgabe02.RandomAccessDoubleLinkedList;

class RandomAccessDoubleLinkedListTest {

	private RandomAccessDoubleLinkedList list;

	@BeforeEach
	void setUp() {
		list = new RandomAccessDoubleLinkedList();
		list.insertAt(0, 1);
		list.insertAt(1, 2);
		list.insertAt(2, 3);
	}

	@Test
	void testInsertAt() {
		list.insertAt(3, 4);
		assertEquals(4, list.size());
		list.insertAt(-1, 5);
		list.insertAt(2, 6);
		assertEquals(5, list.size());
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
		assertTrue(list.removeAt(1));
		assertFalse(list.removeAt(3));
		assertEquals(2, list.size());
	}
	
	@Test
	void testRemoveAll() {
		assertTrue(list.removeAll(2));
		assertFalse(list.removeAll(4));
	}
	
	@Test
	void testElementAt() {
		assertEquals(2, list.elementAt(1));
		assertEquals(Integer.MIN_VALUE, list.elementAt(3));
		assertEquals(Integer.MIN_VALUE, list.elementAt(-1));
	}
	
}
