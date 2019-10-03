package Exercise2;

import java.util.Iterator;
/*
 * Authors: Håkan Johansson and Amelie Löwe for the 1DV516 course
 * 
 * Methods concerning operations on the right side are coming first, then right after is 
 * the methods of the left operations.
 * 
 * The method for finding the minimum value in the list is after the right and left methods.
 * 
 * At the end we have a toString method and a Node class.
 */

public class MySequenceWithMinimum implements A1SequenceWithMinimum {

	private Node head;
	private Node tail;
	private Node temp;
	private int size;
	private int minimum;

	public MySequenceWithMinimum() {
		head = null;
		tail = null;
		temp = null;
		size = 0;
		minimum = Integer.MAX_VALUE;// Makes sure that the minimum value is updated in the initial step

	}

	@Override
	public void insertRight(Integer value) {
		if (head == null && tail == null) {
			temp = new Node(value, null, null);
			head = temp;
			tail = temp;
			minimum = temp.value;
		} else {
			temp = new Node(value, tail, null);
			tail.next = temp;
			tail = temp;

			if (temp.value < minimum) {
				minimum = temp.value;
			}
		}
		size++;

	}

	@Override
	public Integer removeRight() {
		if (tail == null) {
			return null;
		}
		temp = tail.prev;
		tail = temp;
		tail.prev = temp.prev;

		size--;
		return this.temp.value;
	}

	@Override
	public void insertLeft(Integer value) {
		if (head == null && tail == null) {
			temp = new Node(value, null, null);
			head = temp;
			tail = temp;
			minimum = temp.value;
		} else {
			temp = new Node(value, null, head);
			head.prev = temp;
			head = temp;

			if (temp.value < minimum) {
				minimum = temp.value;
			}

		}
		size++;
	}

	@Override
	public Integer removeLeft() {
		if (head == null) {
			return null;
		}
		temp = head.next;
		head = temp;
		head.next = temp.next;
		size--;
		return this.temp.value;

	}

	@Override
	public Integer findMinimum() {
		return minimum;
	}

	private class LinkedIterator implements Iterator<Object> {
		private Node current = head;
		int count = 0;

		@Override
		public boolean hasNext() {
			return count < size;
		}

		@Override
		public Object next() {
			if (hasNext() == false) {
				throw new IndexOutOfBoundsException();
			}
			int temp = current.value;
			current = current.next;
			count++;
			return temp;
		}

	}

	public String toString() {
		StringBuilder build = new StringBuilder();
		LinkedIterator iter = new LinkedIterator();
		build.append("{");
		while (iter.hasNext()) {
			build.append(iter.next() + ",");
		}
		build.deleteCharAt(build.length() - 1);
		build.append("}");
		return build.toString();

	}

	private class Node {
		Integer value;
		Node next = null;
		Node prev = null;

		Node(int v, Node previous, Node next) {
			value = v;
			this.next = next;
			this.prev = previous;
		}

	}
}
