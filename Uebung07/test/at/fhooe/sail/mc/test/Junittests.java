package at.fhooe.sail.mc.test;

import static org.junit.jupiter.api.Assertions.assertEquals;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import at.fhooe.sail.mc.Aufgabe01.DoubleLinkedList;
import at.fhooe.sail.mc.Aufgabe02.SortableList;
import at.fhooe.sail.mc.Exceptions.InvalidAccessException;

public class Junittests {

	private SortableList<Integer> sortableList;
	private SortableList<Integer> sortableEmpty;
	private SortableList<Integer> sortableUnsorted;
	private DoubleLinkedList<Integer> DLlist;
	private DoubleLinkedList<Integer> emptyList;
	private DoubleLinkedList<Integer> list;

	@BeforeEach
	public void setUp() {
		sortableList = new SortableList<>();
		sortableList.add(3);
		sortableList.add(5);
		
		sortableEmpty = new SortableList<>();
		
		sortableUnsorted = new SortableList<>();
		sortableUnsorted.add(13);
		sortableUnsorted.add(42);
		sortableUnsorted.add(73);
		
		DLlist = new DoubleLinkedList<>();
		DLlist.prepend(5);
		DLlist.prepend(3);
		DLlist.append(7);

		emptyList = new DoubleLinkedList<>();

		list = new DoubleLinkedList<>();
		list.prepend(1);
		list.prepend(2);
	}
	
	@Test
	public void testInsertSortedTrue() throws InvalidAccessException {
		sortableList.insertSorted(4, true);
		assertEquals(4, sortableList.get(1));
		sortableEmpty.insertSorted(1, true);
	}
	
	@Test
	public void testInsertSortedFalse() throws InvalidAccessException {
		sortableList.insertSorted(2, false);
		assertEquals(2, sortableList.get(2));
		sortableEmpty.insertSorted(1, false);
		sortableEmpty.insertSorted(9, false);
	}
	
	@Test
	public void testSortAscending() {
		sortableUnsorted.sortAscending();
		assertEquals(13, sortableUnsorted.get(0));
		assertEquals(42, sortableUnsorted.get(1));
		assertEquals(73, sortableUnsorted.get(2));
		assertEquals(null, sortableEmpty.sortAscending());
		sortableEmpty.add(1);
		sortableEmpty.sortAscending();
		assertEquals(1, sortableEmpty.get(0));
	}
	
	@Test
	public void testSortDescending() {
		sortableUnsorted.sortDescending();
		assertEquals(73, sortableUnsorted.get(0));
		assertEquals(42, sortableUnsorted.get(1));
		assertEquals(13, sortableUnsorted.get(2));
		assertEquals(null, sortableEmpty.sortDescending());
		sortableEmpty.add(1);
		sortableEmpty.sortDescending();
		assertEquals(1, sortableEmpty.get(0));
	}
	
	@Test
	public void testInsertAt() throws InvalidAccessException {
		sortableList.insertAt(1, 4);
		assertEquals(4, sortableList.get(1));
		sortableList.insertAt(0, 2);
		assertEquals(2, sortableList.get(0));
		sortableEmpty.insertAt(0, 1);
		assertEquals(1, sortableEmpty.get(0));
		assertThrows(InvalidAccessException.class, () -> {
			sortableEmpty.insertAt(-1, 90);
		});
		assertThrows(InvalidAccessException.class, () -> {
			sortableEmpty.insertAt(3, 90);
		});
	}
	
	@Test
	public void testContains() {
		assertTrue(sortableList.contains(5));
		assertFalse(sortableList.contains(4));
		assertFalse(sortableEmpty.contains(1));
	}
	
	@Test
	public void testRemoveAt() throws InvalidAccessException {
		assertTrue(sortableList.removeAt(1));
		assertEquals(1, sortableList.size());
		assertThrows(InvalidAccessException.class, () -> {
			sortableList.removeAt(-1);
		});
		assertThrows(InvalidAccessException.class, () -> {
			sortableList.removeAt(2);
		});
	}
	
	@Test
	public void testRemoveAll() {
		assertTrue(sortableList.removeAll(5));
		assertFalse(sortableList.removeAll(4));
		assertFalse(sortableEmpty.removeAll(1));
	}
	
	@Test
	public void testElementAt() throws InvalidAccessException {
		assertEquals(5, sortableList.elementAt(1));
		assertThrows(InvalidAccessException.class, () -> {
			sortableList.elementAt(-1);
		});
		assertThrows(InvalidAccessException.class, () -> {
			sortableList.elementAt(2);
		});
	}
	
	
	//Tests DoubleLinkedList from here
	
	@Test
	public void testClear() {
		DLlist.clear();
		assertEquals(0, DLlist.size());
	}
	
	@Test
	public void testAppend() {
		DLlist.append(9);
		assertEquals(9, DLlist.get(3));
		emptyList.append(1);
	}
	
	@Test
	public void testGet(){
		assertEquals(7, DLlist.get(2));
		assertEquals(null, emptyList.get(0));
		assertEquals(null, DLlist.get(-1));
		assertEquals(null, DLlist.get(3));
	}
	
	@Test
	public void testPopFront() {
		assertEquals(3, DLlist.popFront());
		assertEquals(5, DLlist.popFront());
		assertEquals(7, DLlist.popFront());
		assertEquals(null, DLlist.popFront());
	}
	
	@Test
	public void testPeekFront() {
		assertEquals(3, DLlist.peekFront());
		assertEquals(null, emptyList.peekFront());
	}
	
	@Test
	public void testPopBack() {
		assertEquals(7, DLlist.popBack());
		assertEquals(5, DLlist.popBack());
		assertEquals(3, DLlist.popBack());
		assertEquals(null, DLlist.popBack());
	}
	
	@Test
	public void testPeekBack() {
		assertEquals(7, DLlist.peekBack());
		assertEquals(null, emptyList.peekBack());
	}
	
	@Test
	public void testReverse() {
		DLlist.reverse();
		assertEquals(7, DLlist.get(0));
		assertEquals(5, DLlist.get(1));
		assertEquals(3, DLlist.get(2));
		emptyList.reverse();
		list.reverse();
		list.popFront();
		assertEquals(2, list.get(0));
	}
	
	@Test
	public void testConstructorOther() {
		DoubleLinkedList<Integer> other = new DoubleLinkedList<>(list);
        assertEquals(1, other.get(1));
        assertEquals(2, other.get(0));
        DoubleLinkedList<Integer> otherEmpty = new DoubleLinkedList<>(emptyList);
        assertEquals(null, otherEmpty.get(0));
	}
	
	@Test
	public void testPrependOther() {
		DLlist.prepend(list);
        assertEquals(2, DLlist.get(0));
        assertEquals(1, DLlist.get(1));
        assertEquals(3, DLlist.get(2));
        assertEquals(5, DLlist.get(3));
        assertEquals(7, DLlist.get(4));
        DLlist.prepend(emptyList);
        assertEquals(2, DLlist.get(0));
        assertEquals(1, DLlist.get(1));
        assertEquals(3, DLlist.get(2));
        emptyList.prepend(list);
        assertEquals(2, emptyList.get(0));
        assertEquals(1, emptyList.get(1));
	}
	
	@Test
	public void testAppendOther() {
		DLlist.append(list);
		assertEquals(3, DLlist.get(0));
		assertEquals(5, DLlist.get(1));
		assertEquals(7, DLlist.get(2));
		assertEquals(2, DLlist.get(3));
		assertEquals(1, DLlist.get(4));
		emptyList.append(list);
		assertEquals(2, emptyList.get(0));
		assertEquals(1, emptyList.get(1));
		list.append(emptyList);
		assertEquals(2, list.get(0));
		assertEquals(1, list.get(1));
	}
	
	@Test
	public void testClone() {
		DoubleLinkedList<Integer> clone = DLlist.clone();
		assertEquals(3, clone.get(0));
		assertEquals(5, clone.get(1));
		assertEquals(7, clone.get(2));
		DoubleLinkedList<Integer> cloneEmpty = emptyList.clone();
		assertEquals(null, cloneEmpty.get(0));
	}
	
	@Test
	public void testEquals() {
		DoubleLinkedList<Integer> clone = DLlist.clone();
		assertTrue(DLlist.equals(clone));
		assertFalse(DLlist.equals(list));
		assertFalse(emptyList.equals(list));
		DoubleLinkedList<Integer> cloneEmpty = emptyList.clone();
		assertTrue(emptyList.equals(cloneEmpty));
	}
	
	@Test
	public void testToString() {
		assertEquals("List of size 3: [3] [5] [7] ", DLlist.toString());
		assertEquals("empty", emptyList.toString());
	}
	
	@Test
	public void testSearch() {
		assertTrue(DLlist.search(5));
		assertFalse(DLlist.search(4));
		assertFalse(emptyList.search(1));
	}
	
}