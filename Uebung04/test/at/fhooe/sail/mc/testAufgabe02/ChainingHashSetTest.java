package at.fhooe.sail.mc.testAufgabe02;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import at.fhooe.sail.mc.Aufgabe02.ChainingHashSet;

class ChainingHashSetTest {
	
	private ChainingHashSet c;

	@BeforeEach
	void setUp(){
		c = new ChainingHashSet(5);
		c.insert(0);
		c.insert(1);
		c.insert(2);
		c.insert(4);
		c.insert(5);
		c.insert(6);
		c.insert(7);
		c.insert(9);
		c.insert(10);
		c.insert(11);
	}
	
	@Test
	void testInsert() {
		assertTrue(c.insert(3));
		assertTrue(c.insert(8));
		assertFalse(c.insert(0));
	}
	
	@Test
	void testContains() {
		assertTrue(c.contains(0));
		assertTrue(c.contains(1));
		assertTrue(c.contains(2));
		assertFalse(c.contains(3));
		assertFalse(c.contains(8));
	}
	
	@Test
	void testRemove() {
		assertTrue(c.remove(0));
		assertFalse(c.remove(0));
		assertTrue(c.remove(1));
		assertFalse(c.remove(1));
		assertTrue(c.remove(5));
		assertFalse(c.remove(5));
		assertFalse(c.remove(3));
		assertFalse(c.remove(8));
		assertTrue(c.remove(9));
	}
	
	@Test
	void testGetOverflowCount() {
		assertEquals(Integer.MIN_VALUE, c.getOverflowCount(-1));
		assertEquals(Integer.MIN_VALUE, c.getOverflowCount(8));
		assertEquals(3, c.getOverflowCount(0));
		c.insert(15);
		c.insert(20);
		assertEquals(5, c.getOverflowCount(0));
		assertEquals(0, c.getOverflowCount(3));
	}
	
	@Test
	void testElements() {
		assertEquals(10, c.elements());
		c.remove(0);
		assertEquals(9, c.elements());
		c.insert(15);
		c.insert(20);
		assertEquals(11, c.elements());
	}
}






