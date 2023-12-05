package Lab_11_Tree;

public class BNode<E extends Comparable<E>> {
	private E data;
	private BNode<E> left;
	private BNode<E> right;

	public BNode(E data) {
		this.data = data;
		this.left = null;
		this.right = null;
	}

	@Override
	public String toString() {
		return "BNode [data=" + data + ", left=" + left + ", right=" + right + "]";
	}

	public BNode(E data, BNode<E> left, BNode<E> right) {
		this.data = data;
		this.left = left;
		this.right = right;
	}

	public E getData() {
		return data;
	}

	public void setData(E data) {
		this.data = data;
	}

	public BNode<E> getLeft() {
		return left;
	}

	public void setLeft(BNode<E> left) {
		this.left = left;
	}

	public BNode<E> getRight() {
		return right;
	}

	public void setRight(BNode<E> right) {
		this.right = right;
	}

	public boolean contains(E e) {
		// TODO Auto-generated method stub
		int comp = e.compareTo(data);
		if (comp == 0) {
			return true;
		} else {
			if (comp < 0) {
				return (left == null) ? false : left.contains(e);
			} else {
				return (right == null) ? false : right.contains(e);
			}
		}

	}

	public void add(E e) {
		// TODO Auto-generated method stub

		if (e.compareTo(data) < 0) {
			if (left == null) {
				BNode<E> element = new BNode<E>(e);

				left = element;
			} else {
				left.add(e);
			}
		} else {
			if (right == null) {
				BNode<E> element = new BNode<E>(e);
				right = element;
			} else {
				right.add(e);
			}

		}
	}

	public int depth(E node, int count) {
		// TODO Auto-generated method stub
		int comp = node.compareTo(data);
		if (comp == 0) {
			return count;
		}
		if (comp < 0) {
			return left.depth(node, ++count);
		} else {
			return right.depth(node, ++count);
		}
	}

	public int height(int count) {
		// TODO Auto-generated method stub
		if (this == null) {
			return count;
		} else {
			return this.left.height(count) + this.height(count) + 1;
		}
	}

	public E Min() {
		// TODO Auto-generated method stub
		
		if(left==null) {
			return data;
		}
		return left.Min();
	}

	public E Max() {
		// TODO Auto-generated method stub
		if(right==null) {
			return data;
		}
		return right.Max();
	}
}