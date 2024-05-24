package at.fhhgb.mc.Aufgabe01;

public class BinarySearchTree {
	/** Inner class for the binary tree node. **/
	protected class BinaryTreeNode {
		public BinaryTreeNode left;
		public BinaryTreeNode right;
		public int data;

		public BinaryTreeNode(int elem) {
			data = elem;
			left = null;
			right = null;
		}
	}

	private class Index {
		int index = 0;
	}

	/** Root node of the tree. **/
	protected BinaryTreeNode root;
	/** Number of elements stored in the tree. */
	protected int size;

	/**
	 * Inserts the given element. Duplicate elements are not allowed. Returns true
	 * if insertion was successful, false otherwise.
	 */
	public boolean insert(int elem) {
		// if tree is empty
		BinaryTreeNode n = new BinaryTreeNode(elem);
		if (root == null) {
			root = n;
			size++;
			return true;
		}
		//look for node with same data, if found insertion is stopped
		if (find(n.data)) {
			return false;
		}
		
		//if find had no match
		BinaryTreeNode p = root;
		BinaryTreeNode parent = null;
		//traverse tree to find insertion point
		while (p != null) {
			parent = p;
			//go left if data value is smaller
			if (n.data < p.data) {
				p = p.left;
			//go right if data value is bigger
			} else {
				p = p.right;
			}
		}
		//after end is reached(p == null)
		//lower data value inserted on left side
		if (n.data < parent.data) {
			parent.left = n;
			size++;
			return true;
		//higher data value inserted on right side
		} else {
			parent.right = n;
			size++;
			return true;
		}
	}

	/**
	 * Searches for the (first) element with the given key. Returns true if it could
	 * be found, false otherwise.
	 */
	public boolean find(int key) {
		BinaryTreeNode p = root;
		if (root == null) {
			return false;
		} else {
			//tree traversion
			while (p != null) {
				if (key == p.data) {
					return true;
				} else if (key < p.data) {
					p = p.left;
				} else {
					p = p.right;
				}
			}
			return false;
		}
	}

	/**
	 * Removes the element with the given key. Returns true if the key could be
	 * found (and removed), false otherwise.
	 */
	public boolean remove(int key) {
		//if tree is empty or key was not found
		if (!this.find(key)) {
			return false;
		//tree is not empty and key has been found
		} else {
			//setup for traversion
			BinaryTreeNode n = this.root;
			BinaryTreeNode parent = null;
			while (n != null) {
				if (key == n.data) {
					break;
				} else if (key < n.data) {
					parent = n;
					n = n.left;
				} else if (key > n.data) {
					parent = n;
					n = n.right;
				}
			}

			// in case node to remove is leaf
			if (n.left == null && n.right == null) {
				//in case only root is in tree
				if (parent == null) {
					this.root = null;
				//based on value comparison set parent left or right to null
				} else if (n.data < parent.data) {
					parent.left = null;
				} else {
					parent.right = null;
				}

			// in case node to remove has one child
			} else if (n.left == null || n.right == null) {
				//node to store child information
				BinaryTreeNode child = null;
				if (n.left == null) {
					child = n.right;
				} else {
					child = n.left;
				}
				//in case parent of child is root
				if (parent == null) {
					this.root = child;
				} else if (n.data < parent.data) {
					parent.left = child;
				} else {
					parent.right = child;
				}

			// in case node to remove has two children
			} else if (n.left != null && n.right != null) {
				//traverse tree to find node with nearest, highest value
				BinaryTreeNode offspring = n.right;
				BinaryTreeNode offspringParent = n;
				while (offspring.left != null) {
					offspringParent = offspring;
					offspring = offspring.left;
				}
				//if parent of offspring is node to remove
				if (offspringParent != n) {
					offspringParent.left = offspring.right;
					offspring.right = n.right;
				}
				offspring.left = n.left;
				//if root is n
				if (parent == null) {
					root = offspring;
				//if not rearranging position of offspring
				} else if (n.data < parent.data) {
					parent.left = offspring;
				} else {
					parent.right = offspring;
				}
			}
			size--;
			return true;
		}
	}

	/** Returns the number of elements stored in the tree. */
	public int size() {
		return size;
	}

	/**
	 * Returns the parent element of the given key. Integer.MIN_VALUE if no parent
	 * can be found.
	 */
	public int getParent(int key) {
		//if tree is empty
		if (root == null) {
			return Integer.MIN_VALUE;
		}
			BinaryTreeNode p = root;
			BinaryTreeNode parent = null;
			//traversing tree
			while(p != null) {
				if (key < p.data) {
					parent = p;
					p = p.left;
				} else if(key > p.data) {
					parent = p;
					p = p.right;
				//in case no traversion is done
				} else {
					return parent.data;
				}
			}
			//if while-loop was exited without finding key
			return Integer.MIN_VALUE;
	}

	/**
	 * Returns the elements of the tree in ascending (inorder traversal) or
	 * descending (reverse inorder traversal) order.
	 */
	public int[] toArray(boolean ascending) {
		int[] sorted = new int[this.size];
		//index, explained in postOrder
		Index i = new Index();
		//calling helper method
		traverseOrdered(root, sorted, i, ascending);
		return sorted;
	}
	//helper method to separate ascending and descending and copies to array
	private void traverseOrdered(BinaryTreeNode node, int[] array, Index i, boolean ascending) {
		//in case parameter in caller method was set to true
		if (ascending) {
			//if tree is empty
			if (node == null) {
				return;
			}
			//recursive inOrder traversion for ascending
			traverseOrdered(node.left, array, i, ascending);
			array[i.index] = node.data;
			i.index++;
			traverseOrdered(node.right, array, i, ascending);
		//in case parameter in caller method was set to false
		} else {
			//if tree is empty
			if (node == null) {
				return;
			}
			//recursive inOrder traversion for descending
			traverseOrdered(node.right, array, i, ascending);
			array[i.index] = node.data;
			i.index++;
			traverseOrdered(node.left, array, i, ascending);
		}
	}

	/** Returns the elements of the tree (postorder traversal). */
	public int[] toArrayPostOrder() {
		int[] postOrder = new int[this.size];
		//Index created to track position where to insert from node to array
		Index i = new Index();
		//call helper method 
		traversePostOrder(root, postOrder, i);
		return postOrder;
	}
	//helper method for traversion and inserting into array
	private void traversePostOrder(BinaryTreeNode node, int[] array, Index i) {
		//if tree is empty
		if (node == null) {
			return;
		}
		//recursive traversion for postOrder
		traversePostOrder(node.left, array, i);
		traversePostOrder(node.right, array, i);
		array[i.index] = node.data;
		i.index++;

	}

	/** Returns the elements of the tree (preorder traversal). */
	public int[] toArrayPreOrder() {
		int[] preOrder = new int[this.size];
		Index i = new Index();
		traversePreOrder(this.root, preOrder, i);
		return preOrder;
	}
	//helper method for traversing in preOrder
	private void traversePreOrder(BinaryTreeNode node, int[] array, Index i) {
		if (node == null) {
			return;
		}
		array[i.index] = node.data;
		i.index++;
		traversePreOrder(node.left, array, i);
		traversePreOrder(node.right, array, i);
	}

	/**
	 * Returns largest number stored in the tree. Integer.MIN_VALUE if no largest
	 * element can be found
	 */
	public int max() {
		//if tree is empty
		if (root == null) {
			return Integer.MIN_VALUE;
		}
		//go right until next right is null
		BinaryTreeNode n = root;
		while (n.right != null) {
			n = n.right;
		}
		return n.data;
	}

	/**
	 * Returns smallest number stored in the tree. Integer.MIN_VALUE if no smallest
	 * element can be found
	 */
	public int min() {
		//if tree is empty
		if (root == null) {
			return Integer.MIN_VALUE;
		}
		//go left until next left is null
		BinaryTreeNode n = root;
		while (n.left != null) {
			n = n.left;
		}
		return n.data;

	}
	
	

	/** Represents the tree in a human readable form. */
	public String toString() {
		//StringBuilder created
		StringBuilder builder = new StringBuilder();
		//calling helper method for toString
		appendString(builder, root, 0);
		return builder.toString();
	}
	/*
	 * helper method to go recursively through tree, to read this string in the
	 * right was, tilt your head 90° to the left side
	 */
	protected void appendString(StringBuilder builder, BinaryTreeNode t, int indent) {
		if (t == null)
			return;
		//go right until t is null and add 4 to indent
		appendString(builder, t.right, indent + 4);
		//for every indent print 4 spaces
		for (int i = 0; i < indent; i++)
			builder.append(" ");
		//add data of node to stringBuilder
		builder.append(t.data);
		//print new line
		builder.append("\n");
		//start over again
		appendString(builder, t.left, indent + 4);
	}

}