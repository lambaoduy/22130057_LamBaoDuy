package Lab6;

import java.util.LinkedList;

public class SinglyLinkedList<E> {
	private Node<E> head = null;
	private Node<E> tail = null;
	private int size;

	LinkedList<E> link;

	public SinglyLinkedList() {
		super();
	}

	// Returns the number of elements in the list.
	public int size() {
		return this.size;
	}

	// Returns true if the list is empty, and false
//	otherwise.
	public boolean isEmpty() {
		return this.size == 0;
	}

	// Returns (but does not remove) the first element in
//	the list.
	public E first() {
		return this.head.getData();
	}

	// Returns (but does not remove) the last element in
//	the list.
	public E last() {
		return this.tail.getData();

	}

	// Adds a new element to the front of the list.
	public void addFirst(E e) {
		if (isEmpty()) {
			Node newest = new Node(e);
			head = newest;
			size += 1;
		} else {
			Node newest = new Node(e);
			newest.setNext(head);
			head = newest;
			size += 1;
		}
	}

	// Adds a new element to the end of the list.
	public void addLast(E e) {
		if (isEmpty()) {
			Node newest = new Node(e);
			tail = newest;
			size += 1;
		} else {
			Node newest = new Node(e);
			newest.setNext(null);
			tail = newest;
			size += 1;
		}
	}

	// Removes and returns the first element of the list.
	public E removeFirst() {
		Node newest = new Node<E>(head.getData());
		newest.setNext(head.getNext());
		head.setNext(null);
		head = newest.getNext();
		size -= 1;

		return null;
	}

	// Removes and returns the last element of the list.
	public E removeLast() {
		Node newest = new Node<E>(findPrevious(head, tail));
		newest.setNext(head.getNext());
		head.setNext(null);
		head = newest.getNext();
		size -= 1;
		return null;

	}
	
	private E findPrevious(Node<E> head, Node<E> tail3) {
		if (head.getNext()==(tail3)) {
			System.out.println(head.getData());
			return head.getData();
			
		} else {
			return findPrevious(head.getNext(), tail3);
		}
	}

	public static void main(String[] args) {

		SinglyLinkedList<Integer> singleLink = new SinglyLinkedList<>();
		singleLink.addFirst(3);
		singleLink.addFirst(4);
		singleLink.addFirst(5);
		singleLink.addFirst(6);
		singleLink.addLast(4);
		singleLink.addLast(5);
		singleLink.addFirst(1);
		singleLink.removeFirst();
		
		
		System.out.println(singleLink.findPrevious(singleLink.head, singleLink.tail));
		
//		System.out.println(singleLink.first());
//		System.out.println(singleLink.last());
//		System.out.println(singleLink.isEmpty());

	}
}
