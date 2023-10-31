package Lab6;

public class Node<E> {
	private E data;

	public E getData() {
		return data;
	}

	private Node<E> next;

	public Node(E data) {
		this.data = data;
	}

	public Node(E data, Node<E> next) {
		this.data = data;
		this.setNext(next);
	}
	// …

	public Node<E> getNext() {
		return next;
	}

	public void setNext(Node<E> next) {
		this.next = next;
	}

}
