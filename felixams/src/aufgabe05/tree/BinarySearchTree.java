package aufgabe05.tree;

public class BinarySearchTree<T extends Comparable<T>> {
    /** Root node of the tree. **/
    protected BinaryTreeNode root;
    /** Number of elements stored in the tree. */
    protected int size;

    protected class BinaryTreeNode {
        public BinaryTreeNode left;
        public BinaryTreeNode right;
        public T data;

        public BinaryTreeNode(T data) {
            this.data = data;
            this.left = null;
            this.right = null;
        }
    }

    /**
     * Inserts the given element. Duplicate elements are not allowed.
     * Returns true if insertion was successful, false otherwise.
     */
    public boolean insert(T elem) {
        if (root == null) {
            root = new BinaryTreeNode(elem);
            size++;
            return true;
        } else {
            return insertRecursive(root, elem);
        }
    }

    private boolean insertRecursive(BinaryTreeNode tree, T elem) {
        if (elem.compareTo(tree.data) > 0) {
            if (tree.right == null) {
                tree.right = new BinaryTreeNode(elem);
                size++;
                return true;
            } else {
                return insertRecursive(tree.right, elem);
            }
        } else if (elem.compareTo(tree.data) < 0) {
            if (tree.left == null) {
                tree.left = new BinaryTreeNode(elem);
                size++;
                return true;
            } else {
                return insertRecursive(tree.left, elem);
            }
        } else {
            return false;
        }
    }

    /**
     * Searches for the (first) element with the given key. Returns true
     * if it could be found, false otherwise.
     */
    public boolean find(T key) {
        if (root == null) {
            return false;
        } else {
            return findRecursive(root, key);
        }
    }

    private boolean findRecursive(BinaryTreeNode tree, T elem) {
        if (elem.compareTo(tree.data) > 0) {
            if (tree.right == null) {
                return false;
            } else {
                return findRecursive(tree.right, elem);
            }
        } else if (elem.compareTo(tree.data) < 0) {
            if (tree.left == null) {
                return false;
            } else {
                return findRecursive(tree.left, elem);
            }
        } else {
            return true;
        }
    }

    /**
     * Removes the element with the given key. Returns true if
     * the key could be found (and removed), false otherwise.
     */
    public boolean remove(T elem) {
        return removeRecursive(root, elem);
    }

    public boolean removeRecursive(BinaryTreeNode t, T key) {
        BinaryTreeNode n, st, par, succ;
        par = null;
        st = t;
        while ((st != null) && !(st.data == key)) {
            par = st;
            if (key.compareTo(st.data) < 0)
                st = st.left;
            else
                st = st.right;
        }
        n = st;
        if (n == null)
            return false;
        if (n.right == null) {
            // no right son
            st = n.left;
        } else if (n.right.left == null) {
            // right son has no left son
            st = n.right;
            st.left = n.left;
        } else {
            // right son has left son
            succ = n.right;
            while (succ.left.left != null)
                succ = succ.left;
            st = succ.left;
            succ.left = st.right;
            st.left = n.left;
            st.right = n.right;
        }
        if (par == null)
            root = st;
        else if (key.compareTo(par.data) < 0)
            par.left = st;
        else
            par.right = st;
        size--;
        return true;
    }

    /** Returns the number of elements stored in the tree. */
    public int size() {
        return size;
    }

    /**
     * Returns the parent element of the given key. Null if
     * no parent can be found.
     */
    public T getParent(T key) {
        if (root == null) {
            return null;
        } else {
            return getParentRecursive(root, key);
        }
    }

    private T getParentRecursive(BinaryTreeNode tree, T elem) {
        if (elem.compareTo(tree.data) > 0) {
            if (tree.right == null) {
                return null;
            } else if (tree.right.data == elem) {
                return tree.data;
            } else {
                return getParentRecursive(tree.right, elem);
            }
        } else if (elem.compareTo(tree.data) < 0) {
            if (tree.left == null) {
                return null;
            } else if (tree.left.data == elem) {
                return tree.data;
            } else {
                return getParentRecursive(tree.left, elem);
            }
        } else {
            return null;
        }
    }

    /**
     * Returns the elements of the tree in ascending (inorder traversal)
     * or descending (reverse inorder traversal) order.
     */
    public T[] toArray(boolean ascending) {
        T[] array = (T[]) new Comparable[size];
        /**
         * Array to keep track of the number of elements in the array
         * It has to be an array with length 1, because a counter would
         * reset to the current value due to recursion.
         */
        int[] arrayElem = { -1 };

        toArrayRecursive(root, ascending, array, arrayElem);
        return array;
    }

    private void toArrayRecursive(BinaryTreeNode node, boolean ascending, T[] array, int[] arrayElem) {
        if (node != null) {
            if (ascending) {
                toArrayRecursive(node.left, ascending, array, arrayElem);
                arrayElem[0]++;
                array[arrayElem[0]] = node.data;
                toArrayRecursive(node.right, ascending, array, arrayElem);
            } else {
                toArrayRecursive(node.right, ascending, array, arrayElem);
                arrayElem[0]++;
                array[arrayElem[0]] = node.data;
                toArrayRecursive(node.left, ascending, array, arrayElem);
            }
        }
    }

    /** Returns the elements of the tree (postorder traversal). */
    public T[] toArrayPostOrder() {
        T[] array = (T[]) new Comparable[size];
        /**
         * Array to keep track of the number of elements in the array
         * It has to be an array with length 1, because a counter would
         * reset to the current value due to recursion.
         */
        int[] arrayElem = { -1 };

        toArrayPostOrderRecursive(root, array, arrayElem);
        return array;
    }

    private void toArrayPostOrderRecursive(BinaryTreeNode node, T[] array, int[] arrayElem) {
        if (node != null) {
            toArrayPostOrderRecursive(node.left, array, arrayElem);
            toArrayPostOrderRecursive(node.right, array, arrayElem);
            arrayElem[0]++;
            array[arrayElem[0]] = node.data;

        }
    }

    /** Returns the elements of the tree (preorder traversal). */
    public T[] toArrayPreOrder() {
        T[] array = (T[]) new Comparable[size];
        /**
         * Array to keep track of the number of elements in the array
         * It has to be an array with length 1, because a counter would
         * reset to the current value due to recursion.
         */
        int[] arrayElem = { -1 };

        toArrayPreOrderRecursive(root, array, arrayElem);
        return array;
    }

    private void toArrayPreOrderRecursive(BinaryTreeNode node, T[] array, int[] arrayElem) {
        if (node != null) {
            arrayElem[0]++;
            array[arrayElem[0]] = node.data;
            toArrayPostOrderRecursive(node.left, array, arrayElem);
            toArrayPostOrderRecursive(node.right, array, arrayElem);
        }
    }

    /**
     * Returns largest number stored in the tree. Null if
     * no largest element can be found
     */
    public T max() {
        if (root == null) {
            return null;
        }
        BinaryTreeNode t = root;
        while (t.right != null) {
            t = t.right;
        }
        return t.data;
    }

    /**
     * Returns smallest number stored in the tree. Null if
     * no smallest element can be found
     */
    public T min() {
        if (root == null) {
            return null;
        }
        BinaryTreeNode t = root;
        while (t.left != null) {
            t = t.left;
        }
        return t.data;
    }

    /**
     * Represents the tree in a human readable form (inorder traversal).
     */
    public String toString() {
        return toStringRecursive(root);
    }

    /**
     * Recursive helper method to create a human readable string representation of
     * the tree.
     */
    private String toStringRecursive(BinaryTreeNode node) {
        StringBuilder builder = new StringBuilder();
        if (node != null) {
            builder.append(toStringRecursive(node.left));
            builder.append(node.data);
            builder.append(toStringRecursive(node.right));
        }
        return builder.toString();
    }
}