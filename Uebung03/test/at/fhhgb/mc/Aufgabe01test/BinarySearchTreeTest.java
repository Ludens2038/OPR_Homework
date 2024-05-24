package at.fhhgb.mc.Aufgabe01test;

import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import at.fhhgb.mc.Aufgabe01.BinarySearchTree;

public class BinarySearchTreeTest {

	private BinarySearchTree tree, emptyTree, oneEntry;
	
	@BeforeEach
	void setUp() {
		tree = new BinarySearchTree();
		tree.insert(28);
		tree.insert(16);
		tree.insert(19);
		tree.insert(12);
		tree.insert(15);
		tree.insert(34);
		tree.insert(31);
		tree.insert(8);
		tree.insert(29);
		tree.insert(49);
		
		emptyTree = new BinarySearchTree();
		
		oneEntry = new BinarySearchTree();
		oneEntry.insert(73);
	}
	
	@Test
	void testInsert() {
		assertEquals(8, tree.min());
		assertEquals(49, tree.max());
		tree.insert(3);
		tree.insert(51);
		assertEquals(3, tree.min());
		assertEquals(51, tree.max());
		tree.insert(8);
	}
	
	@Test
	void testFind() {
		assertTrue(tree.find(29));
		assertFalse(emptyTree.find(73));
	}
	
	@Test
	void testRemoveLeaf() {
		assertTrue(tree.remove(8));
		assertTrue(tree.remove(49));
		assertFalse(tree.remove(8));
		assertFalse(tree.remove(73));
		assertFalse(emptyTree.remove(2));
	}
	
	@Test
	void testRemoveOneChild() {
		assertTrue(tree.remove(31));
		tree.insert(40);
		tree.insert(42);
		assertTrue(tree.remove(42));
		assertTrue(tree.remove(49));
		assertTrue(oneEntry.remove(73));
		tree.insert(6);
		tree.insert(4);
		assertTrue(tree.remove(6));
	}
	
	@Test
	void testRemoveRoot() {
		assertTrue(tree.remove(28));
	}
	
	@Test
	void testRemoveTwoChildren() {
		assertTrue(tree.remove(34));
	}
	
	@Test
	void testSize() {
		assertEquals(10, tree.size());
	}
	
	@Test
	void testGetParent() {
		assertEquals(Integer.MIN_VALUE, emptyTree.getParent(73));
		assertEquals(16, tree.getParent(19));
		assertEquals(Integer.MIN_VALUE, tree.getParent(73));
	}
	
	@Test
	void testToArray() {
		int[] ascending = {8, 12, 15, 16, 19, 28, 29, 31, 34, 49};
		assertArrayEquals(ascending, tree.toArray(true));
		int[] descending = {49, 34, 31, 29, 28, 19, 16, 15, 12, 8};
		assertArrayEquals(descending, tree.toArray(false));
	}
	
	@Test
	void testToArrayPostOrder() {
		int[] postOrder = {8, 15, 12, 19, 16, 29, 31, 49, 34, 28};
		assertArrayEquals(postOrder, tree.toArrayPostOrder());
	}
	
	@Test
	void testToArrayPreOrder() {
		int[] preOrder = {28, 16, 12, 8, 15, 19, 34, 31, 29, 49};
		assertArrayEquals(preOrder, tree.toArrayPreOrder());
	}
	
	@Test
	void testMaxEmptyTree() {
		assertEquals(Integer.MIN_VALUE, emptyTree.max());
	}
	
	@Test
	void testMinEmptyTree() {
		assertEquals(Integer.MIN_VALUE, emptyTree.min());
	}
	
	@Test
	void testToString() {
		String expected = new String();
		expected = "        49\n" +
                "    34\n" +
                "        31\n" +
                "            29\n" +
                "28\n" +
                "        19\n" +
                "    16\n" +
                "            15\n" +
                "        12\n" +
                "            8\n";
		assertEquals(expected, tree.toString());
		
	}
}





