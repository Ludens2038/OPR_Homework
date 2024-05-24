package at.fhhgb.mc.Aufgabe01test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import at.fhhgb.mc.Aufgabe01.DoubleLinkedList;

public class DoubleLinkedListTest {

	private DoubleLinkedList l, l2;
	
	@BeforeEach
	void setUp() {
		l = new DoubleLinkedList();
		l.prepend(1);
		l.prepend(2);
		l.append(3);
		
		l2 = new DoubleLinkedList();
		l2.append(4);
		l2.append(5);
		l2.append(6);
	}
	
	@Test
	void testClear() {
		l.clear();
		assertEquals(0, l.size());
	}
	
	@Test
	void testPrepend() {
		l.prepend(73);
		assertEquals(73, l.peekFront());
		assertEquals(4, l.size());
		l.clear();
		l.prepend(1);
		assertEquals(1, l.peekFront());
		assertEquals(1, l.peekBack());
		assertEquals(1, l.size());
	}
	
	@Test
	void testAppend() {
		l.clear();
		l.append(1);
		assertEquals(1, l.peekFront());
		assertEquals(1, l.peekBack());
		assertEquals(1, l.size());
		l.append(2);
		assertEquals(1, l.peekFront());
		assertEquals(2, l.peekBack());
	}
	
	@Test
	void testGet() {
		assertEquals(Integer.MIN_VALUE, l.get(8));
		assertEquals(Integer.MIN_VALUE, l.get(-2));
		assertEquals(3, l.get(2));
		l.clear();
		assertEquals(Integer.MIN_VALUE, l.get(1));	
	}
	
	@Test
	void testPopFrontEmptyList() {
		l.clear();
		assertEquals(Integer.MIN_VALUE, l.popFront());
	}
	
	@Test
	void testPopFront() {
		assertEquals(2, l.popFront());
		assertEquals(1, l.popFront());
		assertEquals(3, l.popFront());
	}
	
	@Test
	void testPeekFront() {
		assertEquals(2, l.peekFront());
		l.clear();
		assertEquals(Integer.MIN_VALUE, l.peekFront());
	}
	
	@Test
	void testPopBackEmptyList() {
		l.clear();
		assertEquals(Integer.MIN_VALUE, l.popBack());
	}
	
	@Test
	void testPopBack() {
		assertEquals(3, l.popBack());
		assertEquals(1, l.popBack());
		assertEquals(2, l.popBack());
	}
	
	@Test
	void testPeekBack() {
		assertEquals(3, l.peekBack());
		l.clear();
		assertEquals(Integer.MIN_VALUE, l.peekBack());
	}
	
	@Test
	void testSize() {
		l.append(2);
		l.append(21);
		l.append(22);
		assertEquals(6, l.size());
		l.popBack();
		assertEquals(5, l.size());
		l.popFront();
		assertEquals(4, l.size());
	}
	
	@Test
	void testReverse() {
		assertEquals(2, l.peekFront());
		assertEquals(3, l.peekBack());
		l.reverse();
		assertEquals(3, l.peekFront());
		assertEquals(2, l.peekBack());
		l.clear();
		assertEquals(0, l.size());
		l.reverse();
		l.append(1);
		l.reverse();
		assertEquals(1, l.size());
	}
	
	@Test
	void testDoubleLinkedList() {
		DoubleLinkedList copy = new DoubleLinkedList(l);
		assertEquals(copy.size(), l.size());
		l.popBack();
		assertNotEquals(copy.size(), l.size());
		l.clear();
		copy = new DoubleLinkedList(l);
		assertEquals(copy.size(), l.size());
	}
	
	@Test
	void testPrependList() {
		l.prepend(l2);
		assertEquals(4, l.peekFront());
		assertEquals(6, l.size());
	}
	
	@Test
	void testPrependThisListEmpty() {
		l.clear();
		l.prepend(l2);
		assertEquals(4, l.peekFront());
		assertEquals(3, l.size());
	}
	
	@Test
	void testPrependOtherListEmpty() {
		l2.clear();
		l.prepend(l2);
		assertEquals(2, l.peekFront());
		assertEquals(3, l.size());
	}
	
	@Test
	void testAppendList() {
		l.append(l2);
		assertEquals(2, l.peekFront());
		assertEquals(6, l.size());
	}
	
	@Test
	void testAppendThisListEmpty() {
		l.clear();
		l.append(l2);
		assertEquals(4, l.peekFront());
		assertEquals(3, l.size());
	}
	
	@Test
	void testAppendOtherListEmpty() {
		l2.clear();
		l.append(l2);
		assertEquals(2, l.peekFront());
		assertEquals(3, l.size());
	}
	
	@Test
	void testClone() {
		DoubleLinkedList clone = l.clone();
		assertEquals(clone.peekBack(), l.peekBack());
		assertEquals(clone.peekFront(), l.peekFront());
		assertEquals(clone.size(), l.size());
	}
	
	@Test
	void testCloneEmpty() {
		l.clear();
		DoubleLinkedList clone = l.clone();
		assertEquals(0, clone.size());
	}
	
	@Test
	void testEquals() {
		DoubleLinkedList l3 = l.clone();
		assertTrue(l.equals(l3));
		assertFalse(l.equals(l2));
		l2.clear();
		assertFalse(l.equals(l2));
		assertFalse(l2.equals(l));
		l.clear();
		assertTrue(l.equals(l2));
		assertFalse(l3.equals(l));
	}
	
	@Test
	void testEqualsOneListEmpty() {
		l.clear();
		assertFalse(l.equals(l2));
		assertFalse(l2.equals(l));
	}
	
	@Test
	void testToStringEmpty() {
		String expected = new String("empty");
		l.clear();
		assertEquals(expected, l.toString());
	}
	
	@Test
	void testToString() {
		String expected = new String("List of size 3: [2] [1] [3] ");
		assertEquals(expected, l.toString());
	}
	
	@Test
	void testSearch() {
		assertTrue(l.search(1));
		assertFalse(l.search(23));
		l.clear();
		assertFalse(l.search(1));
	}
}