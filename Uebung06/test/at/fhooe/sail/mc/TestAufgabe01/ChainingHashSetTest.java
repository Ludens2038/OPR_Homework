package at.fhooe.sail.mc.TestAufgabe01;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import at.fhooe.sail.mc.Aufgabe01.ChainingHashSet;
import at.fhooe.sail.mc.Aufgabe01Exceptions.ValueException;

class ChainingHashSetTest {

	private ChainingHashSet c;

	@BeforeEach
	void setUp() {
		try {
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
		} catch (ValueException e) {
			System.out.print(e.toString());
		}
	}

	@Test
	void testInsert() {
		try {
			assertTrue(c.insert(3));
			assertTrue(c.insert(8));
		} catch (ValueException e) {
			System.out.println(e.toString());
		}
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
		try {
			assertEquals(3, c.getOverflowCount(0));
			c.insert(15);
			c.insert(20);
			assertEquals(5, c.getOverflowCount(0));
		} catch (ValueException e) {
			System.out.println(e.toString());
		}
	}

	@Test
	void testElements() {
		assertEquals(10, c.elements());
		c.remove(0);
		assertEquals(9, c.elements());
		try {
			c.insert(15);
			c.insert(20);
			assertEquals(11, c.elements());
		} catch (ValueException e) {
			System.out.println(e.toString());

		}
	}

	@Test
	public void testExpectException() {
		assertThrows(ValueException.class, () -> {
			c.insert(11);
		});
		assertThrows(ValueException.class, () -> {
			c.insert(73);
		});
		
		
	}
}
