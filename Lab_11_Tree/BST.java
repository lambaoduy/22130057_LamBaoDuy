package Lab_11_Tree;

import java.util.Collection;
import java.util.List;

public class BST<E extends Comparable<E>> {
	private BNode<E> root;

	public BST() {
		this.root = null;
	}

	// Add element e into BST
	public void add(E e) {
		// TODO
		if (root == null) {
			root = new BNode<>(e);
		} else {
			this.root.add(e);
		}
	}

	// Add a collection of elements col into BST
	public void add(Collection<E> col) {
		// TODO
		for (E e : col) {
			this.add(e);
		}
	}

	// compute the depth of a node in BST
	int count = 0;

	public int depth(E node) {
		// TODO
		if (root == null) {
			return 0;
		} else {
			int count = 0;
			return this.root.depth(node, count);
		}
	}

	// compute the height of BST
	public int height() {
		// TODO
		return height2(root);
	}

	private int height2(BNode<E> root2) {
		// TODO Auto-generated method stub
		if (root2 == null) {
			return 0;
		} else {
			int leftHeight = height2(root2.getLeft());
			int rightHeight = height2(root2.getRight());
			
			return Math.max(leftHeight, rightHeight) + 1;
		}
	}

	// Compute total nodes in BST
	public int size() {
		// TODO
		return this.size2(root);
	}

	private int size2(BNode<E> root2) {
		// TODO Auto-generated method stub
		if (root2 == null) {
			return 0;
		} else {
			return this.size2(root2.getLeft()) + this.size2(root2.getRight()) + 1;
		}
	}

	// Check whether element e is in BST
	public boolean contains(E e) {
		// TODO
		if (root == null) {
			return false;
		} else {
			return root.contains(e);
		}
	}

	// Find the minimum element in BST
	public E findMin() {
		// TODO
		if (root==null) {
			return null;
		} else {
			return this.root.Min();
		}
	}

	// Find the maximum element in BST
	public E findMax() {
		// TODO
		if (root==null) {
			return null;
		} else {
			return this.root.Max();
		}
	}

	// Remove element e from BST
	public boolean remove(E e) {
		// TODO
		return false;
	}

	// get the descendants of a node
	public List<E> descendants(E data) {
		// TODO
		return null;
	}

	// get the ancestors of a node
	public List<E> ancestors(E data) {
		// TODO
		return null;
	}

	

	public static void main(String[] args) {
		BST tree = new BST<>();
		tree.add(4);
		tree.add(3);
		tree.add(5);
		tree.add(1);
		tree.add(8);
		tree.add(0);
		tree.add(-1);

//		System.out.println(tree.size());
//		System.out.println(tree.contains(8));
//		System.out.println(tree.depth(1));
//		System.out.println(tree.height());
//		System.out.println(tree.findMin());
//		System.out.println(tree.findMax());
	}
}