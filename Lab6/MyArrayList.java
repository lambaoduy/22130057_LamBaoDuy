package Lab6;

import java.util.Arrays;
import java.util.Comparator;

public class MyArrayList<E> {
	public static final int DEFAULT_CAPACITY = 10;
	private E[] elements;
	private int size;

	public MyArrayList() {
		this.elements = (E[]) new Object[DEFAULT_CAPACITY];
	}

	public MyArrayList(int capacity) {
		this.elements = (E[]) new Object[capacity];
	}

	// creates an array of double-size if the array of elements is full
	public void growSize() {
		if(size==elements.length) {Arrays.copyOf(elements, size * 2);}
		
	}

	// Returns the number of elements in this list.
	public int size() {
		return this.size;
	}

	// Returns whether the list is empty.
	public boolean isEmpty() {
		return size() == 0;
	}

	// Returns (but does not remove) the element at index i.
	public E get(int i) throws IndexOutOfBoundsException {
		if (i >= 0 && i < size()) {
			return elements[i];
		} else {
			throw new IndexOutOfBoundsException();
		}
	}

	// Replaces the element at index i with e, and
//	returns the replaced element. ∗/
	public E set(int i, E e) throws IndexOutOfBoundsException {
		if (i >= 0 && i < size()) {
			elements[i] = e;
			return e;
		} else {
			throw new IndexOutOfBoundsException();
		}
	}

	// It is used to append the specified element at the
//	end of a list.
	public boolean add(E e) {
		growSize();
		elements[this.size] = e;
		size+=1;
		return false;
	}

	// Inserts element e to be at index i, shifting all
//	subsequent elements later.
	public void add(int i, E e) throws IndexOutOfBoundsException {
		growSize();
		if (i >= 0 && i < size()) {
			for (int j = size - 1; j >= i; j--) {
				elements[j + 1] = elements[j];
			}
			elements[i] = e;
			size+=1;
		} else {
			throw new IndexOutOfBoundsException();
		}
	}

	// Removes and returns the element at index i,
//	shifting subsequent elements earlier.
	public E remove(int i) throws IndexOutOfBoundsException {
		if (i >= 0 && i < size()) {
			for (int j = i; j <size; j++) {
				elements[j] = elements[j + 1];
			}
			size-=1;
			return elements[i];

		} else {
			throw new IndexOutOfBoundsException();
		}
	}

//	Then implements other methods as in Java Collection Framework - ArrayList.java
	// It is used to clear all elements in the list.
	public void clear() {
		this.elements = (E[]) new Object[DEFAULT_CAPACITY];
		size=0;
	}

	// It is used to return the index in this list of the last occurrence of the
	// specified element, or -1 if the list does not contain this element.
	public int lastIndexOf(Object o) {
		for (int i = size - 1; i > 0; i--) {
			if (o.equals(elements[i])) {
				return i;
			}
		}
		return -1;
	}
	// It is used to return an array containing all of the elements in this list in
	// the correct order.

	public E[] toArray() {
		return Arrays.copyOf(elements, size);
	}

	// It is used to return a shallow copy of an ArrayList.
	public MyArrayList<E> clone() throws CloneNotSupportedException {
		try {
			MyArrayList<E> v = (MyArrayList<E>) super.clone();
			v.elements = Arrays.copyOf(elements, size);
			return v;
		} catch (CloneNotSupportedException e) {
			// this shouldn't happen, since we are Cloneable
			throw new InternalError(e);
		}
	}

	// It returns true if the list contains the specified element
	public boolean contains(E o) {
		for (int i = 0; i < size; i++) {
			if (elements[i].equals(o)) {
				return true;
			}
		}
		return false;
	}

	// It is used to return the index in this list of the first occurrence of the
	// specified element, or -1 if the List does not contain this element.
	public int indexOf(E o) {
		for (int i = 0; i < size; i++) {
			if (o.equals(elements[i])) {
				return i;
			}
		}
		return -1;
	}

	// It is used to remove the first occurrence of the specified element.
	public boolean remove(E e) {
		for (int i = 0; i < size; i++) {
			if (elements[i].equals(e)) {
				for (int j = i; j < elements.length; j++) {
					elements[i] = elements[i + 1];
					size-=1;
					return true;
				}
			}
		}
		return false;
	}

	// It is used to sort the elements of the list on the basis of specified
	// comparator.
	public void sort(Comparator<E> c) {
		Arrays.sort(elements, 0, size);
	}

	public static void main(String[] args) {
		MyArrayList<Integer> myarray = new MyArrayList<>();
		myarray.add(3);
		myarray.add(4);
		myarray.add(3);
		myarray.add(2, 2);
		myarray.remove((Integer) 4);
		myarray.remove(2);
		
		
		System.out.println(Arrays.toString(myarray.toArray()));
	}
}